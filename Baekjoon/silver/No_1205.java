package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 등수 구하기 - 실버 4
public class No_1205 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int point = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if(n == 0){
            System.out.println("1");
            return;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int rank = -1;
        int bf = -1;
        int bfidx = -1;

        for(int i = 1; rank == -1 && i <= n; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(cur < point){
                rank = bf == point ? bfidx : i;
            }
            if(bf != cur){
                bf = cur;
                bfidx = i;
            }
        }

        if(rank == -1 && n + 1 <= p){
            rank = point == bf ? bfidx : n + 1;
        }

        System.out.println(rank <= p ? rank : -1);
    }
}
