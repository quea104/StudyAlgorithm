package TestBackJoon;
/*
 * ������: �������� ����
 * ����: 21.04.01.��
 * https://www.acmicpc.net/problem/9020
 * ��������: 
  		1���� ū �ڿ��� �߿���  1�� �ڱ� �ڽ��� ������ ����� ���� �ڿ����� �Ҽ���� �Ѵ�. ���� ���, 5�� 1�� 5�� ������ ����� ���� ������ �Ҽ��̴�. 
  		������, 6�� 6 = 2 �� 3 �̱� ������ �Ҽ��� �ƴϴ�.
		�������� ������ ������ �������� ���ذ� ������, 2���� ū ��� ¦���� �� �Ҽ��� ������ ��Ÿ�� �� �ִٴ� ���̴�. �̷��� ���� ������ ����� �Ѵ�. 
		��, ¦���� �� �Ҽ��� ������ ��Ÿ���� ǥ���� �� ���� ������ ��Ƽ���̶�� �Ѵ�. ���� ���, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7�̴�. 
		10000���� �۰ų� ���� ��� ¦�� n�� ���� ������ ��Ƽ���� �����Ѵ�.
		2���� ū ¦�� n�� �־����� ��, n�� ������ ��Ƽ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� ������ n�� ������ ��Ƽ���� ���� ������ ��쿡�� �� �Ҽ��� ���̰� ���� ���� ���� ����Ѵ�.
 * �Է�: ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ� ¦�� n�� �־�����.
 * ���: �� �׽�Ʈ ���̽��� ���ؼ� �־��� n�� ������ ��Ƽ���� ����Ѵ�. ����ϴ� �Ҽ��� ���� �ͺ��� ���� ����ϸ�, �������� �����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210401T9020GoldbachConjecture {
	public static void main(String[] args) throws IOException {
		boolean[] prime = new boolean[10000+1];
		prime[0] = prime[1] = true;
		for(int i = 2; i < Math.sqrt(prime.length); i++) {
			for(int j = 2; i*j < prime.length; j++) {
				if(!prime[i*j]) {
					prime[i*j] = true;
				}
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		while(N > 0) {
			N--;
			int n = Integer.parseInt(br.readLine());
			int min = 0;
			for(int i = 2; i <= n/2; i++) {
				if(!prime[i] && !prime[n-i]) {
					min = i;
				}
			}
			sb.append(min).append(" ").append(n-min).append("\n");
		}
		System.out.println(sb.toString());
	}
}
