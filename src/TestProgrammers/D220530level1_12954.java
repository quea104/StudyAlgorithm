package TestProgrammers;

/*
 * ������: x��ŭ ������ �ִ� n���� ����
 * ����: 22.05.30.��
 * https://programmers.co.kr/learn/courses/30/lessons/12954
 * ���� ����
�Լ� solution�� ���� x�� �ڿ��� n�� �Է� �޾�, x���� ������ x�� �����ϴ� ���ڸ� n�� ���ϴ� ����Ʈ�� �����ؾ� �մϴ�. ���� ���� ������ ����, ������ �����ϴ� �Լ�, solution�� �ϼ����ּ���.

���� ����
x�� -10000000 �̻�, 10000000 ������ �����Դϴ�.
n�� 1000 ������ �ڿ����Դϴ�.
����� ��
x	n	answer
2	5	[2,4,6,8,10]
4	3	[4,8,12]
-4	2	[-4, -8]
 */

public class D220530level1_12954 {

	public static void main(String[] args) {
		int x = 2; 
		int n = 5;
		
		long[] answer = new long[n];
        
        for(int c=0; c<n; c++) {
            answer[c] = (long)x*(c+1);
        }
        

        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]+", ");
        }

	}

}
