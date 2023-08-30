package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 2048 (Easy) - 골드 2
public class No_12100 {

	static int n;
    static int[][] map;
    static int ans = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        } // end input

        rotate(0);
        System.out.println(ans);
    }
    
    private static void rotate(int count) { // dfs

        if(count==5){ // 5번 움직였을 때 종결
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    ans = Math.max(ans,map[i][j]); // max 값 갱신
            return;
        }

        int[][] nextMap = new int[n][n]; // 이전 상태로 되돌리기 위한 배열 복사
        for(int k=0;k<n;k++)
            nextMap[k] = map[k].clone();
        
        for(int i = 0; i < 4; i++) {
        	move(i);
        	rotate(count + 1);
        	for(int k = 0; k < n; k++)
        		map[k] = nextMap[k].clone();
        }
    }
    
    static void move(int dir) { // 해당 방향에서 움직이는 함수

        LinkedList<Integer> q = new LinkedList<>(); // 한번 움직임에 두 번 이상 합쳐짐을 방지하기 위한 큐

        if (dir == 0) { // 우 -> 우는 오른쪽으로 미는게 아니라 왼쪽으로 미는거다
            for (int i = 0; i < n; i++) {
            	// 아직 i for문이 안 끝남 즉 행(가로) 한 줄씩만 확인 하는 중임
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != 0)
                        q.add(map[i][j]); // 큐에 삽입
                    map[i][j] = 0;
                }
                
                // 왼쪽으로 미는 것이기에 한 행의 가장 왼쪽 값부터 체크
                int index = 0; // 0부터 시작
                while (!q.isEmpty()) {
                    Integer cur = q.poll();

                    if (map[i][index] == 0) { // 0 이면
                        map[i][index] = cur;
                    } else if (map[i][index] == cur) { // 병합하기
                        map[i][index] = cur * 2;
                        index++;
                    } else { // 합쳐질 수 없는 경우 그대로 이동만
                        index++;
                        map[i][index] = cur;
                    }
                }
            }
        } else if (dir == 1) { // 좌 -> 좌는 왼쪽으로의 이동이 아니라 오른쪽으로 미는 거다
            for (int i = 0; i < n; i++) {
            	// 오른쪽 열(세로) 칸의 값부터 큐에 집어 넣는다
                for (int j = n - 1; j >= 0; j--) {
                    if (map[i][j] != 0)
                        q.add(map[i][j]);
                    map[i][j] = 0;
                }

                // 오른쪽으로 미는 것이기에 한 행의 오른 쪽 값부터 체크
                int index = n - 1;
                while (!q.isEmpty()) {
                    Integer cur = q.poll();

                    if (map[i][index] == 0) {
                        map[i][index] = cur;
                    } else if (map[i][index] == cur) {
                        map[i][index] = cur * 2;
                        index--;
                    } else {
                        index--;
                        map[i][index] = cur;
                    }
                }
            }
        } else if (dir == 2) { // 하 -> 하는 아래로 미는거다
        	// 여기서 i는 행(가로)가 아니라 열(세로)이다.
            for (int i = 0; i < n; i++) {
            	// 위에서 아래로 미는 것 즉 열 단위로 q에 넣어줌
            	// ex) 3,0 2,0 1,0, 0,0이 처음 q에 들어가고 3,1 2,1 1,1 0,1이 다음 q에 들어가는 식
                for (int j = n - 1; j >= 0; j--) {
                    if (map[j][i] != 0)
                        q.add(map[j][i]);
                    map[j][i] = 0;
                }

                // 밑으로 내리는 것이기에 가장 맨 아래 행(가로)값부터 확인
                int index = n - 1;
                while (!q.isEmpty()) {
                    Integer cur = q.poll();

                    if (map[index][i] == 0) {
                        map[index][i] = cur;
                    } else if (map[index][i] == cur) {
                        map[index][i] = cur * 2;
                        index--;
                    } else {
                        index--;
                        map[index][i] = cur;
                    }
                }
            }
        } else if(dir == 3) { // 상 -> 상은 위로 미는 거다
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			if(map[j][i] != 0) q.add(map[j][i]);
        			map[j][i] = 0;
        		}
        		
        		int index = 0;
        		while(!q.isEmpty()) {
        			Integer cur = q.poll();
        			
        			if(map[index][i] == 0) {
        				map[index][i] = cur;
        			} else if(map[index][i] == cur) {
        				map[index][i] *= 2;
        				index++;
        			} else {
        				index++;
        				map[index][i] = cur;
        			}
        		}
        	}
        }
    }
}