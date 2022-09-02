package TestBackJoon;

/*
 * 문제명: 숨바꼭질2
 * 일자: 22.08.30.화~09.01.목
 * https://www.acmicpc.net/problem/1697
 * 문제풀이: BFS
 * 입력1: 
5 17
 * 출력1:
4
2
 * 입력2: 
1 4
 * 출력2:
2
2
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220830T12851HideAndSeek2 {
	static final int MAX = 1000001;
	static int[] map = new int[MAX];
	static boolean[] visited = new boolean[MAX];
	static int N, K, count = 0, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 형 위치가 동생 위치보다 먼저이거나 같을 경우
		if(N >= K) {
			// -1 이동 방법으로만 이동 가능함.
			System.out.print((N-K)+"\n"+1);
		}
		else {
			bfs();
			System.out.print(min+"\n"+count);	
		}
	}

	// 메모리 293840 KB, 시간 412 ms
	static void bfs() {
		Queue<Pair> queue = new LinkedList<Pair>();

		// ★★Queue에 같은 위치에 걸리는 시간의 개수가 여러개일 수 있으므로 위치도 함께 저장함
		queue.add(new Pair(N, 0));

		while(!queue.isEmpty()) {
			Pair now = queue.poll();
			int x = now.x;
			int move = now.move;
			
			// ★★현재 위치를 방문 처리 -> 같은 지점에 걸린 시간이 여러개 존재할 수 있으므로 방문 여부 처리를 push가 아닌 pop할 때 해줌.
			visited[x] = true;

			// ★최소시간보다 현재 걸린 시간이 이상이면 탐색 종료
			if(min < move) return;
			
			if(x == K) {
				System.out.println();
				
				if(min > move)
					min = move; // 가장 빠른 시간 
				 
				if(move == min)
					count++;
				
				continue; // 도착 지점 도달했으므로 해당 탐색은 종료
			}
			
			int[] moveArr = {x-1, x+1, x*2};
			for(int i = 0; i < 3; i++) {
				int nx = moveArr[i];
				
				if(nx < 0 || nx >= MAX) continue;
				
				if(!visited[nx]) {
					queue.add(new Pair(nx, move+1));
				}
			}
		}
	}
	public static class Pair{
		int x;
		int move;
		public Pair(int x, int move){
			this.x = x;
			this.move = move;
		}
	}
	
	// 메모리 123536 KB, 시간 316 ms
	static void bfs2() {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(N);

		// ★★동일한 위치에 재방문해야 하므로 방문 여부 확인 안함
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			// ★최소시간보다 현재 걸린 시간이 이상이면 탐색 종료
			if(min < map[x]) return;
			
			if(x == K) {
				if(min > map[K])
					min = map[K]; // 가장 빠른 시간 
				 
				if(map[K] == min)
					count++;
				
				continue; // 도착 지점 도달했으므로 해당 탐색은 종료
			}
			
			int[] moveArr = {x-1, x+1, x*2};
			for(int i = 0; i < 3; i++) {
				int nx = moveArr[i];
				
				if(nx < 0 || nx >= MAX) continue;
				
				/* ★★ nx로 이동 전에 이동 가능 여부 확인 = push 조건9
				 * 1. 첫 방문
				 * 2. 1->4로 이동할 때 위치1에서 이동하면 2=1+1과 2=1*2 로 두가지 방법으로 같은 지점을 이동할 수 있음
				 	즉, 현재 위치 1에서 이동하는 방법의 수를 점검할 때 
				 	1+1 이동하는 방법 확인 시 위치 2에 최초 방문이므로 이동이 가능하며 map[2] 값 저장해준 후에
				 	1*2 이동하는 방법 확인 시 1+1에서 위치 2를 이미 방문하였으므로 map[2] 값이 현재 위치 값인 map[1]에 1을 더해준 값보다 크면 최소 이동 수를 찾는거니 재방문 하지 않음
				 */ 
				if(map[nx] == 0 || map[nx] == map[x] + 1) {
					queue.add(nx);
					map[nx] = map[x] + 1;
				}
			}
		}
	}
}