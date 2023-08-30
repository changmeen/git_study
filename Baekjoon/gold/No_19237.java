package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 어른 상어 - 골드 2
public class No_19237 {

	// n은 n*n칸 m은 상어 수 k는 냄새 지속 시간
	static int N, M, k;
	static smell[][] map;
	static shark s[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new smell[N + 1][N + 1];
		s = new shark[M + 1];
		// 상어의 숫자는 M마리
		for (int i = 1; i <= M; i++) {
			s[i] = new shark(0, 0, 0);
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = new smell(Integer.parseInt(st.nextToken()), 0);
				if (map[i][j].who != 0) {
					map[i][j].left = k;
					s[map[i][j].who] = new shark(0, i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		// 각 상어의 방향
		for (int i = 1; i <= M; i++) {
			s[i].dir = Integer.parseInt(st.nextToken());
		}

		// 각 상어마다 4개의 줄을 읽어야 함
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				ArrayList<Integer> list = new ArrayList<>();
				st = new StringTokenizer(br.readLine(), " ");
				while (st.hasMoreTokens())
					list.add(Integer.parseInt(st.nextToken()));

				switch (j) {
				case 0:
					s[i].setUp(list);
					break;

				case 1:
					s[i].setDown(list);
					break;

				case 2:
					s[i].setLeft(list);
					break;

				case 3:
					s[i].setRight(list);
					break;
				}
			}
		}

		int time = 0;
		while (true) {

			move();
			time++;
			if(time > 1000) {
				time = -1;
				break;
			}
			int cnt = 0;
			for (int i = 1; i <= M; i++) {
				if (s[i].nx != -1 && s[i].ny != -1)
					cnt++;
			}

			if (cnt == 1)
				break;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j].left != 0) {
						map[i][j].left--;
						if (map[i][j].left == 0)
							map[i][j].who = 0;
					}
				}
			}
		}

		System.out.println(time);
	}

	static void move() {
		smell[][] new_map = new smell[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				new_map[i][j] = map[i][j];
			}
		}

		for (int t = 1; t <= M; t++) {
			shark NS = s[t];

			// 지금 보는 상어의 방향, x y좌표
			int ND = NS.dir;
			int Nx = NS.nx;
			int Ny = NS.ny;
			if (Nx == -1 && Ny == -1)
				continue;

			// 지금 상어의 방향에 따라 다른 우선순위를 불러옴
			int[] Ndx = new int[5];
			int[] Ndy = new int[5];
			switch (ND) {
			case 1:
				Ndx = NS.updx;
				Ndy = NS.updy;
				break;

			case 2:
				Ndx = NS.downdx;
				Ndy = NS.downdy;
				break;

			case 3:
				Ndx = NS.leftdx;
				Ndy = NS.leftdy;
				break;

			case 4:
				Ndx = NS.rightdx;
				Ndy = NS.rightdy;
				break;
			}

			int my_x = -1, my_y = -1, my_dir = -1;
			boolean check = false;
			for (int i = 1; i <= 4; i++) {
				int nextX = Nx + Ndx[i];
				int nextY = Ny + Ndy[i];
				
				// 지금 바라보는 칸이 맵 안인 경우
				if (nextX > 0 && nextY > 0 && nextX <= N && nextY <= N) {
					// 이번 시간에 가려는 칸에 기존 맵에서는 아무 냄새도 없을 경우
					if (map[nextX][nextY].who == 0) {
						// 이번 시간에 다른 상어가 지금 가려는 칸으로 오지 않았을 경우
						if (new_map[nextX][nextY].who == 0) {
							new_map[nextX][nextY] = new smell(t, k + 1);
							s[t].nx = nextX;
							s[t].ny = nextY;
							switch(ND) {
							case 1:
								s[t].dir = s[t].upd[i];
								break;
								
							case 2:
								s[t].dir = s[t].downd[i];
								break;
								
							case 3:
								s[t].dir = s[t].leftd[i];
								break;
								
							case 4:
								s[t].dir = s[t].rightd[i];
								break;
							}
							check = true;
							break;
						}
						// 이번 시간에 다른 상어가 지금 가려는 칸으로 와 있을 경우
						else {
							s[t].nx = -1;
							s[t].ny = -1;
							check = true;
							break;
						}
					}
					// 이번 시간에 보고 있는 곳이 내 냄새가 남이 있는 곳이고 다른 내 냄새가 났던 곳을 본 적이 없을 경우
					else if (map[nextX][nextY].who == t && my_x == -1 && my_y == -1) {
						my_x = nextX;
						my_y = nextY;
						switch(ND) {
						case 1:
							my_dir = s[t].upd[i];
							break;
							
						case 2:
							my_dir = s[t].downd[i];
							break;
							
						case 3:
							my_dir = s[t].leftd[i];
							break;
							
						case 4:
							my_dir = s[t].rightd[i];
							break;
						}
					}
				}
				// 지금 바라본 칸이 맵 밖인 경우 continue
				else {
					continue;
				}
			}
			if (!check) {
				s[t].nx = my_x;
				s[t].ny = my_y;
				s[t].dir = my_dir;
				new_map[my_x][my_y] = new smell(t, k + 1);
			}
		}
		
		// 살아있는 모든 상어의 이동이 끝난 경우
		map = new_map.clone();
	}
}

class smell {
	int who;
	int left;

	smell(int who, int left) {
		this.who = who;
		this.left = left;
	}
}

class shark {
	int[] dx = { 0, -1, 1, 0, 0 };
	int[] dy = { 0, 0, 0, -1, 1 };
	int dir;
	int nx, ny;

	int[] upd = new int[5];
	int[] updx = new int[5];
	int[] updy = new int[5];

	int[] downd = new int[5];
	int[] downdx = new int[5];
	int[] downdy = new int[5];

	int[] leftd = new int[5];
	int[] leftdx = new int[5];
	int[] leftdy = new int[5];

	int[] rightd = new int[5];
	int[] rightdx = new int[5];
	int[] rightdy = new int[5];

	shark(int dir, int nx, int ny) {
		this.dir = dir;
		this.nx = nx;
		this.ny = ny;
	}

	void setUp(ArrayList<Integer> up) {
		for (int i = 1; i <= 4; i++) {
			upd[i] = up.get(i - 1);
			updx[i] = dx[up.get(i - 1)];
			updy[i] = dy[up.get(i - 1)];
		}
	}

	void setDown(ArrayList<Integer> down) {
		for (int i = 1; i <= 4; i++) {
			downd[i] = down.get(i - 1);
			downdx[i] = dx[down.get(i - 1)];
			downdy[i] = dy[down.get(i - 1)];
		}
	}

	void setLeft(ArrayList<Integer> left) {
		for (int i = 1; i <= 4; i++) {
			leftd[i] = left.get(i - 1);
			leftdx[i] = dx[left.get(i - 1)];
			leftdy[i] = dy[left.get(i - 1)];
		}
	}

	void setRight(ArrayList<Integer> right) {
		for (int i = 1; i <= 4; i++) {
			rightd[i] = right.get(i - 1);
			rightdx[i] = dx[right.get(i - 1)];
			rightdy[i] = dy[right.get(i - 1)];
		}
	}
}