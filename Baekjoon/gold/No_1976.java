package Baekjoon.gold;

import java.io.*;
import java.util.*;

// 여행 가자 - 골드4
public class No_1976 {
   static int[][] map;
   static int N,M;
   static boolean[] visited;
   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      M = Integer.parseInt(br.readLine());
      StringTokenizer st;
      map = new int[N+1][N+1];
      visited= new boolean[M+1];
      
      for(int i=1; i<=N; i++) {
         st = new StringTokenizer(br.readLine());
         for(int j=1; j<=N; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      String[] str = br.readLine().split(" ");
      path(Integer.parseInt(str[0]));
      
      boolean flag = true;
      for(int i=0; i<M; i++) {
         if(!visited[Integer.parseInt(str[i])]) {
            flag = false;
            break;
         }
      }
      if(flag) System.out.println("YES");
      else System.out.println("NO");
   }
   public static void path(int start) {
      visited[start] = true;
      for(int i=1; i<=N; i++) {
         if(map[start][i] == 1 && !visited[i]) {
            path(i);
         }
      }
   }

}

// package Baekjoon;
// import java.io.*;
// import java.util.*;

// public class No_1976 {

//     static int n, m;
//     static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
//     static LinkedList<Integer> arr = new LinkedList<>();
//     static boolean[] visited;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;

//         n = Integer.parseInt(br.readLine());
//         m = Integer.parseInt(br.readLine());

//         for(int i = 0; i <= n; i++) list.add(new ArrayList<Integer>());
//         visited = new boolean[n + 1];

//         for(int i = 1; i <= n; i++){
//             st = new StringTokenizer(br.readLine(), " ");
//             for(int j = 1; j <= n; j++){
//                 if(Integer.parseInt(st.nextToken()) == 1){
//                     list.get(i).add(j);
//                     list.get(j).add(i);
//                 }
//             }
//         }

//         st = new StringTokenizer(br.readLine(), " ");
//         for(int i = 0; i < m; i++){
//             arr.add(Integer.parseInt(st.nextToken()));
//         }

//         bfs(arr.get(0));

//         boolean isPossible = true;
//         for(int i = 0; i < m; i++){
//             if(visited[arr.get(i)] == false){
//                 isPossible = false;
//                 System.out.println("NO");
//                 break;
//             }
//         }

//         if(isPossible){
//             System.out.println("YES");
//         }
//     }

//     static void bfs(int city){
//         Queue<Integer> q = new LinkedList<Integer>();
//         visited[city] = true;
//         q.offer(city);

//         while(!q.isEmpty()){
//             city = q.poll();

//             for(int i = 0; i < list.get(city).size(); i++){
//                 if(!visited[list.get(city).get(i)]){
//                     q.offer(list.get(city).get(i));
//                     visited[list.get(city).get(i)] = true;
//                 }
//             }
//         }
//     }
// }