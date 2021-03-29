package TestBackJoon;
/*
 * 일자: 21.03.29.월
 * https://www.acmicpc.net/problem/1193
 * 문제명: 분수찾기
 * 문제내용:
 		이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
		X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
 * 출력: 첫째 줄에 분수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class SearchFraction {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 1, a = 0;
		while(a < N) {
	        a += count++;
		}
		int m = 0, n = 0, d = a-N;
		count--;
		if(count % 2 == 0) {
			m = count+d;
			n = 1-d;
		}
		else {
			m = 1-d;
			n = count+d;			
		}
		System.out.println(m + "/" + n);
	}
}
