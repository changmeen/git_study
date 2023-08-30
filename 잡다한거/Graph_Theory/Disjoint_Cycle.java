package 잡다한거.Graph_Theory;
import java.io.*;
import java.util.*;

// 서로소 집합을 활용한 사이클 판별
public class Disjoint_Cycle {

    public static int v, e;
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parent = new int[v + 1];
        for(int i = 1; i <= v; i++) parent[i] = i;

        boolean Cycle = false;

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find_parent(a) == find_parent(b)){
                Cycle = true;
                break;
            }
            else union(a, b);
        }

        if(Cycle) System.out.println("사이클이 발생했습니다.");
        else System.out.println("사이클이 발생하지 않았습니다.");
    }

    public static int find_parent(int num){
        if(parent[num] != num) {
            parent[num] = find_parent(parent[num]);
        }
        return parent[num];
    }

    public static void union(int a, int b){
        a = find_parent(a);
        b = find_parent(b);

        if(a > b) parent[a] = b;
        else parent[b] = a;
    }
}
