package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 구슬 탈출 2 - 골드 1
public class No_13460 {

    public static int n, m;
    public static char[][] map;
    public static boolean[][][][] visited;
    public static int holeX, holeY;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static Marble red, blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m][n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'O'){
                    holeX = i;
                    holeY = j;
                }
                else if(map[i][j] == 'R'){
                    red = new Marble(i, j, 0, 0, 0);
                }
                else if(map[i][j] == 'B'){
                    blue = new Marble(0, 0, i, j, 0);
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Marble> q = new LinkedList<>();
        q.offer(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.bx][blue.by] = true;

        while(!q.isEmpty()){
            Marble marble = q.poll();

            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.cnt;

            if(curCnt > 10) return -1;

            for(int i = 0; i < 4; i++){
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                while(map[newRx + dx[i]][newRy + dy[i]] != '#'){
                    newRx += dx[i];
                    newRy += dy[i];

                    if(newRx == holeX && newRy == holeY){
                        isRedHole = true;
                        break;
                    }
                }

                while(map[newBx + dx[i]][newBy + dy[i]] != '#'){
                    newBx += dx[i];
                    newBy += dy[i];

                    if(newBx == holeX && newBy == holeY){
                        isBlueHole = true;
                        break;
                    }
                }

                if(isBlueHole) continue;

                if(isRedHole && !isBlueHole) return curCnt;

                if(newRx == newBx && newRy == newBy){
                    if(i == 0){
                        if(curRx > curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    }
                    else if(i == 1){
                        if(curRy > curBy) newBy -= dy[i];
                        else newRy -= dy[i];
                    }

                    else if(i == 2){
                        if(curRx > curBx) newBx -= dx[i];
                        else newRx -= dx[i];
                    }

                    else{
                        if(curRy > curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    }
                }

                if(!visited[newRx][newRy][newBx][newBy]){
                    visited[newRx][newRy][newBx][newBy] = true;
                    q.offer(new Marble(newRx, newRy, newBx, newBy, curCnt + 1));
                }
            }
        }

        return -1;
    }
}

class Marble{
    int rx;
    int ry;
    int bx;
    int by;
    int cnt;

    Marble(int rx, int ry, int bx, int by, int cnt){
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}