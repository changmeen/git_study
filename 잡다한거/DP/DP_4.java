package 잡다한거.DP;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// DP_실전 문제_효율적인 화폐 구성
public class DP_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] d = new int[m + 1];
        Arrays.fill(d, 10001);

        d[0] = 0;

        for(int i = 0; i < n; i++){
            for(int j = arr[i]; j <= m; j++){
                if(d[j - arr[i]] != 10001){
                    d[j] = Math.min(d[j], d[j - arr[i]] + 1);
                }
            }
        }

        if(d[m] == 10001) System.out.println("-1");
        else System.out.println(d[m]);
    }
}
