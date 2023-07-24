package TestBackJoon;
/*
 * 문제명: 설탕 배달
 * 일자: 21.03.30.화
 * https://www.acmicpc.net/problem/2839
 * 문제내용:
 		상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다.
 		봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
		상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
		상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
 * 출력: 상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
 * 풀이
		1) 5kg 에 설탕을 빠짐없이 담을 수 있다면 (입력 값이 5로 나눠떨어진다면) 입력값을 5로 나눈 몫을 출력하고 프로그램 종료
		2) 5kg 에 설탕을 빠짐없이 담을 수 없다면 3kg 봉지에 한 번 담기 (봉지 카운트는 1 증가, 입력값은 3 감소)		
		3) 만약 입력값이 0보다 작아지면 -1을 출력하고 프로그램 종료
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class D210330T2839DeliverySugar {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int weight = Integer.parseInt(br.readLine());
		int count = 0;
		int[] arr = new int[5001];
		arr[0] = weight;
		while(weight > 0) {
			if(weight%5 == 0) {
				count = count + (weight / 5);
				weight = weight % 5;
			}
			else {
				count++;
				weight -= 3;
			}
			
			if (weight < 0) {
				count = -1;
				break;
			}
		}
		bw.write(Integer.toString(count));
		bw.flush();
	}
}