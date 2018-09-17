class Solution7 {
    public ListNode swapPairs(ListNode head) {
        if((head==null)||(head.next==null)){
            return head;
        }
            ListNode result_head=head.next;
            ListNode before=null;
            ListNode tem=head;
            while((tem!=null)&&(tem.next!=null)){
                ListNode tem2=tem.next.next;
                ListNode tem1=tem.next;
                tem.next=tem2;
                tem1.next=tem;
                if(before!=null){
                    before.next=tem1;
                }
                before=tem;
                tem=tem2;

            }
            return result_head;
    }
    public static void main(String []args){
        ListNode tem1=new ListNode(1);
        tem1.next=new ListNode(4);
        tem1.next.next=new ListNode(5);
        tem1.next.next.next=new ListNode(6);
        Solution7 s=new Solution7();
        ListNode tem0=null;
        ListNode result=s.swapPairs(tem0);
        while(result!=null){
            System.out.print(result.val+"->");
            result=result.next;
        }
    }
}
