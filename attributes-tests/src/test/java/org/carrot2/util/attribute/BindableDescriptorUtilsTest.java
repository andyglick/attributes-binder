
/*
 * Carrot2 project.
 *
 * Copyright (C) 2002-2012, Dawid Weiss, Stanisław Osiński.
 * All rights reserved.
 *
 * Refer to the full license file "carrot2.LICENSE"
 * in the root folder of the repository checkout or at:
 * http://www.carrot2.org/carrot2.LICENSE
 */

package org.carrot2.util.attribute;

import org.junit.Test;

import com.carrotsearch.randomizedtesting.RandomizedTest;

public class BindableDescriptorUtilsTest extends RandomizedTest
{
    @Test
    public void testGetDescriptorClassName()
    {
        assertEquals(
            "MyClassDescriptor", 
            BindableDescriptorUtils.getDescriptorClassName("MyClass"));

        assertEquals(
            "com.mypackage.MyClassDescriptor", 
            BindableDescriptorUtils.getDescriptorClassName("com.mypackage.MyClass"));

        assertEquals(
            "com.mypackage.MyClassDescriptor", 
            BindableDescriptorUtils.getDescriptorClassName("com.mypackage.Outer$MyClass"));

        assertEquals(
            "com.mypackage.MyClassDescriptor", 
            BindableDescriptorUtils.getDescriptorClassName("com.mypackage.Outer$Nested$MyClass"));
    }
}
