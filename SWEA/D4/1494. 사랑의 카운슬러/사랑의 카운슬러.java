import java.util.*;
import java.awt.Point;
import java.io.*;

public class Solution {
	static int N;
	static long result;
	static ArrayList<Point> dragons;
	
	static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			sb.append(this.x).append(" ").append(this.y).append(" , ");
			return sb.toString();
		}
	}
	
	static void makeCombo(int startIdx, int cur, int[] arr) {
		if(cur == arr.length) {
			boolean[] vis = new boolean[N];
//			System.out.println(Arrays.toString(arr));
			
			long resX = 0, resY = 0;
			
			for(int i = 0; i < arr.length; i++) {
				vis[arr[i]] = true;
			}
			
			for(int i = 0; i < N; i++) {
				if(vis[i]) {
					resX += dragons.get(i).x;
					resY += dragons.get(i).y;
				}else {
					resX -= dragons.get(i).x;
					resY -= dragons.get(i).y;
				}
				
			}
			
			result = Math.min(result, (resX*resX) + (resY*resY));
			
			return;
		}
		
		for(int i = startIdx; i < N; i++) {
			arr[cur] = i;
			makeCombo(i+1, cur+1, arr);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			result = Long.MAX_VALUE;
		
			dragons = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				dragons.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			makeCombo(0,0, new int[N/2] );
			

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
