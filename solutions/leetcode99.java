/**
 * @创建人 徐介晖
 * @创建时间 2018/10/3
 * @描述  Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure
 */

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class leetcode99 {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode cur = null;

        Stack<TreeNode> stack = new Stack<>();
        cur = root;

        // inOrder traversal
        while (cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            //因为 bst + inOrder 最小的一定是在最前面
            if (first == null && prev.val > cur.val) {
                first = prev;
            }

            // 第二次的时候 因为是 bst + inOrder 第一个大的element 已经找到了 -> first = prev
            //            那么 第二个 就应该是cur 因为 prev.val > cur.val 是错误的  prev.val 应该小于 cur.val
            if (first != null && prev.val > cur.val) {
                second = cur;
            }

            // update cur value
            prev = cur;

            // preOrder logic
            cur = cur.right;
        }

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}

