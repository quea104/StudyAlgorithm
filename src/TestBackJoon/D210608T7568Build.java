package TestBackJoon;

/*
 * ������: ��ġ
 * ����: 21.06.08.ȭ
 * https://www.acmicpc.net/problem/7568
 * ��������:
 		���� ����� ��ġ�� Ű�� ������, �� �� ���� ������ ǥ���Ͽ� �� ����� �Űܺ����� �Ѵ�. � ����� �����԰� x kg�̰� Ű�� y cm��� �� ����� ��ġ�� (x, y)�� ǥ�õȴ�. 
 		�� ��� A �� B�� ��ġ�� ���� (x, y), (p, q)��� �� �� x > p �׸��� y > q �̶�� �츮�� A�� ��ġ�� B�� ��ġ���� "�� ũ��"�� ���Ѵ�. 
 		���� ��� � A, B �� ����� ��ġ�� ���� (56, 177), (45, 165) ��� �Ѵٸ� A�� ��ġ�� B���� ū ���� �ȴ�. �׷��� ���� �ٸ� ��ġ���� ũ�⸦ ���� �� ���� ��쵵 �ִ�. 
 		���� ��� �� ��� C�� D�� ��ġ�� ���� (45, 181), (55, 173)�̶�� �����Դ� D�� C���� �� ���̰�, Ű�� C�� �� ũ�Ƿ�, "��ġ"�θ� �� �� C�� D�� ������ ���溸�� �� ũ�ٰ� ���� �� ����.
		N���� ���ܿ��� �� ����� ��ġ ����� �ڽź��� �� "ū ��ġ"�� ����� ���� ��������. ���� �ڽź��� �� ū ��ġ�� ����� k���̶�� �� ����� ��ġ ����� k+1�� �ȴ�. �̷��� ����� �����ϸ� ���� ��ġ ����� ���� ����� ���� �� �����ϴ�.
 * �Է�: ù �ٿ��� ��ü ����� �� N�� �־�����. �׸��� �̾����� N���� �ٿ��� �� ����� �����Կ� Ű�� ��Ÿ���� ���� ���� x�� y�� �ϳ��� ������ �ΰ� ���� ��Ÿ����.
 * ���: �������� �Է¿� ������ ����� ��ġ ����� ���ؼ� �� ������� ù �ٿ� ����ؾ� �Ѵ�. ��, �� ��ġ ����� ���鹮�ڷ� �и��Ǿ�� �Ѵ�.
 * ����: 2 �� N �� 50, 10 �� x, y �� 200
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class D210608T7568Build {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int[] weightList = new int[n];
		int[] heightList = new int[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weightList[i] = Integer.parseInt(st.nextToken());
			heightList[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int rank = 1;
			int x = weightList[i];
			int y = heightList[i];
			
			for(int j = 0; j < n; j++) {
				if(i == j) 
					continue;
				
				int p = weightList[j];
				int q = heightList[j];
				
				if(x < p && y < q) {
					rank++;
				}
			}
			sb.append(rank).append(" ");
		}
		System.out.print(sb.toString());
	}
}