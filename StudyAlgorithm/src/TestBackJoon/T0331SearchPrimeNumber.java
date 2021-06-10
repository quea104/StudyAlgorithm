package TestBackJoon;
/*
 * 문제명: 소수 찾기
 * 일자: 21.03.31.수
 * https://www.acmicpc.net/problem/1978
 * 문제내용: 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * 입력: 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 * 출력: 주어진 수들 중 소수의 개수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class T0331SearchPrimeNumber {
	public static void main(String[] args) throws IOException {
		boolean[] primeCheck = new boolean[1001]; // true: 소수아님, false:소수임
		primeCheck[0] = primeCheck[1] = true;
		for(int i = 2; i < primeCheck.length; i++) {
			for(int j = i-1; j >= 2; j--) {
				if(primeCheck[j])
					continue;
				if(i%j == 0) {
					primeCheck[i] = true;
					break;
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(!primeCheck[Integer.parseInt(st.nextToken())])
				count++;
		}
		System.out.println(count);
	}
}