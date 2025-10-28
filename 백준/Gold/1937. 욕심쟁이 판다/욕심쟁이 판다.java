import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] forest, dist;
    static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static int dfs(int i, int j) {
        if (dist[i][j] != 0) return dist[i][j];

        dist[i][j] = 1; // 자기 자신 포함
        int cur = forest[i][j];

        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (0 <= ni && ni < n && 0 <= nj && nj < n && forest[ni][nj] > cur) {
                dist[i][j] = Math.max(dist[i][j], 1 + dfs(ni, nj));
            }
        }
        return dist[i][j];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        forest = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }

        System.out.println(result);
    }
}
