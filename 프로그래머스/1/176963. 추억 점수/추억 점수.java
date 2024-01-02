import java.util.*;

class Solution{
   public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        HashMap<String,Integer> map = new LinkedHashMap<>();
        
        for(int i=0; i< name.length; i++){  // HashMap안에 인물+점수 넣기
            map.put(name[i], yearning[i]);
        }

        for(int i=0; i< photo.length; i++){ // 사진마다 배열 생성하기
            String[] persons = photo[i];
            int score = 0;
            
            for(int j=0; j<persons.length; j++){ // 인물 하나씩 for문 돌면서
            	
                String person = persons[j];
                if(map.containsKey(person)){     // 그 인물이 사진에 포함됐으면
                    score+=map.get(person);      // 점수 합산
                }
            }
            answer[i]=score;
        }
        return answer;
    }
  }