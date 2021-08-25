package TestBackJoon;
/*
 * ������: �γ�ȸ���� ���׾�
 * ����: 21.03.30.ȭ
 * https://www.acmicpc.net/problem/2775
 * ��������:
 		��� �ݻ�ȸ�� �����ϴ� ���� �����ϴ� ����� �̹� ��ȸ�� �γ�ȸ���� �ǰ� �;� �� ���� ������� �ҷ� ��� �ݻ�ȸ�� �����Ϸ��� �Ѵ�.
		�� ����Ʈ�� ���ָ� �Ϸ��� ������ �ִµ�, ��a���� bȣ�� ����� �ڽ��� �Ʒ�(a-1)���� 1ȣ���� bȣ���� ������� ���� �ո�ŭ ������� ������ ��ƾ� �Ѵ١� �� ��� ������ �� ��Ű�� ���;� �Ѵ�.
		����Ʈ�� ����ִ� ���� ���� ��� ���ֹε��� �� ��� ������ ��Ű�� �Դٰ� �������� ��, �־����� ���� ���� k�� n�� ���� k���� nȣ���� �� ���� ��� �ִ��� ����϶�. 
		��, ����Ʈ���� 0������ �ְ� �������� 1ȣ���� ������, 0���� iȣ���� i���� ���.
 * �Է�: ù ��° �ٿ� Test case�� �� T�� �־�����. �׸��� ������ ���̽����� �Է����� ù ��° �ٿ� ���� k, �� ��° �ٿ� ���� n�� �־�����
 * ���: ������ Test case�� ���ؼ� �ش� ���� ���ֹ� ���� ����϶�.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class D210330T2775ViceChairman {
	public static void main(String[] args) throws IOException {
		int[][] apart = new int[16][16];
		for(int i = 0; i < apart.length; i++) {
			apart[0][i] = i;
			apart[i][1] = 1;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int floor = 0, room = 0; // i, j
		for(int t = 0; t < T; t++) {
			floor = Integer.parseInt(br.readLine());
			room = Integer.parseInt(br.readLine());
			
			for(int i = 1; i <= floor; i++) {
				for(int j = 2; j <= room; j++) {
					apart[i][j] = apart[i-1][j] + apart[i][j-1];
				}
			}
			bw.write(Integer.toString(apart[floor][room]) + "\n");
		}
		bw.flush();
	}
}
