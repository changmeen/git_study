package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 스카이라인 쉬운거 - 골드 4
public class No_1863 {
    static int N, x, y, answer = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[50002];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr[i] = y;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= N; i++){
            while(!stack.isEmpty() && stack.peek() > arr[i]){
                answer += 1;
                stack.pop();
            }

            if(!stack.empty() && stack.peek() == arr[i]) continue;
            stack.push(arr[i]);
        }

        System.out.println(answer);
    }
}
