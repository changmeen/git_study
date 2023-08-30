package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 결혼식 - 실버 2
public class No_5567 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static HashSet<Integer> hs = new HashSet<>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<Integer>());
        }
        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 0; i < list.get(1).size(); i++){
            hs.add(list.get(1).get(i));
            friend_friend(list.get(1).get(i));
        }

        System.out.println(hs.size());
    }

    static void friend_friend(int num){
        for(int i = 0; i < list.get(num).size(); i++){
            if(list.get(num).get(i) != 1) hs.add(list.get(num).get(i));
        }
    }
}
