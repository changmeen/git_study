package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 택배 배송 - 골드 5
public class No_5972 {
    static int N, M;
    static int[] d;
    static ArrayList<ArrayList<node>> graph = new ArrayList<ArrayList<node>>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        d = new int[N + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        for(int i = 0; i <= N; i++) graph.add(new ArrayList<node>());

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(a).add(new node(b, dist));
            graph.get(b).add(new node(a, dist));
        }

        dijkstra();

        System.out.println(d[N]);
    }

    static void dijkstra(){
        d[1] = 0;
        PriorityQueue<node> q = new PriorityQueue<>();
        q.offer(new node(1, 0));

        while(!q.isEmpty()){
            node p = q.poll();
            int now = p.idx;
            int dist = p.dist;

            if(d[now] < dist) continue;

            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).dist;

                if(cost < d[graph.get(now).get(i).idx]){
                    d[graph.get(now).get(i).idx] = cost;
                    q.offer(new node(graph.get(now).get(i).idx, cost));
                }
            }
        }
    }
}

class node implements Comparable<node> {
    int idx, dist;

    node(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }

    @Override
    public int compareTo(node o) {
        return this.dist - o.dist;
    }
}