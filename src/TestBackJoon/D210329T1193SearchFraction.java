package TestBackJoon;
/*
 * 문제명: 분수찾기
 * 일자: 21.03.29.월
 * https://www.acmicpc.net/problem/1193
 * 문제내용:
 		이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
		X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
 * 출력: 첫째 줄에 분수를 출력한다.
 * 풀이:
		count	~a		m/n
		1		(1)		1/1						=> 1+d / Math.abs(count-d)
		2		(2~3)	1/2 2/1					=> Math.abs(count-d) / 1+d
		3		(4~6)	3/1 2/2 1/3
		4		(7~10)	1/4 2/3 3/2 4/1
		5		(11~15) 5/1 4/2 3/3 2/4 1/5
		6		(16~20)	1/6 2/5 3/4 4/3 5/2 6/1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210329T1193SearchFraction {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int count = 0, a = 0;
		while(a < N) {
			count++;
	        a += count;
		}
		int m = 0, n = 0, d = a-N;
		if(count % 2 == 0) {
			m = Math.abs(count-d);
			n = 1+d;
		}
		else {
			m = 1+d;
			n = Math.abs(count-d);			
		}
		System.out.println(m + "/" + n);
	}
}
