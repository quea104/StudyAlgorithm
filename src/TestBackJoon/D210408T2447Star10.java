package TestBackJoon;
/*
 * ������: �� ��� - 10
 * ����: 21.04.08.��~09.��
 * https://www.acmicpc.net/problem/2447
 * ��������: 
		������� �������� ���� ��� ����. N�� 3�� �ŵ�����(3, 9, 27, ...)�̶�� �� ��, ũ�� N�� ������ N��N ���簢�� ����̴�.
		ũ�� 3�� ������ ����� ������ �ְ�, ����� ������ ��� ĭ�� ���� �ϳ��� �ִ� �����̴�.
		***
		* *
		***
		N�� 3���� Ŭ ���, ũ�� N�� ������ �������� ä���� ����� (N/3)��(N/3) ���簢���� ũ�� N/3�� �������� �ѷ��� �����̴�. ���� ��� ũ�� 27�� ������ ���� ��� 1�� ����.
 * �Է�: ù° �ٿ� N�� �־�����. N�� 3�� �ŵ������̴�. �� � ���� k�� ���� N=3k�̸�, �̶� 1 �� k < 8�̴�.
 * ���: ù° �ٺ��� N��° �ٱ��� ���� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class D210408T2447Star10 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		print(makeStar(new char[N+1][N+1], 1));
	}
	
	public static char[][] makeStar(char[][] star, int n) {
		if(n > star.length-1) {
			return star;
		}
		else {
			int standard = star.length/3;
			for(int i = n; i <= n+3; i++) {
				for(int j = n; j <= n+3; j++) {
				}
			}
			for(int j = 0; j < star.length; j++) {
				if((n > standard && n <= standard*2) && j > standard && j <= standard*2) {
					continue;
				}
				else {
					
				}
			}
			return makeStar(star, n+3);
		}
	}
	
	public static void print(char[][] star) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < star.length; i++) {
			for(int j = 0; j < star.length; j++) {
				bw.write(star[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
