package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 비숍 - 골드1 아직 못품
public class No_1799 {

    public static int n;
    public static int[][] map;
    public static int[] dx = {-1, -1, 1, 1};
    public static int[] dy = {-1, 1, -1, 1};
    public static int b_cnt = 0;
    public static int w_cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] black_visited = new boolean[n + 1][n + 1];
        black_search(black_visited, 1, 1, 0);
        boolean[][] white_visited = new boolean[n + 1][n + 1];
        white_search(white_visited, 1, 2, 0);

        System.out.println(b_cnt + w_cnt);
    }

    public static void black_search(boolean[][] visited, int x, int y, int cnt){
        b_cnt = Math.max(cnt, b_cnt);

        if(y > n){
            x++;
            y = (x % 2 == 0 ? 2 : 1);
        }

        if(x > n) return;

        if(isAble(visited, x, y)){
            visited[x][y] = true;
            black_search(visited, x, y + 2, cnt + 1);
            visited[x][y] = false;
        }

        black_search(visited, x, y + 2, cnt);
    }

    public static void white_search(boolean[][] visited, int x, int y, int cnt){
        w_cnt = Math.max(w_cnt, cnt);

        if(y > n){
            x++;
            y = (x % 2 == 0 ? 1 : 2);
        }

        if(x > n) return;

        if(isAble(visited, x, y)){
            visited[x][y] = true;
            white_search(visited, x, y + 2, cnt + 1);
            visited[x][y] = false;
        }

        white_search(visited, x, y + 2, cnt);
    }

    public static boolean isAble(boolean[][] visited, int x, int y){
        if(map[x][y] == 0) return false;

        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            
            for(int j = 1; j <= n; j++){
                if(nx > 0 && ny > 0 && nx <= n && ny <= n){
                    if(visited[nx][ny]) return false;

                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }

        return true;
    }
}
