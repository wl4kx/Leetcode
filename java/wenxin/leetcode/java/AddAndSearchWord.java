package wenxin.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/*
 * Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 */
public class AddAndSearchWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Use Trie from previous problem with a little modification.
	 */
	public class TrieNode {
	    // Initialize your data structure here.
	    
		char c;
		HashMap<Character, TrieNode> children;
		boolean isLeaf;
		public TrieNode() {
	        children = new HashMap<Character, TrieNode>();
	    }
		public TrieNode(char c) {
			this();
			this.c = c;
	    }
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        char[] ca = word.toCharArray();
	        HashMap<Character, TrieNode> children = root.children;
	        TrieNode p = root;
	        for(int i=0;i<ca.length;i++){
	        	char c = ca[i];
	        	if(children.containsKey(c)){
	        		p = children.get(c);
	        	}else{
	        		TrieNode newNode = new TrieNode(c);
	        		p.children.put(c, newNode);
	        		p=newNode;
	        	}
        		children = p.children;
        		
        		if(i==ca.length-1){
        			p.isLeaf = true;
        		}
	        }
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        return dfsSearch(root.children, word, 0);
	  
	     }
	  
	      public boolean dfsSearch(HashMap<Character, TrieNode> children, String word, int start) {
	         if(start == word.length()){
	             if(children.size()==0) 
	                 return true; 
	             else
	                 return false;
	         }
	  
	         char c = word.charAt(start);    
	  
	         if(children.containsKey(c)){
	             if(start == word.length()-1 && children.get(c).isLeaf){
	                 return true;
	             }
	  
	             return dfsSearch(children.get(c).children, word, start+1);
	         }else if(c == '.'){
	             boolean result = false;
	             for(Map.Entry<Character, TrieNode> child: children.entrySet()){
	                 if(start == word.length()-1 && child.getValue().isLeaf){
	                     return true;
	                 } 
	  
	                 //if any path is true, set result to be true; 
	                 if(dfsSearch(child.getValue().children, word, start+1)){
	                     result = true;
	                 }
	             }
	  
	             return result;
	         }else{
	             return false;
	         }
	     }
	}
	
	public class WordDictionary {
		private Trie trie;
		public WordDictionary(){
			trie = new Trie();
		}
	    // Adds a word into the data structure.
	    public void addWord(String word) {
	    	trie.insert(word);
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	        return trie.search(word);
	    }
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
	
}
