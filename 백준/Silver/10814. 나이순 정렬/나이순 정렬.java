/*
1. 문제 분석
    1) N명의 나이와 이름이 순서대로 주어지면, 나이순 + 기존 순서대로 정렬한다.

2. 제약 조건
    1) 1 <= N <= 100000
    2) 1 <= 나이 <= 200
    3) 1 <= 이름 길이 <= 100

3. 최초 의사결정
    1) N을 받는다.
    2) N만큼 for문 돌리면서 해시맵에 입력받는다.
    3) Key순으로 정렬한다.
    - 정렬하려면 저번에 배운 map.entrySet()을 쓰면 될듯.. 근데 동명이인이 있으면..?
    - 그러면 나이가 같다면 기존순을 유지하지 않나..?

           
4. 문제풀면서 수정한 부분
    1) 해시맵을 사용하면 같은 key를 여러개 저장할 수 없으므로 나중에 입력된 사람이 덮어씌워진다.
        나이 + 이름 + 순서? 를 넣은 list를 사용하자.
    2) 정렬 기준은 두가지
    - 나이 오름차순
    - 가입 순서 오름차순 
    3) Collections.sort()는 기본적으로 안정 정렬이다. 그러나 학습을 위해 가입 순서까지 비교해주자
    * Collections.sott()는 TimSort(합병 정렬 + 삽입 정렬이 섞인 알고리즘)를 사용한다. 
    * TimSort처럼 두가지가 섞인 정렬 알고리즘을 hybrid sorting algorithm이라고 한다.
    * 안정 정렬 : 값이 같은 원소의 전후관계가 바뀌지 않는 정렬 알고리즘


 */

 import java.io.*;
 import java.util.*;

 public class Main {

    static class Member {
        int age;
        String name;
        int order;
    
        public Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Member> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(age, name, i)); // 가입 순서 = i = 0부터 시작
        }

        // 
        Collections.sort(list, (o1, o2) -> {    
            if(o1.age == o2.age) return o1.order - o2.order; // 나이 같으면 가입순서 똑같이 하고
            return o1.age - o2.age; // 나이 오름차순 정렬
        });

        StringBuilder sb = new StringBuilder();
        for (Member m : list) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.println(sb);
    }
 }