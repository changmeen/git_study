package 잡다한거.Algorithm;
import java.io.*;
import java.util.*;

public class GCD {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(gcd(a, b));
    }

    public static int gcd(int n, int m){
        if(n % m == 0){
            return m;
        }

        else{
            return gcd(m, n % m);
        }
    }
}
