package TestBackJoon;
/*
 * ������: ����Ʈ�� ����
 * ����: 21.04.01.��
 * https://www.acmicpc.net/problem/4948
 * ��������: 
  		����Ʈ�� ������ ������ �ڿ��� n�� ���Ͽ�, n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ��� �ϳ� �����Ѵٴ� ������ ��� �ִ�.
		�� ������ ������ ����Ʈ���� 1845�⿡ �����߰�, ������Ƽ ü������� 1850�⿡ �����ߴ�.
		���� ���, 10���� ũ��, 20���� �۰ų� ���� �Ҽ��� 4���� �ִ�. (11, 13, 17, 19) ��, 14���� ũ��, 28���� �۰ų� ���� �Ҽ��� 3���� �ִ�. (17,19, 23)
		�ڿ��� n�� �־����� ��, n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 * �Է�: �Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�. �� ���̽��� n�� �����ϴ� �� �ٷ� �̷���� �ִ�. �Է��� ���������� 0�� �־�����.
 * ���: �� �׽�Ʈ ���̽��� ���ؼ�, n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ������ ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210401T4948BertrandPostulate {
	public static void main(String[] args) throws IOException {
		boolean[] primeCheck = new boolean[(123456*2)+1]; // true:�Ҽ�X, false:�ҽ�O
		primeCheck[0] = primeCheck[1] = true;
		for(int i = 2; i < Math.sqrt(primeCheck.length); i++) {
			for(int j = 2; i*j <= primeCheck.length; j++) {
				if(!primeCheck[i*j]) {
					primeCheck[i*j] = true;
				}
			}
		}
		
		int[] count_arr = new int[primeCheck.length];
		int count = 0;
		for(int i = 2; i < primeCheck.length; i++) {
			if(!primeCheck[i]) count++;	// �Ҽ��� ��� count�� ������Ų��
			/*
			0 ~ i ���� �Ҽ��� ���� = count
			count ���� count_arr �� i �� �����Ѵ�
			*/
			count_arr[i] = count;	
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			sb.append(count_arr[2 * N] - count_arr[N]).append('\n');
		}
		System.out.print(sb.toString());
	}
}