package PGS_220503;

import java.util.LinkedList;

public class PGS_17680_캐시 {

	static final int HIT = 1; // 있어서 맨 앞으로 다시 넣기
	static final int MISS = 5;// 없어. 암튼 5!

	public int solution(int cacheSize, String[] cities) {

		// 만약 cities에 하나도 안 들어가 있는경우, 모두 miss인 경우이므로 길이만큼 5를 곱함
		if (cacheSize == 0)
			return MISS * cities.length;
		// 정답을 담을 숫자
		int answer = 0;
		// 링크드리스트의 remove는, 가장 첫 번째 원소를 찾기 때문에 직접 해보자
		// 또한, 가장 앞에 있는 원소가, 가장 안 쓰인 원소임!
		LinkedList<String> cache = new LinkedList<>();

		for (int i = 0; i < cities.length; i++) {
			// 대소문자 구분 X
			String city = cities[i].toUpperCase();
			// 만약 city라는게 있고 지웠으면, 
			// remove는 있으면 true, 없으면 false 반환함 => 조건으로 사용가능
			if (cache.remove(city)) {
				cache.addFirst(city); // 맨 앞에 넣기 - que처럼 작동
				answer += HIT;
			}
			// 만약 city 원소가 없으면
			else {

				// 현재 size와 cache의 사이즈를 비교해서,
				if (cacheSize == cache.size()) {
					// 같으면 맨앞거 빼고 맨 뒤에 추가
					cache.pollLast();
				}
				// 그냥 추가
				cache.addFirst(city);
				answer += MISS;

			}
		}
		return answer;
	}

}
