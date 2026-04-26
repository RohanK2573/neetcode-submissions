/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> s=new Stack<>();
        ListNode curr=head;
        int len=0;
        while(curr!=null){
            s.push(curr);
            len++;
            curr=curr.next;
        }
         curr=head;
len=len/2;
        while(len>0){
            ListNode nth=s.pop();
            ListNode temp=curr.next;
            curr.next=nth;
            nth.next=temp;
            curr=temp;
            len--;
        }
        curr.next=null;


        
        
    }
}
