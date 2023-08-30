package 잡다한거.DP;
import java.io.*;

// DP_실전 문제_바닥 공사
public class DP_3 {

    public static int n;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        solution();
    }

    public static void solution(){
        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + (2 * dp[i - 2]);
        }

        System.out.println(dp[n]);
    }
}
