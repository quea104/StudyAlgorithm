package TestBackJoon;
/*
 * ������: N-Queen
 * ����: 21.06.17.��
 * https://www.acmicpc.net/problem/9663
 * ��������: N-Queen ������ ũ�Ⱑ N �� N�� ü���� ���� �� N���� ���� ������ �� ���� ���� �����̴�. N�� �־����� ��, ���� ���� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� N�� �־�����. (1 �� N < 15)
 * ���: ù° �ٿ� �� N���� ���� ������ �� ���� ���� ����� ���� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class D210617T9663NQueen {
	static int N;
	static int[] chess;
	static int solve;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N];
		
		dfs(0);
		
		System.out.println(solve);
	}
	
	static void dfs(int row) {
		if(row == N) {
			solve++;
			return;
		}
		
		for(int column = 0; column < N; column++) {
			chess[row] = column; // �� row ��° ��ġ�� �� column ��ġ�� ���� ���� => (row, column) = �� ����
			if(promising(row)) { // (row, column)�� ���� ���Ƶ� �Ǵ��� Ȯ�� 
				dfs(row+1);
			}
		}
		return;
	}
	
	static boolean promising(int currentRow) {
		// ���� ������ ��ġ Ȯ��
		for(int i = 0; i < currentRow; i++) {
			if(chess[i] == chess[currentRow]) // ���� ���� ���� �ִ��� Ȯ��
				return false;
			if(Math.abs(chess[i] - chess[currentRow]) == currentRow - i) // �밢�� �� ���� �ִ��� Ȯ��
				return false;
		}
		
		return true;
	}
}