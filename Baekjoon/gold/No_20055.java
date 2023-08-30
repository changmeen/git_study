package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 컨베이어 벨트 위의 로봇 - 골드 5
public class No_20055 {

    static int N, K, max;
    static belt[] bel;
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        max = (2 * N);

        bel = new belt[max + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= max; i++){
            int left = Integer.parseInt(st.nextToken());
            bel[i] = new belt(i, left, false);
        }
        
        int res = 1;
        while(true) {
        	containerMove();
        	robotMove();
        	
        	int cnt = 0;
        	for(int i = 1; i <= max; i++) {
        		if(bel[i].left == 0) cnt++;
        	}
        	if(cnt >= K) break;
        	
        	res++;
//        	for(int i = 1; i <= max; i++){
//        		System.out.print(bel[i].getNum() + "|" + bel[i].left + "|" + bel[i].robot + " ");
//        	}
        }
        System.out.println(res);
    }

    static void containerMove(){
        belt temp = bel[max];
        for(int i = max; i >= 1; i--){
            bel[i] = bel[i - 1];
        }
        bel[1] = temp;
        if(bel[N].robot == true) bel[N].robot = false;
    }

    static void robotMove(){
        for(int i = N - 1; i >= 1; i--){
        	// 지금 보는 칸에 로봇이 있고 다음 칸의 내구도가 1이상이며 다음 칸에 로봇이 없을 경우
            if(bel[i].robot == true && bel[i + 1].left > 0 && bel[i + 1].robot == false){
                bel[i + 1].robot = true;
                bel[i + 1].left--;
                bel[i].robot = false;
                
            }
        }
        if(bel[N].robot == true) bel[N].robot = false;
        
        // 올리는 위치에 로봇이 없고 내구도가 1 이상일 경우 로봇을 올리고 내구도 1을 깎음
        if(bel[1].robot == false && bel[1].left > 0) {
        	bel[1].robot = true;
        	bel[1].left--;
        }
    }
}

class belt{
    int num;
    int left;
    boolean robot;

    belt(int num, int left, boolean robot){
        this.num = num;
        this.left = left;
        this.robot = robot;
    }
    
    int getNum() {
    	return this.num;
    }
}