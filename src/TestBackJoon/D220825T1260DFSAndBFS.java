package TestBackJoon;
/*
 * 문제명: DFS와 BFS
 * 일자: 22.08.25.목
 * https://www.acmicpc.net/problem/1260
 * 문제내용: 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 * 문제풀이: DFS, BFS 기초
 * 입력: 
4 5 1
1 2
1 3
1 4
2 4
3 4
 * 출력:
1 2 4 3
1 2 3 4
 */

import java.io.*;
import java.util.*;

public class D220825T1260DFSAndBFS {
	static boolean[] visited;
	static LinkedList<Integer>[] adjList;
	
	static void addEdge(int n, int e) {
		adjList[n].add(e);
	}
	
	// Depth First Search; 깊이 우선 탐색
	static void dfs(int v, int depth) {
		if(depth == visited.length) {
			return;
		}
		
		// v 정점 방문 처리
		visited[v] = true;
		// v 출력
		System.out.print(v + " ");
		
		// 방문한 노드와 인접한 모든 노드 가져오기
		Iterator<Integer> it = adjList[v].listIterator();
		while(it.hasNext()) {
			int n = it.next();
			
			// 비방문한 노드이면 해당 노드를 시작 노드로 다시 dfs() 호출
			if(!visited[n]) {
				dfs(n, depth+1);
			}
		}
	}
	
	// Breadth First Search; 너비 우선 탐색
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
				
		// v 정점 방문 처리
		visited[v] = true;
		
		// 방문할 v 정점 추가
		queue.add(v);
		
		while(!queue.isEmpty()) {
			// 방문한 노드를 큐에서 추출(dequeue 처리) 하고 값을 출력
			v = queue.poll();
			// v 출력
			System.out.print(v + " ");
			
			// 방문한 노드와 인접한 모든 노드 가져오기
			Iterator<Integer> it = adjList[v].listIterator();
			while(it.hasNext()) {
				int n = it.next();
				if(!visited[n]) {
					visited[n] = true; // n 정점 방문 처리
					queue.add(n); // 방문할 n 정점 추가
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken())+1;
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		adjList = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			addEdge(x, y);
			addEdge(y, x);
		}

		// 정점 번호가 작은 것을 먼저 방문해야 하므로 정렬
		for(int i = 0; i < n; i++) {
			Collections.sort(adjList[i]);
		}

		visited = new boolean[n];
		dfs(v, 1);
		System.out.println();

		visited = new boolean[n];
		bfs(v);
	}
}
