package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 알고리즘 수업 - 깊이 우선 탐색 1 - 실버 2
public class No_24479 {

    static int n, m, r, cnt = 1;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        visited = new int[n];
        for(int i = 0; i < n; i++) list.add(new ArrayList<Integer>());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            list.get(u).add(v);
            list.get(v).add(u);
        }

        for(int i = 0; i < n; i++){
            Collections.sort(list.get(i));
        }
        dfs(r - 1);

        for(int i = 0; i < n; i++){
            System.out.println(visited[i]);
        }
    }

    static void dfs(int now){
        if(visited[now] == 0){
            visited[now] = cnt;
            cnt++;
        }
        
        for(int i = 0; i < list.get(now).size(); i++){
            if(visited[list.get(now).get(i)] == 0){
                dfs(list.get(now).get(i));
            }
        }
    }
}
