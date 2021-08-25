package TestBackJoon;
/*
 * ������: �似Ǫ�� ����
 * ����: 21.06.30.��
 * https://www.acmicpc.net/problem/1158
 * ��������: �似Ǫ�� ������ ������ ����.
		1������ N������ N���� ����� ���� �̷�鼭 �ɾ��ְ�, ���� ���� K(�� N)�� �־�����. ���� ������� K��° ����� �����Ѵ�. 
		�� ����� ���ŵǸ� ���� ������ �̷���� ���� ���� �� ������ ����� ������. �� ������ N���� ����� ��� ���ŵ� ������ ��ӵȴ�. 
		������ ������� ���ŵǴ� ������ (N, K)-�似Ǫ�� �����̶�� �Ѵ�. ���� ��� (7, 3)-�似Ǫ�� ������ <3, 6, 2, 7, 5, 1, 4>�̴�.		
		N�� K�� �־����� (N, K)-�似Ǫ�� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� N�� K�� �� ĭ�� ���̿� �ΰ� ������� �־�����. (1 �� K �� N �� 5,000)
 * ���: ������ ���� �似Ǫ�� ������ ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D210630T1158JosephuProblem {	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 1. �迭 ���
		int[] queue = new int[N];
		for(int i = 0; i < N; i++) {
			queue[i] = i+1;
		}

		int size = N;
		int front = 0, move = 0;
		
		
		while(size-- > 0) {
			move = 0;
			while(move < K) {
				if(front == N) {
					front = 0;
				}
				
				if(queue[front] == 0) {
					front++;
				}
				else {
					front++;
					move++;
				}
			}
			
			sb.append(queue[front-1]).append(", ");			
			queue[front-1] = 0;
		}
		System.out.println("<" + sb.toString().substring(0, sb.length()-2) + ">");
		
		// 2. List ���
		sb = new StringBuilder();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			arr.add(i);
		}
		int idx = K-1;
		
		sb.append("<");
		while(arr.size() != 1) {
			int out = arr.remove(idx);
			sb.append(out);
			sb.append(", ");
			idx = (idx + K-1) % arr.size();
		}
		sb.append(arr.get(0));
		sb.append(">");
		System.out.println(sb);
	}
}