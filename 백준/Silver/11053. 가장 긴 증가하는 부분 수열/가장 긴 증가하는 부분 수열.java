import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> c;
	static int[] lis, arr;

	static void find(int cur) {

		if (c.isEmpty() || arr[cur] > c.get(c.size() - 1)) {
			c.add(arr[cur]);
			return;
		}

		findProper(arr[cur], 0, c.size() - 1);

		return;
	}

	static void findProper(int value, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (c.get(mid) < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        c.set(left, value);
    }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[N];
		lis = new int[N];
		c = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			find(i);
		}
		
		
		System.out.println(c.size());
	}
}
