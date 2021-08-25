package TestBackJoon;
/*
 * ������: ť
 * ����: 21.06.30.��
 * https://www.acmicpc.net/problem/10845
 * ��������: ������ �����ϴ� ť�� ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		����� �� ���� �����̴�.			
		push X: ���� X�� ť�� �ִ� �����̴�.
		pop: ť���� ���� �տ� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
		size: ť�� ����ִ� ������ ������ ����Ѵ�.
		empty: ť�� ��������� 1, �ƴϸ� 0�� ����Ѵ�.
		front: ť�� ���� �տ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
		back: ť�� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
 * �Է�: ù° �ٿ� �־����� ����� �� N (1 �� N �� 10,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����. �־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.
 * ���: ����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D210630T10845Queue {
	static final int MAX = 10000;
	static int front = 0, back = 0;
	static int[] queue = new int[MAX];
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			String order = br.readLine();
			if(order.equals("pop")) {
				sb.append(pop()).append("\n");
			}
			else if(order.equals("size")) {
				sb.append(size()).append("\n");				
			}
			else if(order.equals("empty")) {
				sb.append(empty()).append("\n");
			}
			else if(order.equals("front")) {
				sb.append(front()).append("\n");
			}
			else if(order.equals("back")) {
				sb.append(back()).append("\n");
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
	
	// ���� X�� ť�� �ִ� ����
	static void push(int x) {
		queue[back++] = x;
	}
	
	// ť���� ���� �տ� �ִ� ������ ����, �� ���� ���. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ���
	static int pop() {
		if(size() == 0)
			return -1;
		return queue[front++];
	}
	
	// ť�� ����ִ� ������ ������ ���
	static int size() {
		if(front > back)
			return 0;
		return back-front;
	}
	
	// ť�� ��������� 1, �ƴϸ� 0�� ���
	static int empty() {
		if(size() == 0)
			return 1;
		return 0;
	}
	
	// ť�� ���� �տ� �ִ� ����, ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ���
	static int front() {
		if(size() == 0)
			return -1;
		return queue[front];
	}
	
	// ť�� ���� �ڿ� �ִ� ����, ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ���
	static int back() {
		if(size() == 0)
			return -1;
		return queue[back-1];
	}
}