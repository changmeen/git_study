package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 경쟁적 전염 - 골드 5
public class No_18405 {

    static int n, k, s;
    static int target_x, target_y;
    static int map[][];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<position> q = new LinkedList<>();

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        ArrayList<position> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0){
                    list.add(new position(i, j, map[i][j], 0));
                }
            }
        }

        Collections.sort(list, new Comparator<position>() {
            @Override
            public int compare(position o1, position o2){
                return o1.virus - o2.virus;
            }
        });

        for(position pos : list){
            q.add(pos);
        }

        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        target_x = Integer.parseInt(st.nextToken()) - 1;
        target_y = Integer.parseInt(st.nextToken()) - 1;

        bfs();

        System.out.println(map[target_x][target_y]);
    }

    static void bfs(){
        while(!q.isEmpty()){
            position p = q.poll();

            if(p.cnt == s) return;

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if(map[nx][ny] == 0){
                        map[nx][ny] = p.virus;
                        q.add(new position(nx, ny, p.virus, p.cnt + 1));
                    }
                }
            }
        }
    }
}

class position{
    int x;
    int y;
    int virus;
    int cnt;

    position(int x, int y, int virus, int cnt){
        this.x = x;
        this.y = y;
        this.virus = virus;
        this.cnt = cnt;
    }
}