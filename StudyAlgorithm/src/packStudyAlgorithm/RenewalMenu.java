package packStudyAlgorithm;

/*
 * 문제: https://programmers.co.kr/learn/courses/30/lessons/72411
 * 
 * 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성
 * 최소 2가지 이상의 단품메뉴로 구성
 * 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함
 * 
 * 풀이방법:
 * 조합
 * 퇴각검색(backtracking)
 *  - 해를 찾는 도중 해가 아니어서 막히면, 되돌아가서 다시 해를 찾아가는 기법
 *  - 반복문의 횟수까지 줄일 수 있음 => 가지치기, 불필요한 부분을 쳐내고 최대한 올바른 쪽으로 간다
 *  - DFS(깊이 우선탐색: 가능한 모든 경로(후보)를 탐색)을 통하여 구현 
 * https://bcp0109.tistory.com/entry/%EC%A1%B0%ED%95%A9-Combination-Java
 */


public class RenewalMenu {

	/*
	 * String[] orders
	 * 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders (크기는 2 이상 20 이하)
	 * 각 원소는 크기가 2 이상 10 이하인 문자열 / 알파벳 대문자 / 같은 알파벳이 중복 X
	 * 
	 * int[] course
	 * 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course (크기는 1 이상 10 이하)
	 * 각 원소는 2 이상 10 이하인 자연수 / 오름차순 / 같은 값이 중복 X
	 * 
	 * String[] answer
	 * 사전 순으로 오름차순 정렬
	 * 
	 */ 
	public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        
        
        
        
        return answer; // 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태 배열
    }
	
	private String[] combination(String order, int start, int n, int r) {
		String[] comOrder = {};
		for(int i = 0; i < order.length(); i++) {
			
		}
		return comOrder;
	}
}
