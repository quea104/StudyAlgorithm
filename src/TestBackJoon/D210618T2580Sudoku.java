package TestBackJoon;
/*
 * 문제명: 스도쿠
 * 일자: 21.06.18.금
 * https://www.acmicpc.net/problem/2580
 * 문제내용: 스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다. 
			이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.
 * 입력: 아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다. 스도쿠 판의 빈 칸의 경우에는 0이 주어진다. 스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.
 * 출력: 모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다. 스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class D210618T2580Sudoku {
	// 스도쿠판은 N-Queen 문제처럼 한 행이나 열에 하나의 퀸만이 오는 것이 아니기 때문에 2차원 배열로 해야함
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
				// 0일 경우에만 확인하기
				if(board[row][column] == 0) {
					// 가능한 수 탐색
					for(int i = 1; i <= 9; i++) {
						if(promising(row, column, i)) {
							board[row][column] = i;
							dfs(row, column+1);
						}
					}
					board[row][column] = 0;
				}
				else {
					dfs(row, column+1); // 아니라면 열 이동						
				}
			}
		}
	}
	
	static boolean promising(int row, int column, int number) {		
		// 가로 확인
		for(int i = 0; i < 9; i++) {
			if(board[row][i] == number) {
				return false;
			}
		}
		
		// 세로 확인
		for(int i = 0; i < 9; i++) {
			if(board[i][column] == number) {
				return false;
			}
		}
		
		// 3X3 정사각형 확인
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