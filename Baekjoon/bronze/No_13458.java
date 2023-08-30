package Baekjoon.bronze;
import java.util.*;
import java.io.*;

// 시험 감독 - 브론즈 2
public class No_13458 {

    static int n, b, c;
    static int[] list;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        long answer = 0;
        for(int i = 0; i < n; i++){
            answer++;
            list[i] -= b;
            
            if(list[i] > 0) {
                int plus;
                if(list[i] % c == 0) plus = list[i] / c;
                else plus = list[i] / c + 1;
                answer += plus;
            }
        }
        System.out.println(answer);
    }
}