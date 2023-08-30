package 잡다한거.Sorting;
import java.io.*;

// 퀵 정렬 시간복잡도는 평균의 경우 O(NlogN) 하지만 최악의 경우 O(N^2) 이다.
public class Quick_Sort {
    public static int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
    public static void main(String[] args) throws IOException{

        System.out.println("Before sorting");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

        quick_sort(0, array.length - 1);

        System.out.println("After sorting");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void quick_sort(int start, int end){
        // 원소가 한개인 경우
        if(start >= end) return;

        // 피벗 즉 기준점은 start지점 즉 현재 확인하는 array의 0번 자리
        int pivot = start;
        // left는 pivot값보다 큰 값을 찾기 위한 index
        int left = pivot + 1;
        // right는 pivot값보다 작은 값을 찾기 위한 index
        int right = end;

        // left가 right보다 커지게 되면 이는 서로 교차했다는 말
        while(left <= right){
            // left가 end 즉 array의 끝에 도달 하지 않았고 현재 index의 값이
            // 피벗 값보다 작은 값이면 오른쪽 index의 값을 확인하기 위해 left++
            while(left <= end && array[left] <= array[pivot]){
                left++;
            }

            // right가 start + 1즉 left의 처음 시작점에 도달하지 않았고
            // 현재 확인하는 index의 값이 pivot 값보다 크면
            // 왼쪽 값을 확인 하기 위해 right--
            while(right >= start + 1 && array[right] >= array[pivot]){
                right--;
            }

            // left가 right보다 크게 되면 즉 교차하게 되면
            // 피벗값은 작은 수 즉 right의 값과 위치 변경
            // 이 경우 left가 right보다 크니 while문 조건 깨짐
            if(left > right){
                int temp = array[right];
                array[right] = array[pivot];
                array[pivot] = temp;
            }

            // left가 right보다 작으면 left와 right값의 위치 변경
            // 이 경우 while문 다시 처음부터 시작
            else{
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        // left가 right보다 커져서 pivot의 위치가 변경되었으니
        // 피벗의 왼쪽 값들을 다시 정렬
        quick_sort(start, right - 1);
        // 피벗의 오른쪽 값들을 다시 정렬
        quick_sort(right + 1, end);
    }
}
