package TestBackJoon;

/*
 * 문제명: 토마토
 * 일자: 22.09.06.화
 * https://www.acmicpc.net/problem/7569
 * 문제풀이: BFS
 * 입력:
5 3 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0
 * 출력:
4
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220906T7569Tomato {
	static int M, N, H, unripeCount = 0, days = 0;
	static int[][][] map;
	static int[][][] visited;
	static Queue<Node> queue = new LinkedList<Node>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		// 컴퓨터는 배열 안에 배열을 저장해야 하므로 (z, y, x)순으로 구현
		map = new int[H][N][M];
		visited = new int[H][N][M];
		
		for(int k = 0; k < H; k++) {
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					visited[k][i][j] = -1;
					
					if(map[k][i][j] == 0) { // 덜익은 상태
						unripeCount++;						
					}
					else if(map[k][i][j] == 1) { // 익은 상태
						queue.add(new Node(k, i, j)); // 높이:z 세로:x 가로:y
						visited[k][i][j] = 0;						
					}
				}
			}
		}
		
		if(unripeCount == 0) {
			days = 0;
		}
		else {
			bfs();
			if(unripeCount > 0) {
				days = -1;
			}
		}
		System.out.print(days);
	}

	private static void bfs() {
		// 동, 서, 남, 북, 위, 아래
		int[] dirX = {1, -1, 0, 0, 0, 0};
		int[] dirY = {0, 0, -1, 1, 0, 0};
		int[] dirZ = {0, 0, 0, 0, 1, -1};
		
		while(!queue.isEmpty()) {
			Node pair = queue.poll();
			int z = pair.z, x = pair.x, y = pair.y;
			
			if(unripeCount == 0)
				return;
			
			for(int i = 0; i < 6; i++) {
				int nx = x + dirX[i], ny = y + dirY[i], nz = z + dirZ[i];
				
				if(nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H)
					continue;
				
				if(visited[nz][nx][ny] == -1 && map[nz][nx][ny] == 0) {
					queue.add(new Node(nz, nx, ny));
					visited[nz][nx][ny] = visited[z][x][y] + 1;
					unripeCount--;
					
					if(days < visited[nz][nx][ny]) {
						days = visited[nz][nx][ny];
					}
				}
			}
		}
	}
}

class Node {
	int z, x, y;
	
	public Node(int z, int x, int y) {
		super();
		this.z = z;
		this.x = x;
		this.y = y;
	}
}