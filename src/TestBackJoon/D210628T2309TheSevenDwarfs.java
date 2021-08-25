package TestBackJoon;
/*
 * ������: �ϰ� ������
 * ����: 21.06.28.��
 * https://www.acmicpc.net/problem/2309
 * ��������: �պ� ���� �ϰ� �����̵�� �Բ� ��ȭ�Ӱ� ��Ȱ�ϰ� �ִ� �鼳���ֿ��� ���Ⱑ ã�ƿԴ�. �ϰ��� ��ġ�� ���ƿ� �����̰� �ϰ� ���� �ƴ� ��ȩ ���̾��� ���̴�.
			��ȩ ���� �����̴� ��� �ڽ��� "�鼳 ���ֿ� �ϰ� ������"�� ���ΰ��̶�� �����ߴ�. �پ ������ �������� ������ �ִ� �鼳���ִ�, ���ེ���Ե� �ϰ� �������� Ű�� ���� 100�� ���� ����� �´�.
			��ȩ �������� Ű�� �־����� ��, �鼳���ָ� ���� �ϰ� �����̸� ã�� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ��ȩ ���� �ٿ� ���� �����̵��� Ű�� �־�����. �־����� Ű�� 100�� ���� �ʴ� �ڿ����̸�, ��ȩ �������� Ű�� ��� �ٸ���, ������ ������ ���� ������ ��쿡�� �ƹ��ų� ����Ѵ�.
 * ���: �ϰ� �������� Ű�� ������������ ����Ѵ�. �ϰ� �����̸� ã�� �� ���� ���� ����.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D210628T2309TheSevenDwarfs {
	static int[] table = new int[9];
	static boolean[] visited = new boolean[9];
	static int[] result = new int[7];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++) {
			table[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0, 0);
	}

	static void dfs(int depth, int start) {
		if(depth == 7) {
			if (Arrays.stream(result).sum() == 100){
				Arrays.sort(result);
				StringBuilder sb = new StringBuilder();
				for (int num : result)
					sb.append(num).append("\n");
				System.out.println(sb.toString());
				System.exit(0);
			}
			
			return ;
		}
		else {
			for(int i = start; i < 9; i++) {
				if(!visited[i]) {
					visited[i] = true;
					result[depth] = table[i];
					dfs(depth+1, i+1);
					visited[i] = false;
				}
			}
		}
	}
}