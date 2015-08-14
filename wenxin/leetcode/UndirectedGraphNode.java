/**
 * 
 */
package wenxin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
