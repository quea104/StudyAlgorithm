package TestBackJoon;

/*
 * ������: ��Ȯ�� ������
 * ����: 22.09.27.ȭ
 * https://www.acmicpc.net/problem/9370
 * ����Ǯ��: Dijkstra
 	�ݵ�� v1�� v2 ������ ������ N �������� ���� �ִܰ���� ����� ���� �ΰ�����.
	��, 	1. 1 �� v1 �� v2 �� N
	 	2. 1 �� v2 �� v1 �� N
 	�ش� �׷����� ������̹Ƿ� v1 �� v2 = v2 �� v1 ��.
 	
 	�ִ� ��θ� Ž���� ��δ�
	 	1. 1 �� v1, 1 �� v2 �ִ� ��� Ž��
	 	2. v1 �� v2(= v2 �� v1), v1 �� N �ִ� ��� Ž�� 		
	 	3. v2 �� N �ִ� ��� Ž��
 	�� 3���� ���̽�Ʈ�� �˰��� �����ϸ� ��. 	
 	
 * �Է�:
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
 * ���:
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
	static ArrayList<Integer> aList = new ArrayList<Integer>();
	
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
			
			while(t-- > 0) {				
				// s �� g �� h �� d
				// s �� h �� g �� d
				int d = Integer.parseInt(br.readLine());
				int shortestPath = INF; 
				
				// s �� g, s �� h
				search(s);
				int sTog = distance[g], sToh = distance[h];
				
				// g �� h, g �� d
				search(g);
				int gToh = distance[h], gTod = distance[d];
				
				// h �� d
				search(h);
				int hTod = distance[d];
				
				shortestPath = Math.min(shortestPath, sTog + gToh + hTod);
				shortestPath = Math.min(shortestPath, sToh + gToh + gTod);				
				if(shortestPath == INF || gToh == INF) continue;
				
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
			
			// ��湮 �Ұ�
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