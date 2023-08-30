package 잡다한거.Implementation;
import java.io.*;
import java.util.*;

// 구현_실전 문제_문자열 재정렬
public class Implementation_3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String letter = "";
        int number = 0;

        for(int i = 0; i < str.length(); i++){
            if(Character.isLetter(str.charAt(i))){
                letter += str.charAt(i);
            }
            else{
                number += str.charAt(i) - '0';
            }
        }

        char[] letter_char = letter.toCharArray();

        Arrays.sort(letter_char);

        String result = new String(letter_char) + number;
        
        System.out.println(result);
    }
}
