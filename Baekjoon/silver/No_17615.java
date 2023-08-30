package Baekjoon.silver;
import java.io.*;

// 볼 모으기 - 실버 1
public class No_17615 {
    static int N;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int cnt = Integer.MAX_VALUE;

        // 왼쪽으로 R을 모으는 경우
        int subCnt = 0;
        boolean sw = false;
        for(int i = 0; i < N; i++){
            if(sw && balls.charAt(i) == 'R'){
                subCnt++;
                continue;
            }

            if(balls.charAt(i) == 'B') sw = true;
        }
        cnt = Math.min(cnt, subCnt);

        // 왼쪽으로 B를 모으는 경우
        subCnt = 0;
        sw = false;
        for(int i = 0; i < N; i++){
            if(sw && balls.charAt(i) == 'B'){
                subCnt++;
                continue;
            }

            if(balls.charAt(i) == 'R') sw = true;
        }
        cnt = Math.min(cnt, subCnt);

        // 오른쪽으로 R을 모으는 경우
        subCnt = 0;
        sw = false;
        for(int i = N - 1; i >= 0; i--){
            if(sw && balls.charAt(i) == 'R'){
                subCnt++;
                continue;
            }

            if(balls.charAt(i) == 'B') sw = true;
        }
        cnt = Math.min(cnt, subCnt);

        // 오른쪽으로 B를 모으는 경우
        subCnt = 0;
        sw = false;
        for(int i = N - 1; i >= 0; i--){
            if(sw && balls.charAt(i) == 'B'){
                subCnt++;
                continue;
            }

            if(balls.charAt(i) == 'R') sw = true;
        }
        cnt = Math.min(cnt, subCnt);

        System.out.println(cnt);
    }
}
