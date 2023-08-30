package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 점프 점프 - 실버 2
public class No_11060 {

    static int n;
    static int[] map;
    static int[] cnt;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1];
        cnt = new int[n + 1];
        Arrays.fill(cnt, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) map[i] = Integer.parseInt(st.nextToken());

        bfs(1);

        if(cnt[n] == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(cnt[n]);
    }

    static void bfs(int now){
        cnt[now] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(now);

        while(!q.isEmpty()){
            now = q.poll();
            int size = map[now];

            for(int i = 1; i <= size; i++){
                if(now + i <= n){
                    if(cnt[now] + 1 < cnt[now + i]){
                        cnt[now + i] = cnt[now] + 1;
                        q.offer(now + i);
                    }
                }
            }
        }
    }
}
