package 잡다한거.DFS_BFS.Binary_Search;
import java.io.*;
import java.util.*;

// 이진 탐색_실전 문제_부품 찾기
public class Binary_Search_1 {

    public static int n, m;
    public static int[] storage;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        storage = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) storage[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(storage);

        m = Integer.parseInt(br.readLine());
        int[] order = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++) order[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++){
            System.out.print(binary_search(0, n - 1, order[i]) + " ");
        }
    }

    public static String binary_search(int start, int end, int target){
        if(start > end) return "no";

        int mid = (start + end) / 2;

        if(storage[mid] == target) return "yes";
        else if(storage[mid] > target) return binary_search(start, mid - 1, target);
        else return binary_search(mid + 1, end, target);
    }
}
