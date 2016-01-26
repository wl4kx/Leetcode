/**
 * 
 */
package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liao.wenxin
 *
 */
public class WordSearchII {
	
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Set<String> result = new HashSet<String>(); 
	 
    public List<String> findWords(char[][] board, String[] words) {
        //HashSet<String> result = new HashSet<String>();
 
        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }
 
        int m=board.length;
        int n=board[0].length;
 
        boolean[][] visited = new boolean[m][n];
 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               dfs(board, visited, "", i, j, trie);
            }
        }
 
        return new ArrayList<String>(result);
    }
 
    public void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie){
        int m=board.length;
        int n=board[0].length;
 
        if(i<0 || j<0||i>=m||j>=n){
            return;
        }
 
        if(visited[i][j])
            return;
 
        str = str + board[i][j];
 
        if(!trie.startsWith(str))
            return;
 
        if(trie.search(str)){
            result.add(str);
        }
 
        visited[i][j]=true;
        dfs(board, visited, str, i-1, j, trie);
        dfs(board, visited, str, i+1, j, trie);
        dfs(board, visited, str, i, j-1, trie);
        dfs(board, visited, str, i, j+1, trie);
        visited[i][j]=false;
    }
}

/*class TrieNode {
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
}*/