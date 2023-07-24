package TestBackJoon;

/*
 * 문제명: 숨바꼭질4
 * 일자: 22.09.05.금
 * https://www.acmicpc.net/problem/13913
 * 문제풀이: BFS
 * 입력1:
5 17
 * 출력1:
4
5 10 9 18 17
 * 입력2: 
5 17
 * 출력2:
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
					// clone 하지 않으면 같은 메모리 주소를 사용하여 메모리 참조 오류 발생할 수 있음
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