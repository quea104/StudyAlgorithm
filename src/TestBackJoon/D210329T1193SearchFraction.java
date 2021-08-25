package TestBackJoon;
/*
 * ������: �м�ã��
 * ����: 21.03.29.��
 * https://www.acmicpc.net/problem/1193
 * ��������:
 		�̿� ���� ������ �м����� 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> �� �� ���� ������� ������ ���ʴ�� 1��, 2��, 3��, 4��, 5��, �� �м���� ����.
		X�� �־����� ��, X��° �м��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� X(1 �� X �� 10,000,000)�� �־�����.
 * ���: ù° �ٿ� �м��� ����Ѵ�.
 * Ǯ��:
		count	~a		m/n
		1		(1)		1/1						=> 1+d / Math.abs(count-d)
		2		(2~3)	1/2 2/1					=> Math.abs(count-d) / 1+d
		3		(4~6)	3/1 2/2 1/3
		4		(7~10)	1/4 2/3 3/2 4/1
		5		(11~15) 5/1 4/2 3/3 2/4 1/5
		6		(16~20)	1/6 2/5 3/4 4/3 5/2 6/1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210329T1193SearchFraction {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int count = 0, a = 0;
		while(a < N) {
			count++;
	        a += count;
		}
		int m = 0, n = 0, d = a-N;
		if(count % 2 == 0) {
			m = Math.abs(count-d);
			n = 1+d;
		}
		else {
			m = 1+d;
			n = Math.abs(count-d);			
		}
		System.out.println(m + "/" + n);
	}
}
