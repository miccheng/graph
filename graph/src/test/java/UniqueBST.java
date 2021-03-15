import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public static void main(String args[]){
        List<Integer> integers = Lists.newArrayList(1, 2, 3);
        constructTree(integers);
    }

    public static List<TreeNode> constructTree( List<Integer> list ) {
        List<TreeNode> roots = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TreeNode parentNode = new TreeNode(list.get(i));
            roots.add(parentNode);

            if (list.size() == 1) {
                roots.add(parentNode);
                return roots;
            }

            int tail = list.size();
            List<TreeNode> leftNodes = new ArrayList<>();
            List<TreeNode> rightNodes = new ArrayList<>();
            //left
            if (i != 0) {
                leftNodes.addAll(constructTree(list.subList(0, i)));
//                parentNode.left = leftNode;
            } else {
                parentNode.left = null;
            }

            //right
            if (i != tail) {
                rightNodes.addAll(constructTree(list.subList(i + 1, tail)));
//                parentNode.right = rightNode;
            } else {
                parentNode.right = null;
            }

            for (TreeNode node : leftNodes) {
                for (TreeNode node2 : rightNodes) {
                    parentNode.left = node;
                    parentNode.right = node2;
                    roots.add(parentNode);
                }
            }
        }
        return roots;
    }

    private List<TreeNode> genTreeList (int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (start > end) {
            list.add(null);
        }
        for(int idx = start; idx <= end; idx++) {
            List<TreeNode> leftList = genTreeList(start, idx - 1);
            List<TreeNode> rightList = genTreeList(idx + 1, end);
            for (TreeNode left : leftList) {
                for(TreeNode right: rightList) {
                    TreeNode root = new TreeNode(idx);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
