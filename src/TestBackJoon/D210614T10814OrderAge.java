package TestBackJoon;
/*
 * ������: ���̼� ����
 * ����: 21.06.14.��
 * https://www.acmicpc.net/problem/10814
 * ��������: �¶��� ������ ������ ������� ���̿� �̸��� ������ ������� �־�����. �̶�, ȸ������ ���̰� �����ϴ� ������, ���̰� ������ ���� ������ ����� �տ� ���� ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� �¶��� ���� ȸ���� �� N�� �־�����. (1 �� N �� 100,000) 
 		��° �ٺ��� N���� �ٿ��� �� ȸ���� ���̿� �̸��� �������� ���еǾ� �־�����. ���̴� 1���� ũ�ų� ������, 200���� �۰ų� ���� �����̰�, �̸��� ���ĺ� ��ҹ��ڷ� �̷���� �ְ�, ���̰� 100���� �۰ų� ���� ���ڿ��̴�. �Է��� ������ ������ �־�����.
 * ���: ù° �ٺ��� �� N���� �ٿ� ���� �¶��� ���� ȸ���� ���� ��, ���̰� ������ ������ ������ �� �ٿ� �� �� ���̿� �̸��� �������� ������ ����Ѵ�.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class D210614T10814OrderAge {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<String> innerList = new ArrayList<>();
			innerList.add(st.nextToken());
			innerList.add(st.nextToken());
			list.add(innerList);
		}
		
		list.sort((e1, e2) -> {
			int numE1 = Integer.parseInt(e1.get(0));
			int numE2 = Integer.parseInt(e2.get(0));
			if(numE1 > numE2) {
				return 1;
			}
			else if(numE1 == numE2) {
				return 0;
			}
			else {
				return -1;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(ArrayList<String> innerList : list) {
			sb.append(innerList.get(0)).append(" ").append(innerList.get(1)).append("\n");	
		}
		System.out.println(sb.toString());
	}
}