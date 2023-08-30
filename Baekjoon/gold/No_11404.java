package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 플로이드 - 골드 4
public class No_11404 {

    public static final int INF = (int) 1e9;
    public static int n, m;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            Arrays.fill(map[i], INF);
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) map[i][j] = 0;
            }
        }

        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(map[a][b] != INF){
                map[a][b] = Math.min(map[a][b], c);
            }
            else map[a][b] = c;
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    map[i][j] = Math.min(map[i][j], (map[i][k] + map[k][j]));
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(map[i][j] == INF) map[i][j] = 0;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
