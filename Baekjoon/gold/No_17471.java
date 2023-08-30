package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 게리맨더링 - 골드 4
public class No_17471 {

    static int n, min = Integer.MAX_VALUE;
    static boolean[] visited, selected;
    static int[] population;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        selected = new boolean[n];
        population = new int[n];
        for(int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            population[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());

            for(int j = 0; j < num; j++){
                graph.get(i).add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        divide(0);
        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }

    static void divide(int idx){
        if(idx == n){
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();

            for(int i = 0; i < n; i++){
                if(selected[i]) aList.add(i);
                else bList.add(i);
            }

            if(aList.size() == 0 || bList.size() == 0) return;

            if(check(aList) && check(bList)){
                getDiff();
            }
            return;
        }
        selected[idx] = true;
        divide(idx + 1);
        selected[idx] = false;
        divide(idx + 1);
    }

    static boolean check(List<Integer> list){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n];
        visited[list.get(0)] = true;
        q.offer(list.get(0));

        int cnt = 1;
        while(!q.isEmpty()){
            int p = q.poll();

            for(int i = 0; i < graph.get(p).size(); i++){
                int next = graph.get(p).get(i);
                if(list.contains(next) && !visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }

        if(cnt == list.size()) return true;
        else return false;
    }

    static void getDiff(){
        int pa = 0, pb = 0;
        for(int i = 0; i < n; i++){
            if(selected[i] == true) pa += population[i];
            else pb += population[i];
        }

        int diff = Math.abs(pa - pb);
        min = Math.min(min, diff);
    }
}
