package TestBackJoon;
/*
 * ������: ���ͺб���
 * ����: 21.03.29.��
 * https://www.acmicpc.net/problem/1712
 * ��������:
 		�������ڴ� ��Ʈ���� �����ϰ� �Ǹ��ϴ� ȸ���̴�. ��Ʈ�� �Ǹ� ����� ������� �ų� �Ӵ��, ��꼼, �����, �޿� �� A������ ���� ����� ���, �� ���� ��Ʈ���� �����ϴ� ������ ����� �ΰǺ� �� �� B������ ���� ����� ��ٰ� �Ѵ�.
		���� ��� A=1,000, B=70�̶�� ����. �� ��� ��Ʈ���� �� �� �����ϴ� ���� �� 1,070������ ���, �� �� �����ϴ� ���� �� 1,700������ ���.		
		��Ʈ�� ������ C�������� å���Ǿ��ٰ� �Ѵ�. �Ϲ������� ���� ����� �÷� ���� ���� ��� ���� �� ����(�Ǹź��)�� �� ���(=�������+�������)���� �������� �ȴ�. ���ʷ� �� ������ �� ��뺸�� ������ ������ �߻��ϴ� ������ ���ͺб���(BREAK-EVEN POINT)�̶�� �Ѵ�.		
		A, B, C�� �־����� ��, ���ͺб����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� A, B, C�� �� ĭ�� ���̿� �ΰ� ������� �־�����. A, B, C�� 21�� ������ �ڿ����̴�.
 * ���: ù ��° �ٿ� ���ͺб��� �� ���ʷ� ������ �߻��ϴ� �Ǹŷ��� ����Ѵ�. ���ͺб����� �������� ������ -1�� ����Ѵ�.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class D210329T1712BreakEvenPoint {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken()); // �������
		int b = Integer.parseInt(st.nextToken()); // �������
		int c = Integer.parseInt(st.nextToken()); // ��ǰ����
				
		if(b >= c) { // �Ȱ��� �Ȱų� ���ذ� �� ��� ���ͺб��� ����
			System.out.println(-1);
		}
		else {
			// �ݺ������� ó���ϸ� �ð����� �ʰ�
			// a + b*count < c*count
			// a < c*count - b*count
			// a < (c-b)*count
			// a / (c-b) < count
			System.out.println(a / (c-b) + 1);
		}
	}
}
