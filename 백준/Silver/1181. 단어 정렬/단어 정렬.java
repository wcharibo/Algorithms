import java.util.*;
import java.io.*;


public class Main {
	
	static class StringLengthComparator implements Comparator<String>{
		public int compare(String str1, String str2) {
			if(str1.length() != str2.length()) return str1.length() - str2.length();
			return str1.compareTo(str2);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int numWords = Integer.parseInt(br.readLine());
		
		Set<String> words = new TreeSet<>(new StringLengthComparator());
		
		for(int i = 0; i < numWords; i++) {
			words.add(br.readLine());
		}
		
		for(String str : words) System.out.println(str);
		
	}

}
