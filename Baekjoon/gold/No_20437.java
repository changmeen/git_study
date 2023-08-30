package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 문자열 게임 2 - 골드 5
public class No_20437 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        HashMap<String, ArrayList<Integer>> hm;

        for(int t = 0; t < T; t++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            hm = new HashMap<>();

            String[] str = br.readLine().split("");
            int k = Integer.parseInt(br.readLine());

            for(int i = 0; i < str.length; i++){
                if(!hm.containsKey(str[i])){
                    hm.put(str[i], new ArrayList<Integer>());
                    hm.get(str[i]).add(i);
                }else{
                    hm.get(str[i]).add(i);
                }
            }

            for(String key : hm.keySet()){
                if(hm.get(key).size() >= k){
                    for(int n = 0; n <= hm.get(key).size() - k; n++){
                        min = Math.min(min, (hm.get(key).get(n + k - 1)) - hm.get(key).get(n));
                        max = Math.max(max, (hm.get(key).get(n + k - 1)) - hm.get(key).get(n));
                    }
                }
            }

            if(min == Integer.MAX_VALUE){
                System.out.println("-1");
            }else{
                System.out.println((min + 1) + " " + (max + 1));
            }
        }
    }
}
