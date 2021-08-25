package TestBackJoon;
/*
 * ������: ������
 * ����: 21.06.18.��
 * https://www.acmicpc.net/problem/2580
 * ��������: ������� 18���� ������ �����ڰ� ���� '��ƾ �簢��'�̶� ���񿡼� ������ ������ ���� ���� �α⸦ ������ �ִ�. 
			�� ������ �Ʒ� �׸��� ���� ����, ���� ���� 9���� �� 81���� ���� ĭ���� �̷���� ���簢�� �� ������ �̷����µ�, ���� ���� �� �Ϻ� ĭ���� 1���� 9������ ���� �� �ϳ��� ���� �ִ�.
 * �Է�: ��ȩ �ٿ� ���� �� �ٿ� 9���� ���� ���� �� �������� �� �ٿ� ���� �ִ� ���ڰ� �� ĭ�� ����� ���ʷ� �־�����. ������ ���� �� ĭ�� ��쿡�� 0�� �־�����. ������ ���� ��Ģ��� ä�� �� ���� ����� �Է��� �־����� �ʴ´�.
 * ���: ��� �� ĭ�� ä���� ������ ���� ���� ����� ��ȩ �ٿ� ���� �� �ٿ� 9���� �� ĭ�� ����� ����Ѵ�. ������ ���� ä��� ����� ������ ���� �� �� �ϳ����� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class D210618T2580Sudoku {
	// ���������� N-Queen ����ó�� �� ���̳� ���� �ϳ��� ������ ���� ���� �ƴϱ� ������ 2���� �迭�� �ؾ���
	static int[][] board = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
	}

	static void dfs(int row, int column) {
		if(column == 9) {
			dfs(row+1, 0);
		}
		else {
			if(row == 9) {
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < 9; i++) {
					for(int j = 0; j < 9; j++) {
						sb.append(board[i][j]).append(" ");
					}
					sb.append("\n");
				}
				System.out.println(sb.toString());
				System.exit(0);
			}
			else {
				// 0�� ��쿡�� Ȯ���ϱ�
				if(board[row][column] == 0) {
					// ������ �� Ž��
					for(int i = 1; i <= 9; i++) {
						if(promising(row, column, i)) {
							board[row][column] = i;
							dfs(row, column+1);
						}
					}
					board[row][column] = 0;
				}
				else {
					dfs(row, column+1); // �ƴ϶�� �� �̵�						
				}
			}
		}
	}
	
	static boolean promising(int row, int column, int number) {		
		// ���� Ȯ��
		for(int i = 0; i < 9; i++) {
			if(board[row][i] == number) {
				return false;
			}
		}
		
		// ���� Ȯ��
		for(int i = 0; i < 9; i++) {
			if(board[i][column] == number) {
				return false;
			}
		}
		
		// 3X3 ���簢�� Ȯ��
		int x = (row/3)*3;
		int y = (column/3)*3;
		for(int i = x; i < x+3; i++) {
			for(int j = y; j < y+3; j++) {
				if(board[i][j] == number) {
					return false;
				}
			}
		}
		
		return true;
	}
}