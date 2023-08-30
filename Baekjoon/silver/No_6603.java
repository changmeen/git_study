package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 로또 - 실버 2
class No_6603{
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] array;
        
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            
            array = new int[k];
            for(int i = 0; i < k; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i = 0; i < k; i++){
                for(int j = i + 1; j < k; j++){
                    for(int l = j + 1; l < k; l++){
                        for(int m = l + 1; m < k; m++){
                            for(int n = m + 1; n < k; n++){
                                for(int o = n + 1; o < k; o++){
                                    System.out.println(array[i] + " " + array[j] + " " + array[l] + " " + array[m] + " " + array[n] + " " + array[o]);
                                }
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}