package com.example.leetcode.tree;

import java.util.LinkedList;

public class VerifyPreorderInBST {
    int start = 0;

    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        validate(preorder, Integer.MAX_VALUE, Integer.MIN_VALUE);

        return start == preorder.length;
    }

    private void validate(int[] preorder, Integer max, Integer min) {
        if (start == preorder.length) return;

        if ((min != Integer.MIN_VALUE && preorder[start] <= min) || (max != Integer.MAX_VALUE && preorder[start] >= max))
            return;
        int rootVal = preorder[start++];
        //  start++;

        validate(preorder, rootVal, min);
        validate(preorder, max, rootVal);
    }


}
