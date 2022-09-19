package TestBackJoon;

/*
 * ������: �˰��� ���� - �ʺ� �켱 Ž�� 1
 * ����: 22.08.29.��
 * https://www.acmicpc.net/problem/24444
 * ����Ǯ��: BFS
 * �Է�: 
5 5 1
1 4
1 2
2 3
2 4
3 4
 * ���:
1
2
4
3
0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D220829T24444BFS1 {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int[] order;
	static int depth = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken())+1;
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjList[x].add(y);
			adjList[y].add(x);
		}
		
		for(int i = 0; i < N; i++) {
			Collections.sort(adjList[i]);
		}
		
		visited = new boolean[N];
		order = new int[N];
		bfs(R);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N; i++) {
			sb.append(order[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		
		while(!queue.isEmpty()) {
			v = queue.poll();

			if(!visited[v]) {
				visited[v] = true;
				order[v] = depth++;
				
				for(int nv: adjList[v]) {
					queue.add(nv);
				}
			}
		}
	}
}