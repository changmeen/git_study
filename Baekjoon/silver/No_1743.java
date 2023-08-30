package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 음식물 피하기 - 실버1
public class No_1743 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int n, m, k, max = Integer.MIN_VALUE, cnt;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(map[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    max = Math.max(max, cnt);
                }
            }
        }
        
        System.out.println(max);
    }

    static void dfs(int r, int c){
        visited[r][c] = true;
        cnt++;

        for(int i = 0; i < 4; i++){
            int nx = r + dx[i];
            int ny = c + dy[i];

            if(nx > 0 && ny > 0 && nx <= n && ny <= m){
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx, ny);
                }
            }
        }
    }
}
