package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 주유소 - 실버 3
public class No_13305 {
    static int N;
    static Long min_cost = Long.MAX_VALUE;
    static Long[] length, oil;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        length = new Long[N];
        oil = new Long[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < N; i++){
            length[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            oil[i] = Long.parseLong(st.nextToken());
        }

        Long sum = 0L;
        for(int i = 1; i <= N; i++){
            int len = 0;
            for(int j = i + 1; j <= N; j++){
                if(oil[i] > oil[j]){
                    for(int l = i; l < j; l++) len += length[l];
                    sum += (len * oil[i]);
                    i = j - 1;
                    break;
                }
                if(j == N){
                    for(int l = i; l < j; l++) len += length[l];
                    sum += (len * oil[i]);
                    System.out.println(sum);
                    return;
                }
            }
        }
        System.out.println(sum);
    }
}
