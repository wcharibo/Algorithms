import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tresure;
	static int unionCnt;

	static int find(int cur) {
		if (tresure[cur] == cur) {
			return cur;
		}

		return tresure[cur] = find(tresure[cur]);
	}

	static boolean union(int x, int y) {
		int repX = find(x);
		int repY = find(y);
		unionCnt++;

		if (repX == repY)
			return false;

		if (tresure[repX] > tresure[repY]) {
			tresure[repX] = tresure[repY];
		} else {
			tresure[repY] = tresure[repX];
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		tresure = new int[n];

		for (int i = 1; i < n; i++)
			tresure[i] = i;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (union(x, y)) {
				continue;
			} else if(unionCnt == m) {
				System.out.println(unionCnt);
				return;
			}else {
				break;
			}
				
		}

		if (unionCnt == m)
			unionCnt = 0;

		System.out.println(unionCnt);

	}

}
