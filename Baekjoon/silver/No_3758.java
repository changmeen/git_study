package Baekjoon.silver;
import java.io.*;
import java.util.*;

// KCPC - 실버 - 3
public class No_3758 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());
        for(int T = 0; T < test_case; T++){
            st = new StringTokenizer(br.readLine(), " ");

            // n은 팀의 개수, k는 문제 개수, idt는 우리팀 id, m은 로그 수
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] list = new Team[n];

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int teamID = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if(list[teamID - 1] == null){
                    list[teamID - 1] = new Team();
                    list[teamID - 1].id = teamID;
                    list[teamID - 1].scoreList = new int[k + 1];
                }

                list[teamID - 1].scoreList[problemNum] = Math.max(score, list[teamID - 1].scoreList[problemNum]);
                list[teamID - 1].submitNum++;
                list[teamID - 1].lastSubmit = i;
            }

            for(int i = 0; i < n; i++){
                int sum = 0;
                for(int j = 1; j <= k; j++){
                    sum += list[i].scoreList[j];
                }
                list[i].totalScore = sum;
            }

            Arrays.sort(list);

            for(int i = 0; i < n; i++){
                if(list[i].id == t){
                    sb.append(i + 1).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}

class Team implements Comparable<Team>{
    int id, submitNum, lastSubmit, totalScore;
    int[] scoreList;

    @Override
    public int compareTo(Team o) {
        if(this.totalScore != o.totalScore){
            return o.totalScore - this.totalScore;
        }else{
            if(this.submitNum != o.submitNum){
                return this.submitNum - o.submitNum;
            }else{
                return this.lastSubmit - o.lastSubmit;
            }
        }
    }
}