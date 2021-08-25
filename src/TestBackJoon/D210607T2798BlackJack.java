package TestBackJoon;
/*
 * ������: ����
 * ����: 21.06.07.��~08.ȭ
 * https://www.acmicpc.net/problem/2798
 * ��������:
 		ī���뿡�� ���� �α� �ִ� ���� ������ ��Ģ�� ����� ����. ī���� ���� 21�� ���� �ʴ� �ѵ� ������, ī���� ���� �ִ��� ũ�� ����� �����̴�. ������ ī���븶�� �پ��� ������ �ִ�.		
		�ѱ� �ְ��� ���� ��� �������� ���ο� ���� ��Ģ�� ����� ���, â���̿� �����Ϸ��� �Ѵ�.		
		������ ������ ���迡�� �� ī�忡�� ���� ������ ���� �ִ�. �� ����, ������ N���� ī�带 ��� ���ڰ� ���̵��� �ٴڿ� ���´�. �׷� �Ŀ� ������ ���� M�� ũ�� ��ģ��.		
		���� �÷��̾�� ���ѵ� �ð� �ȿ� N���� ī�� �߿��� 3���� ī�带 ���� �Ѵ�. ���� ���� �����̱� ������, �÷��̾ �� ī���� ���� M�� ���� �����鼭 M�� �ִ��� ������ ������ �Ѵ�.		
		N���� ī�忡 ���� �ִ� ���ڰ� �־����� ��, M�� ���� �����鼭 M�� �ִ��� ����� ī�� 3���� ���� ���� ����Ͻÿ�.
 * �Է�: ù° �ٿ� ī���� ���� N(3 �� N �� 100)�� M(10 �� M �� 300,000)�� �־�����. ��° �ٿ��� ī�忡 ���� �ִ� ���� �־�����, �� ���� 100,000�� ���� �ʴ� ���� �����̴�. ���� M�� ���� �ʴ� ī�� 3���� ã�� �� �ִ� ��츸 �Է����� �־�����.
 * ���: ù° �ٿ� M�� ���� �����鼭 M�� �ִ��� ����� ī�� 3���� ���� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D210607T2798BlackJack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] cards = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = serach(cards, m, n);
		System.out.println(sum);
	}
	
	public static int serach(int[] cards, int m, int n) {
		int sum = 0;
		
		for(int i = 0; i < m-2; i++) {
			// ù��° ī�尡 n���� Ŭ ��� �ǳʶ��
			if(cards[i] > n) continue;
			
			for(int j = i+1; j < m-1; j++) {
				// ù��° ī��� �ι�° ī�� ���� n���� Ŭ ��� �ǳʶ��
				if(cards[i] + cards[j] > n) continue;
				
				for(int k = j+1; k < m; k++) {				
					int temp = cards[i] + cards[j] + cards[k];
					if(temp == n) {
						sum = temp; 
						break;
					}
					else {
						if(temp > sum && temp < n) {
							sum = temp;
						}
					}
				}
			}
		}
		
		return sum;
	}
}
