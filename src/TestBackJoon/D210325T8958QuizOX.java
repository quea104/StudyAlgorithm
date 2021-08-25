package TestBackJoon;
/*
 * ������: OX����
 * ����: 21.03.25.��
 * https://www.acmicpc.net/problem/8958
 * ��������: 
 		"OOXXOXXOOO"�� ���� OX������ ����� �ִ�. O�� ������ ���� ���̰�, X�� ������ Ʋ�� ���̴�. ������ ���� ��� �� ������ ������ �� �������� ���ӵ� O�� ������ �ȴ�. ���� ���, 10�� ������ ������ 3�� �ȴ�.
		"OOXXOXXOOO"�� ������ 1+2+0+0+1+0+0+1+2+3 = 10���̴�.		
		OX������ ����� �־����� ��, ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, ���̰� 0���� ũ�� 80���� ���� ���ڿ��� �־�����. ���ڿ��� O�� X������ �̷���� �ִ�.
 * ���: �� �׽�Ʈ ���̽����� ������ ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210325T8958QuizOX {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			System.out.println(calculate(br.readLine()));
		}
	}
	
	public static int calculate(String paper) {
		int sum = 0, count = 1;
		for(int i = 0; i < paper.length(); i++) {
			String anw = paper.substring(i, i+1);
			if(anw.equals("O")) {
				sum += 1*(count++);
			}
			else {
				count = 1;
			}
		}		
		return sum;
	}
}
