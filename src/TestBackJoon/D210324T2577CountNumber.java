package TestBackJoon;

/*
 * ������: ������ ����
 * ����: 21.03.24.��
 * https://www.acmicpc.net/problem/2577
 * ��������: �� ���� �ڿ��� A, B, C�� �־��� �� A �� B �� C�� ����� ����� 0���� 9���� ������ ���ڰ� �� ���� ���������� ���ϴ� ���α׷��� �ۼ�
 * �Է�: ù° �ٿ� A, ��° �ٿ� B, ��° �ٿ� C�� �־�����. A, B, C�� ��� 100���� ���ų� ũ��, 1,000���� ���� �ڿ����̴�.
 * ���: ù° �ٿ��� A �� B �� C�� ����� 0 �� �� �� �������� ����Ѵ�. ���������� ��° �ٺ��� �� ��° �ٱ��� A �� B �� C�� ����� 1���� 9������ ���ڰ� ���� �� �� �������� ���ʷ� �� �ٿ� �ϳ��� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class D210324T2577CountNumber {
	// ���ڿ��� �ذ�
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String result = Integer.toString(Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()));
		int[] arrCount = new int[10];
		for(int i = 0; i < result.length(); i++) {
			int num = Integer.parseInt(result.substring(i, i+1));
			arrCount[num]++;
		}
		
		for(int i = 0; i < arrCount.length; i++) {
			System.out.println(arrCount[i]);
		}
	}
	
//	���ڷ� �ذ�
//	public void solution() {
//		Scanner sc = new Scanner(System.in);		
//		int result = sc.nextInt() * sc.nextInt() * sc.nextInt();
//		int[] arrCount = new int[10];
//		for(int i = 0; i < Integer.toString(result).length(); i++) {
//			int num = result/powerTen(i)%10;
//			arrCount[num]++;
//		}
//		
//		for(int i = 0; i < arrCount.length; i++) {
//			System.out.println(arrCount[i]);
//		}
//	}
//	
//	private int powerTen(int n) {
//		if(n == 0) return 1;
//		else if(n == 1) return 10;
//		return 10*powerTen(n-1);
//	}
}
