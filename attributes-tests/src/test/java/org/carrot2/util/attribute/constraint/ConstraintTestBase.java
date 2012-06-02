
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

package org.carrot2.util.attribute.constraint;

import java.lang.annotation.Annotation;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.carrotsearch.randomizedtesting.RandomizedTest;

/**
 * Base class for {@link Constraint} tests.
 */
public abstract class ConstraintTestBase<T extends Annotation> extends RandomizedTest
{
    void assertMet(final Object value) throws NoSuchFieldException
    {
        assertMet(value, getConstrainedFieldName());
    }

    void assertNotMet(final Object value) throws NoSuchFieldException
    {
        assertNotMet(value, getConstrainedFieldName());
    }

    void assertMet(final Object value, String fieldName) throws NoSuchFieldException
    {
        Assertions.assertThat(ConstraintValidator.isMet(value, getAnnotation(fieldName))).isEmpty();
    }

    void assertNotMet(final Object value, String fieldName) throws NoSuchFieldException
    {
        final T annotation = getAnnotation(fieldName);
        Assertions.assertThat(ConstraintValidator.isMet(value, annotation)).contains(annotation);
    }

    private T getAnnotation(String fieldName) throws NoSuchFieldException
    {
        return getAnnotationContainerClass().getDeclaredField(fieldName).getAnnotation(
            getAnnotationType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidType() throws Exception
    {
        if (isInvalidTypeChecked())
        {
            assertMet(new UnknownType(), getInvalidTypeCheckFieldName());
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    boolean isInvalidTypeChecked()
    {
        return true;
    }

    abstract Class<T> getAnnotationType();

    abstract Class<?> getAnnotationContainerClass();

    String getConstrainedFieldName()
    {
        return "field";
    }
    
    String getInvalidTypeCheckFieldName()
    {
        return getConstrainedFieldName();
    }

    /**
     * A type that is guaranteed not to be supported by the constraint.
     */
    static class UnknownType
    {
    }
}
