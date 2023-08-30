package Baekjoon.bronze;
import java.io.*;

// 숫자의 개수 - 브론즈 2
public class No_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[10];

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String sum = String.valueOf(a * b * c);
        for(int i = 0; i < sum.length(); i++){
            int now = sum.charAt(i) - '0';
            cnt[now]++;
        }

        for(int i = 0; i < 10; i++){
            sb.append(cnt[i] + "\n");
        }

        System.out.println(sb);
    }
}
