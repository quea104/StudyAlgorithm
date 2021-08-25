package TestBackJoon;
/*
 * ������: ��Ʈ�λ��̵�
 * ����: 21.06.14.��
 * https://www.acmicpc.net/problem/1427
 * ��������: �迭�� �����ϴ� ���� ����. ���� �־�����, �� ���� �� �ڸ����� ������������ �����غ���.
 * �Է�: ù° �ٿ� �����ϰ����ϴ� �� N�� �־�����. N�� 1,000,000,000���� �۰ų� ���� �ڿ����̴�.
 * ���: ù° �ٿ� �ڸ����� ������������ ������ ���� ����Ѵ�.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class D210614T1427SortNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		
		String strNumber = br.readLine();
		for(int i = 0; i < strNumber.length(); i++) {
			list.add(Integer.parseInt(strNumber.substring(i, i+1)));
		}
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int i = list.size()-1; i >= 0; i--) {
			sb.append(list.get(i));
		}
		System.out.println(sb.toString());
	}
}
