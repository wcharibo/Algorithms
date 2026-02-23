import java.util.*;
import java.io.*;

public class Main{
	
	static Node[] tree = new Node[26];
	
	public static class Node{
		public int name;
		public int left;
		public int right;
		
		Node(int name){
			this.name = name;
			this.left = -1;
			this.right = -1;
		}
		
		public void setLeft(int left) {
			this.left = left;
		}
		
		public void setRight(int right) {
			this.right = right;
		}
		
		public void preorder() {
			System.out.print((char)('A' + this.name));
			if(this.left > 0) tree[this.left].preorder();
			if(this.right > 0) tree[this.right].preorder();
		}
		
		public void inorder() {
			if(this.left > 0) tree[this.left].inorder();
			System.out.print((char)('A' + this.name));
			if(this.right > 0) tree[this.right].inorder();
		}
		
		public void postorder() {
			if(this.left > 0) tree[this.left].postorder();
			if(this.right > 0) tree[this.right].postorder();
			System.out.print((char)('A' + this.name));
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int parent = st.nextToken().charAt(0) - 65;
			
			tree[parent] = new Node(parent);
			tree[parent].setLeft(st.nextToken().charAt(0) - 65);
			tree[parent].setRight(st.nextToken().charAt(0) - 65);
		}
		
		tree[0].preorder();
		System.out.println();
		tree[0].inorder();
		System.out.println();
		tree[0].postorder();
		
		
		
	}
}