package TestBackJoon;

/*
 * ������: Ư���� �ִܰ��
 * ����: 22.09.27.ȭ
 * https://www.acmicpc.net/problem/1504
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
4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3
 * ���:
7
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220927T1504ParticularShortestPath {
	static final int INF = 987654321;
	static int N, E, v1, v2, shortestPath = INF;
	static int[] distance;
	static ArrayList<ArrayList<Node>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		distance = new int[N+1];
		graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node>()); 
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		// s �� v1, s �� v2
		search(1);
		int sToV1 = distance[v1], sToV2 = distance[v2];
		
		// v1 �� v2, v1 �� N
		search(v1);
		int v1ToV2 = distance[v2], v1ToN = distance[N];
		
		// v2 �� N
		search(v2);
		int v2ToN = distance[N];
		 
		// s �� v1 �� v2 �� N
		shortestPath = Math.min(shortestPath, sToV1 + v1ToV2 + v2ToN);
		// s �� v2 �� v1 �� N
		shortestPath = Math.min(shortestPath, sToV2 + v1ToV2 + v1ToN);
		
		System.out.print(v1ToV2 == INF || shortestPath == INF ? -1 : shortestPath);
	}
	
	static void search(int sv) {
		Arrays.fill(distance, INF);
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		queue.add(new Node(sv, 0));
		distance[sv] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			int cv = curNode.vertex;
			
			for(Node nv:graph.get(curNode.vertex)) {
				if(distance[nv.vertex] > distance[cv] + nv.weight) {
					distance[nv.vertex] = distance[cv] + nv.weight;
					queue.add(new Node(nv.vertex, distance[nv.vertex]));
				}
			}
		}
	}
	
	static class Node {
		private int vertex;
		private int weight;
		
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}