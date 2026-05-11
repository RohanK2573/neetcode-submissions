/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
          q= helper( root, k,q);
          return q.peek();
        
    }
    public PriorityQueue<Integer> helper(TreeNode root,int k,PriorityQueue<Integer> q){
        if(root==null) return q;
        if(q.size()==k){
            if(q.peek()>root.val){
                q.poll();
                q.offer(root.val);
            }
        }else{
            q.offer(root.val);
        }
        q=helper(root.left,k,q);
        q=helper(root.right,k,q);
        return q;
    }
}
