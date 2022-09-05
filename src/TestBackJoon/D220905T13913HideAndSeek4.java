package TestBackJoon;

/*
 * ������: ���ٲ���4
 * ����: 22.09.05.��
 * https://www.acmicpc.net/problem/13913
 * ����Ǯ��: BFS
 * �Է�1:
5 17
 * ���1:
4
5 10 9 18 17
 * �Է�2: 
5 17
 * ���2:
4
5 4 8 16 17
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220905T13913HideAndSeek4 {
	static final int MAX = 100001;
	static int[] map = new int[MAX];
	static int[] visited = new int[MAX];
	static int N, K;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(visited, -1);
		
		bfs();
		System.out.println(map[K]);

		/*
		sb.append(N + " ");
		if(tb.containsKey(K)) {
			for(int num:tb.get(K)) {
				sb.append(num + " ");
			}
			sb.append(K);
		}
		*/

		System.out.print(sb.toString());
	}
	
	private static void bfs() {
		Hashtable<Integer, ArrayList<Integer>> tb = new Hashtable<Integer, ArrayList<Integer>>();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		visited[N] = N;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();

			ArrayList<Integer> list = new ArrayList<Integer>();
			if(x == K) {
				print(N, K);
				return;
			}
			else {
				if(tb.containsKey(x)) {
					// clone ���� ������ ���� �޸� �ּҸ� ����Ͽ� �޸� ���� ���� �߻��� �� ����
					list = (ArrayList<Integer>) tb.get(x).clone();		
					list.add(x);
					tb.remove(x);
				}
			}

			for(int nx:new int[] {x*2, x-1, x+1}) {
				if(nx < 0 || nx >= MAX) continue;
				if(visited[nx] == -1) {
					queue.add(nx);
					map[nx] = map[x] + 1;
					visited[nx] = x;
					
					tb.put(nx, list);
				}
			}
		}
	}
	
	private static void print(int start, int end) {
		if(start != end) {
			print(start, visited[end]);
		}
		sb.append(end + " ");
	}
}