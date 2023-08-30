package 잡다한거.Algorithm;
import java.io.*;

// 피보나치 수열 
public class Fibonacci {

    public static int[] d = new int[100];
    public static int[] dp;
    public static void main(String[] args) throws IOException {

        System.out.println("Normal Fibonacci");
        System.out.println(fibo(10));
        System.out.println("TopDown Fibonacci");
        System.out.println(fibo_TopDown(25));
        System.out.println("BottomUp Fibonacci");
        System.out.println(fibo_BottomUp(30));
    }

    // 재귀함수를 이용한 Fibonacci 함수
    // 시간복잡도 = O(2^N)
    public static int fibo(int x){
        if(x == 1 || x == 2) return 1;

        return fibo(x - 1) + fibo(x - 2);
    }

    // 탑다운 = 메모이제이션 = 하향식
    public static int fibo_TopDown(int x){
        if(x == 1 || x == 2) return 1;

        if(d[x] != 0) return d[x];
        else{
            d[x] = fibo(x - 1) + fibo(x - 2);
            return d[x];
        }
    }

    // 버텀업 = 상향식 - 전형적인 DP 방식
    public static int fibo_BottomUp(int x){
        dp = new int[x + 1];
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i <= x; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[x];
    }
}
