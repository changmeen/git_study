package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 예산 - 실버 3
public class No_2512 {
    static Long M;
    static int N;
    static int[] list;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        list = new int[N + 1];
        
        st = new StringTokenizer(br.readLine(), " ");
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            sum += list[i];
            if(max < list[i]) max = list[i];
        }

        M = Long.parseLong(br.readLine());
        if(sum <= M){
            System.out.println(max);
            return;
        }
        
        sb.append(binary_search(0, sum, M));
        System.out.println(sb);
    }

    static int binary_search(int left, int right, Long target){
        while(left <= right){
            int mid = (left + right) / 2;
            Long sum = 0L;
            
            for(int i = 1; i <= N; i++){
                if(list[i] <= mid) sum += list[i];
                else sum += mid;
            }
            if(sum <= target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return right;
    }
}
