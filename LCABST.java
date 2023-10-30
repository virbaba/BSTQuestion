/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

public class Solution {
    public static TreeNode LCAinaBST(TreeNode root, TreeNode p, TreeNode q) {
        // Write your code here.
        // here we have three case
        /*
            1. may be our root.data is less than to p.data && q.data
            then we move at right
            2. may be our root.data is greater than to p.data && q.data
            then we move at left
            3. may be our root.data is greater than to p.data && less than to q.data or 
            vice versa it's mean our current node is answer and return it
        */
        if(root == null)
            return root;
        
        else if((root.data > p.data && root.data < q.data) || (root.data < p.data && root.data > q.data))
            return root;

        else if(root.data < p.data && root.data < q.data)
            return LCAinaBST(root.right, p, q);
        
        else if(root.data > p.data && root.data > q.data)
            return LCAinaBST(root.left, p, q);
        
        return root;
    }
}
