package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 상어 초등학교 - 골드 5
public class No_21608 {
    
    static int N, sum = 0;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] students;
    static Map<Integer, Set<Integer>> preferences;
    public static void main(String args[]) throws IOException {
        init();
        solution();
        System.out.println(sum);
    }

    static void solution(){
        for(int i = 0; i < students.length; i++){
            mate seat = findSeat(students[i]);
            map[seat.x][seat.y] = students[i];
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int cnt = getStudentSum(i, j, map[i][j]);
                if(cnt > 0) sum += (int) Math.pow(10, cnt - 1);
            }
        }
    }

    static mate findSeat(int num){
        mate m = null;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] > 0) continue;

                mate n = new mate(i, j, getStudentSum(i, j, num), getEmptySum(i, j));
                if(m == null){
                    m = n;
                    continue;
                }

                if(m.compareTo(n) > 0) m = n;
            }
        }

        return m;
    }

    static int getStudentSum(int x, int y, int num){
        int cnt = 0;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                if(preferences.get(num).contains(map[nx][ny])) cnt++;
            }
        }

        return cnt;
    }

    static int getEmptySum(int x, int y){
        int cnt = 0;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                if(map[nx][ny] == 0) cnt++;
            }
        }

        return cnt;
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        students = new int[N * N];
        preferences = new HashMap<>();

        for(int i = 0; i < Math.pow(N, 2); i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            students[i] = num;
            preferences.put(num, new HashSet<>());
            for(int j = 0; j < 4; j++) preferences.get(num).add(Integer.parseInt(st.nextToken()));
        }
    }
}

class mate implements Comparable<mate> {
    int x, y, studentSum, emptySum;

    mate(int x, int y, int studentSum, int emptySum){
        this.x = x;
        this.y = y;
        this.studentSum = studentSum;
        this.emptySum = emptySum;
    }

    @Override
    public int compareTo(mate o){
        // studentsum과 emptysum은 더 큰 값이 우선순위가 높기에 앞에 -를 붙이고
        if(studentSum != o.studentSum) return -(this.studentSum - o.studentSum);

        if(emptySum != o.emptySum) return -(this.emptySum - o.emptySum);

        // x와 y는 작을 수록 우선순위가 높기에 그냥 this - o를 한다
        if(x != o.x) return this.x - o.x;

        return this.y - o.y;
    }
}