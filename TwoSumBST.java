import java.util.* ;
import java.io.*; 
/* 

	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

*/
/*
  Approach-1
  in this approach first we traverse tree inorder way and store it into arraylist and using two pointer approach we try to find pair
  TIME COMPLEXITY: O(N)
  SPACE COMPLEXITY: O(N)
*/
public class Solution {
	 public static void solve(BinaryTreeNode<Integer> root, ArrayList<Integer> list){
        if(root == null)
            return;
        
        solve(root.left, list);
        list.add(root.data);
        solve(root.right, list);
    }
	public static boolean twoSumInBST(BinaryTreeNode<Integer> root, int k) {
		// Write your code here!
		ArrayList<Integer> list = new ArrayList<>();
        solve(root, list);

        int i = 0, j = list.size() - 1;
        while(i < j){
            if(list.get(i) + list.get(j) == k)
                return true;
            else if(list.get(i) + list.get(j) < k)
                i++;
            else
                j--;
        }

        return false;
	}
}

/*
    Time Complexity: O(N). 
    Space Complexity: O(H).
    
    Where N is the total number of nodes in the tree and H is the height of the tree.
*/

import java.util.Stack;

public class Solution {
    public static boolean twoSumInBST(BinaryTreeNode<Integer> root, int target) {

        // It stores the iterators for starting and ending indices
        Stack<BinaryTreeNode<Integer>> start = new Stack<>();
        Stack<BinaryTreeNode<Integer>> end = new Stack<>();

        // It initialises the starting operator
        BinaryTreeNode<Integer> currNode = root;

        while (currNode != null) {
            start.push(currNode);
            currNode = currNode.left;
        }

        // It initialises the ending operator
        currNode = root;

        while (currNode != null) {
            end.push(currNode);
            currNode = currNode.right;
        }

        // Using the two-pointer technique.
        while (start.peek() != end.peek()) {

            // It stores the values at starting and end node data
            int val1 = start.peek().data;
            int val2 = end.peek().data;

            // If the sum of values = target, return true
            if (val1 + val2 == target) {
                return true;
            }

            // If the sum of values < target, then move to the next greatest closer value.
            if (val1 + val2 < target) {
                currNode = start.peek().right;
                start.pop();
                while (currNode != null) {
                    start.push(currNode);
                    currNode = currNode.left;
                }
            }

            // If the sum of values > target value, then move to the next smallest closer
            // value .
            else {
                currNode = end.peek().left;
                end.pop();
                while (currNode != null) {
                    end.push(currNode);
                    currNode = currNode.right;
                }
            }
        }

        // If no two nodes is found, return false
        return false;
    }
}
