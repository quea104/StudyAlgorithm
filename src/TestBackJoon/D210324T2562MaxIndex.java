package TestBackJoon;
/*
 * ������: �ִ�
 * ����: 21.03.24.��
 * https://www.acmicpc.net/problem/2562
 * ��������: 9���� ���� �ٸ� �ڿ����� �־��� ��, �̵� �� �ִ��� ã�� �� �ִ��� �� ��° �������� ���ϴ� ���α׷��� �ۼ�
 * �Է�: ù° �ٺ��� ��ȩ ��° �ٱ��� �� �ٿ� �ϳ��� �ڿ����� �־�����. �־����� �ڿ����� 100 ���� �۴�.
 * ���: ù° �ٿ� �ִ��� ����ϰ�, ��° �ٿ� �ִ��� �� ��° �������� ����Ѵ�.
 */

import java.util.Scanner;
public class D210324T2562MaxIndex {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int index = 1;
		int max = sc.nextInt();
		for(int i = 1; i < 9; i++) {
			int num = sc.nextInt();
			if(max < num) {
				max = num;
				index = i+1;
			}
		}
		System.out.println(max);
		System.out.println(index);
	}
}
