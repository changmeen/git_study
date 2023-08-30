package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 청소년 상어 - 골드 2
public class No_19236 {
	static int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int max = Integer.MIN_VALUE;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] fish_info = new int[17][2];
		fish[][] map = new fish[4][4];

		// 물고기 정보 입력
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				map[i][j] = new fish(num, dir);
				fish_info[num][0] = i;
				fish_info[num][1] = j;
			}
		}

		shark s = new shark(map[0][0].dir, map[0][0].num, 0, 0);
		fish_info[map[0][0].num][0] = -1;
		fish_info[map[0][0].num][1] = -1;
		map[0][0] = new fish(0, 0);

		dfs(fish_info, map, s);
		System.out.println(max);
	}

	static void dfs(int[][] fish_info, fish[][] map, shark s) {

		// 상어가 누군가를 먹고 또다시 물고기가 이동하기 전에 현재까지 상어가 먹은 물고기들의 번호합과 max 비교
		max = Math.max(max, s.sum);
		int dangerX = s.x;
		int dangerY = s.y;

		// 1번부터 16번 까지 아직 살아있는 물고기 이동
		for (int i = 1; i <= 16; i++) {
			// 아직 먹히지 않은 물고기면 움직임
			if (fish_info[i][0] != -1 && fish_info[i][1] != -1) {
				// 현재 보고 있는 물고기의 현재 위치
				int nowx = fish_info[i][0];
				int nowy = fish_info[i][1];
				int nowd = map[nowx][nowy].dir;

				// 현재 위치에서 이동할 다음 위치
				int nextx, nexty, first_dir = nowd;
				boolean check = false;
				while (true) {
					nextx = nowx + dx[nowd];
					nexty = nowy + dy[nowd];

					// 이동 가능한 칸이면 현재 물고기의 dir 변경 후 break
					if (nextx >= 0 && nexty >= 0 && nextx < 4 && nexty < 4) {
						if ((nextx != dangerX || nexty != dangerY)) {
							map[nowx][nowy].dir = nowd;
							check = true;
							break;
						}
					}
					nowd++;
					if (nowd == 9)
						nowd = 1;
					if (nowd == first_dir)
						break;
				}
				if (!check)
					continue;
				// 현재 보는 물고기와 이동할 장소에 있는 물고기의 위치 변경
				fish temp1 = new fish(map[nextx][nexty].num, map[nextx][nexty].dir);
				fish temp2 = new fish(map[nowx][nowy].num, map[nowx][nowy].dir);
				fish_info[temp1.num][0] = nowx;
				fish_info[temp1.num][1] = nowy;

				map[nextx][nexty] = temp2;
				map[nowx][nowy] = temp1;

				fish_info[i][0] = nextx;
				fish_info[i][1] = nexty;

			}
			// 이미 먹힌 물고기면 continue
			else {
				continue;
			}
		} // 이동 끝

		// 상어가 어떤 물고기를 먹을 수 있는지 확인
		// 현재 상어의 위치와 방향
		int Snowx = s.x;
		int Snowy = s.y;
		int Snowd = s.dir;

		int Snextx = Snowx;
		int Snexty = Snowy;
		while (true) {
			
			fish[][] new_map = new fish[4][4];
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					new_map[i][j] = new fish(map[i][j].num, map[i][j].dir);
				}
			}
			int[][] new_fish_info = new int[17][2];
			for(int i = 1; i <= 16; i++) {
				new_fish_info[i][0] = fish_info[i][0];
				new_fish_info[i][1] = fish_info[i][1];
			}
			
			Snextx += dx[Snowd];
			Snexty += dy[Snowd];

			if (Snextx >= 0 && Snexty >= 0 && Snextx < 4 && Snexty < 4) {
				if (new_map[Snextx][Snexty].num != 0) {
					int nextd = new_map[Snextx][Snexty].dir;
					int nextNum = new_map[Snextx][Snexty].num;

					new_fish_info[nextNum][0] = -1;
					new_fish_info[nextNum][1] = -1;
					fish temp = new fish(new_map[Snextx][Snexty].num, new_map[Snextx][Snexty].dir);
					new_map[Snextx][Snexty] = new fish(0, 0);
					
					dfs(new_fish_info, new_map, new shark(nextd, s.sum + nextNum, Snextx, Snexty));
					
					new_fish_info[nextNum][0] = Snextx;
					new_fish_info[nextNum][1] = Snexty;
					new_map[Snextx][Snexty] = temp;
				}
			}
			// 상어가 이동할 수 있는 칸을 다 확인했을 경우
			else {
				break;
			}
		}
	}
}

class fish {
	int num;
	int dir;

	fish(int num, int dir) {
		this.num = num;
		this.dir = dir;
	}
}

class shark {
	int dir;
	int x, y;
	int sum;

	shark(int dir, int sum, int x, int y) {
		this.dir = dir;
		this.sum = sum;
		this.x = x;
		this.y = y;
	}
}