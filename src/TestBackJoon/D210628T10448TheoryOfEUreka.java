package TestBackJoon;
/*
 * ������: ����ī �̷�
 * ����: 21.06.28.��~29.ȭ
 * https://www.acmicpc.net/problem/10448
 * ��������: �ﰢ�� Tn(n �� 1)�� [�׸�]������ ���� ������������ ������ ����� ��Ģ�� ���� ������ �������� ǥ���� �� �ִ�.
		�ڿ��� n�� ���� n �� 1�� �ﰢ��Tn�� ����� ������ �ִ�.			
		Tn = 1 + 2 + 3 + ... + n = n(n+1)/2			
		1796��, ���콺�� ��� �ڿ����� �ִ� 3���� �ﰢ���� ������ ǥ���� �� �ִٰ� �����Ͽ���. ���� ���,			
			4 = T1 + T2
			5 = T1 + T1 + T2
			6 = T2 + T2 or 6 = T3
			10 = T1 + T2 + T3 or 10 = T4
		�� ����� ������ ����ϱ� ���� ���� ���̾�� ��Eureka! num = �� + �� + �ġ� ��� �����Ϳ��� ����ī �̷����� �˷�����. ���� ��� �ڿ����� ��Ȯ�� 3���� �ﰢ���� ������ ǥ���� �� �ִ��� �ñ�������. 
		���� ���ÿ���, 5�� 10�� ��Ȯ�� 3���� �ﰢ���� ������ ǥ���� �� ������ 4�� 6�� �׷��� �ʴ�.
		�ڿ����� �־����� ��, �� ������ ��Ȯ�� 3���� �ﰢ���� ������ ǥ���� �� �ִ��� �������� �Ǵ����ִ� ���α׷��� ������. ��, 3���� �ﰢ���� ��� �޶�� �� �ʿ�� ����.
 * �Է�: ���α׷��� ǥ���Է��� ����Ѵ�. �׽�Ʈ���̽��� ������ �Է��� ù ��° �ٿ� �־�����. �� �׽�Ʈ���̽��� �� �ٿ� �ڿ��� K (3 �� K �� 1,000)�� �ϳ��� ���ԵǾ��ִ� T���� �������� �����Ǿ��ִ�.
 * ���: ���α׷��� ǥ������� ����Ѵ�. �� �׽�Ʈ���̽������� ��Ȯ�� �� ������ ����Ѵ�. ���� K�� ��Ȯ�� 3���� �ﰢ���� ������ ǥ���ɼ� �ִٸ� 1��, �׷��� �ʴٸ� 0�� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class D210628T10448TheoryOfEUreka {
	static int N, pass;
	static int[] table = new int[45];
	
	public static void main(String[] args) throws IOException {
		/*
		// 1.����Ž��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			boolean pass = false;			
			for(int i = 1; i < 45; i++) {
				for(int j = 1; j < 45; j++) {
					for(int k = 1; k < 45; k++) {
						int sum = (i*(i+1)/2) + (j*(j+1)/2) + (k*(k+1)/2);
						if(sum == N) {
							pass = true;
							break;
						}
					}
					if(pass) break;
				}
				if(pass) break;
			}
			if(pass) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		
		System.out.println(sb.toString());
		*/
		
		// 2. DFS
		getTriangleNumber();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			pass = 0;
			dfs(0, 0);
			sb.append(pass).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int depth, int sum) {		
		if(depth == 3) {
			if(sum == N) { // 3���� �ﰢ���� ���� �̷��� ���
				pass = 1;
				return;
			}
			else // 3���� �ﰢ���� ���� �̷����� ���� ���
				return;
		}

		for(int i = 1; i < table.length; i++) {
			if(table[i] > N) return;
			
			dfs(depth+1, sum+table[i]);
		}
	}
	
	static void getTriangleNumber() {
		int n = 1;
		while(true) {
			int cal = n*(n+1)/2;
			if(cal >= 1000) break;
			table[n++] = cal;
		}
	}
}