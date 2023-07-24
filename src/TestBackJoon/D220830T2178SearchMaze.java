package TestBackJoon;

/*
 * 문제명: 미로 탐색
 * 일자: 22.08.30.화
 * https://www.acmicpc.net/problem/2178
 * 문제풀이: BFS
 * 입력: 
4 6
101111
101010
101011
111011
 * 출력:
15
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220830T2178SearchMaze {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int x = 0; x < N; x++) {
			String str = br.readLine();
			for(int y= 0; y < M; y++) {
				if(str.charAt(y) == '1') {
					map[x][y] = 1;
				}
			}
		}
		
		System.out.print(bfs(0, 0));
	}
	
	static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x,y});

		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] pair = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = pair[0] + dx[i];
				int ny = pair[1] + dy[i];
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {					
					if(!visited[nx][ny] && map[nx][ny] == 1) {
						queue.add(new int[] {nx,ny});
						visited[nx][ny] = true;
						map[nx][ny] = map[pair[0]][pair[1]] + 1;
					}
				}
			}
		}

		System.out.println();
		for(int i = 0; i < N; i++) {
			for(int j= 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		return map[N-1][M-1];
	}
}