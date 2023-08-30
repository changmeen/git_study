package 잡다한거.DFS_BFS;
import java.util.*;
import java.io.*;

public class DFS_BFS_2 {

    public static int n, m;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            String str = br.readLine();
            for(int j = 1; j <= m; j++){
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        bfs(new Point(1, 1, 1));

        System.out.println(map[n][m]);
    }

    static void bfs(Point p){
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited[p.x][p.y] = true;

        while(!q.isEmpty()){
            p = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 1 && ny >= 1 && nx <= n && ny <= m){
                    if(map[nx][ny] == 1 && !visited[nx][ny]){
                    	map[nx][ny] = p.cnt + 1;
                        q.offer(new Point(nx, ny, p.cnt + 1));
                        visited[nx][ny] = true;
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