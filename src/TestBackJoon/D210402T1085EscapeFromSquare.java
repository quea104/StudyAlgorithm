package TestBackJoon;
/*
 * ������: ���簢������ Ż��
 * ����: 21.04.02.��
 * https://www.acmicpc.net/problem/1085
 * ��������: �Ѽ��� ���� (x, y)�� �ִ�. ���簢���� ���� �Ʒ� �������� (0, 0)�� �ְ�, ������ �� �������� (w, h)�� �ִ�. ���簢���� ��輱���� ���� �Ÿ��� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� x, y, w, h�� �־�����.
 * ���: ù° �ٿ� ������ ������ ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class D210402T1085EscapeFromSquare {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		w -= x; h -= y;
		int c = x;
		if(c > y) c = y;
		if(c > w) c = w;
		if(c > h) c = h;
		System.out.println(c);
	}
}
