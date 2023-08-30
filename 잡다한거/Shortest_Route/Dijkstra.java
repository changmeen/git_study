package 잡다한거.Shortest_Route;
import java.io.*;
import java.util.*;

// 다익스트라 알고리즘_시간 복잡도 = O(V^2) 이때 V는 노드의 개수를 의미
public class Dijkstra {

    public static final int INF = (int) 1e9;
    // n은 노드의 개수 m은 간선의 개수
    public static int n, m, start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] d = new int[100001];
    public static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        // 1번부터 n번까지의 노드 정보들을 담기 위해 n+1개 만큼 선언
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

    // d[]를 돌며 가장 최소 노드의 index를 return
    public static int getSmallestNode(){
        int min_value = INF;
        int index = 0;

        for(int i = 1; i <= n; i++){
            if(d[i] < min_value && !visited[i]){
                min_value = d[i];
                index = i;
            }
        }

        return index;
    }

    public static void dijkstra(int start){
        // 처음 들어온 노드의 거리는 무조건 0
        // 처음 들어온 노드 방문 처리
        d[start] = 0;
        visited[start] = true;

        // 처음 들어온 노드와 연결된 노드들의 index정보를 확인해 distance를
        // d[]에 저장해준다
        for(int i = 0; i < graph.get(start).size(); i++){
            d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
        }

        // 노드의 개수는 총 n개인데 그중에 한개는 처음에 확인했으니 n-1번 수행
        for(int i = 0; i < n - 1; i++){
            // 현재 d[]에 저장되있는 값들 중에 가장 가까운 노드 선택
            int now = getSmallestNode();
            // 선택된 노드 방문 처리
            visited[now] = true;

            // 새로 선택된 노드와 연결된 노드들의 정보들 입력
            for(int j = 0; j < graph.get(now).size(); j++){
                // 단 그냥 입력하는게 아니라
                // 지금 보는 노드에서 갈 수 있는 방법이 더 빠르면
                // d[] 덮어씌움
                int cost = d[now] + graph.get(now).get(j).getDistance();
                if(cost < d[graph.get(now).get(j).getIndex()]){
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }
}

class Node{
    private int index;
    private int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex(){
        return this.index;
    }

    public int getDistance(){
        return this.distance;
    }
}