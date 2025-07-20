// package com.javaBegin.scope;
import java.util.*;
import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String temp = br.readLine();
			Stack<Character> st = new Stack<>();
			
			for(int j = 0; j < temp.length(); j++) {
				if(st.empty()) st.add(temp.charAt(j));
				else if(temp.charAt(j) == ')' && st.peek() == '(') st.pop();
				else st.add(temp.charAt(j));
			}
			
			if(st.empty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
