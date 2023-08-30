package 잡다한거.Greedy;
import java.io.*;
import java.util.*;

// 그리드_실전 문제_모험가 길드
public class Greedy_5 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] member = new int[st.countTokens()];
        for(int i = 0; i < member.length; i++){
            member[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(member);

        int answer = 0;
        int cnt = 0;
        for(int i = 0; i < member.length; i++){
            cnt++;
            if(cnt >= member[i]){
                answer++;
                cnt = 0;
            }
        }

        System.out.println(answer);
    }
}
