package Baekjoon.bronze;
import java.util.*;
import java.io.*;

// 2007년 - 브론즈1
public class No_1924 {

    static int[] month = {31, 28, 31, 30, 31,
        30, 31, 31, 30, 31, 30, 31};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int day = 0;
        for(int i = 0; i < m - 1; i++){
            day += month[i];
        }
        day += (d - 1);

        switch(day % 7){
            case 0:
            System.out.println("MON");
            break;

            case 1:
            System.out.println("TUE");
            break;

            case 2:
            System.out.println("WED");
            break;

            case 3:
            System.out.println("THU");
            break;

            case 4:
            System.out.println("FRI");
            break;

            case 5:
            System.out.println("SAT");
            break;

            case 6:
            System.out.println("SUN");
            break;
        }
    }
}
