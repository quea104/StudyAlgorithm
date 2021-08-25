package TestBackJoon;
/*
 * ������: �Ѽ�
 * ����: 21.03.25.��
 * https://www.acmicpc.net/problem/1065
 * ��������: 
 		� ���� ���� X�� �� �ڸ��� ���������� �̷�ٸ�, �� ���� �Ѽ���� �Ѵ�. 
 		���������� ���ӵ� �� ���� ���� ���̰� ������ ������ ���Ѵ�. N�� �־����� ��, 1���� ũ�ų� ����, N���� �۰ų� ���� �Ѽ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 * �Է�: ù° �ٿ� 1,000���� �۰ų� ���� �ڿ��� N�� �־�����.
 * ���: ù° �ٿ� 1���� ũ�ų� ����, N���� �۰ų� ���� �Ѽ��� ������ ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210325T1065ContinueNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		if (N < 100)
			count = N; 
		else {
			count = 99;
			for(int i = 100; i <= N; i++) {
				int arr[] = new int[3];
				arr[0] = i / 100; // i=100, 1
				arr[1] = (i/10) % 10; // 0
				arr[2] = i % 10; // 0
				
				if(arr[2] - arr[1] == arr[1] - arr[0])
					count++;
				
//				if(check(Integer.toString(i), 0, 0))
//					count++;
			}
		}
		System.out.println(count);
	}
	
//	private boolean check(String strNum, int idx, int d1) {
//		if (idx >= strNum.length()-1)
//			return true;
//		else {
//			int n1 = Integer.parseInt(strNum.substring(idx, idx+1));
//			int n2 = Integer.parseInt(strNum.substring(idx+1, idx+2));
//			int d2 = n2 - n1;
//			if(idx > 0 && d2 != d1) {
//				return false;
//			}
//			else {
//				return check(strNum, idx+1, d2);
//			}
//		}
//	}
}
