package TestBackJoon;

/*
 * 문제명: 최단경로
 * 일자: 22.09.22.목
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
7
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
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220922T1753ShortestPath_2 {
	static final int INF = 987654321; // infinite 무한대
	static int V, E, K;
	static ArrayList<ArrayList<Node>> graph;
	static int[] distance;  // 최단 거리를 저장할 변수
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<ArrayList<Node>>();
		distance = new int[V+1];
		
		// 인접리스트, distance값 무한대로 초기화
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<Node>());
			distance[i] = INF;
		}
		
		// 인접리스트에 가중치 넣기
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())
				, v = Integer.parseInt(st.nextToken())
				, w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, w));
		}
		
		search();

		for(int i = 1; i <= V; i++) {
			sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
		}
		
		System.out.print(sb.toString());
	}

	private static void search() {
		// 노드까지의 거리를 저장할 우선순위 큐
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		
		// 시작 정점 초기화 <- 시작 정점에서 가장 짧은 정점은 시작 정점임
		queue.add(new Node(K, 0));
		distance[K] = 0;
		
		while(!queue.isEmpty()) {	
			// 노드 꺼내기
			Node curNode = queue.poll();
			int curIndex = curNode.index;
			
			// K-정점의 거리값이 정점의 가중치보다 작다면 탐색 종료
			if(distance[curIndex] < curNode.weight)
				continue;
			
			// 다른 노드를 거쳐서 가는 것이 더 비용이 적은지 확인
			for(Node nextNode: graph.get(curIndex)) {				
				if(distance[nextNode.index] > distance[curIndex] + nextNode.weight) {
					distance[nextNode.index] = distance[curIndex] + nextNode.weight;
					queue.add(new Node(nextNode.index, distance[nextNode.index]));
				}
			}
		}
	}

	// 우선순위에 넣을 노드 클래스를 선언
	//static class Node implements Comparable<Node> {
	static class Node {
		private int index;
		private int weight;
		
		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
		
		/*
		 * // 가중치를 기준으로 Comparable을 선언 - 시간 초과됨
		 * 
		 * @Override public int compareTo(Node node) { return
		 * Integer.compare(this.weight, weight); }
		 */
	}
}