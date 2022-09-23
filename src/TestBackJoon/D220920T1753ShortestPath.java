package TestBackJoon;

/*
 * 문제명: 최단경로
 * 일자: 22.09.20.화~22.09.22.목
 * https://www.acmicpc.net/problem/1753
 * 문제풀이: BFS, DP
 * 입력1:
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 * 출력1:
0
2
3
7555555 
INF
 * 입력2:
6 9
1
1 2 7
1 3 9
1 6 14
2 3 10
2 4 15
3 4 11
3 6 2
4 5 6
5 6 9
 * 출력2:
0
7
9
20
26
11
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220920T1753ShortestPath {
	static final int INF = 987654321; // infinite 무한대
	static int V, E, K;
	static int[][] graph;
	static boolean[] visited; // 해당 노드를 방문했는지 체크할 변수
	static int[] distance;  // 최단 거리를 저장할 변수
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		graph = new int[V+1][V+1];
		visited = new boolean[V+1];
		distance = new int[V+1];
		
		// 인접행렬, distance값 무한대로 초기화
		for(int i = 1; i <= V; i++) {
			distance[i] = INF;
			for(int j = 1; j <= V; j++) {
				graph[i][j] = INF;
			}
		}
		
		// 인접행렬에 가중치 넣기
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())
				, v = Integer.parseInt(st.nextToken())
				, w = Integer.parseInt(st.nextToken());
			
			graph[u][v] = w;
		}
		
		dijkstra();

		for(int i = 1; i <= V; i++) {
			sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
		}
		
		System.out.print(sb.toString());
	}

	private static void dijkstra() {
		// 시작노드값 초기화
		distance[K] = 0;
		visited[K] = true;

		// 연결노드 distance갱신
		for(int i = 1; i <= V; i++) {
			if(!visited[i] && graph[K][i] != INF)
				distance[i] = graph[K][i];
		}
		
		print();
		
		// 반복수는 V-2번
		for(int a = 0; a < V-1; a++) {
			// 노드 최소값 찾기
			int minDist = INF, minIndex = -1;
			for(int i = 1; i <= V; i++) {
				if(visited[i]) continue;
				
				if(distance[i] < minDist) {
					minDist = distance[i];
					minIndex = i;
				}
			}
			if(minIndex == -1)
				return;
			
			visited[minIndex] = true;
			
			// 다른 노드를 거쳐서 가는 것이 더 비용이 적은지 확인
			for(int i = 1; i <= V; i++) {
				if(visited[i]) continue;
				if(graph[minIndex][i] == INF) continue;
				
				int d = distance[minIndex] + graph[minIndex][i];
				if(distance[i] > d) {
					distance[i] = d;
				}
			}
			
			print();
		}
	}
	
	static void print() {
		 // 결과값 출력
        for(int i = 1; i <= V; ++i){
        	if(distance[i] == INF) System.out.print("INF ");
        	else System.out.print(distance[i]+" ");
        }
        System.out.println("");
	}
}