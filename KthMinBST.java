import java.util.* ;

import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/
/* WE USE INORDER TRAVERSAL HERE AND AFTER THE LEFT RETURN WE INCREASE THE VALUE OF I WHICH IS REFERENCE VARIABLE AND WHEN THE VALUE OF I IS EQUALL TO K THEN WE RETURN THE VALUE OF ROOT
*/
public class Solution 
{
    public static int inOrderTraversal(TreeNode<Integer> root, int[] i, int k){
        if(root == null)
            return -1;
        
        int left = inOrderTraversal(root.left, i, k);
        if(left != -1)
            return left;

        i[0]++;

        if(i[0] == k)
            return root.data;
        int right = inOrderTraversal(root.right, i, k);

        if(right != -1)
            return right;

        
        return -1;
    }
	public static int kthSmallest(TreeNode<Integer> root, int k) {
        //    Write your code here.
        int[] i = {0};
        
        return inOrderTraversal(root, i, k);


    }
}
