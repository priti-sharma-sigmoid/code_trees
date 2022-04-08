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
    HashMap<Integer,Integer> mp=new HashMap<>();
    int preindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        
        return build(preorder,inorder,0,inorder.length-1);
    }
    
    public  TreeNode build(int[] preorder, int[] inorder,int start,int end){
       
        if(start>end) return null;
        
        TreeNode root= new TreeNode(preorder[preindex++]);
        
         if(root==null)
            return null;
        
        if(start==end) return root;
        
        int index=mp.get(root.val);
        
        root.left=build(preorder,inorder,start,index-1);
        root.right=build(preorder,inorder,index+1,end);
        
        return root;
    }
    
}
