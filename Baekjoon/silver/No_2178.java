package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 미로 탐색 - 실버 1
public class No_2178 {
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y){
        Queue<pos> q = new LinkedList<>();
        q.offer(new pos(x, y, 1));
        visited[x][y] = true;

        while(!q.isEmpty()){
            pos p = q.poll();

            if(p.x == n - 1 && p.y == m - 1){
                return p.cnt;
            }

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(map[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new pos(nx, ny, p.cnt + 1));
                    }
                }
            }
        }

        return 0;
    }
}

class pos{
    int x, y, cnt;

    pos(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}