
import java.io.*;
import java.util.*;
import java.awt.Point;

public class BFS_Shortest_Path {
    // 동 남 서 북
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int n, m;

    // 지도 읽는 map
    public static int[][] map;
    public static boolean[][] visited;

    public static ArrayList<Point> route = new ArrayList<>();

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isPossible = bfs(0, 0);
        if(isPossible){
            for(int i = 0; i < route.size(); i++){
                System.out.println(route.get(i).getX() + " " + route.get(i).getY());
            }
        }
    }

    public static boolean bfs(int x, int y){
        ArrayList<Point> temp = new ArrayList<>();
        temp.add(new Point(0,0));
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, temp));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            ArrayList<Point> arr = node.arr;
            int nowX = node.x;
            int nowY = node.y;

            if(nowX == n - 1 && nowY == m - 1){
                route = node.arr;
                return true;
            }

            for(int i = 0; i < 4; i++){
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];

                if(newX >= 0 && newY >= 0 && newX < n && newY < m){
                    if(map[newX][newY] == 1 && !visited[newX][newY]){
                        arr.add(new Point(newX, newY));
                        visited[newX][newY] = true;
                        q.offer(new Node(newX, newY, arr));
                    }
                }
            }
        }

        return false;
    }
}

class Node{
    int x;
    int y;
    ArrayList<Point> arr = new ArrayList<>();

    Node(int x, int y, ArrayList<Point> arr1){
        this.x = x;
        this.y = y;
        for(int i = 0; i < arr1.size(); i++) {
            arr.add(arr1.get(i));
        }
    }
}