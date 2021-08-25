package TestBackJoon;
/*
 * ������: ���ĺ� ã��
 * ����: 21.03.25.��
 * https://www.acmicpc.net/problem/10809
 * ��������: 
 		���ĺ� �ҹ��ڷθ� �̷���� �ܾ� S�� �־�����. 
 		������ ���ĺ��� ���ؼ�, �ܾ ���ԵǾ� �ִ� ��쿡�� ó�� �����ϴ� ��ġ��, ���ԵǾ� ���� ���� ��쿡�� -1�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� �ܾ� S�� �־�����. �ܾ��� ���̴� 100�� ���� ������, ���ĺ� �ҹ��ڷθ� �̷���� �ִ�.
 * ���: 
 		������ ���ĺ��� ���ؼ�, a�� ó�� �����ϴ� ��ġ, b�� ó�� �����ϴ� ��ġ, ... z�� ó�� �����ϴ� ��ġ�� �������� �����ؼ� ����Ѵ�.
		����, � ���ĺ��� �ܾ ���ԵǾ� ���� �ʴٸ� -1�� ����Ѵ�. �ܾ��� ù ��° ���ڴ� 0��° ��ġ�̰�, �� ��° ���ڴ� 1��° ��ġ�̴�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210325T10809SearchAlphabet {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		br.close();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 'a'; i <= 'z'; i++) {
			sb.append(word.indexOf(i)).append(" ");
		}
//		String smallAlphabet = "abcdefghijklmnopqrstuvwxyz";
//		int[] counts = new int[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
//		for(int i = 0; i < word.length(); i++) {
//			int idx = smallAlphabet.indexOf(word.substring(i, i+1));
//			if(counts[idx] == -1) 
//				counts[idx] = i;
//		}
//		for(int i = 0; i < counts.length; i++) {
//			sb.append(counts[i]).append(" ");
//		}
		System.out.print(sb.toString());
	}
}