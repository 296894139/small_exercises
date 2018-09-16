import java.util.ArrayList;

class Solution6 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        int length=lists.length;
        int i=0;
        while((i<length)&&(lists[i]==null)){
            i++;
        }
        if(i>length-1){
            return null;
        }
        int index=i;
        int min=lists[i].val;
        for( i=1;i<length;i++){
            if((lists[i]!=null)&&(lists[i].val<min)){
                index=i;
                min=lists[i].val;
            }
        }
        ListNode head=new ListNode(min);
        lists[index]=lists[index].next;
        ListNode result=head;
        while(true){
               i=0;
               while((i<length)&&(lists[i]==null)){
                   i++;
               }
               if(i>length-1){
                   break;
               }

               index=i;
               min=lists[i].val;
            for( i=0;i<length;i++){

                if(lists[i]!=null){
                    if(lists[i].val<min){
                        min=lists[i].val;
                        index=i;
                    }
                }
            }
            ListNode tem=new ListNode(min);
            result.next=tem;
            result=tem;
            lists[index]=lists[index].next;

        }
         return head;
    }
    public static void main(String []args){
        Solution6 s=new Solution6();
      /*  ListNode tem1=new ListNode(1);
        tem1.next=new ListNode(4);
        tem1.next.next=new ListNode(5);
        ListNode tem2=new ListNode(1);
        tem2.next=new ListNode(3);
        tem2.next.next=new ListNode(4);
        ListNode tem3=new ListNode(2);
        tem3.next=new ListNode(6);*/

        ListNode tem1=new ListNode(2);
        ListNode tem3=new ListNode(1);

        ListNode[] lists={null,null,null};
        ListNode head=s.mergeKLists(lists);
        while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }


    }
}