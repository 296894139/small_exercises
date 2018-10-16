/**
 * @创建人 徐介晖
 * @创建时间 2018/10/16
 * @描述  Invert a binary tree
 */
public class leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }else{
            invertTree(root.left);
            invertTree(root.right);
            TreeNode tem=root.left;
            root.left=root.right;
            root.right=tem;
            return root;
        }

    }
}
