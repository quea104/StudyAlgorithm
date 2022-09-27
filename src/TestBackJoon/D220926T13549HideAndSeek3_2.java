package TestBackJoon;

/*
 * ������: ���ٲ���3
 * ����: 22.09.26.��
 * https://www.acmicpc.net/problem/13549
 * ����Ǯ��: Dijkstra
 * �Է�1: 
5 17
 * ���1:
2
 * �Է�2: 
1 2
 * ���2:
0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D220926T13549HideAndSeek3_2 {
	static final int INF = 987654321;
	static final int END = 100001;
	static int[] map = new int[END];
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Arrays.fill(map, INF);
		search();

		System.out.print(map[K]);
	}

	private static void search() {
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.second, o2.second));
		queue.add(new Node(N, 0));
		map[N] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			int curIndex = curNode.index;
			System.out.print(curIndex + " / ");
			
			// �̹� ���ŵ� ����(map[curIndex]) �� ����
			if(map[curIndex] < curNode.second)
				continue;
			
			Node[] nextNodes = {new Node(curIndex*2, 0), new Node(curIndex+1, 1), new Node(curIndex-1, 1)};
			for(Node nextNode: nextNodes) {				
				if(nextNode.index < 0 || nextNode.index >= END) continue;
				
				if(map[nextNode.index] > map[curIndex] + nextNode.second) {
					map[nextNode.index] = map[curIndex] + nextNode.second;
					queue.add(new Node(nextNode.index, map[nextNode.index]));
				}
			}
		}
	}

	static class Node {
		private int index;
		private int second;
		
		public Node(int index, int second) {
			this.index = index;
			this.second = second;
		}
	}
}
