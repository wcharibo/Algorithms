import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] W; // W[i][j]: 도시 i에서 j로 가는 비용
    // dp[mask][j]: 1번 도시에서 출발하여 mask의 모든 도시를 거쳐 j에 도착하는 최소 비용
    static int[][] dp; 
    static final int INF = 16_000_000; // 최대 비용 설정 (N=16, 최대 비용 100만일 때 1600만)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 입력 처리
        N = Integer.parseInt(br.readLine());

        W = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 테이블 초기화: (2^N) x (N+1) 크기
        // N이 15라면 32768 x 16 크기
        dp = new int[1 << (N + 1)][N + 1]; 
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        
        // 2. 초기 상태 설정
        // 1번 도시에서 1번 도시로 가는 비용은 0. 마스크는 1번만 방문(1 << 1)
        int startMask = 1 << 1;
        dp[startMask][1] = 0;

        // 3. DP 테이블 채우기 (점화식 적용)
        // 방문 도시의 개수를 1개부터 늘려가며 모든 마스크 상태를 탐색
        // (1 << (N + 1)) - 1은 모든 비트가 켜진 상태 (1부터 N까지 모두 방문)
        for (int mask = 1; mask < (1 << (N + 1)); mask++) {
            for (int j = 1; j <= N; j++) {
                // 현재 상태 (mask, j)에 최소 비용이 없으면 계산할 필요가 없음
                if (dp[mask][j] == INF) continue; 
                
                // j가 mask에 포함되어 있어야만 유효한 상태
                if ((mask & (1 << j)) == 0) continue;
                
                // 다음 방문할 도시 k를 탐색
                for (int k = 1; k <= N; k++) {
                    // k가 이미 mask에 포함되어 있다면 건너뛴다.
                    if ((mask & (1 << k)) != 0) continue;
                    
                    // j에서 k로 가는 경로가 없거나 비용이 0이면 건너뛴다.
                    if (W[j][k] == 0) continue; 

                    // 새로운 마스크: 현재 마스크에 k를 추가 (k 비트 ON)
                    int nextMask = mask | (1 << k);
                    
                    // 새로운 비용: 현재 비용 + j에서 k로 가는 비용
                    int newCost = dp[mask][j] + W[j][k];
                    
                    // DP 업데이트: 현재 dp[nextMask][k]보다 새 비용이 더 작으면 갱신
                    if (newCost < dp[nextMask][k]) {
                        dp[nextMask][k] = newCost;
                    }
                }
            }
        }

        // 4. 최종 결과 도출
        int allVisitedMask = (1 << (N + 1)) - 2; // 1번부터 N번까지 모두 방문한 마스크 (0번 비트 제외)
        int minCost = INF;

        // 마지막 방문 도시 j (1번은 제외)에서 1번 도시로 돌아오는 최소 비용 찾기
        for (int j = 1; j <= N; j++) {
            // 모든 도시를 방문하고 j에 도착한 상태
            int finalMask = allVisitedMask; 
            
            // j에서 1번으로 돌아가는 경로가 있어야 함
            if (W[j][1] != 0 && dp[finalMask][j] != INF) {
                // 최종 사이클 비용: dp[allVisitedMask][j] + W[j][1]
                minCost = Math.min(minCost, dp[finalMask][j] + W[j][1]);
            }
        }

        // 결과 출력
        System.out.println(minCost);
    }
}