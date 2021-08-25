package TestBackJoon;
/*
 * ������: ����
 * ����: 21.06.30.��
 * https://www.acmicpc.net/problem/10828
 * ��������: ������ �����ϴ� ������ ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		����� �� �ټ� �����̴�.		
		push X: ���� X�� ���ÿ� �ִ� �����̴�.
		pop: ���ÿ��� ���� ���� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
		size: ���ÿ� ����ִ� ������ ������ ����Ѵ�.
		empty: ������ ��������� 1, �ƴϸ� 0�� ����Ѵ�.
		top: ������ ���� ���� �ִ� ������ ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
 * �Է�: ù° �ٿ� �־����� ����� �� N (1 �� N �� 10,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����. �־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.
 * ���: ����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D210630T10828Stack {
	static final int TOP_SIZE = 500;
	static int[] stack = new int[TOP_SIZE];
	static int top = 0;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			String order = br.readLine();
			if(order.equals("pop")) {
				sb.append(pop()).append("\n");
			}
			else if(order.equals("top")) {
				sb.append(top()).append("\n");
			}
			else if(order.equals("size")) {
				sb.append(size()).append("\n");				
			}
			else if(order.equals("empty")) {
				sb.append(empty()).append("\n");		
			}
			else {
				StringTokenizer st = new StringTokenizer(order);
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				push(x);
			}
		}
		System.out.println(sb.toString());
	}
	
	// ���� X�� ���ÿ� �ִ� ����c
	static void push(int x) {
		stack[top++] = x;
	}
	
	// ���ÿ��� ���� ���� �ִ� ������ ����, �� ���� ���. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ���
	static int pop() {
		if(top <= 0) {
			return -1;
		}
		return stack[--top];
	}
	
	// ���ÿ� ����ִ� ������ ������ ���
	static int size() {
		return top;
	}
	
	// ������ ��������� 1, �ƴϸ� 0�� ���
	static int empty() {
		if(top <= 0) {
			return 1;
		}
		return 0;
	}
	
	// ������ ���� ���� �ִ� ������ ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ���
	static int top() {
		if(top <= 0) {
			return -1;
		}
		return stack[top-1];
	}
}