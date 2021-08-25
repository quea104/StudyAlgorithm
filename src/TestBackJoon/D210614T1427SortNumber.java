package TestBackJoon;
/*
 * 문제명: 소트인사이드
 * 일자: 21.06.14.월
 * https://www.acmicpc.net/problem/1427
 * 문제내용: 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 * 입력: 첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
 * 출력: 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class D210614T1427SortNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		
		String strNumber = br.readLine();
		for(int i = 0; i < strNumber.length(); i++) {
			list.add(Integer.parseInt(strNumber.substring(i, i+1)));
		}
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int i = list.size()-1; i >= 0; i--) {
			sb.append(list.get(i));
		}
		System.out.println(sb.toString());
	}
}
