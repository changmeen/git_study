package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 겹치는 건 싫어 - 실버 1
public class No_20922 {

    static int N, K;
    static int[] list;
    static int max = Integer.MIN_VALUE;
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        cnt();
        System.out.println(max);
    }

    static void cnt(){
        int start = 0;
        int end = 0;
        int[] cnt = new int[100001];
        while(end < list.length){
            while(end < list.length && cnt[list[end]] + 1 <= K){
                cnt[list[end]]++;
                end++;
            }
            int len = end - start;
            max = Math.max(max, len);
            cnt[list[start]]--;
            start++;
        }
    }
}
