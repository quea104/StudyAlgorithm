package TestBackJoon;
/*
 * 문제명: 별 찍기 - 10
 * 일자: 21.04.08.목~09.금
 * https://www.acmicpc.net/problem/2447
 * 문제내용: 
		재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
		크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
		***
		* *
		***
		N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
 * 입력: 첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.
 * 출력: 첫째 줄부터 N번째 줄까지 별을 출력한다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class T0408Star10 {
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
