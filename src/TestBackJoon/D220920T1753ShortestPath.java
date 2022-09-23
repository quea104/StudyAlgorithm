package TestBackJoon;

/*
 * ������: �ִܰ��
 * ����: 22.09.20.ȭ~22.09.22.��
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
7555555 
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
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220920T1753ShortestPath {
	static final int INF = 987654321; // infinite ���Ѵ�
	static int V, E, K;
	static int[][] graph;
	static boolean[] visited; // �ش� ��带 �湮�ߴ��� üũ�� ����
	static int[] distance;  // �ִ� �Ÿ��� ������ ����
	
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
		
		// �������, distance�� ���Ѵ�� �ʱ�ȭ
		for(int i = 1; i <= V; i++) {
			distance[i] = INF;
			for(int j = 1; j <= V; j++) {
				graph[i][j] = INF;
			}
		}
		
		// ������Ŀ� ����ġ �ֱ�
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
		// ���۳�尪 �ʱ�ȭ
		distance[K] = 0;
		visited[K] = true;

		// ������ distance����
		for(int i = 1; i <= V; i++) {
			if(!visited[i] && graph[K][i] != INF)
				distance[i] = graph[K][i];
		}
		
		print();
		
		// �ݺ����� V-2��
		for(int a = 0; a < V-1; a++) {
			// ��� �ּҰ� ã��
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
			
			// �ٸ� ��带 ���ļ� ���� ���� �� ����� ������ Ȯ��
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
		 // ����� ���
        for(int i = 1; i <= V; ++i){
        	if(distance[i] == INF) System.out.print("INF ");
        	else System.out.print(distance[i]+" ");
        }
        System.out.println("");
	}
}