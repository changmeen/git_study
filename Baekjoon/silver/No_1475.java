package Baekjoon.silver;
import java.io.*;

// 방 번호 - 실버5
public class No_1475 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        int[] cnt = new int[10];

        for(int i = 0; i < str.length; i++){
            int num = Integer.parseInt(str[i]);
            cnt[num]++;
        }

        int max = 0;
        for(int i = 0; i < 10; i++){
            if(i == 6 || i == 9) continue;
            if(max < cnt[i]) max = cnt[i];
        }
        int six_nine = (cnt[6] + cnt[9] + 1) / 2;
        max = max > six_nine ? max : six_nine;

        System.out.println(max);
    }
}
