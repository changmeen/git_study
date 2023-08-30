package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 양 - 실버 1
public class No_3184 {

    static int r, c, s, w;
    static boolean check;
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < c; j++){
                map[i][j] = str[j];
            }
        }

        int res_s = 0;
        int res_w = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if((map[i][j].equals("o") || map[i][j].equals("v")) && !visited[i][j]){
                    check = true;
                    s = 0;
                    w = 0;
                    visited[i][j] = true;
                    dfs(i, j);
                    if(check){
                        if(s > w) res_s += s;
                        else res_w += w;
                    }
                }
            }
        }

        System.out.println(res_s + " " + res_w);
    }

    static void dfs(int x, int y){
        if(check == false) return;
        if((x == 0 || y == 0 || x == r - 1 || y == c - 1) && map[x][y].equals(".")) check = false;
        if(map[x][y].equals("o")) s++;
        else if(map[x][y].equals("v")) w++;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < r && ny < c){
                if(!map[nx][ny].equals("#") && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }
}
