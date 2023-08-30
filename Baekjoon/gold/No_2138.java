package Baekjoon.gold;
import java.io.*;

// 전구와 스위치
public class No_2138 {
    static int n;
    static int[] dx = {-1, 0, 1};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] list1 = new int[n];
        int[] list2 = new int[n];
        int[] target = new int[n];
        int res = Integer.MAX_VALUE;

        String[] list = br.readLine().split("");

        for(int i = 0; i < n; i++){
            list1[i] = list2[i] = Integer.parseInt(list[i]);
        }

        list = br.readLine().split("");
        for(int i = 0; i < n; i++){
            target[i] = Integer.parseInt(list[i]);
        }

        // 0번 바꾸고 시작
        int cnt = 1;
        change(list1, 0);
        for(int i = 1; i < n; i++){
            if(list1[i - 1] != target[i - 1]){
                change(list1, i);
                cnt++;
            }
        }
        
        if(list1[n - 1] == target[n - 1]){
            res = Math.min(res, cnt);
        }

        // 0번 전구를 냅두고 시작
        cnt = 0;
        for(int i = 1; i < n; i++){
            if(list2[i - 1] != target[i - 1]){
                change(list2, i);
                cnt++;
            }
        }
        if(list2[n - 1] == target[n - 1]) {
            res = Math.min(res, cnt);
        }

        if(res == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        else{
            System.out.println(res);
        }
    }

    static void change(int[] list, int idx){
        for(int i = 0; i < dx.length; i++){
            int nx = idx + dx[i];

            if(nx < 0 || nx >= n) continue;

            else{
                if(list[nx] == 0) list[nx] = 1;
                else list[nx] = 0;
            }
        }
    }
}
