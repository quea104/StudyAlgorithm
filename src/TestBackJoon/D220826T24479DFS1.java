package TestBackJoon;
/*
 * ������: �˰��� ���� - ���� �켱 Ž�� 1
 * ����: 22.08.26.��
 * https://www.acmicpc.net/problem/24479
 * ����Ǯ��: DFS
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
3
4
0
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class D220826T24479DFS1 {
	static boolean[] visited; // ��� �湮 ����
	static int[] order; // ��� �湮 ���� ���� => order[i] = i ������ ��� ° ������ �湮�ϴ��� ���� 
	static ArrayList<Integer>[] adjList; // ���� ����Ʈ�� �׷��� ǥ��
	static int depth = 1; // ��ü �̵� ������ ���ϴ� ���̹Ƿ� ���� ������ ó���ؾ� ��
	
	static void dfs(int v) {		
		visited[v] = true;
		order[v] = depth++;
		
		for(int n: adjList[v]) {
			if(!visited[n]) {
				dfs(n);
			}
		}
	}
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()) + 1; // ������ �� - �迭�� 0���� �����ϹǷ� ������ ���ڸ� �״�� ǥ���ϱ� ���ؼ� +1�� ����� ��.
		int M = Integer.parseInt(st.nextToken()); // ������ ��
		int R = Integer.parseInt(st.nextToken()); // ���� ����
		
		adjList = new ArrayList[N]; // ���� �� ��ŭ ���� ����Ʈ ũ��� �ʱ�ȭ
		for(int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// �ش� �׷����� ������ ������̹Ƿ� �� ����� ����Ʈ�� ǥ������� ��.
			adjList[x].add(y);
			adjList[y].add(x);
		}
		
		// ���� ������ ������������ �湮�ؾ� �ϹǷ� ���� ó��
		for(int i = 0; i < N; i++) {
			Collections.sort(adjList[i]);
		}
		
		visited = new boolean[N];
		order = new int[N];
		dfs(R);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < order.length; i++) {
			sb.append(order[i]).append("\n");
        }
		System.out.println(sb.toString());
	}
}
