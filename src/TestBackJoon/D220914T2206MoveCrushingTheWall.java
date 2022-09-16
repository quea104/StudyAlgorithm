package TestBackJoon;

/*
 * 문제명: 벽 부수고 이동하기
 * 일자: 22.09.14.수
 * https://www.acmicpc.net/problem/2206
 * 문제풀이: BFS, https://kscodebase.tistory.com/66
 * 입력1:
6 4
0100
1110
1000
0000
0111
0000
 * 출력:
15

 * 입력2:
10 2
01
00
10
00
01
00
10
00
01
00
 * 출력2:
13
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220914T2206MoveCrushingTheWall {
	static int[][] map;
	static int[][][] visited;
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M][2];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				if(str.charAt(j) == '1')
					map[i][j] = 1;
			}
		}
		
		int move = bfs();		
		System.out.print(move);
	}

	private static int bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0,0,0});
		visited[0][0][0] = 1;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0], y = pos[1], state = pos[2]; // 지금까지 벽을 부쉈는지 상태(1:부숨, 0:안부숨)
						
			if(x == N-1 && y == M-1) {
				return visited[x][y][state];
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i], ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				
				if(visited[nx][ny][state] == 0) {
					if(map[nx][ny] == 1) {
						if(state == 0) {
							visited[nx][ny][1] = visited[x][y][0] + 1;
							queue.add(new int[] {nx, ny, 1});
						}
					}
					else {
						visited[nx][ny][state] = visited[x][y][state] + 1;
						queue.add(new int[] {nx, ny, state});						
					}
				}
			}
		}
		
		return -1;
	}
}