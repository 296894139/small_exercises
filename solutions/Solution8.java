import java.util.ArrayList;

public class Solution8 {
    public ListNode reverseKGroup(ListNode head, int k) {
         ListNode before=null;
         ListNode result_head=head;
         ListNode tem=head;
         if(head==null){
             return null;
         }
         for(int i=0;i<k-1;i++){
             result_head=result_head.next;
             if(result_head==null){
                 return head;
             }
         }

         while(tem!=null){
              ArrayList<ListNode> list=new ArrayList<>();
              ListNode tem1=tem;
              for(int i=0;i<k-1;i++){
                  list.add(tem1);
                  tem1=tem1.next;
                  if(tem1==null){
                      return result_head;
                  }
              }
              list.add(tem1);
              ListNode end=tem1.next;
              for(int i=k-1;i>0;i--){
                  list.get(i).next=list.get(i-1);
              }
              list.get(0).next=end;
              if(before!=null){
                  before.next=list.get(k-1);
              }
              before=tem;
              tem=end;
         }


             return result_head;
    }
}
