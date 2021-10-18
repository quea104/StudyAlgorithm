package TestBackJoon;

/*
 * ������: �Ǻ���ġ �Լ�
 * ����: 21.10.14.��
 * https://www.acmicpc.net/problem/1003
 * ��������: 
 * �Է�: ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, N�� �־�����. N�� 40���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.
 * ���: �� �׽�Ʈ ���̽����� 0�� ��µǴ� Ƚ���� 1�� ��µǴ� Ƚ���� �������� �����ؼ� ����Ѵ�.
 * Ǯ��: ������ȹ��(Dynamic programming)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D211014T1003Fibonacci {
	static int[] memo = new int[41];
	static int[][] result = new int[41][2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		memo[0] = 0; memo[1] = 1;
		result[0][0] = 1; result[0][1] = 0;
		result[1][0] = 0; result[1][1] = 1;
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			fibonacci(n);
			sb.append(result[n][0] + " " + result[n][1] + "\n");
		}
		System.out.print(sb.toString());
	}
	
	static int fibonacci(int n) {
		if(n <= 1) {
			return n;
		}
		else {
			if(memo[n] > 0) {
				return memo[n]; 
			}
			
			memo[n] = fibonacci(n-1) + fibonacci(n-2);
			
			result[n][0] = result[n-1][0] + result[n-2][0];
			result[n][1] = result[n-1][1] + result[n-2][1];
			
			return memo[n];
		}
	}
}