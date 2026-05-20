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
    public int goodNodes(TreeNode root) {
        
        return helper(root,Integer.MIN_VALUE);
    }

    public int helper(TreeNode root,int max){
        if(root==null) return 0;
        int c=0;
        if(max>root.val){
            c+=helper(root.left,max);
            c+=helper(root.right,max);
            return c;
        }else{
            c+=helper(root.left,root.val);
            c+=helper(root.right,root.val);
            return c+1;
        }
        
    }
}
