package TestBackJoon;

/*
 * 문제명: 이분 그래프
 * 일자: 22.09.19.월
 * https://www.acmicpc.net/problem/1707
 * 문제풀이: BFS, DFS, https://hongjw1938.tistory.com/117
  	1. 최초 탐색 시작할 정점의 색상을 빨간색으로 칠한다.(숫자 1로 표현)
	2. 최초 정점의 인접 정점의 색상을 파란색으로 칠한다.(숫자 -1로 표현)
	3. 해당 인접 정점들을 차례로 탐색을 시작하며 자신과 인접한 정점을 빨간색으로 칠한다.(숫자 1로 표현)
	4. 이와 같은 방식을 탐색을 지속하며 반복하여 2개의 색상으로 모두 칠한다.
	5. 색상을 칠하다가 이웃 정점이 같은 색으로 칠해져 있다면 이분 그래프가 될 수 없다.
 * 입력:
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2
 * 출력:
YES
NO
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220919T1707BipartiteGraph {
	static ArrayList<ArrayList<Integer>> adjList;
	static int[] visited;
	static final int RED = 1, BLUE = -1;
	static boolean check;
	static int V, E;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		while(K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			check = true;
			visited = new int[V+1];
			adjList = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i < V+1; i++) {
				adjList.add(new ArrayList<Integer>());
			}
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
				adjList.get(x).add(y);
				adjList.get(y).add(x);
			}
			
            // 연결 그래프와 비연결 그래프(모든 정점을 돌면서 확인) 모두 고려
			for(int v = 1; v < V+1; v++) {
				if(!check) break;
				
				// 방문하지 않은 정점에 대해서 탐색 수행
				if(visited[v] == 0) {
					//bfs(v); // 너비 우선 탐색
					dfs(v, RED); // 깊이 우선 탐색
				}
			}
			sb.append(check ? "YES" : "NO").append("\n");
		}
		
		System.out.print(sb.toString());
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = RED;
		
		while(!queue.isEmpty()) {
			v = queue.poll();
			
			for(int nv:adjList.get(v)) {
				if(visited[nv] == visited[v]) {
					check = false;
					return;
				}
				
				if(visited[nv] == 0) {
					queue.add(nv);
					visited[nv] = -visited[v];
				}
			}
		}
	}

	private static void dfs(int v, int color) {
		visited[v] = color;
		for(int nv:adjList.get(v)) {
			if(visited[nv] == visited[v]) {
				check = false;
				return;
			}
			
			if(visited[nv] == 0) {
				dfs(nv, -visited[v]);
			}
		}
	}
}