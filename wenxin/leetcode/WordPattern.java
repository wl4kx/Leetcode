package wenxin.leetcode;
import java.util.HashMap;
import java.util.HashSet;

/*
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPattern instance = new WordPattern();
		String pattern = "abba";
		String str = "dog dog dog dog";
		System.out.println(instance.wordPattern(pattern, str));
	}
	
	public boolean wordPattern(String pattern, String str) {

		HashMap<Character, String> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		String[] strArr = str.split(" ");
		char[] cArr = pattern.toCharArray();
		if(strArr.length!=cArr.length || Math.min(strArr.length, cArr.length)==0){
			return false;
		}
		int pointer = 0;
		while(pointer<strArr.length){
			if (map.containsKey(cArr[pointer])) {
				if (!map.get(cArr[pointer]).equals(strArr[pointer])) {
					return false;
				}
			} else {
				if(set.contains(strArr[pointer])){
					return false;
				}
				map.put(cArr[pointer], strArr[pointer]);
				set.add(strArr[pointer]);
			}
			pointer++;
		}
		return true;
	}
    
}
