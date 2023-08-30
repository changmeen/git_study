package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 전쟁 - 전투 - 실버1
public class No_1303 {

    static int n, m, cnt;
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new String[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = str[j];
            }
        }

        int w_cnt = 0;
        int b_cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
                    cnt = 0;
                    dfs(i, j);
                    if(map[i][j].equals("W")) w_cnt += Math.pow(cnt, 2);
                    else b_cnt += Math.pow(cnt, 2);
                }
            }
        }

        System.out.println(w_cnt + " " + b_cnt);
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        cnt++;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                if(map[nx][ny].equals(map[x][y]) && !visited[nx][ny]){
                    dfs(nx, ny);
                }
            }
        }
    }
}
