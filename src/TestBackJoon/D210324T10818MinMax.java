package TestBackJoon;
/*
 * ������: �ּ�, �ִ�
 * ����: 21.03.24.��
 * https://www.acmicpc.net/problem/10818
 * ��������: N���� ������ �־�����. �̶�, �ּڰ��� �ִ��� ���ϴ� ���α׷��� �ۼ�
 * �Է�: ù° �ٿ� ������ ���� N (1 �� N �� 1,000,000)�� �־�����. ��° �ٿ��� N���� ������ �������� �����ؼ� �־�����. ��� ������ -1,000,000���� ũ�ų� ����, 1,000,000���� �۰ų� ���� �����̴�.
 * ���: ù° �ٿ� �־��� ���� N���� �ּڰ��� �ִ��� �������� ������ ����Ѵ�.
 */

import java.util.Scanner;
public class D210324T10818MinMax {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = sc.nextInt(), max = min;
		for(int i = 1; i < N; i++) {
			int num = sc.nextInt();
			if(max < num) max = num;
			if(min > num) min = num;
		}
		System.out.print(min + " " + max);
	}
}
