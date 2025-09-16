import java.util.*;
import java.awt.Point;
import java.io.*;

public class Solution {
	static HashMap<Integer, Long> map = new HashMap<>();
	static long[] factorials = new long[1000001];

	static long dq(int a, int p) {
		if (map.containsKey(p)) {
			return map.get(p);
		}

		map.put(p, ((dq(a, p / 2) % a) * (dq(a, p - p / 2) % a)) % a);
		return map.get(p);
	}

	public static long pow(long a, long b, long mod) {
		long result = 1;
		while (b > 0) {
			if ((b & 1) == 1)
				result = (result * a) % mod;
			a = (a * a) % mod;
			b >>= 1;
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int P = 1234567891;
		factorials[1] = 1;

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long factorialN_R = 0;
			long factorialR = 0;
			long factorialN = 0;

			if (factorials[R] == 0) {
				for (int i = 2; i <= R; i++) {
					factorials[i] = (factorials[i - 1] * (i % P) % P);
				}
			}

			if (factorials[N - R] == 0) {
				for (int i = 2; i <= N - R; i++) {
					factorials[i] = (factorials[i - 1] * (i % P) % P);
				}
			}

			if (factorials[N] == 0) {
				for (int i = (N - R < R ? R : N - R); i <= N; i++) {
					factorials[i] = (factorials[i - 1] * (i % P) % P);
				}
			}
			
			factorialR = factorials[R];
			factorialN_R = factorials[N - R];
			factorialN = factorials[N];

//			for(int i = 1; i <= N; i++) {
//				temp = (temp*(i%P)%P);
//				if(i == N-R) factorialN_R = temp;
//				if(i == R) factorialR = temp;
//			}

			map.clear();
			map.put(1, ((factorialN_R * factorialR) % P));

			long fermat = dq(P, P - 2);
//			long fermat = pow((factorialN_R*factorialR)%P, P-2, P);

			sb.append("#").append(tc).append(" ").append((factorialN * fermat) % P).append("\n");
		}
		System.out.println(sb);
	}
}
