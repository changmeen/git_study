package 잡다한거.DP;
import java.io.*;
import java.util.*;

// DP_실전 문제_금광
public class DP_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= n; i++){
            dp[i][1] = map[i][1];
        }

        for(int i = 2; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(j == 1){
                    int one = dp[j][i - 1] + map[j][i];
                    int two = dp[j + 1][i - 1] + map[j][i];
                    dp[j][i] = Math.max(one, two);
                }

                else if(j == n){
                    int one = dp[j - 1][i - 1] + map[j][i];
                    int two = dp[j][i - 1] + map[j][i];
                    dp[j][i] = Math.max(one, two);
                }

                else{
                    int one = dp[j - 1][i - 1] + map[j][i];
                    int two = dp[j][i - 1] + map[j][i];
                    int thr = dp[j + 1][i - 1] + map[j][i];
                    dp[j][i] = Math.max(one, Math.max(two, thr));
                }
            }
        }

        int result = 0;
        for(int i = 1; i <= n; i++){
            result = Math.max(result, dp[i][m]);
        }

        System.out.println(result);
    }
}
