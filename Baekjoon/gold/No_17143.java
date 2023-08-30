package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 낚시왕 - 골드 1
public class No_17143 {

    static int R, C, M;
    static int r, c, s, d, z;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static Shark[][] shark_map;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        shark_map = new Shark[R + 1][C + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            shark_map[r][c] = new Shark(s, d, z);
        }

        int res = 0;
        for(int i = 1; i <= C; i++) {
        	for(int j = 1; j <= R; j++) {
        		if(shark_map[j][i] != null) {
        			res += shark_map[j][i].z;
        			shark_map[j][i] = null;
        			break;
        		}
        	}
        	move();
        }

        System.out.println(res);
    }

    static void move(){
        Shark[][] temp = new Shark[R + 1][C + 1];
        for(int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                if(shark_map[i][j] != null){
                    Shark now = shark_map[i][j];
                    int r = 0, c = 0, power = now.s;
                    int d, cnt;
                    
                    if(now.s == 0) {
                    	if(temp[i][j] != null) {
                    		temp[i][j] = temp[i][j].z > now.z ? temp[i][j] : new Shark(now.s, now.d, now.z);
                    	}
                    }
                    
                    switch(now.d){
                        case 1:
                        d = now.d;
                        if(power < (i - 1)) {
                        	r = i - power;
                        	c = j;
                        }else {
                        	power -= (i - 1);
                        	d++;

                        	cnt = power / (R - 1);
                        	if(cnt % 2 == 1) d--;

                        	if(d == 1) r = R - (power % (R - 1));
                        	else r = power % (R - 1) + 1;
                        	c = j;
                        }

                        if(temp[r][c] == null){
                            temp[r][c] = new Shark(now.s, d, now.z);
                        }else{
                            temp[r][c] = temp[r][c].z > now.z ? temp[r][c] : new Shark(now.s, d, now.z);
                        }
                        break;

                        case 2:
                        d = now.d;
                        if(power < (R - i)) {
                        	r = i + power;
                        	c = j;
                        }else {
                        	power -= (R - i);
                        	d--;

                        	cnt = power / (R - 1);
                        	if(cnt % 2 == 1) d++;

                        	if(d == 1) r = R - (power % (R - 1));
                        	else r = power % (R - 1) + 1;
                        	c = j;
                        }

                        if(temp[r][c] == null){
                            temp[r][c] = new Shark(now.s, d, now.z);
                        }else{
                            temp[r][c] = temp[r][c].z > now.z ? temp[r][c] : new Shark(now.s, d, now.z);
                        }
                        break;

                        case 3:
                        d = now.d;
                        if(power < (C - j)) {
                        	r = i;
                        	c = j + power;
                        }
                        else {
                        	power -= (C - j);
                        	d++;

                        	cnt = power / (C - 1);
                        	if(cnt % 2 == 1) d--;

                        	r = i;
                        	if(d == 3) c = (power % (C - 1) + 1);
                        	else c = C - (power % (C - 1));
                        }

                        if(temp[r][c] == null){
                            temp[r][c] = new Shark(now.s, d, now.z);
                        }else{
                            temp[r][c] = temp[r][c].z > now.z ? temp[r][c] : new Shark(now.s, d, now.z);
                        }
                        break;

                        case 4:
                        d = now.d;
                        if(power < (j - 1)) {
                        	r = i;
                        	c = j - power;
                        }else {
                        	power -= (j - 1);
                        	d--;

                        	cnt = power / (C - 1);
                        	if(cnt % 2 == 1) d++;

                        	r = i;
                        	if(d == 3) c = (power % (C - 1) + 1);
                        	else c = C - (power % (C - 1));
                        }

                        if(temp[r][c] == null){
                            temp[r][c] = new Shark(now.s, d, now.z);
                        }else{
                            temp[r][c] = temp[r][c].z > now.z ? temp[r][c] : new Shark(now.s, d, now.z);
                        }
                        break;
                    }
                }
            }
        }

        shark_map = temp.clone();
    }
}

class Shark{
    int s, d, z;

    Shark(int s, int d, int z){
        this.s = s;
        this.d = d;
        this.z = z;
    }
}
