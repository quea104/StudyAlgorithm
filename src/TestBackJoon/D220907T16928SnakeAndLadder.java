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

public class D220907T16928SnakeAndLadder {
	static final int MAX = 11;
	static int[][] board = new int[MAX][MAX];
	static boolean[][] visited = new boolean[MAX][MAX];
	static int N, M, minCount = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사다리 수
		M = Integer.parseInt(st.nextToken()); // 뱀 수
		
		int sum = N+M;
		while(sum-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
			Pair startPair = getPair(start);
			board[startPair.x][startPair.y] = end;
		}
		
		bfs();
		
		System.out.print(minCount);
	}

	private static void bfs() {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(1,1,0));
		visited[1][1] = true;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			int x = p.x, y = p.y, count = p.count;
			
			if(x == 10 && y == 10) {
				minCount = count;
				return;
			}
			
			// 주사위 돌리기
			for(int d = 1; d <= 6; d++) {
				Pair np = getPair((getOrder(x, y) + d));
				int nx = np.x, ny = np.y;
				
				if(nx < 1 || ny < 1 || nx >= MAX || ny >= MAX)
					continue;
				
				if(!visited[nx][ny]) {
					visited[nx][ny] = true; // 주사위를 통해 이동한 칸 방문 처리
					if(board[nx][ny] != 0) { // 사다리 또는 뱀 존재
						np = getPair(board[nx][ny]);
						nx = np.x;
						ny = np.y;
						visited[nx][ny] = true; // 사다리 또는 뱀 통해 이동한 칸 방문 처리
					}
					queue.add(new Pair(nx,ny,count+1));
				}
			}
		}
	}
	
	static Pair getPair(int order) {
		int x = (order < 11 ? 1 : (order/10)+(order%10 == 0 ? 0 : 1));
		int y = (order%10) + (order%10 == 0 ? 10 : 0);
		return new Pair(x,y);
	}
	static int getOrder(int x, int y) {
		return ((x-1)*10) + y;
	}

	static class Pair {
		int x, y, count;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Pair(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}