import java.util.HashMap;
import java.util.Map;

public class Tests {
    public static Map<String, String[]> data () {
        Map<String, String[]> data = new HashMap<String, String[]>();
        data.put("a", new String[] {"c", "d"});
        data.put("b", new String[] {"d", "a", "c"});
        data.put("c", new String[] {"a", "b"});
        data.put("d", new String[] {"c", "a", "b"});
        return data;
    }

    //check map
    // user's wish list
    public static void testInput(){
        new Solution(new HashMap<String, String[]>()).validateInput("a");
    }

    public static void testHasMutualFirstChoice() {
        assertEqual(new Solution(data()).hasMutualFirstChoice("a"), true);
        assertEqual(new Solution(data()).hasMutualFirstChoice("b"), false);
        assertEqual(new Solution(new HashMap<String, String[]>()).validateInput("b"), false);
    }

    public static void testHasMutualPairForRank() {
     assertEqual(new Solution(data()).hasMutualPairForRank("a", 0), true);
     assertEqual(new Solution(data()).hasMutualPairForRank("a", 1), true);
   }

    public static void assertEqual(boolean actual, boolean expected) {
        if (expected == actual) {
            System.out.println("PASSED");
        } else {
            throw new AssertionError(
                    "Expected:\n  " + expected +
                            "\nActual:\n  " + actual +
                            "\n");
        }
    }

    public static void assertEqual(String[] actual, String expected[]) {
        if (!String.join(",", expected).equals(String.join(",", actual))) {
            throw new AssertionError(
                    "Expected:\n  " + String.join(",", expected) +
                            "\nActual:\n  " + String.join(",", actual) +
                            "\n");
        }
        System.out.println("PASSED");
    }

}
