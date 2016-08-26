package wenxin.leetcode.java;

public class Assert {
	public static boolean equals(int i, int j) throws Exception{
		boolean ret = i==j;
		if(ret){
			System.out.println("Case Pass");
		}else{
			throw new Exception("case failed");
		}
		return ret;
	}
}
