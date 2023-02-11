package TestBackJoon;

/*
 * 문제명: 오민식의 고민
 * 일자: 22.10.04.화~05.수
 * https://www.acmicpc.net/problem/1219
 * 문제풀이: Bellman-Ford 알고리즘
 	https://www.crocus.co.kr/837
 	1. 돈의 최댓값과 교통 수단의 가격은 1,000,000보다 작거나 같은 음이 아닌 정수이므로 
 		최대 이윤 값은 int형 범위(-2147483647~2147483647)를 넘을 수 있으므로 최대, 최소 값 설정은 long형으로 해줘야 함.
 	2. 양수 간선 순환이 존재할 경우 간선이 도착 정점으로 이동하는지 확인해야 함
 		= 양수 간선 순환이 발생하는 정점을 따로 모아 각 순환에 연관된 정점에 대해 bfs 방법으로 탐색하여 연관된 정점이 도착 정점으로 갈 수 있는지 확인
 			→ 만약 도착하면 gee
 			→ 만약 도착하지 않으면 도착정점에서 번 돈의 최대값
 			→ 경로에 도착하지도 못하면 gg
 * 입력1:
5 0 4 7
0 1 13
1 2 17
2 4 20
0 3 22
1 3 4747
2 0 10
3 4 10
0 0 0 0 0
 * 출력1:
-32
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D221004T1219Worry {
	static final long MIN = Long.MIN_VALUE;
	static int N, M, S, E;
	static ArrayList<Edge> list;
	static long[] dist;
	static long[] earn;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new long[N];
		earn = new long[N];
		list = new ArrayList<Edge>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), -Integer.parseInt(st.nextToken())));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			earn[i] = Long.parseLong(st.nextToken());
		}
		
		ArrayList<Integer> cycleEdge = search();
		
		String ans = null;
		if(dist[E] == MIN)
			ans = "gg"; // ���� ���ÿ� �����ϴ� ���� �Ұ���
		else {
			if(cycleEdge.size() != 0) {
				boolean[] visited = bfs(cycleEdge); 
				
				if(visited[E])
					ans = "Gee"; // ��ȯ ������ ���� ������ �����ϹǷ� �� ���� ���Ѵ�
				else
					ans = Long.toString(dist[E]); // ��ȯ ������ ���� ������ ������ ������ �̹� ���� �������� ����
			}
			else {
				ans = Long.toString(dist[E]);
			}
		}
		
		System.out.print(ans);
	}

	private static ArrayList<Integer> search() {
		ArrayList<Integer> cycleEdge = new ArrayList<Integer>();
		
		Arrays.fill(dist, MIN);
		dist[S] = earn[S];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < list.size(); j++) {
				Edge edge = list.get(j);
				int x = edge.x, y = edge.y, w = edge.w;
				
				if(dist[x] == MIN) // x�� �ѹ��� �湮���� ���� ���̸� üũ�� �ʿ� ����. ���� ������ ���� 
					continue;
				else if(dist[y] < dist[x] + w + earn[y]) {
					dist[y] = dist[x] + w + earn[y];
					
					// ���� ���� ��ȯ�� �߻��� ���� ������ ���� ����
					if(i == N) {
						cycleEdge.add(y);
					}
				}
			}
		}
		
		return cycleEdge;
	}
	
	private static boolean[] bfs(ArrayList<Integer> cycleEdge) {
		boolean[] visited = new boolean[N];
		
		// ���� ���� ��ȯ�� ������ ������ ���� �������� �� �� �ִ��� Ȯ��
		for(int s: cycleEdge) {
			if(!visited[s]) {
				Queue<Integer> queue = new LinkedList<Integer>();
				visited[s] = true;
				queue.add(s);
				
				while(!queue.isEmpty()) {					
					int v = queue.poll();
					
					for(int i = 0; i < list.size(); i++) {						
						Edge nextEdge = list.get(i);
						int nx = nextEdge.x, ny = nextEdge.y;
						
						if(v == nx && !visited[ny]) {
							visited[ny] = true;
							queue.add(ny);
						}
					}
				}
			}
		}
		
		return visited;
	}

	static class Edge {
		int x;
		int y;
		int w;
		public Edge(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}		
	}
}