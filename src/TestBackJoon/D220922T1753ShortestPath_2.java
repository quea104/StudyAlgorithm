package TestBackJoon;

/*
 * ������: �ִܰ��
 * ����: 22.09.22.��
 * https://www.acmicpc.net/problem/1753
 * ����Ǯ��: BFS, DP
 * �Է�1:
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 * ���1:
0
2
3
7
INF
 * �Է�2:
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
 * ���2:
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
	static final int INF = 987654321; // infinite ���Ѵ�
	static int V, E, K;
	static ArrayList<ArrayList<Node>> graph;
	static int[] distance;  // �ִ� �Ÿ��� ������ ����
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<ArrayList<Node>>();
		distance = new int[V+1];
		
		// ��������Ʈ, distance�� ���Ѵ�� �ʱ�ȭ
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<Node>());
			distance[i] = INF;
		}
		
		// ��������Ʈ�� ����ġ �ֱ�
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
		// �������� �Ÿ��� ������ �켱���� ť
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		
		// ���� ���� �ʱ�ȭ <- ���� �������� ���� ª�� ������ ���� ������
		queue.add(new Node(K, 0));
		distance[K] = 0;
		
		while(!queue.isEmpty()) {	
			// ��� ������
			Node curNode = queue.poll();
			int curIndex = curNode.index;
			
			// K-������ �Ÿ����� ������ ����ġ���� �۴ٸ� Ž�� ����
			if(distance[curIndex] < curNode.weight)
				continue;
			
			// �ٸ� ��带 ���ļ� ���� ���� �� ����� ������ Ȯ��
			for(Node nextNode: graph.get(curIndex)) {				
				if(distance[nextNode.index] > distance[curIndex] + nextNode.weight) {
					distance[nextNode.index] = distance[curIndex] + nextNode.weight;
					queue.add(new Node(nextNode.index, distance[nextNode.index]));
				}
			}
		}
	}

	// �켱������ ���� ��� Ŭ������ ����
	//static class Node implements Comparable<Node> {
	static class Node {
		private int index;
		private int weight;
		
		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
		
		/*
		 * // ����ġ�� �������� Comparable�� ���� - �ð� �ʰ���
		 * 
		 * @Override public int compareTo(Node node) { return
		 * Integer.compare(this.weight, weight); }
		 */
	}
}