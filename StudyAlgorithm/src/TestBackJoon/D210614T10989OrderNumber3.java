package TestBackJoon;
/*
 * 문제명: 수 정렬하기3
 * 일자: 21.06.14.월
 * https://www.acmicpc.net/problem/10989
 * 문제내용: N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
 * 출력: 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 제한: 3 초 / 8 MB
 * 풀이: Counting Sort
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class D210614T10989OrderNumber3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
        br.close();

		for(int i = 1; i < 10001; i++) {
			while(arr[i] > 0) {
				sb.append(i).append('\n');
				arr[i]--;
			}
		}
		System.out.println(sb);
	}
}