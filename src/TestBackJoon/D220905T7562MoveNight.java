package TestBackJoon;

/*
 * 문제명: 나이트의 이동
 * 일자: 22.09.05.금
 * https://www.acmicpc.net/problem/7562
 * 문제풀이: BFS
 * 입력:
3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1
 * 출력:
5
28
0
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220905T7562MoveNight {
	static int I, sx, sy, ex, ey;
	static int[][] map;
	static boolean[][] visited;
	static int[] dirX = {-1, +1, -1, +1, +2, +2, -2, -2};
	static int[] dirY = {+2, +2, -2, -2, -1, +1, -1, +1};
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			I = Integer.parseInt(br.readLine());
			map = new int[I][I];
			visited = new boolean[I][I];

			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			
			bfs();
			
			sb.append(map[ex][ey]).append("\n");
		}
		
		System.out.print(sb.toString());
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {sx, sy});
		visited[sx][sy] = true;
		
		while(!queue.isEmpty()) {
			int[] pair = queue.poll();
			int x = pair[0], y = pair[1];
			
			if(x == ex && y == ey) {
				return;
			}
			
			for(int i = 0; i < 8; i++) {
				int nx = x + dirX[i], ny = y + dirY[i];
				
				if(nx < 0 || ny < 0 || nx >= I || ny >= I) {
					continue;
				}
				
				if(!visited[nx][ny]) {
					queue.add(new int[] {nx, ny});
					map[nx][ny] = map[x][y] + 1;
					visited[nx][ny] = true;
				}
			}
		}
	}
}