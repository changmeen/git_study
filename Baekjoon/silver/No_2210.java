package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 숫자판 점프 - 실버2
public class No_2210 {

    static int[][] map = new int[5][5];
    static HashSet<String> hs = new HashSet<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                dfs(i, j, 1, String.valueOf(map[i][j]));
            }
        }

        System.out.println(hs.size());
    }

    static void dfs(int x, int y, int depth, String now){
        if(depth == 6){
            if(!hs.contains(now)) hs.add(now);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5){
                String temp = now + String.valueOf(map[nx][ny]);
                dfs(nx, ny, depth + 1, temp);
            }
        }
    }
}
