package TestBackJoon;
/*
 * ������: �� �����ϱ�2
 * ����: 21.06.10.��
 * https://www.acmicpc.net/problem/2751
 * ��������: N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� ���� ���� N(1 �� N �� 1,000,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ���ڰ� �־�����. �� ���� ������ 1,000,000���� �۰ų� ���� �����̴�. ���� �ߺ����� �ʴ´�.
 * ���: ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
 * Ǯ��: �ð� ���⵵�� O(nlogn)�� ���� �˰������� Ǯ �� �ֽ��ϴ�. ���� ��� ���� ����, �� ���� ���� ������, ����� �˰����̹Ƿ� ������ �� ����� ���� �Լ��� ���� ���� ��õ�帳�ϴ�.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class D210610T2751OrderNumber2 {
	public static int[] tempArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		// list �迭 �� �ϳ��� ���� �ȴ�.
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		for(int value : list) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
		
		/*
		// Counting Sort. ���� �ߺ������� �ʱ� ������ boolean[] �迭�� �Է� ���� ���� index�� ���� �Ǵµ�, �ƹ����� ���� �� ������ �ƴϹǷ� �ð����⵵�� O(n) ���� �ſ� ���� ����̴�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[10000001];
		
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())] = true;
		}

		for(int i = 0; i < N; i++) {
			if(arr[i])
				sb.append(i).append('\n');
		}
		System.out.println(sb);
		 */
	}
}
