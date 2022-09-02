package TestBackJoon;

/*
 * 문제명: 숨바꼭질
 * 일자: 22.08.30.화
 * https://www.acmicpc.net/problem/1697
 * 문제풀이: BFS
 * 입력: 
5 17
 * 출력:
4
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220830T1697HideAndSeek {
	static final int MAX = 100001;
	static int[] map = new int[MAX];
	static boolean[] visited = new boolean[MAX];
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		
		System.out.print(map[K]);
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			if(x == K) { // 목적지 도달 시 break
				break;
			}

			int nextArr[] = {x-1, x+1, x*2};
			for(int i = 0; i < 3; i++) {
				int nx = nextArr[i];
				
				if(nx < 0 || nx >= MAX) continue;
				
				if(!visited[nx]) {
					queue.add(nx);
					map[nx] = map[x] + 1;	
					visited[nx] = true; // push 할 때 방문 처리 -> 한번 도달한 지점은 다시 방문하지 않도록						
				}
			}
		}
	}
}