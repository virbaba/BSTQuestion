/*
  TIME COMPLEXITY : O(N)
  SAPCE COMPLEXITY : O(N)

  here we use validate bst code approach where we take min and max value when we build each node
  in bst node we know very well a node always greater than to min and less than to max
  if node lies in the min and max range then we build it otherwise return null
*/

public class Solution {

    public static TreeNode build(int[] preOrder, int min, int max, int[] s, int e){
		if(s[0] > e)
			return null;
		
		int data = preOrder[s[0]];
		if(data < min || data > max)
			return null;
		
		s[0]++;

		TreeNode root = new TreeNode(data);

		root.left = build(preOrder, min, data, s, e);
		root.right = build(preOrder, data, max, s, e);

		return root;
	}
    public static TreeNode preOrderTree(int[] preOrder) {
        // Write your code here.
        int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		int[] s = {0};
		int e = preOrder.length - 1;

		return build(preOrder, min, max, s, e);
    }
}
