import java.util.*;
import java.io.*;

public class Main{
	static ArrayList <ArrayList <Integer>> possible = new ArrayList<>();
	static boolean[] visited;
	
	public static void fill(ArrayList<Integer> arr, int[] nums , int N, int M) {

		if(arr.size() == M) possible.add(arr);
		else {
			for(int i = 0; i < N; i++) {
				ArrayList <Integer> newArr = (ArrayList<Integer>) arr.clone();

				if(visited[i] == false) {			
					newArr.add(nums[i]);
					visited[i] = true;
					fill(newArr, nums, N, M);
					visited[i] = false;
				}
			}
		}
	}
	
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);        
        
        for(int i = 0; i < N; i++) {
        	ArrayList<Integer> arr = new ArrayList<>();
        	
        	arr.add(nums[i]);
        	visited[i] = true;
        	fill(arr, nums, N, M);
        	visited[i] = false;
        }
        
        for(ArrayList <Integer> tempArr : possible) {
        	for(int i : tempArr) {
        		result.append(i).append(" ");
        	}
        	result.append("\n");
        }
        
        System.out.println(result);
    }
}