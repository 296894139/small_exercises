/*Given a linked list, remove the n-th node from the end of list and return its head.

        Example:

        Given linked list: 1->2->3->4->5, and n = 2.

        After removing the second node from the end, the linked list becomes 1->2->3->5.*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution9 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end=head;
        for(int i=0;i<n;i++){
            if(end.next==null){
                return head.next;
            }else{
                end=end.next;
            }
        }
        ListNode head0=head;
        while(end.next!=null){
            head0=head0.next;
            end=end.next;
        }
        head0.next=head0.next.next;

        return head;


    }
}