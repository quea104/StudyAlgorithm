package TestBackJoon;

/*
 * ������: ��Ȧ
 * ����: 22.09.29.��
 * https://www.acmicpc.net/problem/1865
 * ����Ǯ��: Bellman-Ford �˰���
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
 * ���1:
NO
YES
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220929T1865Wormhole_2 {
	static final int INF = 987654321;
	static int N, M, W;
	// �� ������ �����ϴ� ���ΰ� �� ������ ���� ���� �־ ���� ����Ʈ�� �����ؾ� ��
	static ArrayList<ArrayList<Edge>> adjList;
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
	    	
	    	adjList = new ArrayList<>();
	    	distance = new int[N+1];
	    	for(int i = 0; i <= N; i++) {
	    		adjList.add(new ArrayList<Edge>());
	    	}	    	
	    	
	    	for(int i = 0; i < M+W; i++) {
	    		st = new StringTokenizer(br.readLine());
    			int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
    			
	    		if(i < M) {
	    			// ���� - ������ ����(�����)
	    			adjList.get(s).add(new Edge(e, t));
	    			adjList.get(e).add(new Edge(s, t));
	    		}
	    		else {
	    			// ��Ȧ - ���� ����(�ܹ���), ���� ����
	    			adjList.get(s).add(new Edge(e, -t));
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
			for(int j = 1; j <= N; j++) {
				for(Edge edge:adjList.get(j)) {
					int nv = edge.v, t = edge.t;
					
					if(distance[nv] > distance[j] + t) {
						if(i == N) return true; // ���� ���� ��ȯ �߻�
						
						distance[nv] = distance[j] + t;
					}
				}
			}
		}
		
		return false;
	}

	static class Edge {
		int v;
		int t;
		
		public Edge(int v, int t) {
			super();
			this.v = v;
			this.t = t;
		}
	}
}