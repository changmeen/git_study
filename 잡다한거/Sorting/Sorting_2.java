package 잡다한거.Sorting;
import java.io.*;
import java.util.*;

// 정렬_실전 문제_성적이 낮은 순서로 학생 출력하기
public class Sorting_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, String> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            map.put(score, name);
        }

        for(int key : map.keySet()){
            System.out.print(map.get(key) + " ");
        }
    }
}
