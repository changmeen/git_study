package Baekjoon.bronze;
import java.io.*;
import java.util.*;

// 검증수 - 브론즈5
public class No_2475 {

    int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int sum = 0;

        while(true){
            String str = st.nextToken();
            if(str.isEmpty() || str == null){
                break;
            }
            sum += Math.pow(Integer.parseInt(str), 2);
        }

        System.out.println(sum % 10);
    }
}