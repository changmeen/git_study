package 잡다한거.Sorting;
import java.io.*;

// 계수 정렬 시간복잡도는 O(N + K)
// 데이터의 개수가 N 데이터의 최대값이 K
public class Count_Sort {
    public static final int MAX_VALUE = 9;
    public static void main(String[] args) throws IOException {

        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        int[] cnt = new int[MAX_VALUE + 1];

        System.out.println("Before sorting");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < array.length; i++){
            cnt[array[i]]++; 
        }

        for(int i = 0; i <= MAX_VALUE; i++) {
        	for(int j = 0; j < cnt[i]; j++) {
        		System.out.print(i);
        		System.out.print(" ");
        	}
        }
    }
}