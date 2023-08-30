package 잡다한거.DFS_BFS;
import java.util.*;
import java.io.*;

// DFS/BFS_실전 문제_음료수 얼려 먹기
public class DFS_BFS_1 {

    public static int n, m;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // map의 크기를 위한 n과 m
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 0과 1정보를 담기 위한 map과 각 위치 방문 여부 판단을 위한 visited
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        // 0과 1 정보 읽어서 map에 저장
        for(int i = 1; i <= n; i++){
            String str = br.readLine();
            for(int j = 1; j <= m; j++){
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        // map을 전체를 훑으면서 해당 위치가 0이고 방문된 적이 없으면 bfs 탐색
        // bfs 탐색을 한번 돈다 -> 한 위치와 연결된 모든 지점을 다 찾음 -> 하나의 아이스크림을 찾음
        int result = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    bfs(new point(i, j));
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs(point p){
        Queue<point> q = new LinkedList<>();
        q.offer(p);
        visited[p.x][p.y] = true;

        while(!q.isEmpty()){
            p = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 1 && ny >= 1 && nx <= n && ny <= m){
                    if(map[nx][ny] == 0 && !visited[nx][ny]){
                        q.offer(new point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}

// 위치를 참조하기 위한 point class 생성
class point{
    int x;
    int y;

    point(int x, int y){
        this.x = x;
        this.y = y;
    }
}