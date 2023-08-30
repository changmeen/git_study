package 잡다한거.Shortest_Route;
import java.io.*;
import java.util.*;

// 힙 자료구조(우선순위 큐)를 활용한 다익스트라 알고리즘
// 시간복잡도 = O(ElogE) E는 간선의 개수를 의미
public class Dijkstra2 {

    public static final int INF = (int) 1e9;
    // n은 노드의 개수 m은 간선의 개수
    public static int n, m, start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] d = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }   

        Arrays.fill(d, INF);

        dijkstra(start);

        for(int i = 1; i <= n; i++){
            System.out.println(start + "번 노드에서 " + i + "번 노드까지의 거리");
            if(d[i] == INF){
                System.out.println("INFINITY");
            }
            else System.out.println(d[i]);
        }
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();
            
            // 얘가 방문 여부도 판단해 준다
            if(d[now] < dist) continue;

            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }                
            }
        }
    }
}

class Node implements Comparable<Node>{
    private int index;
    private int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node other){
        if(this.distance < other.distance){
            return -1;
        }
        return 1;
    }
}