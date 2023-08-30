package 잡다한거.Shortest_Route;
import java.io.*;
import java.util.*;

// 최단 거리_실전 문제_미래 도시
public class Shortest_Route_1 {
    public static final int INF = (int) 1e9;
    public static int n, m, x, k;
    public static int[][] graph = new int[101][101];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) graph[i][j] = 0;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    graph[j][i] = graph[i][j];
                }
            }
        }

        if(graph[1][k] != INF && graph[k][x] != INF) System.out.println(graph[1][k] + graph[k][x]);
        else System.out.println("-1");
    }
}
