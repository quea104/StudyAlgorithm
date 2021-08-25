package TestBackJoon;
/*
 * ������: ���� �ѹ�
 * ����: 21.03.25.��
 * https://www.acmicpc.net/problem/4673
 * ��������: 
 		���� �ѹ��� 1949�� �ε� ������ D.R. Kaprekar�� �̸� �ٿ���. ���� ���� n�� ���ؼ� d(n)�� n�� n�� �� �ڸ����� ���ϴ� �Լ���� ��������. ���� ���, d(75) = 75+7+5 = 87�̴�.
		���� ���� n�� �־����� ��, �� ���� �����ؼ� n, d(n), d(d(n)), d(d(d(n))), ...�� ���� ���� ������ ���� �� �ִ�. 
		���� ���, 33���� �����Ѵٸ� ���� ���� 33 + 3 + 3 = 39�̰�, �� ���� ���� 39 + 3 + 9 = 51, ���� ���� 51 + 5 + 1 = 57�̴�. �̷������� ������ ���� ������ ���� �� �ִ�.		
		33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...		
		n�� d(n)�� �����ڶ�� �Ѵ�. ���� �������� 33�� 39�� �������̰�, 39�� 51�� ������, 51�� 57�� �������̴�. �����ڰ� �� ������ ���� ��쵵 �ִ�. ���� ���, 101�� �����ڰ� 2��(91�� 100) �ִ�.		
		�����ڰ� ���� ���ڸ� ���� �ѹ���� �Ѵ�. 100���� ���� ���� �ѹ��� �� 13���� �ִ�. 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97		
		10000���� �۰ų� ���� ���� �ѹ��� �� �ٿ� �ϳ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: �Է��� ����.
 * ���: 10,000���� �۰ų� ���� ���� �ѹ��� �� �ٿ� �ϳ��� �����ϴ� ������ ����Ѵ�.
 */

//import java.io.BufferedWriter;
//import java.io.OutputStreamWriter;
//import java.io.IOException;
public class D210325T4673SelfNumber {
	public static void main(String[] args) { // throws IOException
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = 10001;
		boolean[] numbers = new boolean[N];
		for(int i = 1; i < N; i++) {
			int num = d(i);
			if(num < N)
				numbers[num] = true;
		}
		
		for(int i = 1; i < N; i++) {
			if(!numbers[i])
				//bw.write(i + "\n");
				sb.append(i).append('\n');
		}
		System.out.print(sb);
		//bw.flush();
	}
	
	public static int d(int num) {
		int sum = num;
		
		// ���� ���
		while (num != 0) {
			sum += (num % 10);
			num = num / 10;
		}
		
		// ���ڿ��� ���
//		String strNum = Integer.toString(num);
//		for(int i = 0; i < strNum.length(); i++) {
//			sum += Integer.parseInt(strNum.substring(i, i+1));
//		}
		return sum;
	}
}
