package 잡다한거.Implementation;
import java.io.*;

// 구현_실전 문제_왕실의 나이트
public class Implementation_1 {
    
    static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        // char 1를 int 1로 변환
        int row = str.charAt(1) - '0';
        // char a를 int 1로 변환
        int column = str.charAt(0) - 'a' + 1;
        // int row = Integer.parseInt(place[1]);

        // switch(column_string){
        //     case "a": column = 1; break;
        //     case "b": column = 2; break;
        //     case "c": column = 3; break;
        //     case "d": column = 4; break;
        //     case "e": column = 5; break;
        //     case "f": column = 6; break;
        //     case "g": column = 7; break;
        //     case "h": column = 8; break;
        // }

        int answer = 0;
        for(int i = 0; i < 8; i++){
            int nx = dx[i] + row;
            int ny = dy[i] + column;

            if(nx > 0 && ny > 0 && nx <= 8 && ny <= 8){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
