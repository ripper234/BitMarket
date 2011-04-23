package org.totallycommon.util.assertions;

import org.testng.Assert;

/**
 * The goal of this class is to isolate our project's dependencies from any particular unit testing framework.
 */
public class AssertUtil {
    private AssertUtil() {
    }

    public static void assertEquals(int expected, int actual) {
        Assert.assertEquals(actual, expected);
    }

    public static void assertNotNull(Object saved) {
        Assert.assertNotNull(saved);
    }

    public static void assertEquals(double expected, double actual) {
        double delta = 0.00001;
        Assert.assertEquals(actual, expected, delta);
    }

    public static void assertNotSame(long actual, long expected) {
        Assert.assertNotSame(actual, expected);
    }
}
