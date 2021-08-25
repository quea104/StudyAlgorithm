package TestBackJoon;
/*
 * ������: ����
 * ����: 21.06.08.ȭ
 * https://www.acmicpc.net/problem/2231
 * ��������:
 		� �ڿ��� N�� ���� ��, �� �ڿ��� N�� �������� N�� N�� �̷�� �� �ڸ����� ���� �ǹ��Ѵ�. � �ڿ��� M�� �������� N�� ���, M�� N�� �����ڶ� �Ѵ�. ���� ���, 245�� �������� 256(=245+2+4+5)�� �ȴ�. 
 		���� 245�� 256�� �����ڰ� �ȴ�. ����, � �ڿ����� ��쿡�� �����ڰ� ���� ���� �ִ�. �ݴ��, �����ڰ� ���� ���� �ڿ����� ���� �� �ִ�.
		�ڿ��� N�� �־����� ��, N�� ���� ���� �����ڸ� ���س��� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� �ڿ��� N(1 �� N �� 1,000,000)�� �־�����.
 * ���: ù° �ٿ� ���� ����Ѵ�. �����ڰ� ���� ��쿡�� 0�� ����Ѵ�.
 * Ǯ��: https://st-lab.tistory.com/98
 		�ּҰ��� N-9*N�ڸ����ε� Ž���� �� �ִ� ���� ������ ���� ���� ���� ���ؾ� �ϹǷ� �������� ���� ū ��(N+9*N�ڸ���)�� ������ �����Ͽ� 9*N�ڸ����� ����� ��
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D210608T2231ApartSum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str_N = br.readLine();
		int len = str_N.length();
		int N = Integer.parseInt(str_N);
		int result = 0;
		for(int i = N-(9*len); i < N; i++) {
			int sum = i;
			int temp = i;
			while(temp > 0) {
				sum += temp%10;
				temp /= 10;
			}
				
			if(sum == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
