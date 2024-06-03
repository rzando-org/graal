/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.svm.core.graal.meta;

import com.oracle.svm.core.hub.DynamicHub;
import com.oracle.svm.core.meta.SubstrateMethodPointerConstant;
import com.oracle.svm.core.meta.SubstrateMethodPointerStamp;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.MetaAccessProvider;
import jdk.graal.compiler.core.common.type.AbstractPointerStamp;
import jdk.graal.compiler.core.common.type.ObjectStamp;
import jdk.graal.compiler.core.common.type.StampFactory;
import jdk.graal.compiler.core.common.type.TypeReference;
import jdk.graal.compiler.nodes.spi.StampProvider;

public class SubstrateStampProvider implements StampProvider {

    private final AbstractPointerStamp hubStamp;
    private final AbstractPointerStamp methodStamp;
    private final AbstractPointerStamp methodAlwaysNullStamp;

    public SubstrateStampProvider(MetaAccessProvider metaAccess) {
        this.hubStamp = StampFactory.objectNonNull(TypeReference.createExactTrusted(metaAccess.lookupJavaType(DynamicHub.class)));
        this.methodStamp = SubstrateMethodPointerStamp.methodNonNull();
        this.methodAlwaysNullStamp = SubstrateMethodPointerStamp.methodAlwaysNull();
    }

    @Override
    public AbstractPointerStamp createHubStamp(ObjectStamp object) {
        return hubStamp;
    }

    @Override
    public AbstractPointerStamp createMethodStamp() {
        return methodStamp;
    }

    @Override
    public AbstractPointerStamp createMethodAlwaysNullStamp() {
        return methodAlwaysNullStamp;
    }

    @Override
    public Constant methodPointerAlwaysNullConstant() {
        return SubstrateMethodPointerConstant.ALWAYS_NULL;
    }
}
