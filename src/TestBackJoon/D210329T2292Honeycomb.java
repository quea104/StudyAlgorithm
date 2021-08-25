package TestBackJoon;
/*
 * ������: ����
 * ����: 21.03.29.��
 * https://www.acmicpc.net/problem/2292
 * ��������:
 		���� �׸��� ���� ���������� �̷���� ������ �ִ�. 
 		�׸����� ���� �ٿ� ���� �߾��� �� 1���� �����ؼ� �̿��ϴ� �濡 ���ư��鼭 1�� �����ϴ� ��ȣ�� �ּҷ� �ű� �� �ִ�. 
 		���� N�� �־����� ��, ������ �߾� 1���� N�� ����� �ּ� ������ ���� ������ �� �� �� ���� ���� ����������(���۰� ���� �����Ͽ�)�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 		���� ���, 13������ 3��, 58������ 5���� ������.
 * �Է�: ù° �ٿ� N(1 �� N �� 1,000,000,000)�� �־�����.
 * ���: �Է����� �־��� ����� �ּ� ������ ���� ������ �� �� �� ���� ���� �������� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210329T2292Honeycomb {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 1, a = 1;
		while(a < N) {
	        a += 6 * (count++);
		}
		System.out.println(count);
	}
}