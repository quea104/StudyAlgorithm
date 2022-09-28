package TestBackJoon;

/*
 * 문제명: 미확인 도착지
 * 일자: 22.09.27.화
 * https://www.acmicpc.net/problem/9370
 * 문제풀이: Dijkstra
 	s → d 의 최단거리가 s → g → h → d 또는 s → h → g → d 최단거리가 동일해야 함
	왜냐하면 문제에서 '목적지까지 우회하지 않고 최단거리로 갈 것' 이라고 했기 때문 	
 * 입력:
2
5 4 2
1 2 3
1 2 6
2 3 2
3 4 4
3 5 3
5
4
6 9 2
2 3 1
1 2 1
1 3 3
2 4 4
2 5 5
3 4 3
3 6 2
4 5 4
4 6 3
5 6 7
5
6
 * 출력:
4 5
6
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220927T9370UnconfimredDestination {
	static final int INF = 987654321;
	static int T;
	static int n, m, t, s, g, h;
	static ArrayList<ArrayList<Node>> map;
	static int[] distance;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());			

			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			distance = new int[n+1];
			map = new ArrayList<>();
			for(int i = 0; i <= n; i++) {
				map.add(new ArrayList<Node>());
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
				map.get(x).add(new Node(y, w));
				map.get(y).add(new Node(x, w));
			}
			
			ArrayList<Integer> aList = new ArrayList<Integer>();
			while(t-- > 0) {				
				// s → g → h → d
				// s → h → g → d
				int d = Integer.parseInt(br.readLine());
				int shortestPath = INF; 
				
				// s → g, s → h, s → d 
				search(s);
				int sTog = distance[g], sToh = distance[h];
				int sTod = distance[d];
				
				// g → h, g → d
				search(g);
				int gToh = distance[h], gTod = distance[d];
				
				// h → d
				search(h);
				int hTod = distance[d];
				
				shortestPath = Math.min(shortestPath, sTog + gToh + hTod);
				shortestPath = Math.min(shortestPath, sToh + gToh + gTod);				
				if(shortestPath == INF || gToh == INF) continue;
				
				// s → d 의 최단거리가 s → g → h → d 또는 s → h → g → d 최단거리가 동일해야 함
				// 왜냐하면 문제에서 '목적지까지 우회하지 않고 최단거리로 갈 것' 이라고 했기 때문
				if(sTod == shortestPath)
					aList.add(d);
			}

			Collections.sort(aList);
			for(int a:aList) {
				sb.append(a).append(' ');
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	static void search(int start) {
		Arrays.fill(distance, INF);
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		queue.add(new Node(start, 0));
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			int cv = curNode.vertex;
			
			// 재방문 불가
			if(curNode.weight > distance[cv])
				continue;
			
			for(Node nextNode:map.get(cv)) {
				int nv = nextNode.vertex;
				
				if(distance[nv] > distance[cv] + nextNode.weight) {
					distance[nv] = distance[cv] + nextNode.weight;
					queue.add(new Node(nv, distance[nv]));
				}
			}
		}
	}
	
	static class Node {
		int vertex;
		int weight;
		
		public Node(int vertext, int weight) {
			super();
			this.vertex = vertext;
			this.weight = weight;
		}
	}
}