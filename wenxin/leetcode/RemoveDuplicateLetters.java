package wenxin.leetcode;

import java.util.Stack;

public class RemoveDuplicateLetters {

	/*
	 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicateLetters instance = new RemoveDuplicateLetters();
		String str = "bcabc";
		System.out.println(instance.removeDuplicateLetters(str));

	}

	public String removeDuplicateLetters(String s) {
		if (s.isEmpty() || s == null)
			return "";
		char[] ch = s.toCharArray();
		Stack<Character> res = new Stack<Character>();
		int[] times = new int[26];
		int n = ch.length; // initialize the array named times which contains
							// the times of occurrence of every letter;
		for (int i = 0; i < n; i++) {
			times[ch[i] - 'a']++;
		}

		for (int i = 0; i < n; i++) {
			int index = ch[i] - 'a';

			times[index]--; // whenever we get a letter, we reduce the
							// occurrence times of it
			if (res.search(ch[i]) != -1)
				continue;
			// if the element we get now is smaller than one which is at the top
			// of stack
			// and also there are others as same as the latter
			// then we pop the latter from stack.
			while (!res.isEmpty() && ch[i] < res.peek() && times[res.peek() - 'a'] != 0) {
				res.pop();
			}
			res.push(ch[i]);
		}
		// output the result from stack
		int size = res.size();
		char[] resultStr = new char[size];
		while (size > 0) {
			resultStr[size - 1] = res.pop();
			size--;
		}
		return String.valueOf(resultStr);
	}

}
