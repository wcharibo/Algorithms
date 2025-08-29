import java.io.*;
import java.util.*;

import java.awt.*;

public class Main {
	
	static int[] dir = {-1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		int max[] = new int[3];
		int min[] = new int[3];
		int maxcur[] = new int[3];
		int mincur[] = new int[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 3; i++) {
			max[i] = Integer.parseInt(st.nextToken());
			min[i] = max[i];
		}
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				int now = Integer.parseInt(st.nextToken());
				
				if(j == 0) {
					maxcur[j] = now + Math.max(max[0], max[1]);
					mincur[j] = now + Math.min(min[0], min[1]);
				}
				else if(j == 1) {
					maxcur[j] = now + Math.max(max[0], Math.max(max[1], max[2]));
					mincur[j] = now + Math.min(min[0], Math.min(min[1], min[2]));
				}
				else {
					maxcur[j] = now + Math.max(max[1], max[2]);
					mincur[j] = now + Math.min(min[1], min[2]);
				}
				
			}
			
			for(int j = 0; j < 3; j++ ) {
				max[j] = maxcur[j];
				min[j] = mincur[j];
			}
		}
		
		int maxR = Integer.MIN_VALUE;
		int minR = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			maxR = Math.max(maxR, max[i]);
			minR = Math.min(minR, min[i]);
		}
		sb.append(maxR).append(" ").append(minR);
		
		System.out.println(sb);
	}
}
