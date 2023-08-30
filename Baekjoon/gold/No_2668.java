package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 숫자고르기 - 골드 5
public class No_2668 {

    static int n;
    static int[] num;
    static ArrayList<Integer> list;
    static boolean[] visited;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        num = new int[n + 1];
        for(int i = 1; i <= n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++){
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    static void dfs(int s, int e){
        if(visited[num[s]] == false) {
            visited[num[s]] = true;
            dfs(num[s], e);
            visited[num[s]] = false;
        }
        if(num[s] == e) list.add(e);
    }
}
