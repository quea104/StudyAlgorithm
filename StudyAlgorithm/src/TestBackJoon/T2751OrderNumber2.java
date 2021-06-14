package TestBackJoon;
/*
 * 문제명: 수 정렬하기2
 * 일자: 21.06.10.목
 * https://www.acmicpc.net/problem/2751
 * 문제내용: N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 출력: 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 풀이: 시간 복잡도가 O(nlogn)인 정렬 알고리즘으로 풀 수 있습니다. 예를 들면 병합 정렬, 힙 정렬 등이 있지만, 어려운 알고리즘이므로 지금은 언어에 내장된 정렬 함수를 쓰는 것을 추천드립니다.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class T2751OrderNumber2 {
	public static int[] tempArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		// list 계열 중 하나를 쓰면 된다.
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		for(int value : list) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
		
		/*
		// Counting Sort. 수가 중복되지도 않기 때문에 boolean[] 배열에 입력 받은 값을 index로 쓰면 되는데, 아무래도 직접 비교 정렬이 아니므로 시간복잡도는 O(n) 으로 매우 빠른 방법이다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[10000001];
		
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())] = true;
		}

		for(int i = 0; i < N; i++) {
			if(arr[i])
				sb.append(i).append('\n');
		}
		System.out.println(sb);
		 */
	}
}
