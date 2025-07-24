import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int size = Integer.parseInt(br.readLine())/4;


        for(int i = 0; i < size; i++){
            result.append("long ");
        }
        result.append("int");

        System.out.println(result);


    }
}