/*
 * Copyright (c) 2011, 2024, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package jdk.graal.compiler.nodes.calc;

import static jdk.graal.compiler.core.common.calc.CanonicalCondition.LT;

import jdk.graal.compiler.core.common.GraalOptions;
import jdk.graal.compiler.core.common.NumUtil;
import jdk.graal.compiler.core.common.calc.CanonicalCondition;
import jdk.graal.compiler.core.common.type.IntegerStamp;
import jdk.graal.compiler.core.common.type.Stamp;
import jdk.graal.compiler.debug.Assertions;
import jdk.graal.compiler.debug.GraalError;
import jdk.graal.compiler.graph.Node;
import jdk.graal.compiler.graph.NodeClass;
import jdk.graal.compiler.nodeinfo.NodeInfo;
import jdk.graal.compiler.nodes.ConstantNode;
import jdk.graal.compiler.nodes.LogicConstantNode;
import jdk.graal.compiler.nodes.LogicNegationNode;
import jdk.graal.compiler.nodes.LogicNode;
import jdk.graal.compiler.nodes.NodeView;
import jdk.graal.compiler.nodes.ValueNode;
import jdk.graal.compiler.nodes.spi.CanonicalizerTool;
import jdk.graal.compiler.options.OptionValues;
import jdk.vm.ci.code.CodeUtil;
import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.ConstantReflectionProvider;
import jdk.vm.ci.meta.MetaAccessProvider;
import jdk.vm.ci.meta.PrimitiveConstant;
import jdk.vm.ci.meta.TriState;

@NodeInfo(shortName = "<")
public final class IntegerLessThanNode extends IntegerLowerThanNode {
    public static final NodeClass<IntegerLessThanNode> TYPE = NodeClass.create(IntegerLessThanNode.class);
    private static final LessThanOp OP = new LessThanOp();

    public IntegerLessThanNode(ValueNode x, ValueNode y) {
        super(TYPE, x, y, OP);
        Stamp xStamp = x.stamp(NodeView.DEFAULT);
        Stamp yStamp = y.stamp(NodeView.DEFAULT);
        assert xStamp.isIntegerStamp() : "expected integer x value: " + x;
        assert yStamp.isIntegerStamp() : "expected integer y value: " + y;
        assert xStamp.isCompatible(yStamp) : "expected compatible stamps: " + xStamp + " / " + yStamp;
    }

    public static LogicNode create(ValueNode x, ValueNode y, NodeView view) {
        return OP.create(x, y, view);
    }

    public static LogicNode create(ConstantReflectionProvider constantReflection, MetaAccessProvider metaAccess, OptionValues options, Integer smallestCompareWidth,
                    ValueNode x, ValueNode y, NodeView view) {
        LogicNode value = OP.canonical(constantReflection, metaAccess, options, smallestCompareWidth, OP.getCondition(), false, x, y, view);
        if (value != null) {
            return value;
        }
        return create(x, y, view);
    }

    @Override
    public Node canonical(CanonicalizerTool tool, ValueNode forX, ValueNode forY) {
        NodeView view = NodeView.from(tool);
        ValueNode value = OP.canonical(tool.getConstantReflection(), tool.getMetaAccess(), tool.getOptions(), tool.smallestCompareWidth(), OP.getCondition(), false, forX, forY, view);
        if (value != null) {
            return value;
        }
        return this;
    }

    public static boolean subtractMayUnderflow(long x, long y, long minValue) {
        long r = x - y;
        // HD 2-12 Overflow iff the arguments have different signs and
        // the sign of the result is different than the sign of x
        return (((x ^ y) & (x ^ r)) < 0) || r <= minValue;
    }

    public static boolean subtractMayOverflow(long x, long y, long maxValue) {
        long r = x - y;
        // HD 2-12 Overflow iff the arguments have different signs and
        // the sign of the result is different than the sign of x
        return (((x ^ y) & (x ^ r)) < 0) || r > maxValue;
    }

    public static class LessThanOp extends LowerOp {
        @Override
        protected LogicNode duplicateModified(ValueNode newX, ValueNode newY, boolean unorderedIsTrue, NodeView view) {
            if (newX.stamp(view) instanceof IntegerStamp && newY.stamp(view) instanceof IntegerStamp) {
                return IntegerLessThanNode.create(newX, newY, view);
            }
            /*
             * We cannot model the replacement of an integer compare by a floating-point compare
             * because we don't know how to handle the unordered case. The unorderedIsTrue parameter
             * cannot be trusted since its value is arbitrary for the original integer compare.
             */
            throw GraalError.shouldNotReachHere(newX.stamp(view) + " " + newY.stamp(view)); // ExcludeFromJacocoGeneratedReport
        }

        @Override
        protected LogicNode optimizeNormalizeCompare(ConstantReflectionProvider constantReflection, MetaAccessProvider metaAccess, OptionValues options, Integer smallestCompareWidth,
                        Constant constant, AbstractNormalizeCompareNode normalizeNode, boolean mirrored, NodeView view) {
            PrimitiveConstant primitive = (PrimitiveConstant) constant;
            /* @formatter:off
             * a NC b < c  (not mirrored)
             * cases for c:
             *  0         -> a < b
             *  [MIN, -1] -> false
             *  1         -> a <= b
             *  [2, MAX]  -> true
             * unordered-is-less means unordered-is-true.
             *
             * c < a NC b  (mirrored)
             * cases for c:
             *  0         -> a > b
             *  [1, MAX]  -> false
             *  -1        -> a >= b
             *  [MIN, -2] -> true
             * unordered-is-less means unordered-is-false.
             *
             *  We can handle mirroring by swapping a & b and negating the constant.
             *  @formatter:on
             */
            long cst = mirrored ? -primitive.asLong() : primitive.asLong();

            if (cst == 0) {
                return normalizeNode.createLowerComparison(mirrored, constantReflection, metaAccess, options, smallestCompareWidth, view);
            } else if (cst == 1) {
                // a <= b <=> !(a > b)
                // since we negate, we have to reverse the unordered result
                LogicNode compare = normalizeNode.createLowerComparison(!mirrored, constantReflection, metaAccess, options, smallestCompareWidth, view);
                return LogicNegationNode.create(compare);
            } else if (cst <= -1) {
                return LogicConstantNode.contradiction();
            } else {
                assert cst >= 2 : cst;
                return LogicConstantNode.tautology();
            }
        }

        @Override
        protected LogicNode findSynonym(ValueNode forX, ValueNode forY, NodeView view) {
            LogicNode result = super.findSynonym(forX, forY, view);
            if (result != null) {
                return result;
            }
            if (!(forX.stamp(view) instanceof IntegerStamp)) {
                return null;
            }
            // always prefer unsigned comparisons, however, if part of a graph we sometimes want to
            // disable it for testing purposes
            if (forX.getOptions() == null || GraalOptions.PreferUnsignedComparison.getValue(forX.getOptions())) {
                if (forX.stamp(view) instanceof IntegerStamp && forY.stamp(view) instanceof IntegerStamp) {
                    if (IntegerStamp.sameSign((IntegerStamp) forX.stamp(view), (IntegerStamp) forY.stamp(view))) {
                        return new IntegerBelowNode(forX, forY);
                    }
                }
            }

            // Attempt to optimize the case where we can fold a constant from the left side (either
            // from an add or sub) into the constant on the right side.
            if (forY.isConstant()) {
                if (forX instanceof SubNode) {
                    SubNode sub = (SubNode) forX;
                    ValueNode xx = null;
                    ValueNode yy = null;
                    boolean negate = false;
                    if (forY.asConstant().isDefaultForKind()) {
                        // (x - y) < 0 when x - y is known not to underflow <=> x < y
                        xx = sub.getX();
                        yy = sub.getY();
                    } else if (forY.isJavaConstant() && forY.asJavaConstant().asLong() == 1) {
                        // (x - y) < 1 when x - y is known not to underflow <=> !(y < x)
                        xx = sub.getY();
                        yy = sub.getX();
                        negate = true;
                    }
                    if (xx != null) {
                        assert yy != null;
                        IntegerStamp xStamp = (IntegerStamp) sub.getX().stamp(view);
                        IntegerStamp yStamp = (IntegerStamp) sub.getY().stamp(view);
                        long minValue = CodeUtil.minValue(xStamp.getBits());
                        long maxValue = CodeUtil.maxValue(xStamp.getBits());

                        if (!subtractMayUnderflow(xStamp.lowerBound(), yStamp.upperBound(), minValue) && !subtractMayOverflow(xStamp.upperBound(), yStamp.lowerBound(), maxValue)) {
                            LogicNode logic = new IntegerLessThanNode(xx, yy);
                            if (negate) {
                                logic = LogicNegationNode.create(logic);
                            }
                            return logic;
                        }
                    }
                } else if (forX instanceof AddNode) {

                    // (x + xConstant) < forY => x < (forY - xConstant)
                    AddNode addNode = (AddNode) forX;
                    if (addNode.getY().isJavaConstant()) {
                        IntegerStamp xStamp = (IntegerStamp) addNode.getX().stamp(view);
                        if (!IntegerStamp.addCanOverflow(xStamp, (IntegerStamp) addNode.getY().stamp(view))) {
                            long minValue = CodeUtil.minValue(xStamp.getBits());
                            long maxValue = CodeUtil.maxValue(xStamp.getBits());
                            long yConstant = forY.asJavaConstant().asLong();
                            long xConstant = addNode.getY().asJavaConstant().asLong();
                            if (!subtractMayUnderflow(yConstant, xConstant, minValue) && !subtractMayOverflow(yConstant, xConstant, maxValue)) {
                                long newConstant = yConstant - xConstant;
                                return IntegerLessThanNode.create(addNode.getX(), ConstantNode.forIntegerStamp(xStamp, newConstant), view);
                            }
                        }
                    }
                }
            }

            if (forX.stamp(view) instanceof IntegerStamp) {
                int bits = ((IntegerStamp) forX.stamp(view)).getBits();
                assert forY.stamp(view) instanceof IntegerStamp && ((IntegerStamp) forY.stamp(view)).getBits() == bits : Assertions.errorMessageContext("this", this, "forX", forX, "forY", forY);
                LogicNode logic = canonicalizeRangeFlip(forX, forY, bits, true, view);
                if (logic != null) {
                    return logic;
                }
            }
            return null;
        }

        @Override
        protected boolean isMatchingBitExtendNode(ValueNode node) {
            return node instanceof SignExtendNode;
        }

        @Override
        protected boolean addCanOverflow(IntegerStamp a, IntegerStamp b) {
            return IntegerStamp.addCanOverflow(a, b);
        }

        @Override
        protected boolean leftShiftCanOverflow(IntegerStamp a, long shift) {
            // leading zeros, adjusted to stamp bits
            int leadingZeroForBits = Long.numberOfLeadingZeros(a.mayBeSet()) - (Long.SIZE - a.getBits());
            // one extra bit to avoid flipping the sign
            return leadingZeroForBits - 1 < shift;
        }

        @Override
        protected CanonicalCondition getCondition() {
            return LT;
        }

        @Override
        protected IntegerLowerThanNode createNode(ValueNode x, ValueNode y) {
            return new IntegerLessThanNode(x, y);
        }

        @Override
        protected long upperBound(IntegerStamp stamp) {
            return stamp.upperBound();
        }

        @Override
        protected long lowerBound(IntegerStamp stamp) {
            return stamp.lowerBound();
        }

        @Override
        protected int compare(long a, long b) {
            return Long.compare(a, b);
        }

        @Override
        protected long min(long a, long b) {
            return Math.min(a, b);
        }

        @Override
        protected long max(long a, long b) {
            return Math.max(a, b);
        }

        @Override
        protected long cast(long a, int bits) {
            return CodeUtil.signExtend(a, bits);
        }

        @Override
        protected long minValue(int bits) {
            return NumUtil.minValue(bits);
        }

        @Override
        protected long maxValue(int bits) {
            return NumUtil.maxValue(bits);
        }

        @Override
        protected IntegerStamp forInteger(int bits, long min, long max) {
            return IntegerStamp.create(bits, cast(min, bits), cast(max, bits));
        }
    }

    @Override
    public TriState implies(boolean thisNegated, LogicNode other) {
        if (!thisNegated) {
            if (other instanceof IntegerLessThanNode) {
                ValueNode otherX = ((IntegerLessThanNode) other).getX();
                ValueNode otherY = ((IntegerLessThanNode) other).getY();
                // x < y => !y < x
                if (getX() == otherY && getY() == otherX) {
                    return TriState.FALSE;
                }
            }

            // x < y => !x == y
            // x < y => !y == x
            if (other instanceof IntegerEqualsNode) {
                ValueNode otherX = ((IntegerEqualsNode) other).getX();
                ValueNode otherY = ((IntegerEqualsNode) other).getY();
                if ((getX() == otherX && getY() == otherY) || (getX() == otherY && getY() == otherX)) {
                    return TriState.FALSE;
                }
            }
        }
        return super.implies(thisNegated, other);
    }
}