package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 크로스 컨트리 - 실버 4
public class No_9017 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());
        for(int t = 0; t < test_case; t++){
            HashMap<Integer, ArrayList<Integer>> member_cnt = new HashMap<Integer, ArrayList<Integer>>();
            HashMap<Integer, team> team_score = new HashMap<Integer, team>();
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n + 1];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= n; i++){
                int team = Integer.parseInt(st.nextToken());
                list[i] = team;
                if(!member_cnt.containsKey(team)){
                    member_cnt.put(team, new ArrayList<Integer>());
                    member_cnt.get(team).add(i);
                }else{
                    member_cnt.get(team).add(i);
                }
            }

            for(Integer key : member_cnt.keySet()){
                Collections.sort(member_cnt.get(key));
            }

            int min_score = Integer.MAX_VALUE;
            int win_team = -1;
            int score = 1;
            for(int i = 1; i <= n; i++){
                if(member_cnt.get(list[i]).size() >= 6){
                    if(!team_score.containsKey(list[i])){
                        team_score.put(list[i], new team(1, score));
                    }
                    else{
                        if(team_score.get(list[i]).cnt < 4){
                            team_score.replace(list[i], new team(team_score.get(list[i]).cnt + 1, team_score.get(list[i]).score + score));
                        }
                    }

                    if(team_score.get(list[i]).cnt == 4){
                        if(team_score.get(list[i]).score < min_score){
                            win_team = list[i];
                            min_score = team_score.get(list[i]).score;
                        }
                        else if(team_score.get(list[i]).score == min_score){
                            if(member_cnt.get(list[i]).get(4) < member_cnt.get(win_team).get(4)){
                                win_team = list[i];
                            }
                        }
                    }
                    score++;
                }
                else{
                    continue;
                }
            }
            sb.append(win_team + "\n");
        }

        System.out.println(sb);
    }
}

class team{
    int cnt;
    int score;

    team(int cnt, int score){
        this.cnt = cnt;
        this.score = score;
    }
}