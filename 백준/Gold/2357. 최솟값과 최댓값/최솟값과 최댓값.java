import java.io.*;
import java.util.*;

class Pair {
	int min;
	int max;
	
	public Pair(int min, int max) {
		this.min = min;
		this.max = max;
	}
}

class SegmentTree {

	private Pair[] tree;
	private int n;

	public SegmentTree(int[] nums) {
		this.n = nums.length;
		this.tree = new Pair[4 * n];
		build(nums, 1, 1, n - 1);
	}

	private void build(int[] nums, int node, int start, int end) {
		if (start == end) {
			tree[node] = new Pair(nums[start], nums[start]);
			return;
		}

		int mid = start + (end - start) / 2;
		int leftChild = 2 * node;
		int rightChild = 2 * node + 1;

		build(nums, leftChild, start, mid);
		build(nums, rightChild, mid + 1, end);
		
		tree[node] = new Pair(Math.min(tree[leftChild].min, tree[rightChild].min) , Math.max(tree[leftChild].max, tree[rightChild].max));
	}

	public Pair query(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return null;
		}

		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = start + (end - start) / 2;
		int leftChild = 2 * node;
		int rightChild = 2 * node + 1;

		Pair leftSum = query(leftChild, start, mid, left, right);
		Pair rightSum = query(rightChild, mid + 1, end, left, right);
		
		leftSum = leftSum == null ? rightSum : leftSum;
		rightSum = rightSum == null ? leftSum : rightSum;

		return new Pair(Math.min(leftSum.min, rightSum.min) , Math.max(leftSum.max, rightSum.max) );
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		SegmentTree tree = new SegmentTree(arr);

		String[] command = new String[2];

		for (int i = 0; i < M; i++) {
			command = br.readLine().split(" ");
			Pair result = tree.query(1, 1, N, Integer.parseInt(command[0]), Integer.parseInt(command[1]));
			sb.append(result.min).append(" ").append(result.max).append("\n");
		}

		System.out.println(sb);
	}
}