package 잡다한거.DFS_BFS.Binary_Search;
import java.io.*;
import java.util.*;

// 이진 탐색
public class Binary_Search {

    public static int[] arr;
    public static int target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = binary_search(0, n - 1);
        if(result == -1){
            System.out.println("원소가 존재하지 않습니다.");
        }
        else System.out.println(result + 1 + "번째 index에 존재합니다.");
    }

    public static int binary_search(int start, int end){
        if(start > end) return -1;
        int mid = (start + end) / 2;

        if(arr[mid] == target) return mid;

        else if(arr[mid] > target){
            return binary_search(start, mid - 1);
        }
        else{
            return binary_search(mid + 1, end);
        }
    }
}
