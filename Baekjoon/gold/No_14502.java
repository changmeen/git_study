package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 연구소 - 골드 4
public class No_14502 {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int n, m, answer = Integer.MIN_VALUE;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int cnt){
        if(cnt == 3){
            bfs();
            return;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        int[][] copy_map = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                copy_map[i][j] = map[i][j];
                if(map[i][j] == 2){
                    q.offer(new Node(i, j));
                }
            }
        }

        while(!q.isEmpty()){
            Node node = q.poll();

            int nx = node.x;
            int ny = node.y;

            for(int i = 0; i < 4; i++){
                int newX = nx + dx[i];
                int newY = ny + dy[i];

                if(newX >= 1 && newY >= 1 && newX <= n && newY <= m){
                    if(copy_map[newX][newY] == 0){
                        q.offer(new Node(newX, newY));
                        copy_map[newX][newY] = 2;
                    }
                }
            }
        }

        cnt_safe(copy_map);
    }

    public static void cnt_safe(int[][] copy){
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(copy[i][j] == 0) cnt++;
            }
        }

        answer = answer > cnt ? answer : cnt;
    }
}

class Node{
    int x;
    int y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}