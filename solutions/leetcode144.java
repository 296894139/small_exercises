
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 徐介晖
 * @创建时间 2018/9/23
 * @描述 Given a binary tree, return the preorder traversal of its nodes' values.
 */
public class leetcode144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=reverse(root);
        return result;
    }

    public List<Integer> reverse(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null) return result;
        List<Integer> left=preorderTraversal(root.left);
        List<Integer> right=preorderTraversal(root.right);
        result.add(root.val);
        if(left!=null){
            for(int i=0;i<left.size();i++){
                result.add(left.get(i));
            }
        }

        if(right!=null){
            for(int i=0;i<right.size();i++){
                result.add(right.get(i));
            }
        }


        return  result;
    }


    public static  void main(String[]a){
        leetcode144 s=new leetcode144();
        TreeNode n=new TreeNode(1);
        n.right=new TreeNode(2);
        n.right.left=new TreeNode(3);
        System.out.println(s.preorderTraversal(n));

    }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

