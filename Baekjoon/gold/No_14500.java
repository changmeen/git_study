package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 테트로미노 - 골드 4
public class No_14500 {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y, int depth, int sum){
        if(depth == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                if(!visited[nx][ny]){
                    if(depth == 2){
                        visited[nx][ny] = true;
                        dfs(x, y, depth + 1, sum + map[nx][ny]);
                        visited[nx][ny] = false;
                    }

                    visited[nx][ny] = true;
                    dfs(nx, ny, depth + 1, sum + map[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
