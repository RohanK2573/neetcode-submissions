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
              if(head == null || head.next == null) return;
       int len=findLength(head);
       ListNode midNode=findMid(head,len);
       ListNode rHead=reverse(midNode.next);
       midNode.next=null;
       ListNode curr=head;
       while(rHead!=null){
        ListNode temp=curr.next;
        ListNode rTemp=rHead.next;
          curr.next=rHead;
          curr=temp;
          rHead.next=temp;
          rHead=rTemp;
        }
    }

    public ListNode reverse(ListNode mid){
        ListNode prev=null;
        ListNode curr=mid;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    public int findLength(ListNode head){
        int i=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            i++;
        }
        return i;
    }
    public ListNode findMid(ListNode head,int len){
         int i=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            i++;
            if(i==len/2) return curr;
        }
        return curr;
    }
    
}
