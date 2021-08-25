package TestBackJoon;
/*
 * ������: N�� M (2)
 * ����: 21.06.15.ȭ
 * https://www.acmicpc.net/problem/15650
 * ��������: �ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
			1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
			�� ������ ���������̾�� �Ѵ�.
 * �Է�: ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 8)
 * ���: �� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�. ������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class D210615T15650NAndM2 {
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
			sb.append(result.trim()).append("\n");
			return;
		}
		else {
			for(int i = index; i <= N; i++) {
				dfs(i+1, depth+1, result + Integer.toString(i) + " ");
			}
		}
	}
}