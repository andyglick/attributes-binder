
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

package org.carrot2.util.attribute.test.filtering;

import org.carrot2.util.attribute.Attribute;
import org.carrot2.util.attribute.AttributeLevel;
import org.carrot2.util.attribute.Bindable;
import org.carrot2.util.attribute.Group;
import org.carrot2.util.attribute.Input;
import org.carrot2.util.attribute.Level;
import org.carrot2.util.attribute.Output;
import org.carrot2.util.attribute.TestInit;
import org.carrot2.util.attribute.TestProcessing;

/**
 *
 */
@Bindable
@SuppressWarnings("unused")
public class FilteringReferenceClass
{
    @TestInit
    @Input
    @Attribute
    @Level(AttributeLevel.BASIC)
    private int initInput = 10;

    @TestInit
    @Output
    @Attribute
    @Level(AttributeLevel.MEDIUM)
    private int initOutput = 10;

    @TestProcessing
    @Input
    @Attribute
    @Level(AttributeLevel.ADVANCED)
    @Group("Group B")
    private int processingInput = 10;

    @TestProcessing
    @Output
    @Attribute
    @Group("Group A")
    private int processingOutput = 10;
}
