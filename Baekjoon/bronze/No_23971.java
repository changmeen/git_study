package Baekjoon.bronze;
import java.io.*;
import java.util.*;

// ZOAC 4 - 브론즈 3
public class No_23971 {
    static int H, W, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i = 1; i <= H; i = (i + N) + 1){
            for(int j = 1; j <= W; j = (j + M) + 1){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
