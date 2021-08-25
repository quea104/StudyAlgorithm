package TestBackJoon;
/*
 * ������: �� �����ϱ�3
 * ����: 21.06.14.��
 * https://www.acmicpc.net/problem/10989
 * ��������: N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� ���� ���� N(1 �� N �� 10,000,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ���ڰ� �־�����. �� ���� 10,000���� �۰ų� ���� �ڿ����̴�.
 * ���: ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
 * ����: 3 �� / 8 MB
 * Ǯ��: Counting Sort
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class D210614T10989OrderNumber3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
        br.close();

		for(int i = 1; i < 10001; i++) {
			while(arr[i] > 0) {
				sb.append(i).append('\n');
				arr[i]--;
			}
		}
		System.out.println(sb);
	}
}