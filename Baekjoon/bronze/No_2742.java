package Baekjoon.bronze;
import java.io.*;

// 기찍 N - 브론즈 4
public class No_2742 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = n; i >= 1; i--){
            sb.append(i + "\n");
        }

        System.out.println(sb);
    }
}
