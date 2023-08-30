package Baekjoon.platinum;
import java.io.*;
import java.util.*;

// 가장 가까운 두 점 - 플래티넘2 실패함
public class No_2261 {

    static Point[] p;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        p = new Point[n];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(p, Xcomp);

        System.out.println(closest(0, n - 1));
    }

    static int dist(Point o1, Point o2){
        return(o1.x - o2.x) * (o1.x - o2.x) + (o1.y - o2.y) * (o1.y - o2.y);
    }

    static int brute(int start, int end){
        int minDist = Integer.MAX_VALUE;

        for(int i = start; i < end; i++){
            for(int j = i + 1; j <= end; j++){
                minDist = Math.min(minDist, dist(p[i], p[j]));
            }
        }

        return minDist;
    }

    static Comparator<Point> Xcomp = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2){
            return o1.x - o2.x;
        }
    };

    static Comparator<Point> Ycomp = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2){
            return o1.y - o2.y;
        }
    };

    static int closest(int start, int end){
        if(end - start + 1 < 4){
            return brute(start, end);
        }

        int mid = (start + end) / 2;

        int left = closest(start, mid);
        int right = closest(mid + 1, end);

        int minDist = Math.min(left, right);
        int band = middleBand(start, mid, end, minDist);

        return Math.min(minDist, band);
    }

    static int middleBand(int start, int mid, int end, int minDist){
        int xDist;

        ArrayList<Point> list = new ArrayList<>();

        int midX = p[mid].x;
        for(int i = start; i <= end; i++){
            xDist = p[i].x - midX;

            if(xDist * xDist < minDist) list.add(p[i]);
        }

        Collections.sort(list, Ycomp);

        int yDist;
        for(int i = 0; i < list.size() - 1; i++){
            for(int j = i + 1; j < list.size(); j++){
                yDist = list.get(i).y - list.get(j).y;
                if(yDist * yDist < minDist){
                    minDist = Math.min(dist(list.get(i), list.get(j)), minDist);
                }

                else{
                    break;
                }
            }
        }
        return minDist;
    }
}

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}