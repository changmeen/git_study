package Baekjoon.silver;
import java.io.*;

public class No_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N % 2 == 0) System.out.println("CY");
        else System.out.println("SK");
    }
}
