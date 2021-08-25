package TestBackJoon;
/*
 * ������: �ý� ������
 * ����: 21.04.02.��
 * https://www.acmicpc.net/problem/3053
 * ��������: 
		19���� ���� ������ �츣�� ��������Ű�� ����Ŭ���� ������ �� �ý� �������� ����ߴ�.
		�ý� �����п��� �� �� T1(x1,y1), T2(x2,y2) ������ �Ÿ��� ������ ���� ���� �� �ִ�.			
		D(T1,T2) = |x1-x2| + |y1-y2|			
		�� �� ������ �Ÿ��� ������ ������ ���Ǵ� ��Ŭ���� �����п����� ���ǿ� ����.			
		���� �ý� �����п��� ���� ���Ǵ� ��Ŭ���� �����п��� ���� ���ǿ� ����.			
		��: ��� ���� � ������ �Ÿ��� ������ ������ ����			
		������ R�� �־����� ��, ��Ŭ���� �����п��� ���� ���̿�, �ý� �����п��� ���� ���̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� ������ R�� �־�����. R�� 10,000���� �۰ų� ���� �ڿ����̴�.
 * ���: ù° �ٿ��� ��Ŭ���� �����п��� �������� R�� ���� ���̸�, ��° �ٿ��� �ý� �����п��� �������� R�� ���� ���̸� ����Ѵ�. ������� ������ 0.0001���� ����Ѵ�.
 * Ǯ��:
 		��Ŭ���� ������> ���� ���� = ���� ���� * (������)����
 		�ý� ������> ���簢��(��)�� ���� = �Ѻ��Ǳ��� * �Ѻ��� ����
 		
 		�ý� ������> ���� = �밢���� ���� = �Ѻ��� ���� * ��2
 		2r = ��2 * a => ���� ���� ó�� => 4r^2 = 2a^2 => ���� 2 ������ => 2r^2 = a^2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210402T3053TaxicaGeometry {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(br.readLine());
		System.out.println(String.format("%.6f", (Math.PI)*r*r));
		System.out.println(String.format("%.6f", (double)2*r*r));
	}
}