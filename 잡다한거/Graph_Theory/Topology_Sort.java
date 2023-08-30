package 잡다한거.Graph_Theory;
import java.io.*;
import java.util.*;

// 위상 정렬 - 사이클이 없는 방향 그래프의 모든 노드를
// 방향성에 거스르지 않도록 순서대로 나열하는 것
public class Topology_Sort {
    public static int v, e;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        indegree = new int[v + 1];
        for(int i = 0; i <= v; i++) graph.add(new ArrayList<Integer>());

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            graph.get(nodeA).add(nodeB);

            indegree[nodeB]++;
        }

        topology_sort();
    }

    // 위상 정렬 함수
    public static void topology_sort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= v; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            result.add(now);

            for(int i = 0; i < graph.get(now).size(); i++){
                indegree[graph.get(now).get(i)]--;

                if(indegree[graph.get(now).get(i)] == 0){
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }
}
