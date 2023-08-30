package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 진우의 달 여행 (Small) - 실버 3
public class No_17484 {
    static int N, M;
    static int[][] map;
    static int[] dy = {-1, 0, 1};
    static int min = Integer.MAX_VALUE;
    static int[] visited;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            visited = new int[N];
            visited[0] = i;
            dfs(1, i, -1);
        }
        
        System.out.println(min);
    }

    static void dfs(int depth, int y, int dir){
        if(depth == N){
            int sum = map[0][visited[0]];
            for(int i = 1; i < N; i++){
                sum += map[i][visited[i]];
            }

            min = Math.min(min, sum);
            return;
        }

        for(int i = 0; i < 3; i++){
            int ny = y + dy[i];

            if(ny >= 0 && ny < M && dir != i){
                visited[depth] = ny;
                dfs(depth + 1, ny, i);
            }
        }
    }
}