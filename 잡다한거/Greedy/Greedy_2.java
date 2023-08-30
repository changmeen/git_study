package 잡다한거.Greedy;
import java.io.*;
import java.util.*;

// 그리디_실전 문제_숫자 카드 게임
// public class Greedy_2 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine(), " ");

//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());

//         int[] result = new int[n];
//         for(int i = 0; i < n; i++){
//             int[] array = new int[m];
//             st = new StringTokenizer(br.readLine(), " ");

//             for(int j = 0; j < m; j++){
//                 array[j] = Integer.parseInt(st.nextToken());
//             }

//             Arrays.sort(array);

//             result[i] = array[0];
//         }

//         Arrays.sort(result);

//         System.out.println(result[n - 1]);
//     }
// }

public class Greedy_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = -1;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int min = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++){
                min = Math.min(min, Integer.parseInt(st.nextToken()));
            }

            result = Math.max(result, min);
        }

        System.out.println(result);
    }
}