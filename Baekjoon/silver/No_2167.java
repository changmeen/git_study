package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 2차원 배열의 합 - 실버 5
public class No_2167 {
    static int N, M, K;
    static int[][] map;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        K = Integer.parseInt(br.readLine());

        for(int k = 0; k < K; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(cnt(x1, y1, x2, y2));
        }
    }

    static int cnt(int x1, int y1, int x2, int y2){
        int sum = 0;

        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                sum += map[i][j];
            }
        }

        return sum;
    }
}
