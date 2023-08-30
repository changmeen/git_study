package 잡다한거.Greedy;
import java.io.*;

// 그리드_실전 문제_곱하기 혹은 더하기
public class Greedy_4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] string = str.split("");

        int answer = Integer.parseInt(string[0]);

        for(int i = 1; i < string.length; i++){
            if(string[i].equals("0") || string[i].equals("1")){
                answer += Integer.parseInt(string[i]);
            }
            else{
                if(answer == 0){
                    answer += Integer.parseInt(string[i]);
                }
                else{
                    answer *= Integer.parseInt(string[i]);
                }
            }
        }

        System.out.println(answer);
    }
}
