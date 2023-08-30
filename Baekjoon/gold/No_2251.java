package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 물통 - 골드5
public class No_2251 {
    static int[] receiver = {0, 0, 1, 1, 2, 2};
    static int[] sender = {1, 2, 0, 2, 0, 1};
    static int[] list = new int[3];
    static boolean[][] visited;
    static TreeSet<Integer> ts = new TreeSet<>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        list[0] = Integer.parseInt(st.nextToken());
        list[1] = Integer.parseInt(st.nextToken());
        list[2] = Integer.parseInt(st.nextToken());

        visited = new boolean[list[2] + 1][list[2] + 1];

        bfs();
        Iterator<Integer> iter = ts.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
        
    }

    static void bfs(){
        Queue<AB> q = new LinkedList<AB>();
        q.offer(new AB(0, 0));
        visited[0][0] = true;
        ts.add(list[2]);

        while(!q.isEmpty()){
            AB p = q.poll();
            int a = p.a;
            int b = p.b;
            int c = list[2] - a - b;

            for(int i = 0; i < 6; i++){
                int[] nx = {a, b, c};
                nx[receiver[i]] += nx[sender[i]];
                nx[sender[i]] = 0;

                if(nx[receiver[i]] > list[receiver[i]]){
                    nx[sender[i]] = nx[receiver[i]] - list[receiver[i]];
                    nx[receiver[i]] = list[receiver[i]];
                }
                if(!visited[nx[0]][nx[1]]){
                    q.offer(new AB(nx[0], nx[1]));
                    visited[nx[0]][nx[1]] = true;
                    if(nx[0] == 0){
                        if(!ts.contains(nx[2])) ts.add(nx[2]);
                    }
                }
            }
        }
    }
}

class AB{
    int a;
    int b;

    AB(int a, int b){
        this.a = a;
        this.b = b;
    }
}