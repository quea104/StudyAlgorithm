package TestBackJoon;
/*
 * ������: N-Queen
 * https://www.acmicpc.net/problem/9663
 * ��������: N �� N�� ü���� ���� �� N���� ���� ������ �� ���� ���� ����
 * �Է�: N�� �־�����. (1 �� N < 15)
 * ���: �� N���� ���� ������ �� ���� ���� ����� ��
 * ����: ���� ������ �� �� �ڽ��� �������� ��������(���� �� ����)�� �밢�� ���⿡�� �ƹ��͵� ���������� �� ��
 */

public class NQueen {
	public static void main(String[] args) {
		int n = 10;
		boolean[][] arrChess = new boolean[n][n];
		printChess(arrChess);
		System.out.println(calculate(arrChess, 0));
	}
	
	public static int calculate(boolean[][] arrChess, int row) {
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
	
	public static boolean checkMove(boolean[][] arrChess, int row, int col) {		
		int diff = 0;
		for (int j = row-1; j >= 0; j--) {
			diff++;
			if (arrChess[col][j] || (col-diff >= 0 && arrChess[col-diff][j]) || (col+diff < arrChess.length && arrChess[col+diff][j])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void printChess(boolean[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] ? 1 : 0);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// ������ Ǯ���� ���
	/*
	static boolean[][] a = new boolean[15][15];
	static int n = 0;
	static boolean[] check_col = new boolean[15];
	static boolean[] check_dig = new boolean[40];
	static boolean[] check_dig2 = new boolean[40];
	
	public static void main(String[] args) {
		System.out.println(calculate(0));
	}
	public static int calculate(int row) {
		if(row == n) return 1;
		int cnt = 0;
		for(int col = 0; col < n; col++){
			if (check(row, col)) { // �̵��ص� �Ǵ� ��ġ���� Ȯ��
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
	public static boolean check(int row, int col) {
		// | ���� (�� �Ʒ�)
		if (check_col[col]) {
	        return false;
	    }
		// / ����(���� �� �밢��)
		if (check_dig[row+col]) {
	        return false;
	    }
		// \ ����
		if (check_dig2[row-col+n]) {
	        return false;
	    }		
		return true;
	}
	*/
}
