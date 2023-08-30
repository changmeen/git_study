package 잡다한거.Algorithm;

public class LIS_Lower_Bound {
    public static void main(String args[]){
        int arr[] = {1, 6, 3, 4, 2, 7, 8, 5};
        int LIS[] = new int[8];

        int cnt = 0;
        LIS[cnt++] = arr[0];

        for(int i = 1; i < 8; i++){
            if(LIS[cnt - 1] < arr[i]){
                LIS[cnt++] = arr[i];
            }
            else{
                int idx = lowerBound(LIS, arr[i], 0, cnt);
                LIS[idx] = arr[i];
            }
        }

        for (int i = 0; i < 8; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < 8; i++) {
			System.out.print(LIS[i]+" ");
		}
    }

    static int lowerBound(int[] arr, int value, int s, int e){
        System.out.println(s + " " + e);
        while(s < e){
            int mid = (s + e) / 2;
            if(value <= arr[mid])
                e = mid;
            else s = mid + 1;
        }

        return s;
    }
}
