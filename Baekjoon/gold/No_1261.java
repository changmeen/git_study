package Baekjoon.gold;
import java.util.*;
import java.io.*;

public class No_1261 {

    static int n, m, min = Integer.MAX_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(min);
    }

    public static void bfs(){
        Node node = new Node(0, 0, 0);
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(node);
        visited[0][0] = true;

        while(!q.isEmpty()){
            node = q.poll();

            int nowX = node.x;
            int nowY = node.y;
            int cnt = node.cnt;

            if(nowX == n - 1 && nowY == m - 1){
                min = cnt;
                return;
            }

            for(int i = 0; i < 4; i++){
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];

                if((newX >= 0) && (newY >= 0) && (newX < n) && (newY < m)){
                    if(map[newX][newY] == 1 && !visited[newX][newY]){
                        q.offer(new Node(newX, newY, cnt + 1));
                        visited[newX][newY] = true;
                    }

                    else if(map[newX][newY] == 0 && !visited[newX][newY]){
                        q.offer(new Node(newX, newY, cnt));
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int x;
    int y;
    int cnt;

    Node(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node other) {
        return this.cnt - other.cnt;
    }
}