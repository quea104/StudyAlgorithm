package TestBackJoon;
/*
 * ������: ������ �����ֱ�
 * ����: 21.06.18.��
 * https://www.acmicpc.net/problem/14888
 * ��������: N���� ���� �̷���� ���� A1, A2, ..., AN�� �־�����. ��, ���� �� ���̿� �������� �� �ִ� N-1���� �����ڰ� �־�����. �����ڴ� ����(+), ����(-), ����(��), ������(��)���θ� �̷���� �ִ�.
			�츮�� ���� �� ���̿� �����ڸ� �ϳ��� �־, ������ �ϳ� ���� �� �ִ�. �̶�, �־��� ���� ������ �ٲٸ� �� �ȴ�.			
			���� ���, 6���� ���� �̷���� ������ 1, 2, 3, 4, 5, 6�̰�, �־��� �����ڰ� ����(+) 2��, ����(-) 1��, ����(��) 1��, ������(��) 1���� ��쿡�� �� 60������ ���� ���� �� �ִ�. ���� ���, �Ʒ��� ���� ���� ���� �� �ִ�.			
			1+2+3-4��5��6
			1��2+3+4-5��6
			1+2��3��4-5+6
			1��2��3-4+5+6
			���� ����� ������ �켱 ������ �����ϰ� �տ������� �����ؾ� �Ѵ�. ��, �������� ���� ���������� �� ���Ѵ�. ������ ����� ���� ���� C++14�� ������ ������. ��, ����� �ٲ� �� ���� ���ϰ�, �� ���� ������ �ٲ� �Ͱ� ����. �̿� ����, ���� �� 4���� ����� ����غ��� �Ʒ��� ����.			
			1+2+3-4��5��6 = 1
			1��2+3+4-5��6 = 12
			1+2��3��4-5+6 = 5
			1��2��3-4+5+6 = 7
			N���� ���� N-1���� �����ڰ� �־����� ��, ���� �� �ִ� ���� ����� �ִ��� �Ͱ� �ּ��� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� ���� ���� N(2 �� N �� 11)�� �־�����. ��° �ٿ��� A1, A2, ..., AN�� �־�����. (1 �� Ai �� 100) ��° �ٿ��� ���� N-1�� 4���� ������ �־����µ�, ���ʴ�� ����(+)�� ����, ����(-)�� ����, ����(��)�� ����, ������(��)�� �����̴�. 
 * ���: ù° �ٿ� ���� �� �ִ� ���� ����� �ִ���, ��° �ٿ��� �ּڰ��� ����Ѵ�. �����ڸ� ��� �����־ �׻� -10�ﺸ�� ũ�ų� ����, 10�ﺸ�� �۰ų� ���� ����� ������ �Է¸� �־�����. 
		����, �տ������� ������� ��, �߰��� ���Ǵ� ���� ����� �׻� -10�ﺸ�� ũ�ų� ����, 10�ﺸ�� �۰ų� ����.
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
					case 0: // ����
						result = number + numbers[index];
						operation = "+";
						break;
					case 1: // ����
						result = number - numbers[index];
						operation = "-";
						break;
					case 2: // ����
						result = number * numbers[index];
						operation = "*";
						break;
					case 3: // ������
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