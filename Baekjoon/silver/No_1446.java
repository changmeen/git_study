package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 지름길 - 실버1
public class No_1446 {

    static HashMap<Integer, ArrayList<int[]>> hm = new HashMap<>();
    static int N, D;
    static int dp[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if(end > D) continue;
            if(end - start < dist) continue;

            if(!hm.containsKey(start)){
                hm.put(start, new ArrayList<int[]>());
                hm.get(start).add(new int[] {end, dist});
            }else{
                for(int j = 0; j < hm.get(start).size(); j++){
                    int one_end = hm.get(start).get(j)[0];
                    int two_end = end;

                    if(one_end == two_end){
                        int one_dist = hm.get(start).get(j)[1];
                        int two_dist = dist;

                        if(one_dist > two_dist){
                            hm.get(start).set(j, new int[] {end, dist});
                        }
                    }

                    else hm.get(start).add(new int[] {end, dist});
                }
            }
        }

        solution();
        // for(int i = 0; i <= D; i++){
        //     System.out.println(i + " " + dp[i]);
        // }
        System.out.println(dp[D]);
    }

    static void solution(){
        dp[0] = 0;
        for(int i = 0; i < D; i++){
            if(hm.containsKey(i)){
                for(int j = 0; j < hm.get(i).size(); j++){
                    dp[hm.get(i).get(j)[0]] = Math.min(dp[hm.get(i).get(j)[0]], dp[i] + hm.get(i).get(j)[1]);
                }
                // dp[hm.get(i)[0]] = Math.min(dp[hm.get(i)[0]], dp[i] + hm.get(i)[1]);
            }
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
        }
    }
}
