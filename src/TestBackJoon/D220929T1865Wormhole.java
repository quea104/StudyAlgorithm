package TestBackJoon;

/*
 * ������: ��Ȧ
 * ����: 22.09.29.��
 * https://www.acmicpc.net/problem/1865
 * ����Ǯ��: Bellman-Ford �˰���
 	https://backtony.github.io/algorithm/2021-02-13-algorithm-boj-class4-10/
 * �Է�1:
2
3 3 1
1 2 2
1 3 4
2 3 1
3 1 3
3 2 1
1 2 3
2 3 4
3 1 8
 * ���1:  1g
NO
YES
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220929T1865Wormhole {
	static final int INF = 500 * 10_000;
	static int N, M, W;
	static ArrayList<Edge> list;
	static int[] distance;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    int T = Integer.parseInt(br.readLine());
	    while(T-- > 0) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	N = Integer.parseInt(st.nextToken());
	    	M = Integer.parseInt(st.nextToken());
	    	W = Integer.parseInt(st.nextToken());
	    	
	    	list = new ArrayList<Edge>();
	    	distance = new int[N+1];
	    	
	    	for(int i = 0; i < M+W; i++) {
	    		st = new StringTokenizer(br.readLine());
    			int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
    			
	    		if(i < M) {
	    			// ���� - ������ ����(�����)
	    			list.add(new Edge(s, e, t));
	    			list.add(new Edge(e, s, t));
	    		}
	    		else {
	    			// ��Ȧ - ���� ����(�ܹ���), ���� ����
	    			list.add(new Edge(s, e, -t));
	    		}
	    	}
	    	
	    	boolean check = search(1);
	    	sb.append(check ? "YES" : "NO").append("\n");
	    }
	    
	    System.out.print(sb.toString());
	}
	
	private static boolean search(int start) {
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < list.size(); j++) {
				Edge edge = list.get(j);
				int s = edge.s, e = edge.e, t = edge.t;
				
				// ��� ������ ���ؼ� �ִ� �Ÿ��� �����ؾ� �ϹǷ� üũ ����
				//if(distance[s] == INF) continue; // �̵� �Ұ�
				
				if(distance[e] > distance[s] + t) {
					if(i == N) return true;	// ���� ���� ��ȯ �߻�
					
					distance[e] = distance[s] + t;
				}
			}
		}
		
		return false;
	}

	static class Edge {
		int s;
		int e;
		int t;
		
		public Edge(int s, int e, int t) {
			super();
			this.s = s;
			this.e = e;
			this.t = t;
		}
	}
}