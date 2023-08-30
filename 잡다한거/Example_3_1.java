package 잡다한거;
import java.io.*;

// 그리디_예제_거스름돈
public class Example_3_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] change = {500, 100, 50, 10};

        int result = 0;
        for(int i = 0; i < change.length; i++){
            result += n / change[i];
            n %= change[i];
        }

        System.out.println(result);
    }
}
