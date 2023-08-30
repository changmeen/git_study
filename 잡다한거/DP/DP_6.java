package 잡다한거.DP;
import java.io.*;
import java.util.*;

// DP_실전 문제_병사 배치하기
// LIS(Longest Increasing Subsequence) 알고리즘 이용
// 가장 긴 순열을 찾는 알고리즘이다
public class DP_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // dp[n - 1]이 항상 순열의 끝이 아닐 수도 있음
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(arr[i] < arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(n - max);
    }
}
