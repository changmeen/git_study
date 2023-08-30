package 잡다한거.Greedy;
import java.io.*;
import java.util.*;

// 그리디_실전 문제_큰 수의 법칙
public class Greedy_1 {
    // public static void main(String[] args) throws IOException{
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    //     int n = Integer.parseInt(st.nextToken());
    //     int m = Integer.parseInt(st.nextToken());
    //     int k = Integer.parseInt(st.nextToken());

    //     int[] array = new int[n];
    //     st = new StringTokenizer(br.readLine(), " ");
    //     for(int i = 0; i < n; i++){
    //         array[i] = Integer.parseInt(st.nextToken());
    //     }

    //     Arrays.sort(array);

    //     int result = 0;
    //     int cnt = 0;
    //     while(cnt != m){
    //         for(int i = 0; i < k; i++){
    //             if(cnt == m){
    //                 break;
    //             }
    //             result += array[n - 1];
    //             cnt++;
    //         }
    //         if(cnt == m){
    //             break;
    //         }
    //         result += array[n - 2];
    //         cnt++;
    //     }

    //     System.out.println(result);
    // }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        int first = array[n - 1];
        int second = array[n - 2];

        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);

        int result = cnt * first;
        result += second * (m - cnt);

        System.out.println(result);
    }
}
