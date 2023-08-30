package 잡다한거.DP;
import java.io.*;

// DP_실전 문제_1로 만들기
public class DP_1 {

    public static int[] dp;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        solution();
    }

    public static void solution(){
        dp[1] = 0;

        // for(int i = 2; i <= n; i++){
        //     if(i % 5 == 0) dp[i] = Math.min(dp[i / 5] + 1, dp[i - 1] + 1);
        //     else if(i % 3 == 0) dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
        //     else if(i % 2 == 0) dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
        //     else dp[i] = dp[i - 1] + 1;
        // }

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + 1;

            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if(i % 5 == 0) dp[i] = Math.min(dp[i], dp[i / 5] + 1);
        }

        System.out.println(dp[n]);
    }
}
