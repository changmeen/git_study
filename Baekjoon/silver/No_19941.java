package Baekjoon.silver;
import java.io.*;
import java.util.*;

public class No_19941 {
    static int N, K;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String[] list = br.readLine().split("");

        solution(0, 0, list);
    }

    static void solution(int idx, int cnt, String[] list){
        boolean check = false;
        if(idx == N) {
            System.out.println(cnt);
            return;
        }
        if(list[idx].equals("H") || list[idx].equals("X")) solution(idx + 1, cnt, list);
        else if(list[idx].equals("P")) {
            for(int i = idx - K; i <= idx + K; i++){
                if(i < 0) continue;
                else if(i >= N) break;
                else if(i == idx) continue;
                if(list[i].equals("H")){
                    check = true;
                    list[i] = "X";
                    solution(idx + 1, cnt + 1, list);
                    break;
                }
            }
            if(!check) solution(idx + 1, cnt, list);
        }
    }
}
