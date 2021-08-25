package TestBackJoon;
/*
 * ������: ��� 
 * ����: 21.03.24.��
 * https://www.acmicpc.net/problem/1546
 * ��������: 
 		�����̴� �⸻��縦 ���ƴ�. �����̴� ������ �����ؼ� ���� ��������� �ߴ�. �ϴ� �����̴� �ڱ� ���� �߿� �ִ��� �����. �� ���� M�̶�� �Ѵ�. �׸��� ���� ��� ������ ����/M*100���� ���ƴ�.
		���� ���, �������� �ְ����� 70�̰�, ���������� 50�̾����� ���������� 50/70*100�� �Ǿ� 71.43���� �ȴ�.
		�������� ������ ���� ������ ���� ������� ��, ���ο� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� ���� �� ������ ���� N�� �־�����. �� ���� 1000���� �۰ų� ����. ��° �ٿ� �������� ���� ������ �־�����. �� ���� 100���� �۰ų� ���� ���� �ƴ� �����̰�, ��� �ϳ��� ���� 0���� ũ��.
 * ���: ù° �ٿ� ���ο� ����� ����Ѵ�. ���� ����� ��°��� ������� �Ǵ� �������� 10-2 �����̸� �����̴�.
 */

//import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class D210324T1546Average {
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		//double arr[] = new double[sc.nextInt()];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double arr[] = new double[Integer.parseInt(br.readLine())];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		double max = 0;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
			if(max < arr[i])
				max = arr[i];
		}
		double sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i]/max*100;
		}
		System.out.println(sum/arr.length);
	}
}
