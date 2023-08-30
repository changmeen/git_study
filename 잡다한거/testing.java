package 잡다한거;
import java.util.*;

class testing {
    // 채팅방에서 기억해야 하는 맴버의 수를 나타내고 link에서 노드로 쓴다
    static int node = 0;
    // member는 어떤 uid가 어떤 닉네임을 쓰는지를 저장한다
    static HashMap<String, String> member = new HashMap<>();
    // 링크는 한 uid가 몇번 노드인지 저장해 두기 위해서 사용, location과 연동해서 쓴다
    static HashMap<String, Integer> link = new HashMap<>();
    // 한 uid가 몇번째 줄에 등장 했는지 저장해두기 위한 location Arraylist 그래프(노드로 표현하기 위해)
    static ArrayList<ArrayList<Integer>> location = new ArrayList<ArrayList<Integer>>();
    static String[] answer;
    
    public static void main(String args[]) {
      String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
// member는 어떤 uid가 어떤 닉네임을 쓰는지를 저장한다
    
    for(int i = 0; i < record.length; i++){
        String[] str = record[i].split(" ");
        
        // 입장인 경우
        if(str[0].equals("Enter")){
            // 해당 uid로 들어온 사람이 없던 경우 새로 맴버 hashmap에 추가
            if(!member.containsKey(str[1])){
                member.put(str[1], str[2]);
                answer[i] = str[1] + "님이 들어왔습니다.";
            }
            // 해당 uid로 입장한 적이 있던 사람이면 nickname 변경
            else{
                member.replace(str[1], str[2]);
                answer[i] = str[1] + "님이 들어왔습니다.";
            }
        }
        // 해당하는 uid의 멤버가 떠난 경우
        else if(str[0].equals("Leave")){
            answer[i] = str[1] + "님이 나갔습니다.";
        }
        // 해당하는 uid의 멤버가 Nick Name을 교체한 경우
        else{
            member.replace(str[1], str[2]);
        }
    }
    
    replaceName();
    
    return answer;
}

static void replaceName(){
    for(int i = 0; i < answer.length; i++){
        String[] temp = answer[i].split("님이");
        temp[0] = member.get(temp[0]);
        
        String tmp = "";
        for(int j = 0; j < temp.length; j++){
            tmp += temp[j];
            if(i == 0) tmp += "님이";
        }
        
        answer[i] = tmp;
    }
}
}