package 잡다한거.Sorting;
import java.io.*;
import java.util.*;

// 정렬_실전 문제_위에서 아래로
public class Sorting_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
