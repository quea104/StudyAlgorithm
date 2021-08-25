package TestBackJoon;
/*
 * ������: N�� M (3)
 * ����: 21.06.16.��
 * https://www.acmicpc.net/problem/15651
 * ��������: �ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
			1���� N���� �ڿ��� �߿��� M���� �� ����
			���� ���� ���� �� ��� �ȴ�.
 * �Է�: ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 8)
 * ���: �� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�. ������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class D210616T15651NAndM3 {
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dfs(0, "");
		
		System.out.println(sb.toString());
	}

	static void dfs(int depth, String result) {
		if(depth == M) {
			sb.append(result).append("\n");
		}
		else {
			for(int i = 1; i <= N; i++) {
				dfs(depth+1, result + Integer.toString(i) + " ");
			}
		}
	}
}