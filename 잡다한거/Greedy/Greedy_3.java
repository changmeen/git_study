package 잡다한거.Greedy;
import java.util.*;
import java.io.*;

/* 그리드_실전 문제_1이 될 때까지 */ 
public class Greedy_3{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;

        // while(n != 1){
        //     if( n % k != 0){
        //         n--;
        //         cnt++;
        //     }
        //     else{
        //         n /= k;
        //         cnt++;
        //     }
        // }

        while(true){
            if(n < k){
                break;
            }
            
            int target = (n / k) * k;
            cnt += n - target;
            n = target;

            n /= k;
            cnt++;
        }

        cnt += n - 1;

        System.out.println(cnt);
    }
}