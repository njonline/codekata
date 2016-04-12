package kata2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChopTest {

    @Test
    public void testChop() {

        KarateChop chop = new KarateChop();

        int[] numbers = new int[] {1, 3, 5, 7};

        assertEquals(0, chop.chop5(1, numbers));
        assertEquals(3, chop.chop5(7, numbers));
        assertEquals(2, chop.chop5(5, numbers));
        assertEquals(-1, chop.chop5(2, numbers));
        assertEquals(-1, chop.chop5(4, numbers));
        assertEquals(-1, chop.chop5(8, numbers));

    }
}
