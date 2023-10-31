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
 6521171 5650934 9278816 899375 -1 8989449 -1 -1 -1 -1 -1 

arr[0] denote predecessor & arr[1] denote successor
  ********************************************************/

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static TreeNode findKey(TreeNode root, int key, int[] arr){
        if(root == null)
            return null;
            
        if(root.data == key)
            return root;
        
        if(key < root.data){
            arr[1] = root.data;
            return findKey(root.left, key, arr);
        }
            
        arr[0] = root.data;
        return findKey(root.right, key, arr);
    } 
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        // Write your code here.
        // in this question first we find key and when we traverse the tree inorder way
        // then right most of left tree is predecessor and left most of right subtree is 
        // successor
        // while visiting remember that may current root is predecessor or may be successor
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        
        root = findKey(root, key, arr);
        TreeNode t1 = null;
        TreeNode t2 = null;

        int pre = arr[0];
        int suc = arr[1];
        
        if(root == null)
        {
            ans.add(pre);
            ans.add(suc);
            return ans;
        }

        if(root.left != null){
            t1 = root.left;
            while(t1.right != null){
                t1 = t1.right;
            }
            pre = t1.data;
        }

        if(root.right != null){
            t2 = root.right;
            while(t2.left != null){
                t2 = t2.left;
            }
            suc = t2.data;
        }

        
        ans.add(pre);
        ans.add(suc);

        return ans;
        
    }
}
