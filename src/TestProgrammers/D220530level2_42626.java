package TestProgrammers;

/*
 * 문제명: 더 맵게
 * 일자: 22.05.30.월
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 * 도움말: ArrayList를 사용하면 시간초과 발생하므로 Heap을 사용해야 함.
 * 문제 설명
매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.

섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

제한 사항
scoville의 길이는 2 이상 1,000,000 이하입니다.
K는 0 이상 1,000,000,000 이하입니다.
scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
입출력 예
scoville	K	return
[1, 2, 3, 9, 10, 12]	7	2
입출력 예 설명
스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]

스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
가진 음식의 스코빌 지수 = [13, 9, 10, 12]

모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
 */

import java.util.*;

public class D220530level2_42626 {
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		int answer = 0;

		// 자바에서는 PriorityQueue (우선순위 큐)로 주어지며 자동으로 최소 힙으로 만들어진다.
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		for(int num: scoville) {
			heap.offer(num);
		}
		
		
		while(heap.peek() < K) {
			try {
				// 값을 넣는 순서에 상관없이 poll()을 하면 최솟값이 순서대로 나온다.
				int mixFood = heap.poll() + heap.poll()*2;
				heap.offer(mixFood);
				answer++;
				
				if(heap.peek() >= K) break;
				
				// 힙 사이즈가 1이 榮쨉 스코빌이 K보다 작으면 더 이상 만들 수 없으므로 answer = -1을 한다.
				if(heap.size() == 1 && heap.peek() < K) {
					answer = -1;
					break;
				}
			}
			catch(Exception e) {
				answer = -1;
			}
		}
		

        System.out.print(answer);
	}

	/*
	ArrayList 방식
	static int limit;
	static int answer = 0;
	static ArrayList<Integer> scovilleList = new ArrayList<Integer>();
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		limit = 7;
		for(int num: scoville) {
			scovilleList.add(num);
		}
		
		make();

        System.out.print(answer);
	}
	
	static void make() {
		if(check()) {
			return;
		}

		Collections.sort(scovilleList);
		
		mix(scovilleList.get(0), scovilleList.get(1));
		
		scovilleList.remove(0);
		scovilleList.remove(1);
		
		answer++;
		
		make();
	}
	
	static boolean check() {
		for(int i = 0; i < scovilleList.size(); i++) {
			if(scovilleList.get(i) <= limit) {
				return false;
			}
		}
		return true;
	}
	
	static int mix(int min, int secondMin) {
		return min + (secondMin*2);
	}
	*/

}
