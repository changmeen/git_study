package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 가장 가까운 공통 조상 - 골드 4
public class No_3584 {
    
    // 각 노드들의 부모 노드를 담을 parent 배열
    static int[] parent;
    static int n, root;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int t = 0; t < test_case; t++){
            n = Integer.parseInt(br.readLine());
            parent = new int[n + 1];

            for(int i = 0; i < n - 1; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                parent[B] = A;
            }

            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // 처음부터 둘이 같은 값일 경우
            if(node1 == node2){
                System.out.println(node1);
                continue;
            }

            
            int node1_depth = 0, node2_depth = 0;
            root = getRoot();
            // 둘 중 하나라도 루트노드가 아닐 경우에만 각자 depth를 구해줌
            if(node1 != root && node2 != root){
                node1_depth = depth_cnt(node1, 0);
                node2_depth = depth_cnt(node2, 0);
            }
            // 둘 중 하나가 루트 노드 인 경우 최소 공통 조상은 반드시 루트 노드다
            else if(node1 == root || node2 == root){
                System.out.println(root);
                continue;
            }

            // 최소 공통 조상 찾을 때까지 while문 반복
            // depth를 낮춰가며(트리 위로 올라가면서) 서로 같은지 비교
            while(node1 != node2){
                if(node1_depth > node2_depth){
                    node1_depth--;
                    node1 = parent[node1];
                }
                else if(node1_depth < node2_depth){
                    node2_depth--;
                    node2 = parent[node2];
                }
                else if(node1_depth == node2_depth){
                    node1_depth--;
                    node2_depth--;
                    node1 = parent[node1];
                    node2 = parent[node2];
                }
            }
            System.out.println(node1);
        }
    }

    static int getRoot(){
        int root = -1;
        for(int i = 1; i <= n; i++){
            if(parent[i] == 0) root = i;
        }
        return root;
    }

    static int depth_cnt(int node, int cnt){
        if(parent[node] == root){
            return cnt + 1;
        }
        else return depth_cnt(parent[node], cnt + 1);
    }
}