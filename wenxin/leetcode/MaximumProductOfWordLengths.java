package wenxin.leetcode;

/*
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
 */
public class MaximumProductOfWordLengths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProductOfWordLengths instance = new MaximumProductOfWordLengths();
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		String[] words2 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
		System.out.println(instance.maxProduct(words));
		System.out.println(instance.maxProduct(words2));
	}
	
	/*
	 * basic idea is use bit to represent each letter. For example abc will be 00000...00111,
	 * bdf will be 0000...0101010
	 * In this case, judge if two words share letter can just become as easy as expression (int1 & int2 == 0)
	 */
	public int maxProduct(String[] words) {
		int len = words.length;
		int[] mark = new int[len];
		int[] leng = new int[len];
		for (int i = 0; i < len; i++) {
			int k = words[i].length();
			leng[i] = k;
			for (int j = 0; j < k; j++) {
				int p = (int) (words[i].charAt(j) - 'a');
				p = 1 << p;
				mark[i] = mark[i] | p;
			}
		}
		int ans = 0;
		for (int i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++)
				if ((mark[i] & mark[j]) == 0)
					if (ans < leng[i] * leng[j])
						ans = leng[i] * leng[j];
		return ans;
	}

/*	public int maxProduct(String[] words) {
		int maxProduct = 1;
		int[] lengthArray = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			lengthArray[i] = words[i].length();
		}
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if(!shareCommonLetter(words, i, j)){
					maxProduct = Math.max(maxProduct, lengthArray[i] * lengthArray[j]);
				}
			}
		}

		return maxProduct;
	}
	
	private boolean shareCommonLetter(String[] words, int index1, int index2){
		for (int i = 0; i < words[index1].length(); i++) {
			if(words[index2].contains(words[index1].charAt(i)+"")){
				return true;
			}
		}
		return false;
	}
	*/
}
