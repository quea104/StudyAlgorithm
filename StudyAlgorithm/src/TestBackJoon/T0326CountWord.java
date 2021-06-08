package TestBackJoon;
/*
 * ������: �ܾ��� ����
 * ����: 21.03.26.��
 * https://www.acmicpc.net/problem/1152
 * ��������: ���� ��ҹ��ڿ� ���⸸���� �̷���� ���ڿ��� �־�����. �� ���ڿ����� �� ���� �ܾ ������? �̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, �� �ܾ ���� �� �����ϸ� ������ Ƚ����ŭ ��� ����� �Ѵ�.
 * �Է�: ù �ٿ� ���� ��ҹ��ڿ� ����� �̷���� ���ڿ��� �־�����. �� ���ڿ��� ���̴� 1,000,000�� ���� �ʴ´�. �ܾ�� ���� �� ���� ���еǸ�, ������ �����ؼ� ������ ���� ����. ���� ���ڿ��� �հ� �ڿ��� ������ ���� ���� �ִ�.
 * ���: ù° �ٿ� �ܾ��� ������ ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class T0326CountWord {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence = br.readLine().trim();
		int count = sentence.split(" ").length;
		if(sentence.equals(""))
			count = 0;
		System.out.println(count);
	}
}