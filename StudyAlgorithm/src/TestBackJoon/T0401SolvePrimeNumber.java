package TestBackJoon;
/*
 * 문제명: 소수 구하기
 * 일자: 21.04.01.목
 * https://www.acmicpc.net/problem/1929
 * 문제내용: M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 * 출력: 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class T0401SolvePrimeNumber {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] primeCheck = new boolean[N+1]; // true:소수X, false:소수O
		primeCheck[0] = primeCheck[1] = true;
		StringBuilder sb = new StringBuilder();
//		for(int i = 2; i <= N; i++) {
//			if(!primeCheck[i]) {
//				if(i >= M)
//					sb.append(i).append("\n");
//				for(int j = i+i; j <= N; j+=i) {
//					if(j%i == 0) {
//						primeCheck[j] = true;
//					}
//				}
//			}
//		}
		for(int i = 2; i < Math.sqrt(N); i++) {
			for(int j = 2; i*j <= N; j++) {
				if(!primeCheck[i*j]) {
					primeCheck[i*j] = true;
				}
			}
		}
		for(int i = M; i <= N; i++) {
			if(!primeCheck[i])
				sb.append(i).append("\n");
		}
		System.out.print(sb.toString());
	}
}
