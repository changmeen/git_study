package Baekjoon.silver;
import java.io.*;
import java.util.*;

public class No_8979 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][3];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int num = Integer.parseInt(st.nextToken());

            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            map[num][0] = gold;
            map[num][1] = silver;
            map[num][2] = bronze;
        }

        int rank = 1;
        for(int i = 1; i <= n; i++){
            if(i == k) continue;

            if(map[i][0] > map[k][0]) rank++;
            else if(map[i][0] == map[k][0]){
                if(map[i][1] > map[k][1]) rank++;
                else if(map[i][1] == map[k][1]){
                    if(map[i][2] > map[k][2]) rank++;
                }
            }
        }

        System.out.println(rank);
    }
}
