package TestBackJoon;

/*
 * 문제명: 숨바꼭질3
 * 일자: 22.09.02.금
 * https://www.acmicpc.net/problem/13549
 * 문제풀이: BFS
 * 입력1: 
5 17
 * 출력1:
2
 * 입력2: 
1 2
 * 출력2:
0
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220903T13549HideAndSeek3 {
	static final int MAX = 100001;
	static int N, K;
	static boolean[] visited = new boolean[MAX];
	static int[] map = new int[MAX];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		
		System.out.print(map[K]);
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x + " / ");

			if(x == K) {
				break;
			}
			
			// *2인 경우에 0초므로 최고 빨리 이동하니 이동 조건을 가장 최우선으로 고려해야 함.
			int[] move = {x*2, x-1, x+1};
			int[] second = {0, 1, 1};
			for(int i = 0; i < 3; i++) {
				int nx = move[i];
				if(nx < 0 || nx >= MAX) continue;
				
				if(!visited[nx]) {
					queue.add(nx);
					map[nx] = map[x] + second[i];
					visited[nx] = true;
				}
			}
		}
	}
}