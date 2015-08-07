package wenxin.test;

import java.util.HashSet;

public class Test {
	public static void main(String[] args) {
		
		HashSet<Integer> modifiedInsps = new HashSet<Integer>();
		modifiedInsps.add(1);
		modifiedInsps.add(2);
		//System.out.println(modifiedInsps.toString().replace("[", "").replace("]", ""));
		StringBuilder sb = new StringBuilder("[1,2]");
		sb.replace(sb.length()-1,sb.length(),","+3).append("]");
		System.out.println(sb.toString());
	}
}