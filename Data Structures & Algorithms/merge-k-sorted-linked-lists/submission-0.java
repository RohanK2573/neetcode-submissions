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

class Pair{
    int node;
    ListNode head;
    Pair(int node,ListNode h){
        this.node=node;
        this.head=h;
    }
}

class Solution {

    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq=prepareQueue(lists);
        ListNode ans=new ListNode(-1,null);
        ListNode curr=ans;
        while(!pq.isEmpty()){
            Pair current=pq.poll();
            ListNode currentHead=current.head;
            curr.next=currentHead;;
            curr=curr.next;
    
            currentHead=currentHead.next;
            if(currentHead!=null) pq.offer(new Pair(currentHead.val,currentHead));
        }
        curr.next=null;
        return ans=ans.next;
       

    }

    public PriorityQueue<Pair> prepareQueue(ListNode[] lists){
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(a.node-b.node));
        for(int i=0;i<lists.length;i++){
            pq.offer(new Pair(lists[i].val,lists[i]));
        }
        return pq;
    }
}
