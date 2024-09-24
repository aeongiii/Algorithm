import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		Map<String, Boolean> dance = new HashMap<>(); //이름과 true or false를 저장, true 면 춤을 춘다.
		for(int i = 0; i < N; ++ i)
		{
			st = new StringTokenizer(br.readLine());
			
			String p1 = st.nextToken(); //첫 번째 이름을 받아옴
			String p2 = st.nextToken(); //두 번째 이름을 받아옴
			
			if(p1.equals("ChongChong") == true || p2.equals("ChongChong") == true)
			{ //총총이라는 이름이 있다면 둘 다 춤추게 만듦
				dance.put(p1, true); 
				dance.put(p2, true);
				continue;
			}
			if(dance.containsKey(p1) == true)
			{ //한 명이라도 춤을 추고 있다면 나머지도 춤을 추게 만든다.
				if(dance.get(p1) == true) 
				{
					dance.put(p2, true);
					continue;
				}
			}
			if(dance.containsKey(p2) == true)
			{ //한 명이라도 춤을 추고 있다면 나머지도 춤을 추게 만든다.
				if(dance.get(p2) == true)
				{
					dance.put(p1, true);
					continue;
				}
			}
            //아무도 춤을 추고 있지 않다면 둘 다 false로 저장
			dance.put(p1, false);
			dance.put(p2, false);
		}
		int count = 0;
		Set<Entry<String, Boolean>> entrySet = dance.entrySet(); //dance 엔트리 셋을 가져옴
		Iterator<Entry<String, Boolean>> entryIterator = entrySet.iterator(); //entrySet의 이터레이터를 가져옴
		while (entryIterator.hasNext()) {
			Entry<String, Boolean> entry = entryIterator.next();
			Boolean v = entry.getValue(); //이터레이터의 값을 가져옴
			if(v == true) ++count; // 값이 true면 count를 증가
		}
		System.out.print(count);
	}
}