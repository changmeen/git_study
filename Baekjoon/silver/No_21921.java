package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 블로그 - 실버 3
public class No_21921 {
    static int N, X;
    static int[] list;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int sum = 0;
        for(int i = 1; i <= X; i++) sum += list[i];
        max = sum;

        int cnt = 1;
        if(N >= 2){
            for(int i = 1; i <= N - X; i++){
                sum -= list[i];
                sum += list[i + X];
                if(sum == max) cnt++;

                if(max < sum){
                    cnt = 1;
                    max = sum;
                }
            }
        }

        if(max != 0){
            System.out.println(max);
            System.out.println(cnt);
        }
        else{
            System.out.println("SAD");
        }
    }
}
