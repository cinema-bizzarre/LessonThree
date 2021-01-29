import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestArrayOneAndFour {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 4, 4, 4, 1, 4, 1}, true},
                {new int[]{9, 6, 3, 5, 9, 3, 5, 1}, false},
                {new int[]{1, 4, 8, 7}, false}
        });
    }
    private int[] in;
    private boolean out;

    public TestArrayOneAndFour(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    private ArrayOneAndFour array;

    @Before
    public void startTest() {
        array = new ArrayOneAndFour();
    }

    @Test
    public void testOnly1And4() {
        Assert.assertEquals(ArrayOneAndFour.Only1And4(in), out);
    }
}
