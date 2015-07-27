package wenxin.leetcode;


import java.util.LinkedList;

/*
 * problemn 129
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */
public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
    	int result = 0;
    	if(root==null)
    		return result;
    	
    	LinkedList<TreeNode> nodeToTravel = new LinkedList<TreeNode>();
    	LinkedList<String> nodeValue = new LinkedList<String>();
    	nodeValue.add(root.val+"");
    	nodeToTravel.addFirst(root);

    	while(!nodeToTravel.isEmpty()){
    		TreeNode next = nodeToTravel.remove();
    		String value = nodeValue.remove();

    		if(next.left==null&&next.right==null){
    			result+=Integer.parseInt(value);
    		}else{
        		
        		if(next.left!=null){
        			nodeToTravel.addFirst(next.left);
        			nodeValue.addFirst(value+next.left.val);
        		}
        		if(next.right!=null){
        			nodeToTravel.addFirst(next.right);
        			nodeValue.addFirst(value+next.right.val);
        		}
    		}

    		
    	}
    	
    	
        return result;
    
    }
    public static void main(String[] args){
    	TreeNode anode = new TreeNode(9);
    	System.out.println(sumNumbersRecursion(anode));
    }
    
    public static int sumNumbersRecursion(TreeNode root) {
    	Integer result = 0;
    	if(root==null)
    		return result;
    	IntegerObj intObj = new IntegerObj();
    	findSumRecursively(root, "", intObj);
    	
        return intObj.val;
    
    }

    public static void findSumRecursively(TreeNode root, String value, IntegerObj intObj){
    	String newValue = value+root.val;
		if(root.left==null&&root.right==null){
			intObj.val+=Integer.parseInt(newValue);
		}else{
    		
    		if(root.left!=null){
    			findSumRecursively(root.left,newValue,intObj);
    		}
    		if(root.right!=null){
    			findSumRecursively(root.right,newValue,intObj);
    		}
		}
    }
    
}
class IntegerObj{
	public IntegerObj(){
		this.val=0;
	}
	int val;
}