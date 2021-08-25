package TestBackJoon;
/*
 * ������: �ϳ��� ž �̵� ����
 * ����: 21.05.12.��
 * https://www.acmicpc.net/problem/11729
 * ��������: 
		�� ���� ��밡 �ְ� ù ��° ��뿡�� �ݰ��� ���� �ٸ� n���� ������ �׿� �ִ�. �� ������ �ݰ��� ū ������� �׿��ִ�. ���� �����µ��� ���� ��Ģ�� ���� ù ��° ��뿡�� �� ��° ���� �ű�� �Ѵ�.

		�� ���� �� ���� ���Ǹ��� �ٸ� ž���� �ű� �� �ִ�.
		�׾� ���� ������ �׻� ���� ���� �Ʒ��� �ͺ��� �۾ƾ� �Ѵ�.
		�� �۾��� �����ϴµ� �ʿ��� �̵� ������ ����ϴ� ���α׷��� �ۼ��϶�. ��, �̵� Ƚ���� �ּҰ� �Ǿ�� �Ѵ�.
		
		�Ʒ� �׸��� ������ 5���� ����� �����̴�.
 * �Է�: ù° �ٿ� ù ��° ��뿡 ���� ������ ���� N (1 �� N �� 20)�� �־�����.
 * ���: ù° �ٿ� �ű� Ƚ�� K�� ����Ѵ�.
�� ��° �ٺ��� ���� ������ ����Ѵ�. �� ��° �ٺ��� K���� �ٿ� ���� �� ���� A B�� ��ĭ�� ���̿� �ΰ� ����ϴµ�, �̴� A��° ž�� ���� ���� �ִ� ������ B��° ž�� ���� ���� �ű�ٴ� ���̴�.
 * Ǯ��: https://devlimk1.tistory.com/153
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D210512T11729Hanoi {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// �ϳ���ž �̵� Ƚ�� ��� ���� = 2^n-1
		sb.append((int)(Math.pow(2, n)-1)).append('\n');
		
		hanoi(n, 1, 2, 3); //start(1) -> to(3) �� ����n�� �̵�
		System.out.println(sb);
	}
	
	// ����n�� ���a���� ���c�� �ű��
	static void hanoi(int n, int start, int mid, int to) {
		if(n == 1) { // �̵��� ������ ���� 1�����?
			// ����n�� ���start���� ���to�� �Ű���
			sb.append(start + " " + to + "\n");
			return;
		}
		
		// ����n-1�� ���start���� ���mid�� �ű��
		hanoi(n-1, start, to, mid);
		
		// ����n�� ���start���� ���to�� �Ű���
		sb.append(start + " " + to + "\n");

		// ����n-1�� ���b���� ���to�� �ű��
		hanoi(n-1, mid, start, to);
	}
}
