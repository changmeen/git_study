package Baekjoon.silver;
import java.io.*;

// 비슷한 단어 - 실버 3
public class No_2607 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int res = 0;

        String std = br.readLine();
        int len = std.length();
        int[] alphabet = new int[26];
        for(int i = 0; i < len; i++){
            alphabet[std.charAt(i) - 'A']++;
        }

        for(int n = 1; n < num; n++){
            int[] temp = alphabet.clone();
            String cmp = br.readLine();
            int cnt = 0;

            for(int i = 0; i < cmp.length(); i++){
                if(temp[cmp.charAt(i) - 'A'] > 0){
                    cnt++;
                    temp[cmp.charAt(i) - 'A']--;
                }
            }

            if(std.length() - 1 == cmp.length()){
                if(cnt == cmp.length()) res++;
            }
            else if(std.length() + 1 == cmp.length()){
                if(cnt == std.length()) res++;
            }
            else if(std.length() == cmp.length()){
                if(cnt == std.length()) res++;
                else if(cnt == std.length() - 1) res++;
            }
        }

        System.out.println(res);
    }
}
