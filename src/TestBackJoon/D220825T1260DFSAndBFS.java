package TestBackJoon;
/*
 * ������: DFS�� BFS
 * ����: 22.08.25.��
 * https://www.acmicpc.net/problem/1260
 * ��������: �׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. ���� ��ȣ�� 1������ N�������̴�.
 * ����Ǯ��: DFS, BFS ����
 * �Է�: 
4 5 1
1 2
1 3
1 4
2 4
3 4
 * ���:
1 2 4 3
1 2 3 4
 */

import java.io.*;
import java.util.*;

public class D220825T1260DFSAndBFS {
	static boolean[] visited;
	static LinkedList<Integer>[] adjList;
	
	static void addEdge(int n, int e) {
		adjList[n].add(e);
	}
	
	// Depth First Search; ���� �켱 Ž��
	static void dfs(int v, int depth) {
		if(depth == visited.length) {
			return;
		}
		
		// v ���� �湮 ó��
		visited[v] = true;
		// v ���
		System.out.print(v + " ");
		
		// �湮�� ���� ������ ��� ��� ��������
		Iterator<Integer> it = adjList[v].listIterator();
		while(it.hasNext()) {
			int n = it.next();
			
			// ��湮�� ����̸� �ش� ��带 ���� ���� �ٽ� dfs() ȣ��
			if(!visited[n]) {
				dfs(n, depth+1);
			}
		}
	}
	
	// Breadth First Search; �ʺ� �켱 Ž��
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
				
		// v ���� �湮 ó��
		visited[v] = true;
		
		// �湮�� v ���� �߰�
		queue.add(v);
		
		while(!queue.isEmpty()) {
			// �湮�� ��带 ť���� ����(dequeue ó��) �ϰ� ���� ���
			v = queue.poll();
			// v ���
			System.out.print(v + " ");
			
			// �湮�� ���� ������ ��� ��� ��������
			Iterator<Integer> it = adjList[v].listIterator();
			while(it.hasNext()) {
				int n = it.next();
				if(!visited[n]) {
					visited[n] = true; // n ���� �湮 ó��
					queue.add(n); // �湮�� n ���� �߰�
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken())+1;
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		adjList = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			addEdge(x, y);
			addEdge(y, x);
		}

		// ���� ��ȣ�� ���� ���� ���� �湮�ؾ� �ϹǷ� ����
		for(int i = 0; i < n; i++) {
			Collections.sort(adjList[i]);
		}

		visited = new boolean[n];
		dfs(v, 1);
		System.out.println();

		visited = new boolean[n];
		bfs(v);
	}
}
