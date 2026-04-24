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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        ListNode finalHead=null;
            ListNode prevHead=null;
        while(curr!=null){
            ListNode temp=curr;
            ListNode kthNode=temp;
            ListNode nextGroup=null;
            int i=1;
            while(kthNode!=null && i<k){
                i++;
                kthNode=kthNode.next;
             
            }
            if(i<k || kthNode==null){
                   prevHead.next=curr;
                   break;
            } 
            if(kthNode.next!=null) nextGroup=kthNode.next;

            reverseList(temp,kthNode,null);
            if(finalHead==null) finalHead=kthNode;
            if(prevHead==null) prevHead=temp;
            else{
                prevHead.next=kthNode;
                prevHead=temp;
            }
            curr=nextGroup;

        }
        return finalHead;

       
       
}

  public void reverseList(ListNode temp,ListNode kthNode,ListNode prev){
    if(temp==kthNode){
        temp.next=prev;
        return;
    }
    reverseList(temp.next,kthNode,temp);
    temp.next=prev;
  }
}
