package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 기타 레슨 - 실버1
public class No_2343 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] lesson_list = new int[n];

        int left = 0;
        int right = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            lesson_list[i] = Integer.parseInt(st.nextToken());
            right += lesson_list[i];
            left = Math.max(left, lesson_list[i]);
        }

        while(left <= right){
            int mid = (left + right) / 2;

            int cnt = getCount(n, lesson_list, mid);

            if(cnt > m){
                left = mid + 1;
            }
            else right = mid - 1;
        }

        System.out.println(left);
    }

    static int getCount(int n, int[] lesson_list, int mid){
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(sum + lesson_list[i] > mid){
                sum = 0;
                cnt++;
            }
            sum += lesson_list[i];
        }
        if(sum != 0) cnt++;
        return cnt;
    }
}