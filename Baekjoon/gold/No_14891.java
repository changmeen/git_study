package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 톱니바퀴 - 골드 5
public class No_14891 {

    static int K;
    static int[][] gear = new int[5][9];
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 1; i <= 4; i++){
            String[] str = br.readLine().split("");
            for(int j = 1; j <= 8; j++){
                // 각 톱니바퀴의 톱에 S극인지 N극인지 입력
                // N극은 0 S극은 1이다.
                gear[i][j] = Integer.parseInt(str[j - 1]);
            }
        }

        K = Integer.parseInt(br.readLine());
        for(int k = 0; k < K; k++){
            st = new StringTokenizer(br.readLine(), " ");
            // num은 어떤 톱니바퀴를 돌릴 것인지 dir은 어느 방향을 돌릴 것인지 결정
            // 1은 시계방향 -1은 반시계방향이다.
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            gearOperation(num, dir);
            // for(int i = 1; i <= 4; i++){
            //     for(int j = 1; j <= 8; j++){
            //         System.out.print(gear[i][j]);
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }

        int res = 0;
        for(int i = 1; i <= 4; i++){
            // 각 톱니바퀴의 12시 방향이 N극이면 0점
            if(gear[i][1] == 0) res += 0;

            // 각 톱니바퀴의 12시 방향이 S극이면 톱니바퀴의 번호에 따라 점수 부여
            else{
                switch(i){
                    case 1:
                    res += 1;
                    break;

                    case 2:
                    res += 2;
                    break;

                    case 3:
                    res += 4;
                    break;

                    case 4:
                    res += 8;
                    break;
                }
            }
        }
        System.out.println(res);
    }

    static void gearOperation(int num, int dir){
        leftSide(num - 1, -dir);
        rightSide(num + 1, -dir);
        rotation(num, dir);
    }

    static void leftSide(int num, int dir){
        if(num < 1) return;
        if(gear[num][3] == gear[num + 1][7]) return;
        leftSide(num - 1, -dir);
        rotation(num, dir);
    }

    static void rightSide(int num, int dir){
        if(num > 4) return;
        if(gear[num][7] == gear[num - 1][3]) return;
        rightSide(num + 1, -dir);
        rotation(num, dir);
    }

    static void rotation(int num, int dir){
        if(dir == 1){
            int temp = gear[num][8];
            for(int i = 8; i > 1; i--){
                gear[num][i] = gear[num][i - 1];
            }
            gear[num][1] = temp;
        }
        else{
            int temp = gear[num][1];
            for(int i = 1; i < 8; i++){
                gear[num][i] = gear[num][i + 1];
            }
            gear[num][8] = temp;
        }
    }
}
