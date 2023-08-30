package Baekjoon.bronze;
import java.io.*;

// N 찍기 - 브론즈 5
public class No_2741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++){
            sb.append(i + "\n");
        }

        System.out.println(sb);
    }
}
