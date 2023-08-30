package Baekjoon.bronze;
import java.io.*;
import java.util.*;

// 삼각형과 세 변 - 브론즈 3
public class No_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            HashSet<Integer> hs = new HashSet<>();
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0 && c == 0) break;

            int sum = a + b + c;
            int max = (a > b ? (a > c ? a : c) : (b > c ? b : c));

            if(sum - max <= max){
                sb.append("Invalid" + "\n");
                continue;
            }else{
                hs.add(a);
                hs.add(b);
                hs.add(c);

                if(hs.size() == 1){
                    sb.append("Equilateral" + "\n");
                    continue;
                }else if(hs.size() == 2){
                    sb.append("Isosceles" + "\n");
                    continue;
                }else{
                    sb.append("Scalene" + "\n");
                    continue;
                }
            }
        }

        System.out.println(sb);
    }
}
