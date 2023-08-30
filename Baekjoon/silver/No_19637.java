package Baekjoon.silver;
import java.io.*;
import java.util.*;

// IF문 좀 대신 써줘 - 실버 3
public class No_19637 {
    static TreeMap<Integer, String> medal = new TreeMap<>();
    static int n, m;
    static int[] score_list;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        score_list = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            if(!medal.containsKey(score)){
                medal.put(score, name);
            }
            score_list[i] = score;
        }
        Arrays.sort(score_list);

        for(int i = 0; i < m; i++){
            int value = Integer.parseInt(br.readLine());
            sb.append(binary_search(0, n - 1, value)).append("\n");
        }

        System.out.println(sb);
    }

    static String binary_search(int start, int end, int target){
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;

            if(score_list[mid] == target){
                break;
            }
            else if(score_list[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        // System.out.println("target: " + target + ", mid: " + score_list[mid]);
        if(target <= score_list[mid]){
            return medal.get(score_list[mid]);
        }
        else{
            return medal.get(score_list[mid + 1]);
        }
    }
}
