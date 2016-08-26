package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets may form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
public class ReconstructItinerary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReconstructItinerary instance = new ReconstructItinerary();
		String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		String[][] tickets2 = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		String[][] tickets3 = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		List<String> ret = instance.findItinerary(tickets3);
		for (int i = 0; i < ret.size(); i++) {
			System.out.print(ret.get(i)+" ");
		}
		System.out.println();
	}
	private Comparator<String> com = new Comparator<String>(){

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return o1.compareTo(o2);
		}
		
	};
	public List<String> findItinerary(String[][] tickets) {
		
		ArrayList<String> ret = new ArrayList<>();
		HashMap<String, LinkedList<String>> map = new HashMap<>();
		HashMap<String, Integer> inMap = new HashMap<>();
		HashMap<String, Integer> outMap = new HashMap<>();
		
		for (int i = 0; i < tickets.length; i++) {
			LinkedList list = map.get(tickets[i][0]);
			if(list==null){
				list = new LinkedList<String>();
				map.put(tickets[i][0], list);
				inMap.put(tickets[i][0], 0);
				outMap.put(tickets[i][1], 0);
			}
			if(outMap.get(tickets[i][1])==null){
				outMap.put(tickets[i][1], 0);
			}
			inMap.put(tickets[i][0], inMap.get(tickets[i][0])+1);
			outMap.put(tickets[i][1], outMap.get(tickets[i][1])+1);
			list.add(tickets[i][1]);
		}
		
		for(String key: map.keySet()){
			map.get(key).sort(com);
		}
		
		ret.add("JFK");
		
		LinkedList<String> nextList = map.get("JFK");
		while(nextList!=null&&!nextList.isEmpty()){
			String next = nextList.removeFirst();
			if((inMap.get(next)==null || inMap.get(next)<outMap.get(next))&&!nextList.isEmpty()){
				nextList.add(next);
				continue;
			}
			ret.add(next);
			nextList = map.get(next);
		}
		
		return ret;
		
	}
	
}
