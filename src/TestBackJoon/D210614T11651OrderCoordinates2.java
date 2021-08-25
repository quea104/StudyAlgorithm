package TestBackJoon;
/*
 * ������: ��ǥ �����ϱ�2
 * ����: 21.06.14.��
 * https://www.acmicpc.net/problem/11651
 * ��������: 2���� ��� ���� �� N���� �־�����. ��ǥ�� y��ǥ�� �����ϴ� ������, y��ǥ�� ������ x��ǥ�� �����ϴ� ������ ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� ���� ���� N (1 �� N �� 100,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� i������ ��ġ xi�� yi�� �־�����. (-100,000 �� xi, yi �� 100,000) ��ǥ�� �׻� �����̰�, ��ġ�� ���� �� ���� ����.
 * ���: ù° �ٺ��� N���� �ٿ� ���� ������ ����� ����Ѵ�.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class D210614T11651OrderCoordinates2 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			ArrayList<Integer> innerList = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			innerList.add(Integer.parseInt(st.nextToken()));
			innerList.add(Integer.parseInt(st.nextToken()));
			list.add(innerList);
		}
		
		list.sort((e1, e2) -> {
			if(e1.get(1) > e2.get(1)) {
				return 1;
			}
			else if(e1.get(1).equals(e2.get(1))) {
				if(e1.get(0) > e2.get(0)) {
					return 1;
				}
				else if(e1.get(0).equals(e2.get(0))) {
					return 0;
				}
				else {
					return -1;
				}
			}
			else {
				return -1;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (ArrayList<Integer> innerList : list) {
			sb.append(innerList.get(0)+" "+innerList.get(1)).append("\n");
		}
		System.out.println(sb.toString());
	}
}