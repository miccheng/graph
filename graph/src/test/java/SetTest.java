import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(JUnit4.class)
public class SetTest {
    public static MySet empty = new MySet();
    public static MySet one = new MySet();
    public static MySet two = new MySet();

    @BeforeClass
    public static void setup() {
        one.add("1");
        two.add("1");
        two.add("2");
    }

    @Test
    public void test_empty() {
        Assert.assertEquals(true, empty.isEmpty());
        Assert.assertEquals(false, one.isEmpty());
        Assert.assertEquals(false, two.isEmpty());
    }

    @Test
    public void test_size() {
        Assert.assertEquals(0, empty.size());
        Assert.assertEquals(1, one.size());
        Assert.assertEquals(2, two.size());
    }

    @Test
    public void test_has_value() {
        Assert.assertEquals(false, empty.hasValue("1"));
        Assert.assertEquals(true, one.hasValue("1"));
        Assert.assertEquals(true, two.hasValue("2"));
    }

    @Test
    public void test_no_duplicates() {
        MySet set = new MySet();
        set.add("1");
        set.add("1");

        Assert.assertEquals(1, set.size());
    }

    @Test
    public void test_remove() {
        MySet set = new MySet();
        set.add("1");
        set.add("2");
        set.add("3");

        set.remove("2");

        Assert.assertEquals(2, set.size());
        Assert.assertEquals(false, set.hasValue("2"));
        Assert.assertEquals(true, set.hasValue("1"));
        Assert.assertEquals(true, set.hasValue("3"));
    }

}
