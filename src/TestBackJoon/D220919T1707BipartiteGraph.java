package TestBackJoon;

/*
 * ������: �̺� �׷���
 * ����: 22.09.19.��
 * https://www.acmicpc.net/problem/1707
 * ����Ǯ��: BFS, DFS, https://hongjw1938.tistory.com/117
  	1. ���� Ž�� ������ ������ ������ ���������� ĥ�Ѵ�.(���� 1�� ǥ��)
	2. ���� ������ ���� ������ ������ �Ķ������� ĥ�Ѵ�.(���� -1�� ǥ��)
	3. �ش� ���� �������� ���ʷ� Ž���� �����ϸ� �ڽŰ� ������ ������ ���������� ĥ�Ѵ�.(���� 1�� ǥ��)
	4. �̿� ���� ����� Ž���� �����ϸ� �ݺ��Ͽ� 2���� �������� ��� ĥ�Ѵ�.
	5. ������ ĥ�ϴٰ� �̿� ������ ���� ������ ĥ���� �ִٸ� �̺� �׷����� �� �� ����.
 * �Է�:
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2
 * ���:
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
			
            // ���� �׷����� �񿬰� �׷���(��� ������ ���鼭 Ȯ��) ��� ���
			for(int v = 1; v < V+1; v++) {
				if(!check) break;
				
				// �湮���� ���� ������ ���ؼ� Ž�� ����
				if(visited[v] == 0) {
					//bfs(v); // �ʺ� �켱 Ž��
					dfs(v, RED); // ���� �켱 Ž��
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