package TestBackJoon;


/*
 * 문제명: 바이러스
 * 일자: 22.08.29.월
 * https://www.acmicpc.net/problem/2606
 * 문제풀이: DFS
 * 입력: 
7
6
1 2
2 3
1 5
5 2
5 6
4 7
 * 출력:
4
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class D220829T2667BlockNumbering {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dirX = {0,0,-1,+1}; // X좌표 방향 동서남북
	static int[] dirY = {+1,-1,0,0}; // Y좌표 방향 동서남북
	static int block = 0, count = 0;
	static ArrayList<Integer> list = new ArrayList<Integer>();
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];		
		for(int x = 0; x < N; x++) {
			String str = br.readLine();
			for(int y = 0; y < N; y++) {
				if(str.charAt(y) == '1') {
					map[x][y] = 1;
				}
			}
		}

		visited = new boolean[N][N];
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				count = 0;
				if(!visited[x][y] && map[x][y] == 1) {
					block++;
					bfs(x, y);
					list.add(count);
				}
			}
		}
		
		System.out.println(block);
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int c:list) {
			sb.append(c).append("\n");
		}
		System.out.print(sb.toString());
	}

	static void dfs(int x, int y) {
		//System.out.println(x + " " + y);
		visited[x][y] = true;
		count++;
		
		for(int i = 0; i < 4; i++) {
			int nx = x+dirX[i];
			int ny = y+dirY[i];
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(!visited[nx][ny] && map[nx][ny] == 1) {
					dfs(nx, ny);
				}
			}
		}
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();		
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		count++;
		
		while(!queue.isEmpty()) {
			int[] pair = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = pair[0] + dirX[i];
				int ny = pair[1] + dirY[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if(!visited[nx][ny] && map[nx][ny] == 1) {
						queue.add(new int[] {nx, ny});
						visited[nx][ny] = true;
						count++;
					}
				}
			}
		}
	}
}