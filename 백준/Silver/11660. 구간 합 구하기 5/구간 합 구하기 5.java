import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int j = 0; j < N; j++) {
				sum += Integer.parseInt(st.nextToken());
				map[i][j] = sum;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			int[] points = new int[4];
			
			for(int j = 0; j < points.length; j++) {
				points[j] = Integer.parseInt(st.nextToken()) - 1;
			}
			
			
			for(int j = points[0] ; j <= points[2]; j++) {
				if(points[1] == 0) sum += map[j][points[3]];
				else sum += (map[j][points[3]] - map[j][points[1] - 1]);
			}
			
			result.append(sum).append("\n");
		}
		
			System.out.println(result);
	}
}
