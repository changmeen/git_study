package 잡다한거.Sorting;
import java.io.*;
import java.util.*;

public class Sorting_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        for(int i = 0; i < k; i++){
            if(arr1[i] < arr2[i]){
                int temp = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = temp;
            }
        }

        // for(int i = 0; i < k; i++){
        //     if(arr1[0] >= arr2[n - 1]) break;

        //     else{
        //         int temp = arr1[0];
        //         arr1[0] = arr2[n - 1];
        //         arr2[n - 1] = temp;
        //     }

        //     Arrays.sort(arr1);
        //     Arrays.sort(arr2);
        // }

        int sum = 0;
        for(int i = 0; i < n; i++) sum += arr1[i];

        System.out.println(sum);
    }
}
