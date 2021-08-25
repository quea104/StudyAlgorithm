package TestBackJoon;
/*
 * ������: ���� ����
 * ����: 21.07.01.��
 * https://www.acmicpc.net/problem/1874
 * ��������: ���� (stack)�� �⺻���� �ڷᱸ�� �� �ϳ���, ��ǻ�� ���α׷��� �ۼ��� �� ���� �̿�Ǵ� �����̴�. 
		������ �ڷḦ �ִ� (push) �Ա��� �ڷḦ �̴� (pop) �Ա��� ���� ���� ���߿� �� �ڷᰡ ���� ���� ������ (LIFO, Last in First out) Ư���� ������ �ִ�.
		1���� n������ ���� ���ÿ� �־��ٰ� �̾� �þ�������ν�, �ϳ��� ������ ���� �� �ִ�. �̶�, ���ÿ� push�ϴ� ������ �ݵ�� ���������� ��Ű���� �Ѵٰ� ����. 
		������ ������ �־����� �� ������ �̿��� �� ������ ���� �� �ִ��� ������, �ִٸ� � ������ push�� pop ������ �����ؾ� �ϴ����� �˾Ƴ� �� �ִ�. �̸� ����ϴ� ���α׷��� �ۼ��϶�.
 * �Է�: ù �ٿ� n (1 �� n �� 100,000)�� �־�����. ��° �ٺ��� n���� �ٿ��� ������ �̷�� 1�̻� n������ ������ �ϳ��� ������� �־�����. ���� ���� ������ �� �� ������ ���� ����.
 * ���: �Էµ� ������ ����� ���� �ʿ��� ������ �� �ٿ� �� ���� ����Ѵ�. push������ +��, pop ������ -�� ǥ���ϵ��� �Ѵ�. �Ұ����� ��� NO�� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class D210701T1874StackSequence {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> sequnce = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) {
			sequnce.add(Integer.parseInt(br.readLine()));
		}
        br.close();

		ArrayList<Integer> stack = new ArrayList<Integer>();		
		int idx = 1;
		while(sequnce.size() > 0) {
			int n = sequnce.get(0);

			if(stack.size() > 0 && stack.get(stack.size()-1) == n) {
				sb.append("-").append("\n");
				stack.remove(stack.size()-1);
				sequnce.remove(0);
			}
			else if(idx <= n) {
				while(idx <= n) {
					sb.append("+").append("\n");
					stack.add(idx++);
				}	
			}
			else {
				System.out.println("NO");
				System.exit(0);
				break;				
			}
		}		
		System.out.println(sb.toString());
		
		/*
		int[] stack = new int[N];
        int top = -1;
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            // �ϴ� push
            stack[++top] = i;
            sb.append("+" + "\n");
            // �Էµ� ������ idx��° ���� stack�� peek�� ���ٸ� pop
            while(nums[idx] == stack[top]) {
                sb.append("-" + "\n");
                top--;
                idx++;
                if(top < 0 || idx > N) break;
            }
        }
        if(top == -1 && idx == N)     
            System.out.println(sb);
        else {
            sb.substring(0, sb.length());
            System.out.println("NO");
        }
		*/
	}
}