package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 퇴사 - 실버 3
public class No_14501 {

    static int N;
    static int[] t, p, dp;
    static int max = Integer.MIN_VALUE;
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        t = new int[N + 5];
        p = new int[N + 5];
        dp = new int[N + 5];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= N; i++){
            dp[i] = Math.max(dp[i], max);

            dp[t[i] + i] = Math.max(dp[t[i] + i], p[i] + dp[i]);

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
