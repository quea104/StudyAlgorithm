package TestBackJoon;
/*
 * ������: ���
 * ����: 21.03.26.��
 * https://www.acmicpc.net/problem/2908
 * ��������:
 		������� ���� ����� ������ ���� ���Ѵ�. ����� ���ڸ� �дµ� ������ �ִ�. �̷��� ������ ���ϴ� ����� ���ؼ� ����̴� ���� ũ�⸦ ���ϴ� ������ ���־���. ����̴� �� �ڸ� �� �� ���� ĥ�ǿ� ���־���. �� ������ ũ�Ⱑ ū ���� ���غ���� �ߴ�.
		����� ���� �ٸ� ����� �ٸ��� �Ųٷ� �д´�. ���� ���, 734�� 893�� ĥ�ǿ� �����ٸ�, ����� �� ���� 437�� 398�� �д´�. ����, ����� �� ���� ū ���� 437�� ū ����� ���� ���̴�.
		�� ���� �־����� ��, ����� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� ����̰� ĥ�ǿ� ���� �� �� A�� B�� �־�����. �� ���� ���� ���� �� �ڸ� ���̸�, 0�� ���ԵǾ� ���� �ʴ�.
 * ���: ù° �ٿ� ����� ����� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class D210326T2908ReverseConstant {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		//int a = reverseNumber(Integer.parseInt(st.nextToken()));
		int b = reverseNumber(Integer.parseInt(st.nextToken()));
		System.out.println((a > b) ? a : b);
	}
	
	public static int reverseNumber(int num) {
		int rNum = 0;
		int ten = 100;
		while(num > 0) {
			rNum += (num%10)*ten;
			num /= 10;
			ten /= 10;
		}
		return rNum;
	}
}
