package TestBackJoon;

/*
 * ������: Ÿ�Ӹӽ�
 * ����: 22.09.29.��
 * https://www.acmicpc.net/problem/11657
 * ����Ǯ��: Bellman-Ford �˰���
 * �Է�1:
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2
 * ���1:
4
3
 * �Է�2:
3 4
1 2 4
1 3 3
2 3 -4
3 1 -2
 * ���2:
-1
 * �Է�3:
3 2
1 2 4
1 2 3
 * ���3:
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
	// INF ���� ����� ũ�� ���� ��� �ð��� �ſ� �ɸ��� ��η� ������ INF ���� ���� ���ϵ��� ũ�� �����ž� ��.
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
		
		// Ž��
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				Edge edge = list.get(j);
				int x = edge.x, y = edge.y, w = edge.w;
				
				if(distance[x] == INF) continue;
				
				if(distance[y] > distance[x] + w) {
					// ���� ���� ��ȯ �߻�
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