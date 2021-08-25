package TestBackJoon;
/*
 * ������: �Ҽ�
 * ����: 21.03.31.��
 * https://www.acmicpc.net/problem/2581
 * ��������: 
		�ڿ��� M�� N�� �־��� �� M�̻� N������ �ڿ��� �� �Ҽ��� ���� ��� ��� �̵� �Ҽ��� �հ� �ּڰ��� ã�� ���α׷��� �ۼ��Ͻÿ�.
		���� ��� M=60, N=100�� ��� 60�̻� 100������ �ڿ��� �� �Ҽ��� 61, 67, 71, 73, 79, 83, 89, 97 �� 8���� �����Ƿ�, �̵� �Ҽ��� ���� 620�̰�, �ּڰ��� 61�� �ȴ�.
 * �Է�: �Է��� ù° �ٿ� M��, ��° �ٿ� N�� �־�����. M�� N�� 10,000������ �ڿ����̸�, M�� N���� �۰ų� ����.
 * ���: M�̻� N������ �ڿ��� �� �Ҽ��� ���� ��� ã�� ù° �ٿ� �� ����, ��° �ٿ� �� �� �ּڰ��� ����Ѵ�. 
		��, M�̻� N������ �ڿ��� �� �Ҽ��� ���� ���� ù° �ٿ� -1�� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210331T2581PrimeNumber {
	public static void main(String[] args) throws IOException {
		boolean[] primeCheck = new boolean[10001]; // true: �Ҽ��ƴ�, false:�Ҽ���
		primeCheck[0] = primeCheck[1] = true;
//		for(int i = 2; i < primeCheck.length; i++) {
//			for(int j = i-1; j >= 2; j--) {
//				if(primeCheck[j])
//					continue;
//				if(i%j == 0) {
//					primeCheck[i] = true;
//					break;
//				}
//			}
//		}
		for(int i = 2; i < primeCheck.length; i++) {
			if(!primeCheck[i]) {
				for(int j = i+i; j < primeCheck.length; j+=i) {
					primeCheck[j] = true;
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0, minPrime = 0;
		for(int i = M; i <= N; i++) {
			if(!primeCheck[i]) {
				sum += i;
				if(minPrime == 0) {
					minPrime = i;
				}
			}
		}
		if(sum == 0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(minPrime);
		}
	}
}