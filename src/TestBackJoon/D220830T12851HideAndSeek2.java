package TestBackJoon;

/*
 * ������: ���ٲ���2
 * ����: 22.08.30.ȭ~09.01.��
 * https://www.acmicpc.net/problem/1697
 * ����Ǯ��: BFS
 * �Է�1: 
5 17
 * ���1:
4
2
 * �Է�2: 
1 4
 * ���2:
2
2
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D220830T12851HideAndSeek2 {
	static final int MAX = 1000001;
	static int[] map = new int[MAX];
	static boolean[] visited = new boolean[MAX];
	static int N, K, count = 0, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// �� ��ġ�� ���� ��ġ���� �����̰ų� ���� ���
		if(N >= K) {
			// -1 �̵� ������θ� �̵� ������.
			System.out.print((N-K)+"\n"+1);
		}
		else {
			bfs();
			System.out.print(min+"\n"+count);	
		}
	}

	// �޸� 293840 KB, �ð� 412 ms
	static void bfs() {
		Queue<Pair> queue = new LinkedList<Pair>();

		// �ڡ�Queue�� ���� ��ġ�� �ɸ��� �ð��� ������ �������� �� �����Ƿ� ��ġ�� �Բ� ������
		queue.add(new Pair(N, 0));

		while(!queue.isEmpty()) {
			Pair now = queue.poll();
			int x = now.x;
			int move = now.move;
			
			// �ڡ����� ��ġ�� �湮 ó�� -> ���� ������ �ɸ� �ð��� ������ ������ �� �����Ƿ� �湮 ���� ó���� push�� �ƴ� pop�� �� ����.
			visited[x] = true;

			// ���ּҽð����� ���� �ɸ� �ð��� �̻��̸� Ž�� ����
			if(min < move) return;
			
			if(x == K) {
				System.out.println();
				
				if(min > move)
					min = move; // ���� ���� �ð� 
				 
				if(move == min)
					count++;
				
				continue; // ���� ���� ���������Ƿ� �ش� Ž���� ����
			}
			
			int[] moveArr = {x-1, x+1, x*2};
			for(int i = 0; i < 3; i++) {
				int nx = moveArr[i];
				
				if(nx < 0 || nx >= MAX) continue;
				
				if(!visited[nx]) {
					queue.add(new Pair(nx, move+1));
				}
			}
		}
	}
	public static class Pair{
		int x;
		int move;
		public Pair(int x, int move){
			this.x = x;
			this.move = move;
		}
	}
	
	// �޸� 123536 KB, �ð� 316 ms
	static void bfs2() {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(N);

		// �ڡڵ����� ��ġ�� ��湮�ؾ� �ϹǷ� �湮 ���� Ȯ�� ����
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			// ���ּҽð����� ���� �ɸ� �ð��� �̻��̸� Ž�� ����
			if(min < map[x]) return;
			
			if(x == K) {
				if(min > map[K])
					min = map[K]; // ���� ���� �ð� 
				 
				if(map[K] == min)
					count++;
				
				continue; // ���� ���� ���������Ƿ� �ش� Ž���� ����
			}
			
			int[] moveArr = {x-1, x+1, x*2};
			for(int i = 0; i < 3; i++) {
				int nx = moveArr[i];
				
				if(nx < 0 || nx >= MAX) continue;
				
				/* �ڡ� nx�� �̵� ���� �̵� ���� ���� Ȯ�� = push ����9
				 * 1. ù �湮
				 * 2. 1->4�� �̵��� �� ��ġ1���� �̵��ϸ� 2=1+1�� 2=1*2 �� �ΰ��� ������� ���� ������ �̵��� �� ����
				 	��, ���� ��ġ 1���� �̵��ϴ� ����� ���� ������ �� 
				 	1+1 �̵��ϴ� ��� Ȯ�� �� ��ġ 2�� ���� �湮�̹Ƿ� �̵��� �����ϸ� map[2] �� �������� �Ŀ�
				 	1*2 �̵��ϴ� ��� Ȯ�� �� 1+1���� ��ġ 2�� �̹� �湮�Ͽ����Ƿ� map[2] ���� ���� ��ġ ���� map[1]�� 1�� ������ ������ ũ�� �ּ� �̵� ���� ã�°Ŵ� ��湮 ���� ����
				 */ 
				if(map[nx] == 0 || map[nx] == map[x] + 1) {
					queue.add(nx);
					map[nx] = map[x] + 1;
				}
			}
		}
	}
}