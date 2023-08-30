package 잡다한거.DFS_BFS;
import java.util.*;
import java.io.*;

public class DFS_Graph {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws IOException{

        // 그래프 초기화
        for(int i = 0; i < 9; i++){
            graph.add(new ArrayList<Integer>());
        }

        // 1번 노드와 연결된 노드들 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 2번 노드와 연결된 노드들 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 3번 노드와 연결된 노드들 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 4번 노드와 연결된 노드들 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        // 5번 노드와 연결된 노드들 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        // 6번 노드와 연결된 노드들 정보 저장 
        graph.get(6).add(7);
        
        // 7번 노드와 연결된 노드들 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        // 8번 노드와 연결된 노드들 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);
    }

    public static void dfs(int x){
        visited[x] = true;
        System.out.print(x + " ");
        
        for(int i = 0; i < graph.get(x).size(); i++){
            int node = graph.get(x).get(i);
            if(!visited[node]){
                dfs(node);
            }
        }
    }
}
