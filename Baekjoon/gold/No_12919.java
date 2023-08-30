package Baekjoon.gold;
import java.io.*;

// A와 B 2 - 골드 5 
public class No_12919 {
    static boolean check = false;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        dfs(S, T);

        if(check) System.out.println("1");
        else System.out.println("0");
    }

    static void dfs(String s, String t){
        if(s.length() == t.length()){
            if(s.equals(t)) check = true;
            return;
        }

        String t_origin = "";
        t_origin += t;
        String temp = "";
        if(t.charAt(0) == 'B'){
            t = t.substring(1, t.length());
            for(int i = t.length() - 1; i >= 0; i--){
                temp += String.valueOf(t.charAt(i));
            }
            dfs(s, temp);
        }

        t = t_origin;
        if(t.charAt(t.length() - 1) == 'A'){
            t = t.substring(0, t.length() - 1);
            dfs(s, t);
        }
    }
}