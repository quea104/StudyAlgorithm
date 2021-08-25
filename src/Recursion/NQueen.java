package Recursion;

/*
 * https://www.inflearn.com/course/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B0%95%EC%A2%8C/lecture/4077?tab=curriculum
 * '������ ���α׷����� ���� �˰��� ����' ���� ����2 6. Recursion�� ����: n queens problem
 */

/*
 * ����: 21.03.23.ȭ~21.03.24.��
 * n queens problem
 * 	- N*N ũ���� ü����
 * 	- N �� N�� ü���� ���� �� N���� ���� ������ �� ���� ���� ����
 * 	- ���� ������ �� �� �ڽ��� �������� ��������(���� �� ����)�� �밢�� ���⿡�� �ƹ��͵� ���������� �� ��
 * 
 * Backtracking(������ ���)
 *  - �ֱٿ� ������ ������ �ǵ��ư��� �����Ͽ� ������ �ذ��ϴ� ���
 *  - ���°��� Ʈ���� ���� �켱 ������� Ž���Ͽ� �ظ� ã�� �˰���
 * 	- ���°���Ʈ��: 
 * 			ã�� �ظ� �����ϴ� Ʈ��. 
 * 			�ذ� �����Ѵٸ� �װ��� �ݵ�� �� Ʈ���� � �� ��忡 �ش���. 
 * 			���� �� Ʈ���� ü�������� Ž���ϸ� �ظ� ���� �� ����. 
 * 			(Ʈ���� ����� ���� �ƴ϶� ������ ������ Ȱ���Ͽ� ������ �ذ��ϴ� �����.)
 * 			Ž�� �Ұ��� Ʈ���� Infeasible �Ǵ� non-promising ���¿� �����ִٰ� ��.
 * 
 * �Է�: N�� �־�����. (1 �� N < 15)
 * ���: �� N���� ���� ������ �� ���� ���� ����� ��
 */
public class NQueen {
	public static int[] cols;
	public static int N;

	public static void main(String[] args) {
		N = 10;
		cols = new int[N+1];
		System.out.println(queens(0));
	}

	// �Ű����� level: ���� ����� ��ġ�� ����
	// �������� �迭 cols: level�� ���� ��� ���������� �� ǥ�� => cols[i]=j i�� ���� (i��, j��)�� ������ �ǹ�
	public static boolean queens(int level) {
		if(!promising(level)) // when state is non-promising(Infeasible)
			return false;
		else if(level == N) {// success
			for(int i = 1; i <= N; i++) {
				System.out.println("(" + i + "," + cols[i] + ")");
			}
			return true;
		}
		else {
			// visit children recursively
			for(int i = 1; i <= N; i++) {
				cols[level+1] = i; // (level+1��, i��)
				if(queens(level+1))
					return true;
			}
			
			// N���� ���� �õ��ߴµ� ��� �����Ͽ����Ƿ� false ��ȯ
			return false;
		}
	}
	
	public static boolean promising(int level) {
		for(int i = 1; i < level; i++) {
			if(cols[i] == cols[level]) // ���� ���� �������� Ȯ�� 
				return false;
			else if(level - i == Math.abs(cols[i] - cols[level])) // ���� �밢���� �������� �˻�				
				return false;
		}
		return true;
	}
}