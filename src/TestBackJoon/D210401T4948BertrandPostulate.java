package TestBackJoon;
/*
 * 문제명: 베르트랑 공준
 * 일자: 21.04.01.목
 * https://www.acmicpc.net/problem/4948
 * 문제내용: 
  		베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
		이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
		예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
		자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오. 
 * 입력: 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다. 입력의 마지막에는 0이 주어진다.
 * 출력: 각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210401T4948BertrandPostulate {
	public static void main(String[] args) throws IOException {
		boolean[] primeCheck = new boolean[(123456*2)+1]; // true:소수X, false:소스O
		primeCheck[0] = primeCheck[1] = true;
		for(int i = 2; i < Math.sqrt(primeCheck.length); i++) {
			for(int j = 2; i*j <= primeCheck.length; j++) {
				if(!primeCheck[i*j]) {
					primeCheck[i*j] = true;
				}
			}
		}
		
		int[] count_arr = new int[primeCheck.length];
		int count = 0;
		for(int i = 2; i < primeCheck.length; i++) {
			if(!primeCheck[i]) count++;	// 소수일 경우 count를 증가시킨다
			/*
			0 ~ i 까지 소수의 개수 = count
			count 값을 count_arr 의 i 에 저장한다
			*/
			count_arr[i] = count;	
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			sb.append(count_arr[2 * N] - count_arr[N]).append('\n');
		}
		System.out.print(sb.toString());
	}
}