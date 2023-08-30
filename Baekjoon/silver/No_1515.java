package Baekjoon.silver;
import java.io.*;

// 수 이어 쓰기 - 실버 3
public class No_1515 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int pos = 0;
        int idx = 1;
        while(pos < s.length()){
            char[] arr = Integer.toString(idx++).toCharArray();
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == s.charAt(pos)) pos++;
                if(pos >= s.length()) break;
            }
        }

        System.out.println(idx - 1);
    }
}
