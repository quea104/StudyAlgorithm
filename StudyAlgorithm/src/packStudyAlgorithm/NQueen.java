package packStudyAlgorithm;

/*
 * 문제: 
 * https://www.acmicpc.net/problem/9663
 * N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제
 * 
 * 답: N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하기
 * 
 * 입력: N이 주어진다. (1 ≤ N < 15)
 * 출력: 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수
 * 조건: 퀸이 놓였을 때 퀸 자신을 기준으로 일직선상(가로 및 세로)과 대각선 방향에는 아무것도 놓여있으면 안 됨
 */

public class NQueen {	
	public int solution(int n) {
		boolean[][] arrChess = new boolean[n][n];
		printChess(arrChess);
		return calculate(arrChess, 0);
	}
	
	private int calculate(boolean[][] arrChess, int row) {
		if (row == arrChess.length-1) {
			printChess(arrChess);
			return 1;
		}
		
		int count = 0;
		for(int col = 0; col < arrChess.length; col++) {
			if(checkMove(arrChess, row, col)) {
				arrChess[row][col] = true;
				count += calculate(arrChess, row+1);
				arrChess[row][col] = false;
			} 
		}
		return count;
	}
	
	private boolean checkMove(boolean[][] arrChess, int row, int col) {		
		int diff = 0;
		for (int j = row-1; j >= 0; j--) {
			diff++;
			if (arrChess[col][j] || (col-diff >= 0 && arrChess[col-diff][j]) || (col+diff < arrChess.length && arrChess[col+diff][j])) {
				return false;
			}
		}
		
		return true;
	}
	
	private void printChess(boolean[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] ? 1 : 0);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// 예전에 풀었던 방법
	/*
	static boolean[][] a = new boolean[15][15];
	static int n = 0;
	static boolean[] check_col = new boolean[15];
	static boolean[] check_dig = new boolean[40];
	static boolean[] check_dig2 = new boolean[40];
	
	public int solution(int number) {
		n = number;
		return calculate(0);
	}
	private int calculate(int row) {
		if(row == n) return 1;
		int cnt = 0;
		for(int col = 0; col < n; col++){
			if (check(row, col)) { // 이동해도 되는 위치인지 확인
	            check_dig[row+col] = true;
	            check_dig2[row-col+n] = true;
	            check_col[col] = true;
	            a[row][col] = true;
	            
	            cnt += calculate(row+1);
	            
	            check_dig[row+col] = false;
	            check_dig2[row-col+n] = false;
	            check_col[col] = false;
	            a[row][col] = false;
	        }
		}
		return cnt;	
	}
	private static boolean check(int row, int col) {
		// | 방향 (위 아래)
		if (check_col[col]) {
	        return false;
	    }
		// / 방향(왼쪽 위 대각선)
		if (check_dig[row+col]) {
	        return false;
	    }
		// \ 방향
		if (check_dig2[row-col+n]) {
	        return false;
	    }		
		return true;
	}
	*/
}
