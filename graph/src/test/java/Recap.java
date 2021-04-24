import com.example.leetcode.tree.TreeNode;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Recap {
    static int value[] = {1, 6, 10, 16};
    static int weight[] = {1, 2, 3, 5};

    public static void main(String args[]) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3, node5,node1);
        lowestCommonAncestorOfTree(node3,node1,node5);

        String wordBank[] = {"le", "l", "e"};
        String target = "le";
        List<List<String>> lists = constructWord(target, wordBank);

        String str = "abcd";
        List<String> subsets = subsetAll(str);

        int value = knapSack(7, 0);

        String input = "abcde";
//        String target="caebd";

        List<String> resultList = Arrays.asList("b", "a");
//        List<String> collect = Stream.of("a", "b").collect(Collectors.toList());
        String output = String.join(",", resultList).replace(",", "");
        String output2 = resultList.stream().collect(Collectors.joining());
        //check length
        //check equal at the beginning
        boolean flag = scrambleString(input, target);
        System.out.println(flag);
    }

    private static List<List<String>> constructWord(String target, String[] wordBank) {
        List<List<String>> resultList = new ArrayList<>();

        //base case
        if ("".equals(target)) {
            List<String> strings = new ArrayList<>();
            resultList.add(strings);
            return resultList;
        }

        for (int i = 0; i < wordBank.length; i++) {
            String current = wordBank[i];
            if (target.indexOf(current) == 0) {
                int length = current.length();
                String suffix = target.substring(length);
                List<List<String>> lists = constructWord(suffix, wordBank);
                for (List<String> list : lists) {
                    list.add(current);
                }
                resultList.addAll(lists);
            }
        }

        return resultList;
    }

    private static List<String> subsetAll(String str) {
        //base case
        if (str.length() == 0) return new ArrayList<>(Arrays.asList(""));

        //base cases
        List<String> resultList = new ArrayList<>();

        //body
        //take
        String current = String.valueOf(str.charAt(0));
        List<String> in = subsetAll(str.substring(0 + 1));
        List<String> updatedIn = in.stream().map(e -> e + current).collect(Collectors.toList());

        //not to take
        List<String> result2 = in;
        resultList.addAll(updatedIn);
        resultList.addAll(result2);
        return resultList;
    }

    private static boolean scrambleString(String input, String target) {
        int end = input.length() - 1;
        //true
        if (input.equalsIgnoreCase(target)) return true;
        if (input.length() != target.length()) return false;
        //1 word left
        if (input.length() == 1) return false;

        for (int i = 1; i < input.length(); i++) {

            String firstHalf = input.substring(0, i);
            String secondHalf = input.substring(i, end + 1);

            boolean first = scrambleString(firstHalf, target.substring(0, i));
            boolean second = scrambleString(secondHalf, target.substring(i));

            //combination of swap and not swap
            String firstHalfReversed = new StringBuilder(firstHalf).reverse().toString();
            String secondHalfReversed = new StringBuilder(secondHalf).reverse().toString();

            boolean firstReversed = scrambleString(firstHalfReversed, target.substring(0, i));
            boolean secondReversed = scrambleString(secondHalfReversed, target.substring(i));

            if (first && secondReversed == true || first && second == true ||
                    firstReversed && second == true || firstReversed && secondReversed == true)
                return true;

        }
        return false;
    }

    public static int knapSack(int space, int i) {
        //base cases
        if (i >= weight.length) return 0;
        if (space < weight[i]) return 0;

        //take
        int take = value[i] + knapSack(space - weight[i], i + 1);

        //not take
        int not = knapSack(space, i + 1);

        int max = Math.max(not, take);
        return max;
    }

    public static List<String> getAllSubCombination(String str) {
        //base case
        if ("".equals(str)) {
            return new ArrayList<>(Arrays.asList(""));
        }

        List<String> result = Lists.newArrayList();
        for (int i = 0; i < str.length(); i++) {
            String current = str.substring(i, i + 1);
            String suffix = str.substring(i + 1);

            List<String> combination = getAllSubCombination(suffix);
            List<String> combCopy = Lists.newArrayList(combination);
            //not to take
            result.addAll(combination);
            //take
            List<String> collect = combCopy.stream().map(e -> e + current).collect(Collectors.toList());
            result.addAll(collect);
        }

        return result;
    }

    public static TreeNode lowestCommonAncestorOfTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestorOfTree(root.left, p, q);
        TreeNode right = lowestCommonAncestorOfTree(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

}
