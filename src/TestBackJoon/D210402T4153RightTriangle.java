package TestBackJoon;
/*
 * ������: �����ﰢ��
 * ����: 21.04.02.��
 * https://www.acmicpc.net/problem/4153
 * ��������: ���� ����Ʈ�ε��� �� ������ ���̰� 3, 4, 5�� �ﰢ���� ���� �ﰢ���ΰ��� �˾Ƴ´�. �־��� ������ ���̷� �ﰢ���� �������� �ƴ��� �����Ͻÿ�.
 * �Է�: �Է��� �������� �׽�Ʈ���̽��� �־����� �������ٿ��� 0 0 0�� �Էµȴ�. �� �׽�Ʈ���̽��� ��� 30,000���� ���� ���� ������ �־�����, �� �Է��� ���� ���̸� �ǹ��Ѵ�.
 * ���: �� �Է¿� ���� ���� �ﰢ���� �´ٸ� "right", �ƴ϶�� "wrong"�� ����Ѵ�.
 * Ǯ��: ��Ÿ��� ���� ��� a*a+b*b=c*c (��, C�� ���� ū��)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class D210402T4153RightTriangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 0 && b == 0 && c == 0) break;			
			if(a > c) {
				int tmp = a;
				a = c;
				c = tmp;
			}
			if(b > c) {
				int tmp = b;
				b = c;
				c = tmp;
			}
			sb.append(((a*a)+(b*b)==(c*c)) ? "right" : "wrong").append("\n");
		}
		System.out.println(sb.toString());
	}
}