package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 문자열 폭발 - 골드 4
public class No_9935 {
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        String regex = br.readLine();
        int regex_size = regex.length();

        for(int i = 0; i < line.length(); i++){
            stack.push(line.charAt(i));

            if(stack.size() >= regex_size){
                boolean flag = true;

                for(int j = 0; j < regex_size; j++){
                    if(stack.get(stack.size() - regex_size + j) != regex.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int k = 0; k < regex_size; k++){
                        stack.pop();
                    }
                }
            }
        }

        for(int i = 0; i < stack.size(); i++){
            sb.append(stack.get(i));
        }

        if(sb.length() == 0){
            System.out.println("FRULA");
        }
        else{
            System.out.println(sb);
        }
    }
}
