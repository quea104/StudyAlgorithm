package TestBackJoon;
/*
 * ������: �Ҽ� ã��
 * ����: 21.03.31.��
 * https://www.acmicpc.net/problem/1978
 * ��������: �־��� �� N�� �߿��� �Ҽ��� �� ������ ã�Ƽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù �ٿ� ���� ���� N�� �־�����. N�� 100�����̴�. �������� N���� ���� �־����µ� ���� 1,000 ������ �ڿ����̴�.
 * ���: �־��� ���� �� �Ҽ��� ������ ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class D210331T1978SearchPrimeNumber {
	public static void main(String[] args) throws IOException {
		boolean[] primeCheck = new boolean[1001]; // true: �Ҽ��ƴ�, false:�Ҽ���
		primeCheck[0] = primeCheck[1] = true;
		for(int i = 2; i < primeCheck.length; i++) {
			for(int j = i-1; j >= 2; j--) {
				if(primeCheck[j])
					continue;
				if(i%j == 0) {
					primeCheck[i] = true;
					break;
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(!primeCheck[Integer.parseInt(st.nextToken())])
				count++;
		}
		System.out.println(count);
	}
}