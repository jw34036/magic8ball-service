package org.light32.projects.m8b;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jwhitt on 8/15/16.
 */
public class Magic8BallTest {

    @Test
    public void testAsk() {
        Magic8Ball m = new Magic8Ball();

        assertNotNull(m.ask());
    }
}
