package kata2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChopTest {

    @Test
    public void testChop() {

        ChopA chop = new ChopA();

        assertEquals(-1, chop.chop(3, new int[]{}));
        assertEquals(-1, chop.chop(3, new int[]{1}));
        assertEquals(0,  chop.chop(1, new int[]{1}));

        assertEquals(0,  chop.chop(1, new int[]{1, 3, 5}));
        assertEquals(1,  chop.chop(3, new int[]{1, 3, 5}));
        assertEquals(2,  chop.chop(5, new int[]{1, 3, 5}));
        assertEquals(-1, chop.chop(0, new int[]{1, 3, 5}));
        assertEquals(-1, chop.chop(2, new int[]{1, 3, 5}));
        assertEquals(-1, chop.chop(4, new int[]{1, 3, 5}));
        assertEquals(-1, chop.chop(6, new int[]{1, 3, 5}));

        assertEquals(0,  chop.chop(1, new int[]{1, 3, 5, 7}));
        assertEquals(1,  chop.chop(3, new int[]{1, 3, 5, 7}));
        assertEquals(2,  chop.chop(5, new int[]{1, 3, 5, 7}));
        assertEquals(3,  chop.chop(7, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(0, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(2, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(4, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(6, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(8, new int[]{1, 3, 5, 7}));
    }
}
