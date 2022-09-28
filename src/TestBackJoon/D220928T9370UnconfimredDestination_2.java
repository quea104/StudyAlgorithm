package TestBackJoon;

/*
 * 문제명: 미확인 도착지
 * 일자: 22.09.28.수
 * https://www.acmicpc.net/problem/9370
 * 문제풀이: Dijkstra
 	최단거리 값을 구하는 문제가 아니기 때문에 알고리즘을 한번만 탐색하기 위해
 	특정 경로 탐색 여부를 최단거리 값이 짝수, 홀수 여부로 판단하게끔 해줌
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
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class D220928T9370UnconfimredDestination_2 {
	// Integar.MAX_VALUE 값을 넣으면 오류 발생 - 이유 모르겠음
	static final int INF = 100_000_000; // 단위가 큰 수의 표현에는 중간에 언더바를 넣는 것도 허용
	static ArrayList<ArrayList<Node>> map;
	static int[] distance;
	
	public static void main(String[] args) throws IOException {
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			distance = new int[n+1];
			Arrays.fill(distance, INF);
			
			map = new ArrayList<>();
			for(int i = 0; i <= n; i++) {
				map.add(new ArrayList<Node>());
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				// 특정 구간(g → h, h → g)은 가중치 홀수화
				if((g == a && h == b) || (h == a && g == b))
					w = w*2 - 1;
				else // 그외 구간 짝수화
					w = w*2;

				map.get(a).add(new Node(b, w));
				map.get(b).add(new Node(a, w));
			}

			search(s);
			
			ArrayList<Integer> aList = new ArrayList<Integer>();
			while(t-- > 0) {
				int d = Integer.parseInt(br.readLine());
				if(distance[d] % 2 == 1) {
					aList.add(d);
				}
			}
			
			Collections.sort(aList);
			
			for(int d:aList) {
				bw.write(d + " ");
			}
			bw.write("\n");
		}
		
		bw.close();
		br.close();
	}
	
	private static void search(int s) {		
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		queue.add(new Node(s, 0));
		distance[s] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			int cv = curNode.vertex;
			
			if(distance[cv] < curNode.weight)
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

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}