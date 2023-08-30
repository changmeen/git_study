package Baekjoon.silver;
import java.io.*;

// 쿠키의 신체 측정 - 실버 4
public class No_20125 {
    static String[][] map;
    static int n;
    static int body_x = -1, body_y = -1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        
        map = new String[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            String[] str = br.readLine().split("");
            for(int j = 1; j <= n; j++){
                map[i][j] = str[j - 1];
            }
        }
        int heart_x = -1, heart_y = -1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(map[i][j].equals("*") && heart_y == -1){
                    heart_y = j;
                }
                if(map[j][i].equals("*") && heart_x == -1){
                    heart_x = j;
                }
                if(heart_x != -1 && heart_y != -1) break;
            }
        }

        System.out.println(heart_x + " " + heart_y);
        System.out.print(left_arm(heart_x, heart_y) + " ");
        System.out.print(right_arm(heart_x, heart_y) + " ");
        System.out.print(body_length(heart_x, heart_y) + " ");
        System.out.print(leg_length(body_x, heart_y - 1) + " ");
        System.out.print(leg_length(body_x, heart_y + 1));
    }

    static int left_arm(int x, int y){
        int cnt = 0;
        while(true){
            y--;
            if(y < 1) break;
            if(map[x][y].equals("*")) cnt++;
            else break;
        }
        return cnt;
    }

    static int right_arm(int x, int y){
        int cnt = 0;
        while(true){
            y++;
            if(y > n) break;
            if(map[x][y].equals("*")) cnt++;
            else break;
        }
        return cnt;
    }

    static int body_length(int x, int y){
        int cnt = 0;
        while(true){
            x++;
            if(x > n) break;
            if(map[x][y].equals("*")) cnt++;
            else{
                body_x = x - 1;
                body_y = y;
                break;
            }
        }
        return cnt;
    }

    static int leg_length(int x, int y){
        int cnt = 0;
        while(true){
            x++;
            if(x > n) break;
            if(map[x][y].equals("*")) cnt++;
            else break;
        }
        return cnt;
    }
}
