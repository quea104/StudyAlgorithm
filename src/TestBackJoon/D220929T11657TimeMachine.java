package TestBackJoon;

/*
 * 문제명: 타임머신
 * 일자: 22.09.29.목
 * https://www.acmicpc.net/problem/11657
 * 문제풀이: Bellman-Ford 알고리즘
 * 입력1:
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2
 * 출력1:
4
3
 * 입력2:
3 4
1 2 4
1 3 3
2 3 -4
3 1 -2
 * 출력2:
-1
 * 입력3:
3 2
1 2 4
1 2 3
 * 출력3:
3
-1
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220929T11657TimeMachine {
	// INF 값이 충분히 크지 못한 경우 시간이 매우 걸리는 경로로 가더라도 INF 값을 넘지 못하도록 크게 잡으셔야 함.
	static final long INF = Long.MAX_VALUE;
	static int N, M;
	static ArrayList<Edge> list = new ArrayList<Edge>();
	static long[] distance;
	
	public static void main(String[] args) throws IOException {
	    StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		distance = new long[N+1];
		Arrays.fill(distance, INF);
		 
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());			
			list.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
	    
		boolean check = search();
		if(!check)
			sb.append(-1);
		else {
			for(int i = 2; i <= N; i++) {
				sb.append((distance[i] == INF ? -1 : distance[i]) + "\n");
			}
		}
		System.out.print(sb.toString());
		
		br.close();
	}
	
	static boolean search() {
		distance[1] = 0;
		
		// 탐색
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				Edge edge = list.get(j);
				int x = edge.x, y = edge.y, w = edge.w;
				
				if(distance[x] == INF) continue;
				
				if(distance[y] > distance[x] + w) {
					// 음수 간선 순환 발생
					if(i == N) {
						return false;
					}
					
					distance[y] = distance[x] + w;
				}
			}
		}
		
		return true;
	}

	static class Edge {
		private int x;
		private int y;
		private int w;
		
		public Edge(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}		
	}
}