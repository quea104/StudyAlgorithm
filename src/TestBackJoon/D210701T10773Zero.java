package TestBackJoon;
/*
 * ������: ����
 * ����: 21.07.01.��
 * https://www.acmicpc.net/problem/10773
 * ��������: ���ڴ� ���� ����̴� ���Ƹ� ȸ���� �غ��ϱ� ���ؼ� ��θ� �����ϴ� ���̴�.
		�����̴� ����̸� ���ͼ� ���� �����ϴ� ���ε�, �ּ��ϰԵ� �׻� ���ž��� �����̴� ���� �Ǽ��� �߸� �θ��� ��� ġ�� �Ͼ�����.		
		�����̴� �߸��� ���� �θ� ������ 0�� ���ļ�, ���� �ֱٿ� ����̰� �� ���� ����� ��Ų��.		
		����̴� �̷��� ��� ���� �޾� ���� �� �� ���� ���� �˰� �;� �Ѵ�. ����̸� ��������!
 * �Է�: ù ��° �ٿ� ���� K�� �־�����. (1 �� K �� 100,000)
		���� K���� �ٿ� ������ 1���� �־�����. ������ 0���� 1,000,000 ������ ���� ������, ������ "0" �� ��쿡�� ���� �ֱٿ� �� ���� �����, �ƴ� ��� �ش� ���� ����.		
		������ "0"�� ��쿡 ���� �� �ִ� ���� ������ ������ �� �ִ�.
 * ���: ����̰� ���������� ���� �� ���� ���� ����Ѵ�. ���������� ��� ���� ���� 231-1���� �۰ų� ���� �����̴�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D210701T10773Zero {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		int[] stack = new int[K];
		int top = -1;

		while(K-- > 0) {
			int money = Integer.parseInt(br.readLine());
			if(money == 0) {
				stack[top] = 0;
				top--;
			}
			else {
				stack[++top] = money;
			}
		}

		int sum = 0;
		for(int i = 0; i < stack.length; i++) {
			sum += stack[i];
		}
		System.out.println(sum);
	}
}