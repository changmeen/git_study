package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 집합 - 실버 5
public class No_11723 {

    static int m, s = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException{
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()) num = Integer.parseInt(st.nextToken());

            switch(cmd){
                case "add":
                add(1 << (num - 1));
                break;

                case "remove":
                remove(~(1 << (num - 1)));
                break;

                case "check":
                check(1 << (num - 1));
                break;

                case "toggle":
                toggle(1 << (num - 1));
                break;

                case "all":
                all();
                break;

                case "empty":
                empty();
                break;
            }
        }

        System.out.println(sb);
    }

    static void add(int num){
        s |= num;
        return;
    }

    static void remove(int num){
        s &= num;
        return;
    }

    static void check(int num){
        sb.append(((s & num) == num) ? "1\n" : "0\n");
        return;
    }

    static void toggle(int num){
        s ^= num;
    }

    static void all(){
        s |= ~0;
        return;
    }

    static void empty(){
        s = 0;
        return;
    }
}