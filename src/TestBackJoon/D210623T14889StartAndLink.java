package TestBackJoon;
/*
 * ������: ��ŸƮ�� ��ũ
 * ����: 21.06.18.��, 22.ȭ~23.��
 * https://www.acmicpc.net/problem/14889
 * ��������: ������ ��ŸƮ��ũ�� �ٴϴ� ������� �𿩼� �౸�� �غ����� �Ѵ�. �౸�� ���� ���Ŀ� �ϰ� �ǹ� ������ �ƴϴ�. �౸�� �ϱ� ���� ���� ����� �� N���̰� �ű��ϰԵ� N�� ¦���̴�. ���� N/2������ �̷���� ��ŸƮ ���� ��ũ ������ ������� ������ �Ѵ�.
			BOJ�� ��ϴ� ȸ�� ��� ������� ��ȣ�� 1���� N������ �����߰�, �Ʒ��� ���� �ɷ�ġ�� �����ߴ�. �ɷ�ġ Sij�� i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�̴�. 
			���� �ɷ�ġ�� ���� ���� ��� ���� �ɷ�ġ Sij�� ���̴�. Sij�� Sji�� �ٸ� ���� ������, i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�� Sij�� Sji�̴�.
			���� ���, 1, 2���� ��ŸƮ ��, 3, 4���� ��ũ ���� ���� ��쿡 �� ���� �ɷ�ġ�� �Ʒ��� ����.
				��ŸƮ ��: S12 + S21 = 1 + 4 = 5
				��ũ ��: S34 + S43 = 2 + 5 = 7
			1, 3���� ��ŸƮ ��, 2, 4���� ��ũ ���� ���ϸ�, �� ���� �ɷ�ġ�� �Ʒ��� ����.
				��ŸƮ ��: S13 + S31 = 2 + 7 = 9
				��ũ ��: S24 + S42 = 6 + 4 = 10
			�౸�� ����ְ� �ϱ� ���ؼ� ��ŸƮ ���� �ɷ�ġ�� ��ũ ���� �ɷ�ġ�� ���̸� �ּҷ� �Ϸ��� �Ѵ�. ���� ������ ���� ��쿡�� 1, 4���� ��ŸƮ ��, 2, 3�� ���� ��ũ ���� ���ϸ� ��ŸƮ ���� �ɷ�ġ�� 6, ��ũ ���� �ɷ�ġ�� 6�� �Ǿ ���̰� 0�� �ǰ� �� ���� �ּ��̴�.
 * �Է�: ù° �ٿ� N(4 �� N �� 20, N�� ¦��)�� �־�����. ��° �ٺ��� N���� �ٿ� S�� �־�����. �� ���� N���� ���� �̷���� �ְ�, i�� ���� j��° ���� Sij �̴�. Sii�� �׻� 0�̰�, ������ Sij�� 1���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�.
 * ���: ù° �ٿ� ��ŸƮ ���� ��ũ ���� �ɷ�ġ�� ������ �ּڰ��� ����Ѵ�.
 * Ǯ��: https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%8014889-%EC%8A%A4%ED%83%80%ED%8A%B8%EC%99%80-%EB%A7%81%ED%81%AC-java
 		���չ���ó�� Ǯ�� ��
 		����� 6��(0��~5��)�� ��� 012, 013, 014, 015, 023, 024, 025, 034, 035, 045, 123, 124, 125, 134, 135, 145, 234, 235, 345 ���� ������ start ������ ������ ��.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class D210623T14889StartAndLink {
	static int[][] table;
	static boolean[] visited;
	static int N;
	static int diffMin = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		table = new int[N][N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(diffMin);
	}

	static void dfs(int round, int start) {
		// ��ü �ο��� ������ ������ ������ ������ �ο����� ������ ��� �б� �̵� �ߴ�
		if(round == N/2) {
			int[] startTeam = new int[N/2], linkTeam = new int[N/2];
			int startIndex = 0, linkIndex = 0;
			int sumStart = 0, sumLink = 0;
			
			for(int i = 0; i < N; i++) {
				if(visited[i]) { // true�� ��� ��ŸƮ �� �ͼ�
					startTeam[startIndex++] = i;
				}
				else { // false�� ��� ��ũ �� �ͼ�
					linkTeam[linkIndex++] = i;
				}
			}

//			System.out.print("\n\nS: ");
//			for(int i = 0; i < startIndex; i++) {
//				System.out.print(startTeam[i]);
//			}
//			System.out.print("\nL: ");
//			for(int i = 0; i < linkIndex; i++) {
//				System.out.print(linkTeam[i]);
//			}

			// i=j �� ���� ���� 0�̹Ƿ� j�� i+1�� ��������
			for(int i = 0; i < N/2; i++) {
				for(int j = i+1; j < N/2; j++) {
					//System.out.print("\nI: " + i + "," + j);
					//System.out.print("\nS: " + startTeam[i] + "," + startTeam[j]);
					//System.out.print("\nL: " + linkTeam[i] + "," + linkTeam[j]);
					sumStart += table[startTeam[i]][startTeam[j]] + table[startTeam[j]][startTeam[i]];
					sumLink += table[linkTeam[i]][linkTeam[j]] + table[linkTeam[j]][linkTeam[i]];
				}
			}
			//System.out.println();
			
			diffMin = Math.min(diffMin, Math.abs(sumStart-sumLink));
		}
		else {
			for(int i = start; i < N; i++) {
				visited[i] = true; // true�� ��� ��ŸƮ �� �ͼ�
				dfs(round+1, i+1);
				visited[i] = false; // false�� ��� ��ũ �� �ͼ�
			}
		}
	}
}