package 잡다한거.DFS_BFS.Binary_Search;
import java.io.*;
import java.util.*;

// 이진 탐색_실전 문제_떡볶이 떡 만들기
public class Binary_Search_2 {

    public static int[] arr;
    public static int n, m, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(binary_search(0, arr[n - 1]));
    }

    public static int binary_search(int start, int end){
        if(start > end) return result;
        int mid = (start + end) / 2;
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > mid) sum += arr[i] - mid;
        }

        if(sum == m) return mid;

        else if(sum < m) return binary_search(start, mid - 1);
        else{
            result = mid;
            return binary_search(mid + 1, end);
        } 
    }
}
