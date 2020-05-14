
/**
 * @Copyright:Copyright (c) 2017 - 2018
 * @Company:aomi-miguatch
 * @User: Petershow@mem853.com
 * @BaseTestConfiguration.java
 * @Author Petershow@mem853.com
 * @Time 下午3:24:07
 */

package com.migua.tech.test;

import org.junit.Test;

public class ThingTests extends BaseTestConfiguration {
    @Test
    public void testThis() {
        /* will fail if not done in 1 minute */
    }

    @Test
    public void testThat() {
        /* will fail if not done in 1 minute */
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        formula.calculate(100);                    //	100.0 formula.sqrt(16);											//	4.0

    }
}
