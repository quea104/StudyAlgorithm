package TestProgrammers;

/*
 * ������: ���� ���ڿ��� ���ܾ�
 * ����: 22.06.02.ȭ
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 * ���� ����
�׿��� ���ε��� ���ڳ��̸� �ϰ� �ֽ��ϴ�. �׿��� ���ε����� ���ڸ� �ǳ� �� �Ϻ� �ڸ����� ���ܾ�� �ٲ� ī�带 �ǳ��ָ� ���ε��� ���� ���ڸ� ã�� �����Դϴ�.

������ ������ �Ϻ� �ڸ����� ���ܾ�� �ٲٴ� �����Դϴ�.

1478 �� "one4seveneight"
234567 �� "23four5six7"
10203 �� "1zerotwozero3"
�̷��� ������ �Ϻ� �ڸ����� ���ܾ�� �ٲ�����ų�, Ȥ�� �ٲ��� �ʰ� �״���� ���ڿ� s�� �Ű������� �־����ϴ�. s�� �ǹ��ϴ� ���� ���ڸ� return �ϵ��� solution �Լ��� �ϼ����ּ���.

����� �� ���ڿ� �����Ǵ� ���ܾ�� ���� ǥ�� �����ϴ�.

����	���ܾ�
0	zero
1	one
2	two
3	three
4	four
5	five
6	six
7	seven
8	eight
9	nine
���ѻ���
1 �� s�� ���� �� 50
s�� "zero" �Ǵ� "0"���� �����ϴ� ���� �־����� �ʽ��ϴ�.
return ���� 1 �̻� 2,000,000,000 ������ ������ �Ǵ� �ùٸ� �Է¸� s�� �־����ϴ�.
����� ��
s	result
"one4seveneight"	1478
"23four5six7"	234567
"2three45sixseven"	234567
"123"	123
����� �� ����
����� �� #1

���� ���ÿ� �����ϴ�.
����� �� #2

���� ���ÿ� �����ϴ�.
����� �� #3

"three"�� 3, "six"�� 6, "seven"�� 7�� �����Ǳ� ������ ������ ����� �� #2�� ���� 234567�� �˴ϴ�.
����� �� #2�� #3�� ���� ���� ������ ����Ű�� ���ڿ��� ���� ������ ���� �� �ֽ��ϴ�.
����� �� #4

s���� ���ܾ�� �ٲ� �κ��� �����ϴ�.
���ѽð� �ȳ�
��Ȯ�� �׽�Ʈ : 10��
 */

import java.util.*;

public class D220602level1_81301 {

	public static void main(String[] args) {
		String s = "one4seveneight";
		
		int answer = 0;
		StringBuilder sb = new StringBuilder();

		HashMap<String, String> numbers = new HashMap<String, String>(); // ���ܾ �����Ǵ� ����
		numbers.put("zero","0");
		numbers.put("one","1");
		numbers.put("two","2");
		numbers.put("three","3");
		numbers.put("four","4");
		numbers.put("five","5");
		numbers.put("six","6");
		numbers.put("seven","7");
		numbers.put("eight","8");
		numbers.put("nine", "9");
		
		int i = 0;
		while(i < s.length()) {
			int start = i;
			int end = i+1;

			String str = s.substring(start, end);
			
			// ���ڿ��� Ȯ��
			if(str.chars().allMatch(Character::isDigit)) {
				i++;
				sb.append(str);
			}
			else {
				int add = 3;
				while(true) {
					str = s.substring(start, start+add);
					if(numbers.containsKey(str)) {
						sb.append(numbers.get(str));
						i = start+add;
						break;
					}
					
					add++;
				}	
			}
		}


		answer = Integer.parseInt(sb.toString());
		System.out.print(answer);
	}
}
