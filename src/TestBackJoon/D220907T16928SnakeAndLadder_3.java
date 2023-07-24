package TestBackJoon;

/*
 * 문제명: 뱀과 사다리 게임
 * 일자: 22.09.07.수
 * https://www.acmicpc.net/problem/16928
 * 문제풀이: BFS
 * 입력:
3 7
32 62
42 68
12 98
95 13
97 25
93 37
79 27
75 19
49 47
67 17
 * 출력:
3
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220907T16928SnakeAndLadder_3 {
	
	public static void main(String[] args) throws IOException {
		final int MAX = 101;
		int[] board = new int[MAX];
		boolean[] visited = new boolean[MAX];
		int time = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		while(sum-- > 0) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		final int MASK = 1023;
		int[] queue = new int[MASK+1]; // -> FIFO 선입선출
		int head = -1; // 앞 front - 앞에서 자료 추출
		int tail = -1; // 뒤 rear - 뒤에서 자료 추가
		
		visited[1] = true;
		queue[++tail] = 1;
		
		while(head < tail) {
			int size = tail - head;
			
			while(size-- > 0) {
				int o = queue[++head & MASK]; // &: 비트 논리곱
				if(o == 100) {
					System.out.print(time);
					return;
				}
				
				int j = board[o];
				if(j > 0) visited[o = j] = true;
				
				for(j = o+6; j > o; j--) {
					if(j > 100 || visited[j]) continue;
					visited[j] = true;
					queue[++tail & MASK] = j;
				}
			}
			
			time++;
		}
		
	}
}