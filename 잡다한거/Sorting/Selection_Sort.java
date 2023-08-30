package 잡다한거.Sorting;
import java.io.*;

// 선택정렬 시간 복잡도는 O(N^2)
public class Selection_Sort {
    public static void main(String[] args) throws IOException{
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        System.out.println("Before sorting");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
        
        for(int i = 0; i < array.length; i++){
            int min_idx = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[min_idx] > array[j]){
                    min_idx = j;
                }
            }
            int temp = array[i];
            array[i] = array[min_idx];
            array[min_idx] = temp;
        }

        System.out.println("After sorting");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    } 
}
