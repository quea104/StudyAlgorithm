package TestBackJoon;
/*
 * 문제명: 알고리즘 수업 - 깊이 우선 탐색 1
 * 일자: 22.08.26.금
 * https://www.acmicpc.net/problem/24479
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
	static boolean[] visited; // 노드 방문 여부
	static int[] order; // 노드 방문 순서 저장 => order[i] = i 정점이 몇번 째 순서에 방문하는지 저장 
	static ArrayList<Integer>[] adjList; // 인접 리스트로 그래프 표현
	static int depth = 1; // 전체 이동 순서를 구하는 것이므로 전역 변수로 처리해야 함
	
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
		int N = Integer.parseInt(st.nextToken()) + 1; // 정점의 수 - 배열은 0부터 시작하므로 정점의 숫자를 그대로 표현하기 위해선 +1을 해줘야 함.
		int M = Integer.parseInt(st.nextToken()); // 간선의 수
		int R = Integer.parseInt(st.nextToken()); // 시작 정점
		
		adjList = new ArrayList[N]; // 정점 수 만큼 인접 리스트 크기로 초기화
		for(int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 해당 그래프의 간선은 양방향이므로 양 노드의 리스트에 표기해줘야 함.
			adjList[x].add(y);
			adjList[y].add(x);
		}
		
		// 인접 정점은 오름차순으로 방문해야 하므로 정렬 처리
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
