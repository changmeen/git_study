package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 감시 - 골드 4
public class No_15683 {
    static int N, M, cnt;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static cctv[] tv = new cctv[9];
    static int res = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        // cnt는 cctv의 개수를 세기 위한 것
        cnt = 0;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6) {
                    tv[++cnt] = new cctv(map[i][j], i, j);
                }
            }
        }
        dfs(1, map);
        System.out.println(res);
    }

    static void dfs(int idx, int[][] temp_map){
        int[][] temp = new int[N + 1][M + 1];
        if(idx == (cnt + 1)){
            int zero_cnt = 0;
            // System.out.println();
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= M; j++){
                    // System.out.print(temp_map[i][j] + " ");
                    if(temp_map[i][j] == 0) zero_cnt++;
                }
                // System.out.println();
            }

            res = Math.min(res, zero_cnt);
            return;
        }

        switch(tv[idx].num){
            case 1:
            for(int r = 0; r < 4; r++){
                int x = tv[idx].x;
                int y = tv[idx].y;
                for(int i = 1; i <= N; i++){
                    for(int j = 1; j <= M; j++){
                        temp[i][j] = temp_map[i][j];
                    }
                }

                while(true){
                    x = x + dx[r];
                    y = y + dy[r];

                    if(x >= 1 && y >= 1 && x <= N && y <= M){
                        if(temp_map[x][y] >= 1 && temp_map[x][y] <= 5) continue;
                        else if(temp_map[x][y] <= 0){
                            temp[x][y] = -1;
                        }
                        else{
                            break;
                        }
                    }
                    else break;
                }
                dfs(idx + 1, temp);
            }
            break;

            case 2:
            for(int r = 0; r < 2; r++){
                int x1 = tv[idx].x;
                int y1 = tv[idx].y;
                int x2 = tv[idx].x;
                int y2 = tv[idx].y;

                for(int i = 1; i <= N; i++){
                    for(int j = 1; j <= M; j++){
                        temp[i][j] = temp_map[i][j];
                    }
                }

                while(true){
                    x1 = x1 + dx[r];
                    y1 = y1 + dy[r];

                    if(x1 >= 1 && y1 >= 1 && x1 <= N && y1 <= M){
                        if(temp_map[x1][y1] >= 1 && temp_map[x1][y1] <= 5) continue;
                        else if(temp_map[x1][y1] <= 0){
                            temp[x1][y1] = -1;
                        }
                        else{
                            break;
                        }
                    }
                    else break;
                }

                while(true){
                    x2 = x2 + dx[(r + 2) % 4];
                    y2 = y2 + dy[(r + 2) % 4];

                    if(x2 >= 1 && y2 >= 1 && x2 <= N && y2 <= M){
                        if(temp_map[x2][y2] >= 1 && temp_map[x2][y2] <= 5) continue;
                        else if(temp_map[x2][y2] <= 0){
                            temp[x2][y2] = -1;
                        }
                        else{
                            break;
                        }
                    }
                    else break;
                }

                dfs(idx + 1, temp);
            }
            break;

            case 3:
            for(int r = 0; r < 4; r++){
                int x1 = tv[idx].x;
                int y1 = tv[idx].y;
                int x2 = tv[idx].x;
                int y2 = tv[idx].y;

                for(int i = 1; i <= N; i++){
                    for(int j = 1; j <= M; j++){
                        temp[i][j] = temp_map[i][j];
                    }
                }

                while(true){
                    x1 = x1 + dx[r];
                    y1 = y1 + dy[r];

                    if(x1 >= 1 && y1 >= 1 && x1 <= N && y1 <= M){
                        if(temp_map[x1][y1] >= 1 && temp_map[x1][y1] <= 5) continue;
                        else if(temp_map[x1][y1] <= 0){
                            temp[x1][y1] = -1;
                        }
                        else{
                            break;
                        }
                    }
                    else break;
                }

                while(true){
                    x2 = x2 + dx[(r + 1) % 4];
                    y2 = y2 + dy[(r + 1) % 4];

                    if(x2 >= 1 && y2 >= 1 && x2 <= N && y2 <= M){
                        if(temp_map[x2][y2] >= 1 && temp_map[x2][y2] <= 5) continue;
                        else if(temp_map[x2][y2] <= 0){
                            temp[x2][y2] = -1;
                        }
                        else{
                            break;
                        }
                    }
                    else break;
                }

                dfs(idx + 1, temp);
            }
            break;

            case 4:
            for(int r = 0; r < 4; r++){
                int x1 = tv[idx].x;
                int y1 = tv[idx].y;
                int x2 = tv[idx].x;
                int y2 = tv[idx].y;
                int x3 = tv[idx].x;
                int y3 = tv[idx].y;

                for(int i = 1; i <= N; i++){
                    for(int j = 1; j <= M; j++){
                        temp[i][j] = temp_map[i][j];
                    }
                }

                while(true){
                    x1 = x1 + dx[r];
                    y1 = y1 + dy[r];

                    if(x1 >= 1 && y1 >= 1 && x1 <= N && y1 <= M){
                        if(temp_map[x1][y1] >= 1 && temp_map[x1][y1] <= 5) continue;
                        else if(temp_map[x1][y1] <= 0){
                            temp[x1][y1] = -1;
                        }
                        else{
                            break;
                        }
                    }
                    else break;
                }

                while(true){
                    x2 = x2 + dx[(r + 1) % 4];
                    y2 = y2 + dy[(r + 1) % 4];

                    if(x2 >= 1 && y2 >= 1 && x2 <= N && y2 <= M){
                        if(temp_map[x2][y2] >= 1 && temp_map[x2][y2] <= 5) continue;
                        else if(temp_map[x2][y2] <= 0){
                            temp[x2][y2] = -1;
                        }
                        else{
                            break;
                        }
                    }
                    else break;
                }

                while(true){
                    x3 = x3 + dx[(r + 2) % 4];
                    y3 = y3 + dy[(r + 2) % 4];

                    if(x3 >= 1 && y3 >= 1 && x3 <= N && y3 <= M){
                        if(temp_map[x3][y3] >= 1 && temp_map[x3][y3] <= 5) continue;
                        if(temp_map[x3][y3] <= 0){
                            temp[x3][y3] = -1;
                        }
                        else{
                            break;
                        }
                    }
                    else break;
                }

                dfs(idx + 1, temp);
            }
            break;

            case 5:
            int x1 = tv[idx].x;
            int y1 = tv[idx].y;
            int x2 = tv[idx].x;
            int y2 = tv[idx].y;
            int x3 = tv[idx].x;
            int y3 = tv[idx].y;
            int x4 = tv[idx].x;
            int y4 = tv[idx].y;

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= M; j++){
                    temp[i][j] = temp_map[i][j];
                }
            }

            while(true){
                x1 = x1 + dx[0];
                y1 = y1 + dy[0];

                if(x1 >= 1 && y1 >= 1 && x1 <= N && y1 <= M){
                    if(temp_map[x1][y1] >= 1 && temp_map[x1][y1] <= 5) continue;
                    else if(temp_map[x1][y1] <= 0){
                        temp[x1][y1] = -1;
                    }
                    else{
                        break;
                    }
                }
                else break;
            }

            while(true){
                x2 = x2 + dx[1];
                y2 = y2 + dy[1];

                if(x2 >= 1 && y2 >= 1 && x2 <= N && y2 <= M){
                    if(temp_map[x2][y2] >= 1 && temp_map[x2][y2] <= 5) continue;
                    else if(temp_map[x2][y2] <= 0){
                        temp[x2][y2] = -1;
                    }
                    else{
                        break;
                    }
                }
                else break;
            }

            while(true){
                x3 = x3 + dx[2];
                y3 = y3 + dy[2];

                if(x3 >= 1 && y3 >= 1 && x3 <= N && y3 <= M){
                    if(temp_map[x3][y3] >= 1 && temp_map[x3][y3] <= 5) continue;
                    else if(temp_map[x3][y3] <= 0){
                        temp[x3][y3] = -1;
                    }
                    else{
                        break;
                    }
                }
                else break;
            }

            while(true){
                x4 = x4 + dx[3];
                y4 = y4 + dy[3];

                if(x4 >= 1 && y4 >= 1 && x4 <= N && y4 <= M){
                    if(temp_map[x4][y4] >= 1 && temp_map[x4][y4] <= 5) continue;
                    else if(temp_map[x4][y4] <= 0){
                        temp[x4][y4] = -1;
                    }
                    else{
                        break;
                    }
                }
                else break;
            }

            dfs(idx + 1, temp);
        }
    }
}

class cctv{
    int num, x, y;

    cctv(int num, int x, int y){
        this.num = num;
        this.x = x;
        this.y = y;
    }
}