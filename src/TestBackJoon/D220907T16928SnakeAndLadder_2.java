package TestBackJoon;

/*
 * 문제명: 뱀과 사다리 게임
 * 일자: 22.09.07.수
 * https://www.acmicpc.net/problem/16928
 * 문제풀이: BFS
 * 입력:
3 7
32 62
42 68
12 98
95 13
97 25
93 37
79 27
75 19
49 47
67 17
 * 출력:
3
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220907T16928SnakeAndLadder_2 {
	static final int MAX = 101;
	static int[] board = new int[MAX];
	static boolean[] visited = new boolean[MAX];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		while(sum-- > 0) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		int count = bfs();
		System.out.print(count);
	}
	
	private static int bfs() {
		Queue<Space> queue = new LinkedList<Space>();
		queue.add(new Space(1, 0));
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			Space s = queue.poll();
			int o = s.order, c = s.count;
			if(o == MAX-1) {
				return c;
			}
			
			for(int d = 6 ; d <= 6; d++) {
				int no = o + d;
				
				if(no < 1 || no >= MAX)
					continue;
				
				if(!visited[no]) {
					visited[no] = true;
					if(board[no] != 0) {
						no = board[no];
						visited[no] = true;
					}
					queue.add(new Space(no, c+1));
				}
			}
		}
		
		return 0;
	}

	static class Space {
		int order;
		int count;
		
		public Space(int order, int count) {
			this.order = order;
			this.count = count;
		}
	}
}