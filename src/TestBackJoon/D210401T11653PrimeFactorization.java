package TestBackJoon;
/*
 * 문제명: 소수
 * 일자: 21.04.01.목
 * https://www.acmicpc.net/problem/11653
 * 문제내용: 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
 * 출력: N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
 * 풀이:
 		N의 소수 판별할 때 제곱근까지만 검사하면 됨
		: √18  * √18도 18인데, 이 √18을 좌우로 곱하기가 대칭이므로 sqrt()값보다 같거나 작은 숫자로 나누어지면 그 이후에 대해서는 대칭이므로 계산을 할 필요가 없음.
		: 18의 약수는 1, 2, 3, 6, 9, 18  =>  18은 1 * 18, 2 * 9, 3 * 6   < √18 >   6 * 3, 9 * 2, 18 * 1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210401T11653PrimeFactorization {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
//		boolean[] primeCheck = new boolean[N+1]; // true: 소수아님, false:소수임
//		primeCheck[0] = primeCheck[1] = true;
//		for(int i = 2; i < primeCheck.length; i++) {
//			if(!primeCheck[i]) {
//				while(N%i == 0) {
//					sb.append(i).append("\n");
//					N /= i;
//				}
//				if(N == 1)
//					break;
//				for(int j = i+i; j <= N; j+=i) {
//					if(i%j == 0) {
//						primeCheck[j] = true;
//					}
//				}
//			}
//		}
		for(int i = 2; i <= Math.sqrt(N); i++) {
			while(N%i == 0) {
				sb.append(i).append("\n");
				N /= i;
			}
			if(N == 1) break;
		}
		if(N != 1) {
			sb.append(N);
		}
		System.out.print(sb.toString());
	}
}