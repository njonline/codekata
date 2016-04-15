package kata2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChopTest {

    ChopA chop = new ChopA();

    @Test
    public void testChop() {
        assertEquals(-1, chop.chop(3, new Integer[]{}));
        assertEquals(-1, chop.chop(3, new Integer[]{1}));
        assertEquals(0,  chop.chop(1, new Integer[]{1}));

        assertEquals(0,  chop.chop(1, new Integer[]{1, 3, 5}));
        assertEquals(1,  chop.chop(3, new Integer[]{1, 3, 5}));
        assertEquals(2,  chop.chop(5, new Integer[]{1, 3, 5}));
        assertEquals(-1, chop.chop(0, new Integer[]{1, 3, 5}));
        assertEquals(-1, chop.chop(2, new Integer[]{1, 3, 5}));
        assertEquals(-1, chop.chop(4, new Integer[]{1, 3, 5}));
        assertEquals(-1, chop.chop(6, new Integer[]{1, 3, 5}));

        assertEquals(0,  chop.chop(1, new Integer[]{1, 3, 5, 7}));
        assertEquals(1,  chop.chop(3, new Integer[]{1, 3, 5, 7}));
        assertEquals(2,  chop.chop(5, new Integer[]{1, 3, 5, 7}));
        assertEquals(3,  chop.chop(7, new Integer[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(0, new Integer[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(2, new Integer[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(4, new Integer[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(6, new Integer[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(8, new Integer[]{1, 3, 5, 7}));
    }
}
