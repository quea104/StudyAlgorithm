package TestBackJoon;
/*
 * 문제명: 소수
 * 일자: 21.03.31.수
 * https://www.acmicpc.net/problem/2581
 * 문제내용: 
		자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
		예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.
 * 입력: 입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다. M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
 * 출력: M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다. 
		단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210331T2581PrimeNumber {
	public static void main(String[] args) throws IOException {
		boolean[] primeCheck = new boolean[10001]; // true: 소수아님, false:소수임
		primeCheck[0] = primeCheck[1] = true;
//		for(int i = 2; i < primeCheck.length; i++) {
//			for(int j = i-1; j >= 2; j--) {
//				if(primeCheck[j])
//					continue;
//				if(i%j == 0) {
//					primeCheck[i] = true;
//					break;
//				}
//			}
//		}
		for(int i = 2; i < primeCheck.length; i++) {
			if(!primeCheck[i]) {
				for(int j = i+i; j < primeCheck.length; j+=i) {
					primeCheck[j] = true;
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0, minPrime = 0;
		for(int i = M; i <= N; i++) {
			if(!primeCheck[i]) {
				sum += i;
				if(minPrime == 0) {
					minPrime = i;
				}
			}
		}
		if(sum == 0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(minPrime);
		}
	}
}