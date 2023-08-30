package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 용액 - 골드 5
public class No_2467 {
    // acid - 산성 - 양수
    // alcal - 알칼리성 - 음수
    static ArrayList<Long> acid = new ArrayList<Long> ();
    static ArrayList<Long>  alcal = new ArrayList<Long> ();
    static Long min = Long.MAX_VALUE, min_left, min_right;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            Long num = Long.parseLong(st.nextToken());

            // 현재 숫자가 양수면 acid에 입력 음수면 alcal에 입력
            if(num >= 0){
                acid.add(num);
            }else{
                alcal.add(-num);
            }
        }

        // acid와 alcal 모두 sort
        Collections.sort(acid);
        Collections.sort(alcal);
        
        // acid의 개수가 0개인 경우 alcal의 0과 1을 더한게 가장 최소
        if(acid.size() == 0){
            System.out.println(-alcal.get(1) + " " + -alcal.get(0));
            return;
        }
        // alcal의 개수가 0인 경우 acid의 0과 1을 더한게 가장 최소
        if(alcal.size() == 0){
            System.out.println(acid.get(0) + " " + acid.get(1));
            return;
        }
        
        // acid의 내용물들 각각 alcal의 내용물들과 binrary search를 통해
        // 가장 합했을때 0과 가까운 수를 찾음
        for(int i = 0; i < acid.size(); i++){
            binarySearch(acid.get(i));
        }

        // acid와 alcal만의 비교가 아니라 alcal로만의 조합으로 최소값이 나올 경우 체크
        if(alcal.size() >= 2){
            if(min >= (Math.abs(alcal.get(0) + alcal.get(1)))){
                min_left = (-1) * alcal.get(1);
                min_right = (-1) * alcal.get(0);
            }
        }

        
        // acid와 alcal만의 비교가 아니라 acid로만의 조합으로 최소값이 나올 경우 체크
        if(acid.size() >= 2){
            if(min >= (Math.abs(acid.get(0) + acid.get(1)))){
                min_left = acid.get(0);
                min_right = acid.get(1);
            }
        }

        System.out.println(min_left + " " + min_right);
    }

    static void binarySearch(Long num){
        int left = 0;
        int right = alcal.size() - 1;
        int mid = 0;

        while(left <= right){
            mid = (left + right) / 2;

            if(alcal.get(mid) == num){
                min = 0L;
                min_left = -num;
                min_right = num;
                return;
            }

            if(alcal.get(mid) < num){
                left = mid + 1;
            }

            else right = mid - 1;
        }

        if(mid - 1 >= 0){
            if(min > (Math.abs(num - alcal.get(mid - 1)))){
                min = Math.abs(num - alcal.get(mid - 1));
                min_left = -alcal.get(mid - 1);
                min_right = num;
            }
        }
        if(mid + 1 < alcal.size()){
            if(min > (Math.abs(num - alcal.get(mid + 1)))){
                min = Math.abs(num - alcal.get(mid + 1));
                min_left = -alcal.get(mid + 1);
                min_right = num;
            }
        }
        if(min > (Math.abs(num - alcal.get(mid)))){
            min = Math.abs(num - alcal.get(mid));
            min_left = -alcal.get(mid);
            min_right = num;
        }
        return;
    }
}
