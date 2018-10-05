/**
 * @创建人 徐介晖
 * @创建时间 2018/10/5
 * @描述  Given a sorted linked list, delete all duplicates such that each element appear only once.
 */
public class leetcode83 {

    public ListNode deleteDuplicates(ListNode head) {
           ListNode tem=head;
           ListNode before=null;
           while(tem!=null){
            if(before!=null){
                if(before.val==tem.val){
                    before.next=tem.next;
                }else{
                    before=tem;
                }
            }else{
                before=tem;
            }
            tem=tem.next;
           }
           return head;
    }
    public static void main(String[]args){
        leetcode83 s=new leetcode83();
        ListNode tem=new ListNode(1);
        tem.next=new ListNode(1);
        tem.next.next=new ListNode(2);
        tem.next.next.next=new ListNode(2);
        ListNode tem0=s.deleteDuplicates(tem);
        System.out.println(tem0.val);
        System.out.println(tem0.next.val);
        if(tem0.next.next!=null){
            System.out.println(123);
        }

    }
}
