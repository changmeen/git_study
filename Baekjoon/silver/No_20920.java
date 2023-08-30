package Baekjoon.silver;
import java.io.*;
import java.util.*;
import java.util.stream.*;

// 영단어 암기는 괴로워 - 실버 3
public class No_20920 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> hm = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            if(s.length() >= M){
                hm.put(s, hm.getOrDefault(s, 0) + 1);
            }
            else continue;
        }
        List<String> words = hm.keySet().stream().collect(Collectors.toList());
        words.sort((o1, o2) -> {
            int f1 = hm.get(o1);
            int f2 = hm.get(o2);

            if(f1 != f2){
                return f2 - f1;
            }else{
                if(o2.length() != o1.length()){
                    return o2.length() - o1.length();
                }
                else{
                    return o1.compareTo(o2);
                }
            }
        });

        for(int i = 0; i < words.size(); i++){
            sb.append(words.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}