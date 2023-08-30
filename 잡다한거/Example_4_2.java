package 잡다한거;
import java.io.*;

// 구현_예제_시각
public class Example_4_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 60; j++){
                for(int k = 0; k < 60; k++){
                    String temp = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
                    if(temp.contains("3")){
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
