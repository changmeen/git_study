package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 새로운 게임 2 - 골드 2
public class No_17837 {

	static int N, K;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
	static int[][] map;
	static ArrayList<String>[][] map_list;
	static horse[] horses;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		horses = new horse[K + 1];
		map_list = new ArrayList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map_list[i][j] = new ArrayList<>();
			}
		}

		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map_list[x][y].add(String.valueOf(i));

			horses[i] = new horse(x, y, d);
		}

		int res = 0;
		for (res = 1; res <= 1000; res++) {
			if (move()) {
				System.out.println(res);
				return;
			}
		}

		if (res > 1000) {
			System.out.println("-1");
		}
	}

	static boolean move() {
		for (int i = 1; i <= K; i++) {
			// 현재 보고 있는 말의 지점 nowx nowy
			int nowx = horses[i].x;
			int nowy = horses[i].y;
			
//			System.out.println();
//			System.out.println("Now Horse: " + i);
//			System.out.println("nowx: " + nowx + ", nowy: " + nowy);

			// 현재 보고 있는 말의 방향에 따른 다음 지점
			int nextx = nowx + dx[horses[i].d];
			int nexty = nowy + dy[horses[i].d];

//			System.out.println("nextx: " + nextx + ", nexty: " + nexty);
			
			// 이동하는 말들을 담기 위한 temp Deque
			Deque<Integer> temp = new LinkedList<>();
			// 현재 말이 원래 있던 map_list[nowx][nowy]에서 i말 삭제
			int idx = map_list[nowx][nowy].indexOf(String.valueOf(i));

			while (idx != map_list[nowx][nowy].size()) {
				temp.add(Integer.parseInt(map_list[nowx][nowy].get(idx)));
				map_list[nowx][nowy].remove(idx);
			}
			// 한칸 전진한 곳이 벽 안인 경우
			if (nextx >= 1 && nexty >= 1 && nextx <= N && nexty <= N) {
				switch (map[nextx][nexty]) {
				// W로 간 경우
				case 0:
					while (!temp.isEmpty()) {
						horses[temp.peekFirst()].x = nextx;
						horses[temp.peekFirst()].y = nexty;
						map_list[nextx][nexty].add(String.valueOf(temp.pollFirst()));
					}
					if (map_list[nextx][nexty].size() >= 4) {
						return true;
					}
					break;

				// R로 간 경우
				case 1:
					while (!temp.isEmpty()) {
						horses[temp.peekLast()].x = nextx;
						horses[temp.peekLast()].y = nexty;
						map_list[nextx][nexty].add(String.valueOf(temp.pollLast()));
					}
					if (map_list[nextx][nexty].size() >= 4) {
						return true;
					}
					break;

				// B로 간 경우
				case 2:
					switch (horses[i].d) {
					case 1:
						horses[i].d = 2;
						break;

					case 2:
						horses[i].d = 1;
						break;

					case 3:
						horses[i].d = 4;
						break;

					case 4:
						horses[i].d = 3;
						break;
					}

					int newx, newy;
					newx = nowx + dx[horses[i].d];
					newy = nowy + dy[horses[i].d];
					
//					System.out.println("newx: " + newx + ", newy: " + newy);
					
					// 한 칸 뒤가 벽 안인 경우
					if(newx >= 1 && newy >= 1 && newx <= N && newy <= N) {
						// 한칸 뒤가 B가 아닌 경우
						if(map[newx][newy] != 2) {
							switch(map[newx][newy]) {
							// W로 간 경우
							case 0:
								while(!temp.isEmpty()) {
									horses[temp.peekFirst()].x = newx;
									horses[temp.peekFirst()].y = newy;
									map_list[newx][newy].add(String.valueOf(temp.pollFirst()));
								}
								if(map_list[newx][newy].size() >= 4) {
									return true;
								}
								break;
							
							// R로 간 경우
							case 1:
								while(!temp.isEmpty()) {
									horses[temp.peekLast()].x = newx;
									horses[temp.peekLast()].y = newy;
									map_list[newx][newy].add(String.valueOf(temp.pollLast()));
								}
								if(map_list[newx][newy].size() >= 4) {
									return true;
								}
								break;
							}
						}
						// 한칸 뒤가 B인 경우
						else {
//							System.out.println("front is B behind is B");
							while(!temp.isEmpty()) {
								horses[temp.peekFirst()].x = nowx;
								horses[temp.peekFirst()].y = nowy;
								map_list[nowx][nowy].add(String.valueOf(temp.pollFirst()));
							}
							if(map_list[nowx][nowy].size() >= 4) {
								return true;
							}
						}
					}
					// 한칸 뒤가 벽 바깥인 경우
					else {
//						System.out.println("front is B behind is out");
						while(!temp.isEmpty()) {
							horses[temp.peekFirst()].x = nowx;
							horses[temp.peekFirst()].y = nowy;
							map_list[nowx][nowy].add(String.valueOf(temp.pollFirst()));
						}
						if(map_list[nowx][nowy].size()>= 4) {
							return true;
						}
//						System.out.println(map_list[nowx][nowy]);
					}
				}
			}
			// 한칸 전진한 곳이 벽 바깥인 경우
			else {
				// 현재 보는 말의 방향 반대로 바꿔 줌
				switch (horses[i].d) {
				case 1:
					horses[i].d = 2;
					break;

				case 2:
					horses[i].d = 1;
					break;

				case 3:
					horses[i].d = 4;
					break;

				case 4:
					horses[i].d = 3;
					break;
				}
				
				int newx, newy;
				newx = nowx + dx[horses[i].d];
				newy = nowy + dy[horses[i].d];

				// 한칸 뒤 자리가 B가 아닌 경우
				if(map[newx][newy] != 2) {
					switch(map[newx][newy]) {
					case 0:
//						System.out.println("front is out behind is W");
						while(!temp.isEmpty()) {
							horses[temp.peekFirst()].x = newx;
							horses[temp.peekFirst()].y = newy;
							map_list[newx][newy].add(String.valueOf(temp.pollFirst()));
						}
						if(map_list[newx][newy].size() >= 4) {
							return true;
						}
						break;
						
					case 1:
//						System.out.println("front is out behind is R");
						while(!temp.isEmpty()) {
							horses[temp.peekLast()].x = newx;
							horses[temp.peekLast()].y = newy;
							map_list[newx][newy].add(String.valueOf(temp.pollLast()));
						}
						if(map_list[newx][newy].size() >= 4) {
							return true;
						}
						break;
					}
				}
				// 한칸 뒤 자리가 B인 경우
				else {
//					System.out.println("front is out behind is B");
					while(!temp.isEmpty()) {
						horses[temp.peekFirst()].x = nowx;
						horses[temp.peekFirst()].y = nowy;
						map_list[nowx][nowy].add(String.valueOf(temp.pollFirst()));
					}
					if(map_list[nowx][nowy].size() >= 4) {
						return true;
					}
//					System.out.println(map_list[nowx][nowy]);
				}
			}
		}
		return false;
	}
}

class horse {
	int x, y, d;

	horse(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}