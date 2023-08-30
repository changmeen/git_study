package Baekjoon.silver;
import java.io.*;

// 비밀번호 발음하기 - 실버 5
public class No_4659 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;

            int mo = 0, ja = 0;
            char last_mo = 0, last_ja = 0;
            boolean pass = false;
            for(int i = 0; i < str.length(); i++){
                char now = str.charAt(i);
                
                if(now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u'){
                    if(!pass) pass = true;
                    mo++;
                    // sb.append(now + " " + mo + "\n");

                    if(ja > 0){
                        ja = 0;
                        last_ja = 0;
                    }
                    
                    if(mo == 2){
                        if(last_mo == now){
                            if(now != 'e' && now != 'o'){
                                pass = false;
                                break;
                            }
                        }
                    }
                    if(mo == 3){
                        pass = false;
                        break;
                    }
                    last_mo = now;
                }
                else{
                    ja++;
                    // sb.append(now + " " + ja + "\n");
                    if(mo > 0){
                        mo = 0;
                        last_mo = 0;
                    }

                    if(ja == 2){
                        if(last_ja == now){
                            pass = false;
                            break;
                        }
                    }
                    if(ja == 3){
                        pass = false;
                        break;
                    }
                    last_ja = now;
                }
            }

            if(pass){
                sb.append("<" + str + ">" + " is acceptable.\n");
            }
            else{
                sb.append("<" + str + ">" + " is not acceptable.\n");
            }
        }
        System.out.println(sb);
    }
}
