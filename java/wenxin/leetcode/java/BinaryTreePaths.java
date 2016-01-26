/**
 * 
 */
package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
public class BinaryTreePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<String>();
        if(root == null) return rst;
        StringBuilder sb = new StringBuilder();
        helper(rst, sb, root);
        return rst;
    }

    public void helper(List<String> rst, StringBuilder sb, TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            sb.append(root.val);
            rst.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        int tmp = sb.length();

        sb.append(root.val + "->");
        helper(rst, sb, root.left);
        sb.delete(tmp , sb.length());

        sb.append(root.val + "->");
        helper(rst, sb, root.right);
        sb.delete(tmp , sb.length());
        return;

    }
	
}
