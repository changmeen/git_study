package 잡다한거.Graph_Theory;
import java.io.*;
import java.util.*;

// 서로소 집합 자료구조(Union Find 자료구조) 개선한 코드
// 노드들의 부모를 다 루트 노드로 하게 함
public class Disjoint_Sets2 {

    public static int v, e;
    public static int[] parent;
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
            union(a, b);
        }

        System.out.print("각 원소가 속한 집합: ");
        for(int i = 1; i <= v; i++){
            System.out.print(find_parent(i) + " ");
        }

        System.out.println();

        System.out.print("부모 테이블: ");
        for(int i = 1; i <= v; i++){
            System.out.print(parent[i] + " ");
        }
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
