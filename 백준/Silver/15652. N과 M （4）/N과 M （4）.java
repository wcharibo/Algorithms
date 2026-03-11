import java.util.*;
import java.io.*;

public class Main{
	static ArrayList <ArrayList <Integer>> possible = new ArrayList<>();
	
	public static void fill(ArrayList<Integer> arr, int N, int M) {
		int start = arr.get(arr.size()-1);
		
		if(arr.size() == M) possible.add(arr);
		else {
			for(int i = start; i < N; i++) {
				ArrayList <Integer> newArr = (ArrayList<Integer>) arr.clone();
				newArr.add(i);
				fill(newArr, N, M);
			}
		}
	}
	
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++) {
        	ArrayList<Integer> arr = new ArrayList<>();
        	
        	arr.add(i);
        	fill(arr, N, M);
        }
        
        for(ArrayList <Integer> tempArr : possible) {
        	for(int i : tempArr) {
        		result.append(i+1).append(" ");
        	}
        	result.append("\n");
        }
        
        System.out.println(result);
    }
}