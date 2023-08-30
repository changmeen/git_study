package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 로봇 청소기 - 골드 5
public class No_14503 {
    
    static int n, m, sx, sy, sd, cnt = 1;
    // 1이면 벽 0이면 빈칸
    static int[][] map;
    // 0_북, 1_동, 2_남, 3_서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        st = new StringTokenizer(br.readLine(), " ");
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        sd = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(sx, sy, sd);

        System.out.println(cnt);
    }

    static void dfs(int x, int y, int d){
        map[x][y] = 2;

        for(int i = 0; i < 4; i++){
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                if(map[nx][ny] == 0){
                    cnt++;
                    dfs(nx, ny, d);
                    return;
                }
            }
        }

        int back = (d + 2) % 4;
        int nx = x + dx[back];
        int ny = y + dy[back];

        if(nx >= 0 && ny >= 0 && nx < n && ny < m){
            if(map[nx][ny] != 1){
                dfs(nx, ny, d);
            }
        }
    }
}