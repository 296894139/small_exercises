/**
 * @创建人 徐介晖
 * @创建时间 2018/9/25
 * @描述  Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 */
public class leetcode116 {
    public void connect(TreeLinkNode root) {

             root=relate(root,null,1);
             if(root!=null){
                 root.next=null;
             }
    }
    public TreeLinkNode relate(TreeLinkNode now,TreeLinkNode last,int k){
        if(now==null){
            return null;
        }
        if(last==null){
            now.next=null;
            now.left=relate(now.left,now,0);
            now.right=relate(now.right,now,1);
        }else{
            if(k==0){  //当前为左
                now.next=last.right;
                TreeLinkNode left=now.left;
                now.left=relate(left,now,0);
                TreeLinkNode right =now.right;
                now.right=relate(right,now,1);
            }else{
                if(last.next!=null){
                    now.next=last.next.left;
                }else{
                    now.next=null;
                }
                TreeLinkNode left=now.left;
                now.left=relate(left,now,0);
                TreeLinkNode right =now.right;
                now.right=relate(right,now,1);

            }
        }
        return now;
    }
    public static void main(String[]ats){
        TreeLinkNode s=new TreeLinkNode(0);
        leetcode116 ss=new leetcode116();
        ss.connect(s);
        System.out.println(s);
    }
}
class TreeLinkNode {
    int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }