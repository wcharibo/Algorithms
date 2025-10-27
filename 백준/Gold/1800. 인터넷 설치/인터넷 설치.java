import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();
        int P = fs.nextInt();
        int K = fs.nextInt();

        int[][] w = new int[N + 1][N + 1];
        List<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int maxFare = 0;
        for (int i = 0; i < P; i++) {
            int a = fs.nextInt(), b = fs.nextInt(), c = fs.nextInt();
            adj[a].add(b);
            adj[b].add(a);
            w[a][b] = w[b][a] = c;
            if (c > maxFare) maxFare = c;
        }

        int lo = 0, hi = maxFare, ans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;      // 임계값
            int[] dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            Deque<Integer> dq = new ArrayDeque<>();
            dist[1] = 0;                   // 1에서 시작해 N으로
            dq.addFirst(1);

            while (!dq.isEmpty()) {
                int cur = dq.pollFirst();
                if (cur == N) break;       // 조기 종료(선택)

                for (int nxt : adj[cur]) {
                    int cost = (w[cur][nxt] > mid) ? 1 : 0; // 비싼 간선: 1, 아니면 0
                    if (dist[cur] + cost < dist[nxt]) {      // ★ 더 좋으면 갱신
                        dist[nxt] = dist[cur] + cost;
                        if (cost == 0) dq.addFirst(nxt);
                        else dq.addLast(nxt);
                    }
                }
            }

            if (dist[N] <= K) {            // 가능 → 더 낮춰보기
                ans = mid;
                hi = mid - 1;
            } else {                       // 불가능 → 더 올리기
                lo = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
