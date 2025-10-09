import java.io.*;
import java.util.*;

class SegmentTree{
	
	private long[] tree;
	private int n;
	
	public SegmentTree(long[] nums) {
		this.n = nums.length;
		this.tree = new long[4*n];
		build(nums, 1, 1, n - 1);
	}
	
	private void build(long[] nums, int node, int start, int end) {
		if(start == end) {
			tree[node] = nums[start];
			return;
		}
		
		int mid = start + (end - start)/2;
		int leftChild = 2*node;
		int rightChild = 2*node + 1;
		
		build(nums, leftChild, start, mid);
		build(nums, rightChild, mid + 1, end);
		
		tree[node] = tree[leftChild] + tree[rightChild];
	}
	
	public long query(int node, int start, int end, int left, int right) {
		if(right < start || end < left) {
			return 0;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = start + (end - start) / 2;
		int leftChild = 2 * node;
		int rightChild = 2 * node + 1;
		
		long leftSum = query(leftChild, start, mid, left, right);
		long rightSum = query(rightChild, mid + 1, end, left, right);
		
		return leftSum + rightSum;
	}
	
	public void update(int node, int start, int end, int index, long value) {
		if(start == end) {
			tree[node] = value;
			return;
		}
		
		int mid = start + (end - start)/2;
		int leftChild = 2 * node;
		int rightChild = 2 * node + 1;
		
		if(index <= mid) {
			update(leftChild, start, mid, index, value);
		}else {
			update(rightChild, mid + 1, end, index, value);
		}
		
		tree[node] = tree[leftChild] + tree[rightChild];
	}
	
}

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new  StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine()); 
		}
		
		SegmentTree tree = new SegmentTree(arr);
		
		String[] command = new String[3];
		
		for(int i = 0; i < M + K; i++) {
			command = br.readLine().split(" ");
			if(command[0].equals("1")) {
				tree.update(1, 1, N, Integer.parseInt(command[1]), Long.parseLong(command[2]));
			}else {
				sb.append(tree.query(1, 1, N, Integer.parseInt(command[1]), Integer.parseInt(command[2]))).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}