package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 어두운 굴다리 - 실버 4
public class No_17266 {

    static int n, m;
    static int[] position;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        position = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++){
            position[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = n;
        int result = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(possible(mid)) {
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }

        System.out.println(result);
    }

    static boolean possible(int target){
        int prev = 0;

        for(int i = 0; i < position.length; i++){
            if(position[i] - target <= prev){
                prev = position[i] + target;
            } else return false;
        }

        return n - prev <= 0;
    }
}
