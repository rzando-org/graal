/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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
package jdk.graal.compiler.hotspot;

import jdk.graal.compiler.core.common.CompilerProfiler;
import jdk.graal.compiler.serviceprovider.ServiceProvider;

import jdk.vm.ci.hotspot.JFR;
import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * A HotSpot JFR implementation of {@link CompilerProfiler}.
 */
@ServiceProvider(CompilerProfiler.class)
public final class JFRCompilerProfiler implements CompilerProfiler {

    @Override
    public long getTicks() {
        return JFR.Ticks.now();
    }

    @Override
    public void notifyCompilerPhaseEvent(int compileId, long startTime, String name, int nestingLevel) {
        JFR.CompilerPhaseEvent.write(startTime, name, compileId, nestingLevel);
    }

    @Override
    public void notifyCompilerInlingEvent(int compileId, ResolvedJavaMethod caller, ResolvedJavaMethod callee,
                    boolean succeeded, String message, int bci) {
        JFR.CompilerInliningEvent.write(compileId, caller, callee, succeeded, message, bci);
    }

}
