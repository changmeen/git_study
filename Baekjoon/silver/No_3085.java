package Baekjoon.silver;
import java.io.*;

// 사탕 게임 - 실버 2
class No_3085{

    static char[][] map;
    static int n, max = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++){
                char temp = map[i][j];
                map[i][j] = map[i][j + 1];
                map[i][j + 1] = temp;

                arrCheck();

                temp = map[i][j];
                map[i][j] = map[i][j + 1];
                map[i][j + 1] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++){
                char temp = map[j][i];
                map[j][i] = map[j + 1][i];
                map[j + 1][i] = temp;

                arrCheck();

                temp = map[j][i];
                map[j][i] = map[j + 1][i];
                map[j + 1][i] = temp;
            }
        }

        System.out.println(max);
    }

    static void arrCheck(){
        for(int i = 0; i < n; i++){
            int cnt = 1;
            for(int j = 0; j < n - 1; j++){
                if(map[i][j] == map[i][j + 1]) cnt++;
                else cnt = 1;

                max = Math.max(max, cnt);
            }
        }

        for(int i = 0; i < n; i++){
            int cnt = 1;
            for(int j = 0; j < n - 1; j++){
                if(map[j][i] == map[j + 1][i]) cnt++;
                else cnt = 1;

                max = Math.max(max, cnt);
            }
        }
    }
}