package 잡다한거.Sorting;
import java.io.*;

// 삽입정렬 시간 복잡도는 O(N^2)이지만 이미 정렬되어 있는 경우 O(N)
public class Insertion_Sort {
    public static void main(String[] args) throws IOException{
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        System.out.println("Before sorting");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // 2번째 index부터 마지막 index까지 순차적으로 이동
        for(int i = 1; i < array.length; i++){
            // 지금 i index부터 1까지 1씩 줄여가면서(왼쪽으로 이동하면서) 확인
            for(int j = i; j > 0; j--){

                // 지금 확인하고 있는 index와 그 왼쪽 수를 비교
                // 지금 확인하는 수가 더 작으면 위치 바꿈
                if(array[j] < array[j - 1]){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }

                // 지금 확인 하는 수가 더 크면 왼쪽은 이미 정렬됬다고 가정
                // 따라서 위치는 지금으로 정해지고 종료
                else{
                    break;
                }
            }
        }

        System.out.println("After sorting");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
