package TestBackJoon;
/*
 * ������: N�� M (4)
 * ����: 21.06.16.��
 * https://www.acmicpc.net/problem/15652
 * ��������: �ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
			1���� N���� �ڿ��� �߿��� M���� �� ����
			���� ���� ���� �� ��� �ȴ�.
			�� ������ �񳻸������̾�� �Ѵ�.
			���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�.
 * �Է�: ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 8)
 * ���: �� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�. ������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class D210616T15652NAndM4 {
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dfs(1, 0, "");
		
		System.out.println(sb.toString());
	}

	static void dfs(int index, int depth, String result) {
		if(depth == M) {
			sb.append(result).append("\n");
		}
		else {
			for(int i = index; i <= N; i++) {
				dfs(i, depth+1, result + Integer.toString(i) + " ");
			}
		}
	}
}