package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 주사위 굴리기 - 골드 4
public class No_14499 {
    static int N, M, x, y, K;
    static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
    static int[][] map;
    static int[] dice = new int[7];

    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            move(Integer.parseInt(st.nextToken()));
        }
    }

    static void move(int dir){
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // 주사위의 이동한 장소가 map의 내부일 경우
        if(nx >= 0 && ny >= 0 && nx < N && ny < M){
            x = nx;
            y = ny;
            int temp = dice[3];
            switch(dir){

                // 동쪽
                case 1:
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
                break;

                // 서쪽
                case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
                break;

                // 북쪽
                case 3:
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
                break;

                // 남쪽
                case 4:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = temp;
            }
            System.out.println(dice[6]);

            if(map[nx][ny] == 0){
                map[nx][ny] = dice[3];
            }else{
                dice[3] = map[nx][ny];
                map[nx][ny] = 0;
            }
        }
        // 주사위의 이동한 장소가 map을 나갈 경우
        else return;
    }
}