package TestBackJoon;
/*
 * ������: �ܾ� ����
 * ����: 21.06.14.��
 * https://www.acmicpc.net/problem/1181
 * ��������: ���ĺ� �ҹ��ڷ� �̷���� N���� �ܾ ������ �Ʒ��� ���� ���ǿ� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�. ���̰� ª�� �ͺ���->���̰� ������ ���� ������
 * �Է�: ù° �ٿ� �ܾ��� ���� N�� �־�����. (1 �� N �� 20,000) ��° �ٺ��� N���� �ٿ� ���� ���ĺ� �ҹ��ڷ� �̷���� �ܾ �� �ٿ� �ϳ��� �־�����. �־����� ���ڿ��� ���̴� 50�� ���� �ʴ´�.
 * ���: ���ǿ� ���� �����Ͽ� �ܾ���� ����Ѵ�. ��, ���� �ܾ ���� �� �Էµ� ��쿡�� �� ������ ����Ѵ�.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class D210614T1181OrderWord {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < N; i++) {
			ArrayList<String> innerList = new ArrayList<>();
			String word = br.readLine();
			innerList.add(Integer.toString(word.length()));
			innerList.add(word);
			list.add(innerList);
		}
		
		list.sort((e1, e2) -> {
			int numE1 = Integer.parseInt(e1.get(0));
			int numE2 = Integer.parseInt(e2.get(0));
			if(numE1 > numE2) {
				return 1;
			}
			else if(numE1 == numE2) {
				if(e1.get(1).compareTo(e2.get(1)) > 0) {
					return 1;
				}
				else if(e1.get(1).equals(e2.get(1))) {
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
		
		String repeatWord = "";
		StringBuilder sb = new StringBuilder();
		for(ArrayList<String> innerList : list) {
			String word = innerList.get(1);
			if(!repeatWord.equals(word)) {
				sb.append(word).append("\n");	
			}
			repeatWord = word; 
		}
		System.out.println(sb.toString());
	}
}