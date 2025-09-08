import java.util.*;
import java.io.*;

class Solution {
	static int iWin = 0, qWin = 0;
	static int[] cardQ, cardI;
	static boolean[] vis;
	static int cnt = 0;
	
	static void calc(int[] cur) {
		for(int i = 0; i < 9; i++) {
			int iWinSum = 0, qWinSum = 0;
			
			for(int j = 0; j < 9; j++) {
				int calJ = j + i >= 9 ? j + i - 9 : j + i;
				int sum = cardQ[j] + cur[calJ];
				
				if(cardQ[j] < cur[calJ]) iWinSum += sum;
				else qWinSum += sum;

				if(iWinSum >= 86 || qWinSum >= 86) break;
			}
			
			if(iWinSum > qWinSum) iWin++;
			else qWin++;
		}
	}
	
	static void make(int level, int[] cur) {
		if(level==9) {
			calc(cur);
		}else {
			for(int i = 1; i < 9; i++) {
				if(!vis[i]) {
					cur[level] = cardI[i];
					vis[i] = true;
					make(level+1, cur);
					vis[i] = false;
				}
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T ; tc++) {
			boolean[] cards = new boolean[18];
			cardQ = new int[9];
			cardI = new int[9];
			vis = new boolean[9];
			qWin = 0;
			iWin = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 9; i++) {
				int cur = Integer.parseInt(st.nextToken())-1;
				cards[cur] = true;
			}
			
			for(int i = 0, cntQ = 0, cntI = 0; i < 18; i++) {
				if(cards[i]) cardQ[cntQ++] = i+1;
				else cardI[cntI++] = i+1;
			}
			
			int[] start = new int[9];
			start[0] = cardI[0];
			vis[0] = true;
			
			make(1, start);
			
			
			sb.append("#").append(tc).append(" ").append(qWin).append(" ").append(iWin).append("\n");
		}
		System.out.println(sb);
	}
}