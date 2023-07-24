package TestBackJoon;

/*
 * 문제명: 알고리즘 수업 - 깊이 우선 탐색 2
 * 일자: 22.08.29.월
 * https://www.acmicpc.net/problem/24480
 * 문제풀이: DFS
 * 입력: 
5 5 1
1 4
1 2
2 3
2 4
3 4
 * 출력:
1
4
3
2
0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class D220829T24480DFS2 {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int[] order;
	static int depth = 1;
	
	static void dfs(int v) {
		visited[v] = true;
		order[v] = depth++;
		
		for(int n:adjList[v]) {
			if(!visited[n]) {
				dfs(n);
			}
		}
	}
		
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
		
		// 인접 정점은 내림차순 방문해야 함 - 인접 리스트 내림차순
		for(int i = 0; i < N; i++) {
			Collections.sort(adjList[i], Comparator.reverseOrder());
		}
		
		visited = new boolean[N];
		order = new int[N];
		dfs(R);		
				
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < order.length; i++) {
			sb.append(order[i]).append("\n");
		}
		System.out.println(sb.toString());		
	}
}
