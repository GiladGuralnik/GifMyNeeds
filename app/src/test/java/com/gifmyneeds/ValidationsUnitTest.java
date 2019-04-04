package com.gifmyneeds;

import com.gifmyneeds.utilities.Validations;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ValidationsUnitTest {

    @Test
    public void testIsIdValid() {
        assertTrue(Validations.isIdValid("311606420"));
        assertTrue(Validations.isIdValid("27806389"));
    }

    @Test
    public void testIsIdNotValid() {
        assertFalse(Validations.isIdValid(""));
        assertFalse(Validations.isIdValid("s2343453"));
        assertFalse(Validations.isIdValid("311606421"));
        assertFalse(Validations.isIdValid("3116064200"));
    }
}