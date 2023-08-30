package 잡다한거.Graph_Theory;
import java.io.*;
import java.util.*;

// 신장 트리 - 하나의 그래프가 모든 노드를 포함하면서
// 사이클이 존재하지 않는 부분 그래프
// 크루스칼 알고리즘을 사용하여 최소 신장 트리를 만든다
public class Spanning_Tree {
    public static int v, e, result = 0;
    public static int[] parent;
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        for(int i = 1; i <= v; i++) parent[i] = i;

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(c, a, b));
        }

        Collections.sort(edges);

        for(int i = 0; i < edges.size(); i++){
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            if(find_parent(a) != find_parent(b)){
                union(a, b);
                result += cost;
            }
        }

        System.out.println(result);
    }

    public static int find_parent(int x){
        if(parent[x] == x) return x;
        return parent[x] = find_parent(parent[x]);
    }

    public static void union(int a, int b){
        a = find_parent(a);
        b = find_parent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
}

class Edge implements Comparable<Edge>{
    private int distance;
    private int nodeA;
    private int nodeB;

    Edge(int distance, int nodeA, int nodeB){
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance(){
        return this.distance;
    }

    public int getNodeA(){
        return this.nodeA;
    }

    public int getNodeB(){
        return this.nodeB;
    }

    @Override
    public int compareTo(Edge other){
        if(this.distance < other.distance) return -1;
        else return 1;
    }
}
