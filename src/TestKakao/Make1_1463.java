package TestKakao;

import java.util.Scanner;

public class Make1_1463 {
	public static int[] D = new int[10000001]; // x�� ������ ����ϴ� Ƚ���� �ּҰ� �����ϴ� �迭 ����
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt(); // ����Ϸ��� ��
		System.out.println(go(N)); // N�� ������ ����ϴ� Ƚ���� �ּҰ�
	}
	
	public static int go(int n){
		if(n == 1) return 0; // 1�� ��� ���� ����
		if(D[n] > 0) return D[n]; // n�� ���� ȸ������ ������ ��� �ش� �� ��ȯ
		
		// ** ���� ���� ** //
		D[n] = go(n-1)+1; // 1. 1  ����
		if(n%3==0) { // 2. 3���� ������������ Ȯ��
			int tmp = go(n/3)+1; // ������ �̹� �� �� �����Ͽ��⿡ 1�� ������� ��
			if(D[n] > tmp) D[n] = tmp;
		}
		if(n%2==0) { // 3. 2�� ������������ Ȯ��
			int tmp = go(n/2)+1;
			if(D[n] > tmp) D[n] = tmp;
		}

		return D[n];
	}
}