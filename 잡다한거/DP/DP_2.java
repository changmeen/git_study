package 잡다한거.DP;
import java.io.*;
import java.util.*;

// DP_실전 문제_개미 전사
public class DP_2 {

    public static int n;
    public static int[] food;
    public static int[] storage;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        storage = new int[n + 1];
        food = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) storage[i] = Integer.parseInt(st.nextToken());

        System.out.println(solution());
    }

    public static int solution(){
        food[1] = storage[1];
        // 주의!!! 그냥 storage[2]가 아니다!!!!
        food[2] = Math.max(storage[1], storage[2]);
        
        for(int i = 3; i <= n; i++) {
            food[i] = Math.max(food[i - 1], food[i - 2] + storage[i]);
        }

        return food[n];
    }
}
