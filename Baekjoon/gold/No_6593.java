package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 상범 빌딩 - 골드 5
public class No_6593 {

    static int L, R, C;
    static Character[][][] map;
    static boolean[][][] visited;
    static int sl, sr, sc, el, er, ec;
    static int[] dx = {0, 0, 1, 0, -1, 0};
    static int[] dy = {0, 0, 0, 1, 0, -1};
    static int[] dz = {1, -1, 0, 0, 0, 0};

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) break;

            map = new Character[L][R][C];
            visited = new boolean[L][R][C];

            for(int i = 0; i < L; i++){
                for(int j = 0; j < R; j++){
                    String str = br.readLine();

                    if(str.equals("")) str = br.readLine();

                    for(int k = 0; k < C; k++){
                        map[i][j][k] = str.charAt(k);
                        if(map[i][j][k] == 'S'){
                            sl = i;
                            sr = j;
                            sc = k;
                        }
                        else if(map[i][j][k] == 'E'){
                            el = i;
                            er = j;
                            ec = k;
                        }
                    }
                }
            }

            bfs();
        }
    }

    static void bfs(){
        Queue<pos> q = new LinkedList<>();
        visited[sl][sr][sc] = true;
        q.offer(new pos(sl, sr, sc, 0));

        while(!q.isEmpty()){
            pos p = q.poll();

            if(p.z == el && p.x == er && p.y == ec){
                System.out.println("Escaped in " + p.cnt + " minute(s).");
                return;
            }

            for(int i = 0; i < 6; i++){
                int nz = p.z + dz[i];
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nz >= 0 && nx >= 0 && ny >= 0 && nz < L && nx < R && ny < C){
                    if(map[nz][nx][ny] != '#' && !visited[nz][nx][ny]){
                        visited[nz][nx][ny] = true;
                        q.offer(new pos(nz, nx, ny, p.cnt + 1));
                    }
                }
            }
        }
        if(visited[el][er][ec] == false){
            System.out.println("Trapped!");
            return;
        }
    }
}

class pos{
    int z;
    int x;
    int y;
    int cnt;

    pos(int z, int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.z = z;
        this.cnt = cnt;
    }
}
