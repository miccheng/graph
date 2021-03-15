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
        ArrayList<TreeNode> roots = new ArrayList<>();
        constructTree(integers,roots);
    }

    public static TreeNode constructTree( List<Integer> list,List<TreeNode> roots ) {
        TreeNode parentNode = null;
        for (int i = 0; i < list.size(); i++) {
            parentNode = new TreeNode(list.get(i));
            roots.add(parentNode);

            if (list.size() == 1) {
                return parentNode;
            }

            int tail = list.size();
            //left
            if (i != 0) {
                TreeNode leftNode = constructTree(list.subList(0, i), roots);
                parentNode.left = leftNode;
            } else {
                parentNode.left = null;
            }

            //right
            if (i != tail) {
                TreeNode rightNode = constructTree(list.subList(i + 1, tail), roots);
                parentNode.right = rightNode;
            } else {
                parentNode.right = null;
            }

        }
        return parentNode;
    }


}
