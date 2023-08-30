package Baekjoon.bronze;
import java.io.*;
import java.util.*;

// 그대로 출력하기 - 브론즈 5
public class No_11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] song = new int[9];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < 9; i++) song[i] = Integer.parseInt(st.nextToken());

        if(song[1] == 1){
            for(int i = 2; i < 8; i++){
                if(song[i] != i){
                    sb.append("mixed");
                    System.out.println(sb);
                    return;
                }
            }
            sb.append("ascending");
            System.out.println(sb);
            return;
        }

        else if(song[1] == 8){
            for(int i = 2; i < 8; i++){
                if(song[i] != 8 - i + 1){
                    sb.append("mixed");
                    System.out.println(sb);
                    return;
                }
            }
            sb.append("descending");
            System.out.println(sb);
            return;
        }

        else{
            sb.append("mixed");
            System.out.println(sb);
            return;
        }
    }
}
