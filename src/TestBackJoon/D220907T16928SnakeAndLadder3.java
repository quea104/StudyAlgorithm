package TestBackJoon;

/*
 * ������: ��� ��ٸ� ����
 * ����: 22.09.07.��
 * https://www.acmicpc.net/problem/16928
 * ����Ǯ��: BFS
 * �Է�:
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
 * ���:
3
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220907T16928SnakeAndLadder3 {
	
	public static void main(String[] args) throws IOException {
		final int MAX = 101;
		int[] board = new int[MAX];
		boolean[] visited = new boolean[MAX];
		int time = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		while(sum-- > 0) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		final int MASK = 1023;
		int[] queue = new int[MASK+1]; // -> FIFO ���Լ���
		int head = -1; // �� front - �տ��� �ڷ� ����
		int tail = -1; // �� rear - �ڿ��� �ڷ� �߰�
		
		visited[1] = true;
		queue[++tail] = 1;
		
		while(head < tail) {
			int size = tail - head;
			
			while(size-- > 0) {
				int o = queue[++head & MASK]; // &: ��Ʈ ����
				if(o == 100) {
					System.out.print(time);
					return;
				}
				
				int j = board[o];
				if(j > 0) visited[o = j] = true;
				
				for(j = o+6; j > o; j--) {
					if(j > 100 || visited[j]) continue;
					visited[j] = true;
					queue[++tail & MASK] = j;
				}
			}
			
			time++;
		}
		
	}
}