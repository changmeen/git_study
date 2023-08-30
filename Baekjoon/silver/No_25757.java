package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 임스와 함께하는 미니게임 - 실버 5
public class No_25757 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashSet<String> hs = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());
        int game = 0;
        switch(st.nextToken()){
            case "Y":
            game = 1;
            break;

            case "F":
            game = 2;
            break;

            case "O":
            game = 3;
            break;
        }

        for(int i = 0; i < n; i++){
            hs.add(br.readLine());
        }

        System.out.println(hs.size() / game);
    }
}
