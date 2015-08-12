/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 100.
 * Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class SameTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p==null && q==null){
    		return true;
    	}else if(p==null || q==null){
    		return false;
    	}
        if(p.val!=q.val){
        	return false;
        }
        if(!isSameTree(p.left, q.left)){
        	return false;
        }
        if(!isSameTree(p.right, q.right)){
        	return false;
        }
        return true;
        
    }

}
