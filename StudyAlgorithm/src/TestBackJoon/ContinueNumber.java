package TestBackJoon;

/*
 * 일자: 21.03.25.목
 * https://www.acmicpc.net/problem/1065
 * 문제명: 한수
 * 문제내용: 
 		어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 
 		등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
 * 입력: 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
 * 출력: 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class ContinueNumber {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		if (N < 100)
			count = N; 
		else {
			count = 99;
			for(int i = 100; i <= N; i++) {
				int arr[] = new int[3];
				arr[0] = i / 100; // i=100, 1
				arr[1] = (i/10) % 10; // 0
				arr[2] = i % 10; // 0
				
				if(arr[2] - arr[1] == arr[1] - arr[0])
					count++;
				
//				if(check(Integer.toString(i), 0, 0))
//					count++;
			}
		}
		System.out.println(count);
	}
	
//	private boolean check(String strNum, int idx, int d1) {
//		if (idx >= strNum.length()-1)
//			return true;
//		else {
//			int n1 = Integer.parseInt(strNum.substring(idx, idx+1));
//			int n2 = Integer.parseInt(strNum.substring(idx+1, idx+2));
//			int d2 = n2 - n1;
//			if(idx > 0 && d2 != d1) {
//				return false;
//			}
//			else {
//				return check(strNum, idx+1, d2);
//			}
//		}
//	}
}
