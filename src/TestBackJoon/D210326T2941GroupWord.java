package TestBackJoon;
/*
 * ������: ũ�ξ�Ƽ�� ���ĺ�
 * ����: 21.03.26.��
 * https://www.acmicpc.net/problem/2941
 * ��������: �ܾ �־����� ��, �� ���� ũ�ξ�Ƽ�� ���ĺ����� �̷���� �ִ��� ����Ѵ�.
 * �Է�: ù° �ٿ� �ִ� 100������ �ܾ �־�����. ���ĺ� �ҹ��ڿ� '-', '='�θ� �̷���� �ִ�. �ܾ�� ũ�ξ�Ƽ�� ���ĺ����� �̷���� �ִ�. ���� ������ ǥ�� �����ִ� ���ĺ��� ����� ���·� �Էµȴ�.
 * ���: �Է����� �־��� �ܾ �� ���� ũ�ξ�Ƽ�� ���ĺ����� �̷���� �ִ��� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class D210326T2941GroupWord {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(wordCheck(br.readLine()))
				count++;
		}
		System.out.println(count);
	}
	
	public static boolean wordCheck(String word) {
		boolean[] alpha = new boolean[26];
		int prev = 0;
		for(int i = 0; i < word.length(); i++) {
			int now = word.charAt(i); 	// i ��° ���� ���� (���� ����)
			if (prev != now) {
				if(alpha[word.charAt(i)-'a'])
					return false;
				else {
					alpha[word.charAt(i)-'a'] = true;
					prev = now;
				}
				
			}
			else {
				continue;
			}
		}
	    return true;
	}
}