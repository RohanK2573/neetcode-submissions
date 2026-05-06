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
    public int pairSum(ListNode head) {
        ListNode curr=head;
        ListNode scurr=reverseSecondHalf(head);
        int maxSum=0;
        while(scurr!=null){
            int sum=curr.val+scurr.val;
            maxSum=Math.max(maxSum,sum);
            curr=curr.next;
            scurr=scurr.next;

        }
        return maxSum;
        
    }

    public ListNode reverseSecondHalf(ListNode head){
        int len=findLengthOfList(head);
        ListNode midNode=findMiddle(head,len);
        ListNode prev=null;
        ListNode curr=midNode;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public int findLengthOfList(ListNode head){
        int len=1;
        ListNode curr=head;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        return len;
    }
    public ListNode findMiddle(ListNode head,int len){
        int mid=1;
        ListNode curr=head;
        while(mid<=len/2){
            mid++;
            curr=curr.next;
        }
        return curr;

    }
}