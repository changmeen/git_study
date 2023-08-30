package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 쉬운 최단거리 - 실버 1
public class No_14940 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        int sx = -1, sy = -1;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    sx = i;
                    sy = j;
                }
            }
        }

        bfs(sx, sy);
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(map[i][j] == 1) System.out.print("-1 ");
                else if(map[i][j] == -2) System.out.print("1 ");
                else System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int sx, int sy){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(sx, sy, 0));
        visited[sx][sy] = true;
        map[sx][sy] = 0;

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    map[nx][ny] = p.cnt + 1;
                    if(map[nx][ny] == 1) map[nx][ny] = -2;
                    q.offer(new Point(nx, ny, p.cnt + 1));
                }
            }
        }
    }
}

class Point{
    int x, y, cnt;

    Point(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}