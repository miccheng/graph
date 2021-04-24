import com.example.leetcode.rotate.BusStop;
import com.example.leetcode.recursivestring.LetterCombination;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class LetterCombinationTest {
    @Test
    public void test_empty() {
        String digits="";
        List<String> expected = Lists.newArrayList();
        List<String> output = new LetterCombination().findCombinations(digits);
        Assert.assertEquals(expected,output);
    }

    @Test
    public void test_good() {
        String digits="2345";
        List<String> expected = Lists.newArrayList("ad", "bd", "cd", "ae", "be", "ce", "af", "bf", "cf");
        List<String> output = new LetterCombination().findCombinations(digits);
        Assert.assertEquals(expected,output);
    }

    @Test
    public void test_roman() {
        String number="1994";
        new LetterCombination().convert2RomanNum(number);
        String output="";
        String expected="xciv";
        Assert.assertEquals(expected,output);
    }

    @Test
    public void test_bus() {
        int[] array = {1, 2, 3, 4};
        int expected = 3;
        int output = new BusStop().distanceBetweenBusStops(array, 0, 2);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void test_bus_reverse() {
        int[] array ={7,10,1,12,11,14,5,0};
        int expected = 17;
        int output = new BusStop().distanceBetweenBusStops(array, 7, 2);
        Assert.assertEquals(expected, output);
    }


}
