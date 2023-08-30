package Baekjoon.bronze;
import java.io.*;

// A+B - 2 - 브론즈 5 
public class No_2558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        sb.append(a + b);

        System.out.println(sb);
    }
}
