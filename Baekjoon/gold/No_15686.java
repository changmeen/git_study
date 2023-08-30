package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 치킨 배달 - 골드 5
public class No_15686 {

    static int[][] map;
    static boolean[][] visited;
    static boolean[] check;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int h_cnt = 0, c_cnt = 0;
    static int[] target_x;
    static int[] target_y;
    static int[][] c_dist;
    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) h_cnt++;
                else if(map[i][j] == 2) c_cnt++;
            }
        }

        target_x = new int[c_cnt];
        target_y = new int[c_cnt];
        c_dist = new int[h_cnt][c_cnt];

        int cnt = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(map[i][j] == 2){
                    target_x[cnt] = i;
                    target_y[cnt] = j;
                    cnt++;
                }
            }
        }
    
        int h_num = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(map[i][j] == 1){
                    bfs(i, j, 0, h_num);
                    h_num++;
                }
            }
        }

        check = new boolean[c_cnt];
        dfs(0, 0);

        System.out.println(min);
    }

    static void dfs(int idx, int depth){
        if(depth == m){
            int sum = 0;

            for(int i = 0; i < h_cnt; i++){

                int h_min = Integer.MAX_VALUE;

                for(int j = 0; j < c_cnt; j++){
                    if(check[j] == true){
                        h_min = h_min > c_dist[i][j] ? c_dist[i][j] : h_min;
                    }
                }
                sum += h_min;
            }
            min = min > sum ? sum : min;
            return;
        }
        if(idx == c_cnt) return;

        check[idx] = true;
        dfs(idx + 1, depth + 1);
        check[idx] = false;
        dfs(idx + 1, depth);
    }

    static void bfs(int x, int y, int cnt, int h_num){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, cnt));
        visited = new boolean[n + 1][n + 1];
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(map[p.x][p.y] == 2){
                for(int i = 0; i < target_x.length; i++){
                    if(p.x == target_x[i] && p.y == target_y[i]){
                        c_dist[h_num][i] = p.cnt;
                        break;
                    }
                }
            }

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 1 && ny >= 1 && nx <= n && ny <= n){
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny, p.cnt + 1));
                    }
                }
            }
        }
    }
}

class Point{
    int x;
    int y;
    int cnt;

    Point(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}