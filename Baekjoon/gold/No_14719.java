package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 빗물 - 골드 5
public class No_14719 {
    static int H, W;
    static int[][] map;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");

        map = new int[H + 1][W + 1];
        for(int i = 1; i <= W; i++){
            int num = Integer.parseInt(st.nextToken());
            for(int j = H; j > H - num; j--){
                map[j][i] = 1;
            }
        }

        for(int i = H; i >= 1; i--){
            for(int j = 1; j < W; j++){
                if(map[i][j] == 1 && map[i][j + 1] == 0){
                    paint(i, j + 1);
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i <= H; i++){
            for(int j = 1; j <= W; j++){
                if(map[i][j] == -1) cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void paint(int X, int Y){
        Queue<box> q = new LinkedList<>();
        q.offer(new box(X, Y));
        map[X][Y] = -1;
        int ny = -1;

        while(!q.isEmpty()){
            box p = q.poll();
            ny = p.y + 1;
            if(ny <= W){
                if(map[p.x][ny] == 0){
                    map[p.x][ny] = -1;
                    q.offer(new box(p.x, ny));
                }
            }
        }

        if(map[X][W] == -1){
            ny = W;
            while(map[X][ny] != 1){
                map[X][ny] = 0;
                ny--;
            }
        }
    }
}

class box{
    int x, y;

    box(int x, int y){
        this.x = x;
        this.y = y;
    }
}