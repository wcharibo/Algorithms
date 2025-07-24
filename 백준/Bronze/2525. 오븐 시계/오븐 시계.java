import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		int cookingTime = Integer.parseInt(br.readLine());
		
		minute += cookingTime;
		
		while(minute >= 60) {
			hour++;
			minute-=60;			
		}
		if(hour > 23) hour-=24;
		
		System.out.println(hour + " " + minute);
	}
}