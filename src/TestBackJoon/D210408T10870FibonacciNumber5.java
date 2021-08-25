package TestBackJoon;
/*
 * ������: �Ǻ���ġ ��
 * ����: 21.04.08.��
 * https://www.acmicpc.net/problem/10870
 * ��������: 
		�Ǻ���ġ ���� 0�� 1�� �����Ѵ�. 0��° �Ǻ���ġ ���� 0�̰�, 1��° �Ǻ���ġ ���� 1�̴�. �� ���� 2��° ���ʹ� �ٷ� �� �� �Ǻ���ġ ���� ���� �ȴ�.
		�̸� ������ �Ẹ�� Fn = Fn-1 + Fn-2 (n �� 2)�� �ȴ�.		
		n=17�϶� ���� �Ǻ���ġ ���� �Ẹ�� ������ ����.		
		0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597		
		n�� �־����� ��, n��° �Ǻ���ġ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� n�� �־�����. n�� 20���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.
 * ���: ù° �ٿ� n��° �Ǻ���ġ ���� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210408T10870FibonacciNumber5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(f(Integer.parseInt(br.readLine())));		
	}
	
	public static int f(int n) {
		if(n == 0 || n == 1) return n;
		else {
			return f(n-1) + f(n-2);
		}
	}
}