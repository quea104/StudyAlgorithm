package TestBackJoon;

/*
 * 문제명: 유기농 배추
 * 일자: 22.08.30.화
 * https://www.acmicpc.net/problem/1012
 * 문제풀이: DFS, BFS
 * 입력: 
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5
 * 출력:
5
1
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220830T1012OragnicCabbage {
	static int[][] map;
	static boolean[][] visited;
	static int M, N;
	static int[] dx = {0, 0, -1, +1};
	static int[] dy = {+1, -1, 0, 0};
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			visited = new boolean[M][N];
			
			int K = Integer.parseInt(st.nextToken());
			while(K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			int count = 0;
			for(int x = 0; x < M; x++) {
				for(int y = 0; y < N; y++) {
					if(!visited[x][y] && map[x][y] == 1) {
						count++;
						bfs(x, y);
					}
				}
			}
			sb.append(count).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if(!visited[nx][ny] && map[nx][ny] == 1) {
					dfs(nx, ny);
				}
			}
		}
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] pair = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = pair[0] + dx[i];
				int ny = pair[1] + dy[i];
				if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if(!visited[nx][ny] && map[nx][ny] == 1) {
						queue.add(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
}