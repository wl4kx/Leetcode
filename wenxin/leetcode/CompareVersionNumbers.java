/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CompareVersionNumbers instance = new CompareVersionNumbers();
		System.out.println(instance.compareVersion("1", "1.0"));

	}
	
    public int compareVersion(String version1, String version2) {
        
    	String[] va1 = version1.split("\\.");
    	String[] va2 = version2.split("\\.");
    	
    	int iter = 0;
    	
		while (va1.length > iter || va2.length > iter) {

			String s1 = "0";
			String s2 = "0";

			if (va1.length > iter)
				s1 = va1[iter];
			if (va2.length > iter)
				s2 = va2[iter];

			if (Integer.parseInt(s1) > Integer.parseInt(s2)) {
				return 1;
			} else if (Integer.parseInt(s1) < Integer.parseInt(s2)) {
				return -1;
			}
			iter++;
		}
    	
    	return 0;
    	
    }

}
