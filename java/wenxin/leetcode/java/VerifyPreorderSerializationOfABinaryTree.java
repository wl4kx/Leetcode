package wenxin.leetcode.java;

/*
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
 */
public class VerifyPreorderSerializationOfABinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerifyPreorderSerializationOfABinaryTree instance = new VerifyPreorderSerializationOfABinaryTree();
		String input = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		String input2 = "9,3,#,#,#";
		String input3 = "1,#,#,1";
		System.out.println(instance.isValidSerialization(input3));
	}
	/*
	 * idea is that using recursion, check if a node's left and its right are both valid tree.
	 * int i is used to record where the node's right starts.
	 */
	private String[] sa;
	private int i = 0;
	public boolean isValidSerialization(String preorder) {
		if(preorder.length()==0){
			return true;	
		}
		sa = preorder.split(",");
		return isValid(0) && (i == sa.length);
	}
	
	public boolean isValid(int start){
		if(sa[start].equals("#")){
			i++;
			return true;
		}
		if(start+2>=sa.length){
			return false;
		}
		
		i++;
		return isValid(start+1) && isValid(i);
	}
	
}
