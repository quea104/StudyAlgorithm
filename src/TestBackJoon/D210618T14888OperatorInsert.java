package TestBackJoon;
/*
 * 문제명: 연산자 끼워넣기
 * 일자: 21.06.18.금
 * https://www.acmicpc.net/problem/14888
 * 문제내용: N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다. 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다. 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.
			우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 이때, 주어진 수의 순서를 바꾸면 안 된다.			
			예를 들어, 6개의 수로 이루어진 수열이 1, 2, 3, 4, 5, 6이고, 주어진 연산자가 덧셈(+) 2개, 뺄셈(-) 1개, 곱셈(×) 1개, 나눗셈(÷) 1개인 경우에는 총 60가지의 식을 만들 수 있다. 예를 들어, 아래와 같은 식을 만들 수 있다.			
			1+2+3-4×5÷6
			1÷2+3+4-5×6
			1+2÷3×4-5+6
			1÷2×3-4+5+6
			식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다. 또, 나눗셈은 정수 나눗셈으로 몫만 취한다. 음수를 양수로 나눌 때는 C++14의 기준을 따른다. 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다. 이에 따라서, 위의 식 4개의 결과를 계산해보면 아래와 같다.			
			1+2+3-4×5÷6 = 1
			1÷2+3+4-5×6 = 12
			1+2÷3×4-5+6 = 5
			1÷2×3-4+5+6 = 7
			N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다. 둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 100) 셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다. 
 * 출력: 첫째 줄에 만들 수 있는 식의 결과의 최댓값을, 둘째 줄에는 최솟값을 출력한다. 연산자를 어떻게 끼워넣어도 항상 -10억보다 크거나 같고, 10억보다 작거나 같은 결과가 나오는 입력만 주어진다. 
		또한, 앞에서부터 계산했을 때, 중간에 계산되는 식의 결과도 항상 -10억보다 크거나 같고, 10억보다 작거나 같다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class D210618T14888OperatorInsert {
	static int[] numbers;
	static int[] operators = new int[4];
	static int max = -1000000000;
	static int min = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, numbers[0], Integer.toString(numbers[0]));
		
		System.out.println(max + "\n" + min);
	}

	static void dfs(int index, int number, String formula) {
		if(index == numbers.length) {
			if(max < number) {
				max = number;
			}
			if(min > number) {
				min = number;
			}
			System.out.println("Formula: "+formula);
		}
		else {
			int result = 0;
			String operation = "";
			for(int i = 0; i < 4; i++) {
				if(operators[i] > 0) {
					switch(i) {
					case 0: // 덧셈
						result = number + numbers[index];
						operation = "+";
						break;
					case 1: // 뺄셈
						result = number - numbers[index];
						operation = "-";
						break;
					case 2: // 곱셈
						result = number * numbers[index];
						operation = "*";
						break;
					case 3: // 나눗셈
						result = number / numbers[index];
						operation = "/";
						break;
					}
					operators[i] -= 1;
					dfs(index+1, result, formula + operation + Integer.toString(numbers[index]));
					operators[i] += 1;
				}
			}
		}
	}
}