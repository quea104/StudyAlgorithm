package TestBackJoon;
/*
 * ������: ���� �� ���ϱ�
 * ����: 21.07.01.��
 * https://www.acmicpc.net/problem/2042
 * ��������: � N���� ���� �־��� �ִ�. �׷��� �߰��� ���� ������ ����� �Ͼ�� �� �߰��� � �κ��� ���� ���Ϸ� �Ѵ�.
 * 		���࿡ 1,2,3,4,5 ��� ���� �ְ�, 3��° ���� 6���� �ٲٰ� 2��°���� 5��°���� ���� ���϶�� �Ѵٸ� 17�� ����ϸ� �Ǵ� ���̴�. 
 * 		�׸��� �� ���¿��� �ټ� ��° ���� 2�� �ٲٰ� 3��°���� 5��°���� ���� ���϶�� �Ѵٸ� 12�� �� ���̴�.
 * �Է�: ù° �ٿ� ���� ���� N(1 �� N �� 1,000,000)�� M(1 �� M �� 10,000), K(1 �� K �� 10,000) �� �־�����. 
 		M�� ���� ������ �Ͼ�� Ƚ���̰�, K�� ������ ���� ���ϴ� Ƚ���̴�. �׸��� ��° �ٺ��� N+1��° �ٱ��� N���� ���� �־�����. 
 		�׸��� N+2��° �ٺ��� N+M+K+1��° �ٱ��� �� ���� ���� a, b, c�� �־����µ�, a�� 1�� ��� b(1 �� b �� N)��° ���� c�� �ٲٰ� a�� 2�� ��쿡�� b(1 �� b �� N)��° ������ c(b �� c �� N)��° �������� ���� ���Ͽ� ����ϸ� �ȴ�.
		�Է����� �־����� ��� ���� -263���� ũ�ų� ����, 263-1���� �۰ų� ���� �����̴�.
 * ���: ù° �ٺ��� K�ٿ� ���� ���� ������ ���� ����Ѵ�. ��, ������ -263���� ũ�ų� ����, 263-1���� �۰ų� ���� �����̴�.
 * Ǯ��: Segment Tree �ڷᱸ���� Ǯ���ؾ� ��
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D210701T2042SolvingSumOfInterval {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // ���� ����
		int M = Integer.parseInt(st.nextToken()); // ���� ������ �Ͼ�� Ƚ��
		int K = Integer.parseInt(st.nextToken()); // ������ ���� ���ϴ� Ƚ��
				
		long[] arr = new long[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		StringBuilder sb = new StringBuilder();
		while(M > 0 || K > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) { // b(1 �� b �� N)��° ���� c�� �ٲٱ�
				M--;
				arr[b-1] = c;
			}
			else { // a�� 2�� ��쿡�� b(1 �� b �� N)��° ������ c(b �� c �� N)��° �������� ���� ���Ͽ� ���
				K--;
				long sum = 0;
				for(int i = b-1; i < c; i++) {
					sum += arr[i];
				}
				sb.append(sum + "\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}