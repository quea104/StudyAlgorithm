package TestBackJoon;

/*
 * ������: ���ٲ���
 * ����: 22.08.30.ȭ
 * https://www.acmicpc.net/problem/1697
 * ����Ǯ��: BFS
 * �Է�: 
5 17
 * ���:
4
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220830T1697HideAndSeek {
	static final int MAX = 100001;
	static int[] map = new int[MAX];
	static boolean[] visited = new boolean[MAX];
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		
		System.out.print(map[K]);
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			if(x == K) { // ������ ���� �� break
				break;
			}

			int nextArr[] = {x-1, x+1, x*2};
			for(int i = 0; i < 3; i++) {
				int nx = nextArr[i];
				
				if(nx < 0 || nx >= MAX) continue;
				
				if(!visited[nx]) {
					queue.add(nx);
					map[nx] = map[x] + 1;	
					visited[nx] = true; // push �� �� �湮 ó�� -> �ѹ� ������ ������ �ٽ� �湮���� �ʵ���						
				}
			}
		}
	}
}