package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 미세먼지 안녕! - 골드 4
public class No_17144 {

    static int r, c, t, ox, tx;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r + 1][c + 1];
        visited = new boolean[r + 1][c + 1];

        int air = 0;
        for(int i = 1; i <= r; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= c; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    if(air == 0){
                        ox = i;
                        air++;
                    }
                    else{
                        tx = i;
                    }
                }
            }
        }

        for(int k = 0; k < t; k++){
            spread();
            clean();
        }

        int res = 0;
        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                if(map[i][j] != -1) res += map[i][j];
            }
        }

        System.out.println(res);
    }
    static void clean(){
        for(int i = ox - 1; i > 1; i--){
            map[i][1] = map[i - 1][1];
        }
        for(int i = 1; i < c; i++){
            map[1][i] = map[1][i + 1];
        }
        for(int i = 1; i < ox; i++){
            map[i][c] = map[i + 1][c];
        }
        for(int i = c; i > 1; i--){
            map[ox][i] = map[ox][i - 1];
        }
        map[ox][2] = 0;

        for(int i = tx + 1; i < r; i++){
            map[i][1] = map[i + 1][1];
        }
        for(int i = 1; i < c; i++){
            map[r][i] = map[r][i + 1];
        }
        for(int i = r; i > tx; i--){
            map[i][c] = map[i - 1][c];
        }
        for(int i = c; i > 1; i--){
            map[tx][i] = map[tx][i - 1];
        }
        map[tx][2] = 0;
    }

    static void spread(){
        int[][] temp = new int[r + 1][c + 1];

        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                if(map[i][j] == -1) temp[i][j] = -1;
                if(map[i][j] > 0){
                    int move_cnt = 0;
                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx > 0 && ny > 0 && nx <= r && ny <= c){
                            if(map[nx][ny] != -1){
                                move_cnt++;
                                temp[nx][ny] += (map[i][j] / 5);
                            }
                        }
                    }
                    temp[i][j] += map[i][j] - (map[i][j] / 5) * move_cnt;
                }
            }
        }

        map = temp.clone();
    }
}
