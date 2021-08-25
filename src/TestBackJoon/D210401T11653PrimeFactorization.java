package TestBackJoon;
/*
 * ������: �Ҽ�
 * ����: 21.04.01.��
 * https://www.acmicpc.net/problem/11653
 * ��������: ���� N�� �־����� ��, ���μ������ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� ���� N (1 �� N �� 10,000,000)�� �־�����.
 * ���: N�� ���μ����� ����� �� �ٿ� �ϳ��� ������������ ����Ѵ�. N�� 1�� ��� �ƹ��͵� ������� �ʴ´�.
 * Ǯ��:
 		N�� �Ҽ� �Ǻ��� �� �����ٱ����� �˻��ϸ� ��
		: ��18  * ��18�� 18�ε�, �� ��18�� �¿�� ���ϱⰡ ��Ī�̹Ƿ� sqrt()������ ���ų� ���� ���ڷ� ���������� �� ���Ŀ� ���ؼ��� ��Ī�̹Ƿ� ����� �� �ʿ䰡 ����.
		: 18�� ����� 1, 2, 3, 6, 9, 18  =>  18�� 1 * 18, 2 * 9, 3 * 6   < ��18 >   6 * 3, 9 * 2, 18 * 1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210401T11653PrimeFactorization {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
//		boolean[] primeCheck = new boolean[N+1]; // true: �Ҽ��ƴ�, false:�Ҽ���
//		primeCheck[0] = primeCheck[1] = true;
//		for(int i = 2; i < primeCheck.length; i++) {
//			if(!primeCheck[i]) {
//				while(N%i == 0) {
//					sb.append(i).append("\n");
//					N /= i;
//				}
//				if(N == 1)
//					break;
//				for(int j = i+i; j <= N; j+=i) {
//					if(i%j == 0) {
//						primeCheck[j] = true;
//					}
//				}
//			}
//		}
		for(int i = 2; i <= Math.sqrt(N); i++) {
			while(N%i == 0) {
				sb.append(i).append("\n");
				N /= i;
			}
			if(N == 1) break;
		}
		if(N != 1) {
			sb.append(N);
		}
		System.out.print(sb.toString());
	}
}