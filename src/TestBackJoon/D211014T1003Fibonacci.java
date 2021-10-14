package TestBackJoon;

/*
 * 문제명: 피보나치 함수
 * 일자: 21.10.14.목
 * https://www.acmicpc.net/problem/1003
 * 문제내용: 
 * 입력: 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
 * 출력: 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
 * 풀이: 동적계획법(Dynamic programming)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D211014T1003Fibonacci {
	static int[] memo = new int[Integer.MAX_VALUE];
	static int[][] result = new int[Integer.MAX_VALUE][2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		memo[0] = 0;
		memo[1] = 1;
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
		}
	}
	
	static int fibonacci(int n) {
		if(n <= 1) {
			return n;
		}
		else {
			if(memo[n] > 0) {
				return memo[n]; 
			}
			memo[n] = fibonacci(n-1) + fibonacci(n-2);
			return memo[n];
		}
	}
}