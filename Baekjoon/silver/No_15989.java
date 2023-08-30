package Baekjoon.silver;
import java.io.*;

// 1, 2, 3 더하기 4 - 실버1
public class No_15989 {
    static int sum = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < test_case; t++){
            int n = Integer.parseInt(br.readLine());
            sum = 1;

            if(n >= 3){
                for(int i = 1; i <= (n / 3); i++){
                    divide_by_two(n - (i * 3));
                    sum++;
                }
            }

            if(n >= 2){
                for(int i = 1; i <= (n / 2); i++){
                    sum++;
                }
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }

    static void divide_by_two(int num){
        sum += num / 2;
    }
}
