import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int numTest = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        double[] scores = new double[numTest];
        double max = Double.MIN_VALUE, result = 0;
        for(int i = 0 ; i < numTest; i++){
            scores[i] = Double.parseDouble(st.nextToken());
            if(max < scores[i]) max = scores[i];
        }
        
        for(int i = 0; i < numTest; i++){
             result += (scores[i] / max) * 100;
        }
        
        System.out.println(result/numTest);
    }
}