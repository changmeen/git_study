package 잡다한거.Shortest_Route;
import java.io.*;
import java.util.*;

// 최단 거리_실전 문제_전보
public class Shortest_Route_2 {

    public static final int INF = (int) 1e9;
    public static int n, m, c;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        d = new int[n + 1];
        Arrays.fill(d, INF);

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y, dist));
        }

        dijkstra(c);

        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(d[i] != INF && i != c){
                cnt++;
                if(max < d[i]) max = d[i];
            }
        }

        System.out.println(cnt + " " + max);
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if(d[now] < dist) continue;

            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = graph.get(now).get(i).getDistance() + d[now];

                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int index;
    int distance;

    Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex(){
        return this.index;
    }

    public int getDistance(){
        return this.distance;
    }

    @Override
    public int compareTo(Node other) {
        if(this.distance < other.distance) return -1;
        else return 1;
    }
}