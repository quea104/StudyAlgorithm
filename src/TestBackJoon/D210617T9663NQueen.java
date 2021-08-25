package TestBackJoon;
/*
 * 문제명: N-Queen
 * 일자: 21.06.17.목
 * https://www.acmicpc.net/problem/9663
 * 문제내용: N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다. N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 N이 주어진다. (1 ≤ N < 15)
 * 출력: 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class D210617T9663NQueen {
	static int N;
	static int[] chess;
	static int solve;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N];
		
		dfs(0);
		
		System.out.println(solve);
	}
	
	static void dfs(int row) {
		if(row == N) {
			solve++;
			return;
		}
		
		for(int column = 0; column < N; column++) {
			chess[row] = column; // 행 row 번째 위치에 열 column 위치에 퀸을 놓음 => (row, column) = 퀸 놓기
			if(promising(row)) { // (row, column)에 퀸을 놓아도 되는지 확인 
				dfs(row+1);
			}
		}
		return;
	}
	
	static boolean promising(int currentRow) {
		// 이전 퀸들의 위치 확인
		for(int i = 0; i < currentRow; i++) {
			if(chess[i] == chess[currentRow]) // 같은 열에 퀸이 있는지 확인
				return false;
			if(Math.abs(chess[i] - chess[currentRow]) == currentRow - i) // 대각선 상에 퀸이 있는지 확인
				return false;
		}
		
		return true;
	}
}