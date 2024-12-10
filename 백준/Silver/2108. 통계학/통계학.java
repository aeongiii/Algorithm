
import java.io.*;
import java.util.*;

public class Main {

    static int N, total;
    static TreeMap<Integer, Integer> treeMap;
    static List<Integer> keyList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 숫자의 개수
        N = Integer.parseInt(br.readLine());

        total = 0;

        // 저장할 TreeMap 선언(오름차순 정렬)
        treeMap = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
            total += num;
        }

        // 키 리스트
        keyList = new ArrayList<>(treeMap.keySet());

        // 호출
        sb.append(call1()).append("\n");
        sb.append(call2()).append("\n");
        sb.append(call3()).append("\n");
        sb.append(call4()).append("\n");

        // 출력
        System.out.println(sb);
    }

    // 1. 산술평균
    private static int call1() {
        double result = (double) total / N;
        return (int) Math.round(result); // 반올림 후 명시적 캐스팅
    }

    // 2. 중앙값
    private static int call2() {
        int count = 0;
        int mid = (N + 1) / 2; // N은 항상 홀수

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            count += entry.getValue();
            if (count >= mid) {
                return entry.getKey(); // 중앙값 반환
            }
        }
        return 0; // 실행되지 않음
    }

    // 3. 최빈값
    private static int call3() {
        ArrayList<Integer> list = new ArrayList<>();
        int maxFrequency = Collections.max(treeMap.values());

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                list.add(entry.getKey());
            }
        }

        // 최빈값이 여러 개일 경우 두 번째로 작은 값 반환
        if (list.size() > 1) {
            Collections.sort(list);
            return list.get(1);
        }

        // 유일한 최빈값 반환
        return list.get(0);
    }

    // 4. 범위
    private static int call4() {
        return keyList.get(keyList.size() - 1) - keyList.get(0);
    }
}
