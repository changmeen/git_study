package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 줄세우기 - 실버 5
public class No_10431 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 0; t < test_case; t++){
            st = new StringTokenizer(br.readLine(), " ");
            int now = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];

            for(int i = 0; i < 20; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for(int i = 1; i < 20; i++){
                for(int j = i - 1; j >= 0; j--){
                    if(arr[i] < arr[j]) cnt++;
                }
            }

            System.out.println(now + " " + cnt);
        }
    }
}
