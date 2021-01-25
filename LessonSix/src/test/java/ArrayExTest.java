import org.junit.Before;
import org.junit.Test;

public class ArrayExTest {

    private Array arr;

    @Before
    public void startTest() {
        arr = new Array();
    }

    @Test(expected = RuntimeException.class)
    public void testAfterLast4Ex() {
        Array.AfterLast4(new int[]{0, 3, 7, 5, 0, 0, 3, 2});
    }
}
