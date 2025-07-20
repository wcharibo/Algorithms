// package com.javaBegin.scope;
import java.util.*;
import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> numStack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			
			switch(order) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				numStack.add(num);
				break;
			case "top":
				if(numStack.empty()) sb.append(-1).append("\n");
				else sb.append(numStack.peek()).append("\n");
				break;
			case "size":
				sb.append(numStack.size()).append("\n");
				break;
			case "pop":
				if(numStack.empty()) sb.append(-1).append("\n");
				else sb.append(numStack.pop()).append("\n");
				break;
			case "empty":
				if(numStack.empty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			}
			
			
		}
		
			
		System.out.println(sb);
	}
}