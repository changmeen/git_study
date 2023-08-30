package Baekjoon.bronze;
import java.io.*;

// 이진수 연산 - 브론즈 2
public class No_12813 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String A = br.readLine();
        String B= br.readLine();

        // A & B
        for(int i = 0; i < A.length(); i++){
            char a = A.charAt(i);
            char b = B.charAt(i);

            if(a == '1' && b == '1') sb.append('1');
            else sb.append('0');
        }
        sb.append("\n");

        // A | B
        for(int i = 0; i < A.length(); i++){
            char a = A.charAt(i);
            char b = B.charAt(i);

            if(a == '1' || b == '1') sb.append('1');
            else sb.append('0');
        }
        sb.append("\n");

        // A ^ B
        for(int i = 0; i < A.length(); i++){
            char a = A.charAt(i);
            char b = B.charAt(i);

            if(a == '1' && b == '0') sb.append('1');
            else if(a == '0' && b == '1') sb.append('1');
            else sb.append('0');
        }
        sb.append("\n");

        // ~A
        for(int i = 0; i < A.length(); i++){
            char a = A.charAt(i);

            if(a == '1') sb.append("0");
            else sb.append("1");
        }
        sb.append("\n");

        // ~A
        for(int i = 0; i < A.length(); i++){
            char b = B.charAt(i);

            if(b == '1') sb.append("0");
            else sb.append("1");
        }
        sb.append("\n");

        System.out.println(sb);
    }
}
