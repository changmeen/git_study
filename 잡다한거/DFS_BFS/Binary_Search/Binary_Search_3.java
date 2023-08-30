package 잡다한거.DFS_BFS.Binary_Search;
import java.io.*;
import java.util.*;

// 이진 탐색_실전 문제_정렬된 배열에서 특정 수의 개수 구하기
public class Binary_Search_3 {

    public static int[] arr;
    public static int n, x, result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = left_index(0, n - 1);
        int right = right_index(0, n - 1);

        System.out.println(left + " " + right);
        System.out.println(right - left);
    }

    public static int left_index(int start, int end){
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] >= x) end = mid;
            else start = mid + 1;
        }

        return end;
    }

    public static int right_index(int start, int end){
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] > x) end = mid;
            else start = mid + 1;
        }

        return end;
    }
}
