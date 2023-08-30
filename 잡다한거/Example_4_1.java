package 잡다한거;
import java.io.*;
import java.util.*;

// 구현_예제_상하좌우
public class Example_4_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] place = new int[2];

        place[0] = 1;
        place[1] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            String plan = st.nextToken();

            switch(plan){
                case "L":
                if(place[1] != 1){
                    place[1]--;
                }
                break;

                case "R":
                if(place[1] != n){
                    place[1]++;
                }
                break;

                case "U":
                if(place[0] != 1){
                    place[0]--;
                }
                break;

                case "D":
                if(place[0] != n){
                    place[0]++;
                }
                break;
            }
        }

        System.out.println(place[0] + " " + place[1]);
    }
}
