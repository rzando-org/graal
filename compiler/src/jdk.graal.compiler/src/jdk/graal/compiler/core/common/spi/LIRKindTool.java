/*
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates. All rights reserved.
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
package jdk.graal.compiler.core.common.spi;

import jdk.graal.compiler.core.common.LIRKind;

/**
 * This interface can be used to access platform and VM specific kinds.
 */
public interface LIRKindTool {

    /**
     * Get an architecture specific integer kind of a certain size.
     */
    LIRKind getIntegerKind(int bits);

    /**
     * Get an architecture specific floating point kind of a certain size.
     */
    LIRKind getFloatingKind(int bits);

    /**
     * Get the architecture specific kind used to represent Java objects.
     */
    LIRKind getObjectKind();

    /**
     * Get the architecture specific kind pointer-sized integer kind.
     */
    LIRKind getWordKind();

    /**
     * Get the platform specific kind used to represent compressed oops.
     */
    LIRKind getNarrowOopKind();

    /**
     * Gets the platform specific kind used to represent compressed metaspace pointers.
     */
    LIRKind getNarrowPointerKind();
}
