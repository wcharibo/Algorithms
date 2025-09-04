import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	
	static class Node{
		TreeMap<String, Node> child;
		boolean end_of_word;
		
		public Node() {
			this.child = new TreeMap<>();
			this.end_of_word = false;
		}
	}
	
	static class Trie{
		Node root;
		
		public Trie() {
			this.root = new Node();
		}
		
		public void insert(String[] strs) {
			Node cur = this.root;
			
			for(int i = 0; i < strs.length; i++) {
				
				String str = strs[i];
				
				cur.child.putIfAbsent(str, new Node());
				
				cur = cur.child.get(str);
			}
			cur.end_of_word = true;
		}
		
		public boolean search(String[] strs) {
			Node cur = this.root;
			
			for(int i = 0; i < strs.length; i++) {
				
				String str = strs[i];
				
				if(!cur.child.containsKey(str)) {
					return false;
				} 
				
				cur = cur.child.get(str);
			}
			
			return cur.end_of_word;
		}
		
		public boolean delete(String str) {
			return delete(this.root, str, 0);
		}
		
		private boolean delete(Node node, String str, int idx) {
			char c = str.charAt(idx);
			
			if(!node.child.containsKey(c)) return false;
			
			Node cur = node.child.get(c);
			idx++;
			
			if(idx == str.length()) {
				if(!cur.end_of_word) return false;
				
				cur.end_of_word = false;
				
				if(cur.child.isEmpty()) {
					node.child.remove(c);
				}
			}else {
				
				if(!this.delete(cur, str, idx)) return false;
				
				if(!cur.end_of_word && cur.child.isEmpty()) {
					node.child.remove(c);
				}
			}
			return true;
		}
		
		public void cout(Node cur, int cnt) {
			if(cur.end_of_word) return;
			
			String prefix = "";
			
			for(int i = 0; i < cnt; i++) {
				prefix+="--";
			}
			
			
			
			for(Map.Entry<String, Node> strEntry : cur.child.entrySet()) {
				sb.append(prefix).append(strEntry.getKey()).append("\n");
				
				cout(strEntry.getValue(), cnt + 1);
			}
			
			
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(st.nextToken());
			
			String[] strs = new String[K];
			
			for(int j = 0; j < K; j++) {
				strs[j] = st.nextToken();
			}
			
			trie.insert(strs);
		}
		
		trie.cout(trie.root, 0);

		System.out.println(sb);
	}
}