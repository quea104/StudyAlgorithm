package TestProgrammers;

/*
 * 문제명: 양궁대회
 * 일자: 22.08.24.수
 * https://school.programmers.co.kr/learn/courses/30/lessons/92342
 * 풀이: 완전탐색 - BFS(Breadth-First Search), 백트래킹
 */

import java.util.*;

public class D220824level1_92342 {
	static int N;
	static int[] apeach = new int[11];
	static int[] lion = new int[11];
	static int diff = -Integer.MAX_VALUE;
	static int[] result = {-1};
	
	public static void dfs(int count) {
		if(count == N) {
			int lionScore = 0;
			int apeachScore = 0;
			
			for(int i = 0; i <= 10; i++) {
				// 어피치 기준으로 계산 해야 함
				if(apeach[i] > 0 || lion[i] > 0) {
					if(lion[i] > apeach[i]) {
						lionScore += 10-i;
					}
					else {
						apeachScore += 10-i;
					}
				}
			}
			
			// 점수의 최소값을 구해야 하므로 라이언과 어피치 점수의 차이값으로 비교
			if(apeachScore < lionScore && lionScore-apeachScore >= diff) {
				diff = lionScore-apeachScore;
				result = lion.clone();
			}
			
			return;
		}
		
		for(int i = 0; i <= 10; i++) {
			// 백트래킹 구간 -> 가장 낮은 점수를 구해야 하므로
			if(lion[i] > apeach[i])
				break;
			
			lion[i]++;			
			dfs(count+1);
			lion[i]--;
		}
	}
	
	public static void main(String[] args) {
		int n = 10;
		int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
		
		N = n;
		apeach = info;
		
		dfs(0);

		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}	
}