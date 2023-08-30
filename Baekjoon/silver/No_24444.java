package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 알고리즘 수업 - 너비 우선 탐색 1 - 실버 2
public class No_24444 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int n, m, r, num = 1;
    static int[] order;
    static boolean[] visited;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) graph.add(new ArrayList<Integer>());
        order = new int[n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(int i = 0; i <= n; i++){
            Collections.sort(graph.get(i));
        }

        bfs(r);

        for(int i = 1; i <= n; i++){
            System.out.println(order[i]);
        }
    }

    static void bfs(int start){
        visited[start] = true;
        order[start] = num++;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i = 0; i < graph.get(now).size(); i++){
                if(!visited[graph.get(now).get(i)]){
                    visited[graph.get(now).get(i)] = true;
                    order[graph.get(now).get(i)] = num++;
                    q.offer(graph.get(now).get(i));
                }
            }
        }
    }
}
