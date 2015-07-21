package wenxin.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	if(root==null)
    		return new ArrayList<List<Integer>>();
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	LinkedList<TreeNode> nodeToTravel = new LinkedList<TreeNode>();
    	LinkedList<Integer> nodeLevel = new LinkedList<Integer>();
    	nodeLevel.add(1);
    	nodeToTravel.addFirst(root);

    	while(!nodeToTravel.isEmpty()){
    		TreeNode next = nodeToTravel.removeLast();
    		int level = nodeLevel.removeLast();

    		List<Integer> list;
    		if(result.size()<level){
        		list = new ArrayList<Integer>();
        		result.add(list);
    		}else{
    			list = result.get(result.size()-1);
    		}
    		list.add(next.val);
    		
    		
    		if(next.left!=null){
    			nodeToTravel.addFirst(next.left);
    			nodeLevel.addFirst(level+1);
    		}
    		if(next.right!=null){
    			nodeToTravel.addFirst(next.right);
    			nodeLevel.addFirst(level+1);
    		}
    		
    	}
    	
    	
        return result;
    }
}
