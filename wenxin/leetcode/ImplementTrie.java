/**
 * 
 */
package wenxin.leetcode;

import java.util.HashMap;


/**
 * @author liao.wenxin
 *
 */
/*
 * Implement a trie with insert, search, and startsWith methods.
 */
public class ImplementTrie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}

class TrieNode {
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

class Trie {
    private TrieNode root;

    Trie(){
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
        char[] ca = word.toCharArray();
        HashMap<Character, TrieNode> children = root.children;
        TrieNode p = root;
        for(int i=0;i<ca.length;i++){
        	char c = ca[i];
        	if(children.containsKey(c)){
        		p = children.get(c);
        		children = p.children;
        		if(i==ca.length-1){
        			if(p.isLeaf){
        				return true;
        			}
        		}
        	}else{
        		return false;
        	}
        }
		return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] ca = prefix.toCharArray();
        HashMap<Character, TrieNode> children = root.children;
        TrieNode p = root;
        for(int i=0;i<ca.length;i++){
        	char c = ca[i];
        	if(children.containsKey(c)){
        		p = children.get(c);
        		children = p.children;
        	}else{
        		return false;
        	}
        }
		return true;
    }
}
//Your Trie object will be instantiated and called as such:
//Trie trie = new Trie();
//trie.insert("somestring");
//trie.search("key");