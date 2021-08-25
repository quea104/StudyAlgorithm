package TestBackJoon;
/*
 * ������: �ͷ�
 * ����: 21.04.08.��
 * https://www.acmicpc.net/problem/1002
 * ��������: 
		�������� ���ȯ�� �ͷ��� �ٹ��ϴ� �����̴�. ������ ���� ���簨�� ��� �α����� �������� �ʴ´�. ������ �������� ���ȯ�� �����̴�.
		�̼����� �������� ���ȯ���� ����� ����(�����)�� ��ġ�� ����϶�� ����� ���ȴ�. �������� ���ȯ�� ���� �ڽ��� �ͷ� ��ġ���� ���� �������� �Ÿ��� ����ߴ�.
		�������� ��ǥ (x1, y1)�� ���ȯ�� ��ǥ (x2, y2)�� �־�����, �������� ����� �������� �Ÿ� r1�� ���ȯ�� ����� �������� �Ÿ� r2�� �־����� ��, ������� ���� �� �ִ� ��ǥ�� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� ������ ���� �̷���� �ִ�. �� �ٿ� x1, y1, r1, x2, y2, r2�� �־�����. x1, y1, x2, y2�� -10,000���� ũ�ų� ����, 10,000���� �۰ų� ���� �����̰�, r1, r2�� 10,000���� �۰ų� ���� �ڿ����̴�.
 * ���: �� �׽�Ʈ ���̽����� ������� ���� �� �ִ� ��ġ�� ���� ����Ѵ�. ���� ������� ���� �� �ִ� ��ġ�� ������ ���Ѵ��� ��쿡�� -1�� ����Ѵ�.
 * Ǯ��: https://travelerfootprint.tistory.com/61, https://hooongs.tistory.com/245(�ҽ� ���� ���� �ʱ�)
		d(�� �� ������ �Ÿ�) = ��(x2-x1)^2+(y2-y1)^2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class D210408T1002Turret {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // �� �� ������ �Ÿ�
			int count = 0;
			if(d == 0 && r1 == r2) { // �� ���� ����, �� �������� �Ÿ� ���� (����) 
				count = -1; // ���Ѵ�
			}
			else if(d == r1+r2 || (d == Math.abs(r1 - r2) && d != 0)) { // �� �� ������ �Ÿ� = �� ������ ���� �Ÿ��� �� (����) �Ǵ� �� �� ������ �Ÿ� = �� ������ ���� �Ÿ��� �� (����)
				count = 1;
			}
			else if(d < r1+r2 && d > Math.abs(r1 - r2)) { // �� �� ������ �Ÿ� < �� ������ ���� �Ÿ��� ��, �� �� ������ �Ÿ� > �� �������� �Ÿ��� �� (����)
				count = 2;
			}
			System.out.println(count);
			T--;
		}
	}
}
