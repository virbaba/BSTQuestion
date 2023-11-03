
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
     TreeNode(int val) {
         this.data = val;
         this.left = null;
         this.right = null;
     }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.data = val;
         this.left = left;
         this.right = right;
     }
 };

 Approach: 1 first we store INORDER TRAVERSAL OF BOTH TREE INTO ARRAYLIST AND THE WE MERGE TWO SORTED ARRAYLIST INTO SINGLE SORTED LIST
 TIME COMPLEXITY: O(M+N)
 SPACE COMPLEXIYT: O(M+N)
 ********************************************************/

import java.util.*;

public class Solution {
    // firstly inorder traversal of both tree
    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }


    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        // Write your code here.
         
         List<Integer> list1 = new ArrayList<>();
         List<Integer> list2 = new ArrayList<>();
         
         inOrder(root1, list1);
         inOrder(root2, list2);
          
         int i = 0, j = 0;
         int n1 = list1.size(), n2 = list2.size();
         
         List<Integer> ans = new ArrayList<>();
         
         while(i < n1 && j < n2){
         
         if(list1.get(i) < list2.get(j))
         ans.add(list1.get(i++));
         else
         ans.add(list2.get(j++));
         
         }
          
         while(i < n1)
         ans.add(list1.get(i++));
         
         while(j < n2)
         ans.add(list2.get(j++));
         
         
         return ans;
         

    }
}

/*
  IN THIS WE OPTIMIZED THE SAPCE COMPLEXITY FROM O(m + n) to O(h1 + h2)
  using stack for inorder traversal
  TIME COMPLEXITY: O(M+N)
  SPACE COMPLEXITY: O(H1+H2)
*/
import java.util.*;

public class Solution {

  public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        // Write your code here.
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        TreeNode curr1 = root1;
        TreeNode curr2 = root2;

        List<Integer> ans = new ArrayList<>();

        while ((curr1 != null || !s1.isEmpty()) && (curr2 != null || !s2.isEmpty())) {
            while (curr1 != null) {
                s1.push(curr1);
                curr1 = curr1.left;
            }
            while (curr2 != null) {
                s2.push(curr2);
                curr2 = curr2.left;
            }

            if (s1.size() > 0 && s2.size() > 0 && s1.peek().data <= s2.peek().data) {
                curr1 = s1.pop();
                ans.add(curr1.data);
                curr1 = curr1.right;
            } else if (s1.size() > 0 && s2.size() > 0 && s1.peek().data > s2.peek().data) {
                curr2 = s2.pop();
                ans.add(curr2.data);
                curr2 = curr2.right;
            }
        }

        // if the s1 is not empty
        while (curr1 != null || !s1.isEmpty()) {
            while (curr1 != null) {
                s1.push(curr1);
                curr1 = curr1.left;
            }

            curr1 = s1.pop();
            ans.add(curr1.data);
            curr1 = curr1.right;
        }

        // if the s2 is not empty
        while (curr2 != null || !s2.isEmpty()) {
            while (curr2 != null) {
                s2.push(curr2);
                curr2 = curr2.left;
            }

            curr2 = s2.pop();
            ans.add(curr2.data);
            curr2 = curr2.right;
        }

        return ans;

    }

}


