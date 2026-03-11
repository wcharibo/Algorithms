import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int goal = Integer.parseInt(br.readLine());
		
		String[] sizes = br.readLine().split(" ");
		int a = Integer.parseInt(sizes[0]);
		int b = Integer.parseInt(sizes[1]);
		int maxA = 0;
		int maxB = 0;
		int result = 0;
		int[] A = new int[a*2];
		int[] B = new int[b*2];
		
		for(int i = 0; i < a; i++) {
			int cur = Integer.parseInt(br.readLine());
			A[i] = cur;
			A[i + a] = cur;
			maxA += cur;
		}
		
		for(int i = 0; i < b; i++) {
			int cur = Integer.parseInt(br.readLine());
			B[i] = cur;
			B[i+b] = cur;
			maxB += cur;
		}
		
		int[] posA = new int[maxA + 1];
		int[] posB = new int[maxB + 1];
		
		for(int i = 0; i < a; i++) {
			int sum = A[i];
			posA[sum]++;
			for(int j = 1; j < a -1; j++) {
				sum += A[i + j];
				posA[sum]++;
			}
		}
		posA[0]++;
		posA[maxA]++;
		
		for(int i = 0; i < b; i++) {
			int sum = B[i];
			posB[sum]++;
			for(int j = 1; j < b -1; j++) {
				sum += B[i + j];
				posB[sum]++;
			}
		}
		posB[0]++;
		posB[maxB]++;
		
		int max = Math.min(maxA, maxB);
		max = Math.min(goal, max);
		
		if(maxA + maxB < goal) {
			System.out.println(0);
			return;
		}
		
		if(maxA + maxB == goal) {
			System.out.println(1);
			return;
		}
		
		for(int i = 0; i <= goal ; i++) {
			if(i > maxA || goal-i > maxB) {
				continue;
			}
			
			result += (posA[i] * posB[goal-i]);
		}
		
		
		System.out.println(result);
	}
}