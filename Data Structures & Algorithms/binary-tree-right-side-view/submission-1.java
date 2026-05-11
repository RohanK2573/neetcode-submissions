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
    public List<Integer> rightSideView(TreeNode root) {
    Queue<TreeNode> q=new ArrayDeque<>();
    List<Integer> ans=new ArrayList<>();
    if(root==null) return ans;
    q.offer(root);
    while(!q.isEmpty()){
        int levelSize=q.size();
        int ele=0;
        for(int i=0;i<levelSize;i++){
            TreeNode node=q.poll();
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
            ele=node.val;
            
        }
        ans.add(ele);
    }
    return ans;

        
    }
    
}
