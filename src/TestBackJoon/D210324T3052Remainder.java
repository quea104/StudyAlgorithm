package TestBackJoon;
/*
 * ����: 21.03.24.��
 * https://www.acmicpc.net/problem/3052
 * ������: ������
 * ��������: 
 		�� �ڿ��� A�� B�� ���� ��, A%B�� A�� B�� ���� ������ �̴�. ���� ���, 7, 14, 27, 38�� 3���� ���� �������� 1, 2, 0, 2�̴�. 
		�� 10���� �Է¹��� ��, �̸� 42�� ���� �������� ���Ѵ�. �� ���� ���� �ٸ� ���� �� �� �ִ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٺ��� ����° �� ���� ���ڰ� �� �ٿ� �ϳ��� �־�����. �� ���ڴ� 1,000���� �۰ų� ����, ���� �ƴ� �����̴�.
 * ���: ù° �ٿ�, 42�� �������� ��, ���� �ٸ� �������� �� �� �ִ��� ����Ѵ�.
 * �׽�Ʈ ���̽� : 
1
2
43
42
84
23
25
35
34
32
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210324T3052Remainder {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int b = 42;
		int[] arr = new int[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		int n = 0;
		for(int i = 0; i < 10; i++) {
			int remainder = Integer.parseInt(br.readLine())%b;
			boolean isExsited = false;
			System.out.println(remainder);
			for(int j = i-1; j >= 0; j--) {
				if(arr[j] == remainder) {
					isExsited = true;
					break;
				}
			}
			if(!isExsited) {
				arr[n++] = remainder;
				count++;
			}
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(count);
	}
}
