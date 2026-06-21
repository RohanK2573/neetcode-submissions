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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //find length.
        int len=findLen(head);

        ListNode prev=null;
        ListNode curr=head;
        int count=len;
        while(count>n && curr!=null){
            count--;
            prev=curr;
            curr=curr.next;
        }
        if(prev==null){
            return curr.next;
        }
        prev.next=curr.next;
        return head;
        //take two pointers keep moving forward till you reach len-nth node.and finally remove.


    }

    public int findLen(ListNode head){
        int i=0;
        ListNode curr=head;
        while(curr!=null){
            i++;
            curr=curr.next;
        }
        return i;
    }
}

