package 잡다한거.Implementation;
import java.io.*;
import java.util.*;

public class Implementation_2 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, x, y, direction;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // N, M값 읽고 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // Player의 row, col, direction 정보 읽고 입력
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        // 육지와 바다 정보를 담을 map
        int[][] map = new int[N][M];
        // 지도의 해당 부분의 방문 여부를 판단하는 visited
        boolean[][] visited = new boolean[N][M];

        // 육지 바다 정보를 읽고 map에 입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방문한 육지 칸 수를 세기 위한 cnt와 각 지점에서 상하좌우를 살핀 횟수를 체크하는 turn_time
        int cnt = 1;
        int turn_time = 0;
        // 가장 최초 시작 지점은 이미 방문 했으니 true로 설정
        visited[x][y] = true;

        while(true){
            // 현재 위치에서 일단 왼쪽부터 봐야하니 turn_left실행
            turn_left();
            // 지금 direction에서 왼쪽 방향으로의 칸 좌표를 nx, ny에 담음 -> 살펴볼 칸
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 살펴보고 있는 칸이 육지이고 방문한 적이 없으면 해당 칸으로 이동
            if(map[nx][ny] == 0 && !visited[nx][ny]){
                visited[nx][ny] = true;
                x = nx;
                y = ny;
                cnt++;

                // 새로운 칸으로 이동 했으니 turn_time 초기화 후 다음 while문으로 이동
                turn_time = 0;
                continue;
            }

            // 살펴본 칸이 육지가 아니거나 방문한 적이 있으면 turn_time++
            else{
                turn_time++;
            }

            // turn_time이 4 즉 지금 위치 칸에서 상하좌우를 모두 살펴봤는데 이동이 불가
            if(turn_time == 4){
                // 처음 direction에서 뒷 방향으로 한칸 이동
                nx = x - dx[direction];
                ny = y - dy[direction];

                // 단 뒷칸이 육지여야만 함
                if(map[nx][ny] == 0){
                    x = nx;
                    y = ny;

                    // 육지인 뒷칸으로 다시 왔으니 turn_left 초기화
                    turn_time = 0;
                }

                // 육지가 아니라면 종료
                else{
                    break;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void turn_left(){
        direction--;
        if(direction == -1){
            direction = 3;
        }
    }
}
