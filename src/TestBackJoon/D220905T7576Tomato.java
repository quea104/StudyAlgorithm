package TestBackJoon;

/*
 * 문제명: 토마토
 * 일자: 22.09.05.월
 * https://www.acmicpc.net/problem/7576
 * 문제풀이: BFS
 * 입력:
6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
 * 출력:
8
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220905T7576Tomato {
	static int M, N, count = -1, totalRipeCount = 0, ripeCount = 0;
	static int[][] map;
	static int[][] visited;
	static int[] dirX = {0,0,1,-1};
	static int[] dirY = {1,-1,0,0};
	static Queue<int[]> queue = new LinkedList<int[]>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		
		boolean ripeCheck = true;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(visited[i], -1);
			for(int j = 0; j < M; j++) {
				switch(st.nextToken()) {
					case "1":
						map[i][j] = 1;
						totalRipeCount++;
						break;
					case "-1":
						map[i][j] = -1;
						break;
					case "0":
						ripeCheck = false;
						totalRipeCount++;
						break;							
				}
			}
		}

		if(ripeCheck) {
			count = 0;
		}
		else {
			ripeCount = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						queue.add(new int[] {i, j});
						visited[i][j] = 0;
						ripeCount++;
					}
				}
			}
			
			bfs();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					System.out.print(visited[i][j] + " ");
				}
				System.out.println();
			}
			
			if(ripeCount != totalRipeCount)
				count = -1;
		}
		
		System.out.print(count);
	}

	private static void bfs() {		
		while(!queue.isEmpty()) {
			int[] pair = queue.poll();
			int x = pair[0], y = pair[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dirX[i], ny = y + dirY[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				
				if(visited[nx][ny] == -1 && map[nx][ny] == 0) {
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = visited[x][y] + 1;
					
					ripeCount++;
					if(count < visited[nx][ny])
						count = visited[nx][ny];
				}
			}
		}
	}
}