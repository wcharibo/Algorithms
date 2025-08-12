import java.io.*;
import java.util.*;

public class Main {
	static int result;
	static int cnt, N;
	static int[] pol;
	static int[][] city, relation;
	static Set<Integer> possible;
	static ArrayList<int[]> dividedCity;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		pol = new int[N];
		int min = Integer.MAX_VALUE;
		city = new int[N][N];
		possible = new HashSet<>();
		dividedCity = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			pol[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int relativeCnt = Integer.parseInt(st.nextToken());
			Arrays.fill(city[i], 20);
			for (int j = 0; j < relativeCnt; j++) {
				int relative = Integer.parseInt(st.nextToken()) - 1;
				city[i][relative] = 1;
			}
		}
		
		relation = city.clone();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					city[i][j] = 0;
				for (int k = 0; k < N; k++) {
					if (i != j && j != k) {
						city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
					}
				}
			}
		}

		for (int target = 1; target <= N / 2; target++) {
			makeCombination(0, new int[target], 0, 0);
		}

		for (int[] cur : dividedCity) {
			boolean[] redTeam = new boolean[N];
			boolean[] blueTeam = new boolean[N];
			int redIdx=0, blueIdx=0;
			
			if (dividedCity.size() == 1) {
				redTeam[cur[0]] = true;
			} else {
				for (int i = 0; i < cur.length; i++) {
					redTeam[cur[i]] = true;
				}
			}

			for (int i = 0; i < redTeam.length; i++) {
				if (!redTeam[i]) {
					blueTeam[i] = true;
					blueIdx = i;
				}
				else redIdx = i;
					
			}
			
			boolean[] tempRed = redTeam.clone();
			boolean[] tempBlue = blueTeam.clone();
			
			dfs(tempRed, redIdx);
			dfs(tempBlue, blueIdx);
			
			int redCnt = 0, blueCnt = 0;
			for(int i = 0; i < redTeam.length; i++) {
				if(tempRed[i]) redCnt++;
				if(tempBlue[i]) blueCnt++;
			}

			if (redCnt ==0 && blueCnt ==0) {
				min = Math.min(min, calc(redTeam, blueTeam));
			}
		}
		
		if(min == Integer.MAX_VALUE) min = -1;
		
		System.out.println(min);
	}

	static void dfs(boolean[] team, int cur) {
		boolean flag = false;
		boolean changed = false;
		team[cur] = false;
		
		for(int i = 0; i < relation[cur].length; i++) {
			if(relation[cur][i] == 1 && team[i]) {
				dfs(team,i);
			}
		}
	}

	static int calc(boolean[] redTeam, boolean[] blueTeam) {
		int redPol = 0, bluePol = 0;
		for(int i = 0; i < redTeam.length; i++) {
			if(redTeam[i]) redPol+=pol[i];
			else bluePol+=pol[i];
		}
		
		return Math.abs(bluePol - redPol);
	}

	static void makeCombination(int start, int[] selected, int cnt, int check) {
		int[] cur = selected.clone();
		if (cnt == selected.length) {
			if (possible.isEmpty()) {
				dividedCity.add(cur);
				possible.add(check);
			} else if (!possible.contains(check) && !possible.contains(~check)) {
				dividedCity.add(cur);
				possible.add(check);
			}
		} else {
			for (int i = start; i <= N - (selected.length - cnt); i++) {
				if (cnt >= 1) {
					if (selected.length > city[selected[0]][i]) {
						selected[cnt] = i;
						check |= (1 << i);
						makeCombination(i + 1, selected, cnt + 1, check);
						check ^= (1 << i);
					}
				} else {
					selected[cnt] = i;
					check |= (1 << i);
					makeCombination(i + 1, selected, cnt + 1, check);
					check ^= (1 << i);
				}
			}
		}
	}
}
