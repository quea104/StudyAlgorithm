package TestBackJoon;

/*
 * 일자: 21.03.24.수
 * https://www.acmicpc.net/problem/2577
 * 문제명: 숫자의 개수
 * 문제내용: 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성
 * 입력: 첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 같거나 크고, 1,000보다 작은 자연수이다.
 * 출력: 첫째 줄에는 A × B × C의 결과에 0 이 몇 번 쓰였는지 출력한다. 마찬가지로 둘째 줄부터 열 번째 줄까지 A × B × C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CountNumber {
	// 문자열로 해결
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String result = Integer.toString(Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()));
		int[] arrCount = new int[10];
		for(int i = 0; i < result.length(); i++) {
			int num = Integer.parseInt(result.substring(i, i+1));
			arrCount[num]++;
		}
		
		for(int i = 0; i < arrCount.length; i++) {
			System.out.println(arrCount[i]);
		}
	}
	
//	숫자로 해결
//	public void solution() {
//		Scanner sc = new Scanner(System.in);		
//		int result = sc.nextInt() * sc.nextInt() * sc.nextInt();
//		int[] arrCount = new int[10];
//		for(int i = 0; i < Integer.toString(result).length(); i++) {
//			int num = result/powerTen(i)%10;
//			arrCount[num]++;
//		}
//		
//		for(int i = 0; i < arrCount.length; i++) {
//			System.out.println(arrCount[i]);
//		}
//	}
//	
//	private int powerTen(int n) {
//		if(n == 0) return 1;
//		else if(n == 1) return 10;
//		return 10*powerTen(n-1);
//	}
}
