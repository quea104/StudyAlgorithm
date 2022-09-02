package TestBackJoon;

/*
 * 문제명: 바이러스
 * 일자: 22.08.29.월
 * https://www.acmicpc.net/problem/2606
 * 문제풀이: DFS
 * 입력: 
7
6
1 2
2 3
1 5
5 2
5 6
4 7
 * 출력:
4
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class D220829T2606Virus {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int count = -1;
	
	static void dfs(int v) {		
		visited[v] = true;
		count++;
		
		for(int n:adjList[v]) {
			if(!visited[n]) {
				dfs(n);
			}
		}
	}
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine())+1;
		int M = Integer.parseInt(br.readLine());

		visited = new boolean[N];
		adjList = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		while(M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjList[x].add(y);
			adjList[y].add(x);
		}
		
		for(int i = 0; i < N; i++) {
			Collections.sort(adjList[i]);
		}
		
		dfs(1);
		
		System.out.print(count);
	}
}
