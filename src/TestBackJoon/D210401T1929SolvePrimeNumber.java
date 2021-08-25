package TestBackJoon;
/*
 * ������: �Ҽ� ���ϱ�
 * ����: 21.04.01.��
 * https://www.acmicpc.net/problem/1929
 * ��������: M�̻� N������ �Ҽ��� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� �ڿ��� M�� N�� �� ĭ�� ���̿� �ΰ� �־�����. (1 �� M �� N �� 1,000,000) M�̻� N������ �Ҽ��� �ϳ� �̻� �ִ� �Է¸� �־�����.
 * ���: �� �ٿ� �ϳ���, �����ϴ� ������� �Ҽ��� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class D210401T1929SolvePrimeNumber {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] primeCheck = new boolean[N+1]; // true:�Ҽ�X, false:�Ҽ�O
		primeCheck[0] = primeCheck[1] = true;
		StringBuilder sb = new StringBuilder();
//		for(int i = 2; i <= N; i++) {
//			if(!primeCheck[i]) {
//				if(i >= M)
//					sb.append(i).append("\n");
//				for(int j = i+i; j <= N; j+=i) {
//					if(j%i == 0) {
//						primeCheck[j] = true;
//					}
//				}
//			}
//		}
		for(int i = 2; i < Math.sqrt(N); i++) {
			for(int j = 2; i*j <= N; j++) {
				if(!primeCheck[i*j]) {
					primeCheck[i*j] = true;
				}
			}
		}
		for(int i = M; i <= N; i++) {
			if(!primeCheck[i])
				sb.append(i).append("\n");
		}
		System.out.print(sb.toString());
	}
}
