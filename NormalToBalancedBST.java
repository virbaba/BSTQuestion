import java.util.ArrayList;

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

    // here we are using inorder traversal and store it into array and then each time we find mid which act as root and start to mid - 1 treated as left subtree and 
    mid + 1 to end treated as right subtree and then root.left = leftSubtree & root.right = rightSubtree

************************************************************/

public class Solution 
{
    // firstly store inorder traversal
    public static void inOrder(TreeNode<Integer> root, ArrayList<Integer> list){
        if(root == null)
            return;
        
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    // now making BST
    public static TreeNode<Integer> makeTree(int s, int e, ArrayList<Integer> list){
        if(s > e)
            return null;
        
        int mid = s + (e-s) / 2;

        TreeNode<Integer> root = new TreeNode<>(list.get(mid));

        root.left = makeTree(s, mid - 1, list);
        root.right = makeTree(mid + 1, e, list);

        return root;
    }
    public static TreeNode<Integer> balancedBst(TreeNode<Integer> root)
    {
        //    Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int s = 0, e = list.size() - 1;
        return makeTree(s, e, list);
    }
}
