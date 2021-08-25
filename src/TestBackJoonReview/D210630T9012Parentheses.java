package TestBackJoonReview;
/*
 * ������: ��ȣ
 * ����: 21.06.30.��
 * https://www.acmicpc.net/problem/9012
 * ��������: ��ȣ ���ڿ�(Parenthesis String, PS)�� �� ���� ��ȣ ��ȣ�� ��(�� �� ��)�� ������ �����Ǿ� �ִ� ���ڿ��̴�. 
		�� �߿��� ��ȣ�� ����� �ٸ��� ������ ���ڿ��� �ùٸ� ��ȣ ���ڿ�(Valid PS, VPS)�̶�� �θ���. �� ���� ��ȣ ��ȣ�� �� ��( )�� ���ڿ��� �⺻ VPS �̶�� �θ���. ���� x �� VPS ��� �̰��� �ϳ��� ��ȣ�� ���� ���ο� ���ڿ� ��(x)���� VPS �� �ȴ�. 
		�׸��� �� VPS x �� y�� ����(concatenation)��Ų ���ο� ���ڿ� xy�� VPS �� �ȴ�. 
		���� ��� ��(())()���� ��((()))�� �� VPS ������ ��(()(��, ��(())()))�� , �׸��� ��(()�� �� ��� VPS �� �ƴ� ���ڿ��̴�.
		�������� �Է����� �־��� ��ȣ ���ڿ��� VPS ���� �ƴ����� �Ǵ��ؼ� �� ����� YES �� NO �� ��Ÿ����� �Ѵ�. 
 * �Է�: �Է� �����ʹ� ǥ�� �Է��� ����Ѵ�. �Է��� T���� �׽�Ʈ �����ͷ� �־�����. �Է��� ù ��° �ٿ��� �Է� �������� ���� ��Ÿ���� ���� T�� �־�����. �� �׽�Ʈ �������� ù° �ٿ��� ��ȣ ���ڿ��� �� �ٿ� �־�����. �ϳ��� ��ȣ ���ڿ��� ���̴� 2 �̻� 50 �����̴�. 
 * ���: ����� ǥ�� ����� ����Ѵ�. ���� �Է� ��ȣ ���ڿ��� �ùٸ� ��ȣ ���ڿ�(VPS)�̸� ��YES��, �ƴϸ� ��NO���� �� �ٿ� �ϳ��� ���ʴ�� ����ؾ� �Ѵ�. 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class D210630T9012Parentheses {
	static final int MAX = 50;
	static int top = 0;
	static char[] stack;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			stack = new char[MAX];
			top = 0;
			String str = br.readLine();
			boolean check = true;
			for(int i = 0; i < str.length(); i++) {
				char p = str.charAt(i);
				if(p == '(') {
					push('(');
				}
				else if (p == ')') {
					if(top == 0) {
						check = false;
						break;
					}
					pop();
				}
			}
			
			if(check && top == 0) {
				sb.append("YES").append("\n");
			}
			else {
				sb.append("NO").append("\n");				
			}
		}
		
		System.out.println(sb.toString());
	}
	
	static void push(char p) {
		stack[top++] = p;
	}
	
	static int pop() {
		if(top <= 0) return -1;
		return stack[--top];
	}
}