package TestBackJoon;

/*
 * 일자: 21.03.24.수
 * https://www.acmicpc.net/problem/3052
 * 문제명: 나머지
 * 문제내용: 
 		두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다. 
		수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
 * 입력: 첫째 줄부터 열번째 줄 까지 숫자가 한 줄에 하나씩 주어진다. 이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.
 * 출력: 첫째 줄에, 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력한다.
 * 테스트 케이스 : 
1
2
43
42
84
23
25
35
34
32
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Remainder {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int b = 42;
		int[] arr = new int[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		int n = 0;
		for(int i = 0; i < 10; i++) {
			int remainder = Integer.parseInt(br.readLine())%b;
			boolean isExsited = false;
			System.out.println(remainder);
			for(int j = i-1; j >= 0; j--) {
				if(arr[j] == remainder) {
					isExsited = true;
					break;
				}
			}
			if(!isExsited) {
				arr[n++] = remainder;
				count++;
			}
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(count);
	}
}
