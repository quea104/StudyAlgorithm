package TestProgrammers;

import java.util.*;

/*
 * ������: k�������� �Ҽ� ���� ���ϱ�
 * ����: 22.08.23.ȭ
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 * ���� ����
���� ���� n�� �־����ϴ�. �� ���ڸ� k������ �ٲ��� ��, ��ȯ�� �� �ȿ� �Ʒ� ���ǿ� �´� �Ҽ�(Prime number)�� �� ������ �˾ƺ��� �մϴ�.

0P0ó�� �Ҽ� ���ʿ� 0�� �ִ� ���
P0ó�� �Ҽ� �����ʿ��� 0�� �ְ� ���ʿ��� �ƹ��͵� ���� ���
0Pó�� �Ҽ� ���ʿ��� 0�� �ְ� �����ʿ��� �ƹ��͵� ���� ���
Pó�� �Ҽ� ���ʿ� �ƹ��͵� ���� ���
��, P�� �� �ڸ����� 0�� �������� �ʴ� �Ҽ��Դϴ�.
���� ���, 101�� P�� �� �� �����ϴ�.
���� ���, 437674�� 3������ �ٲٸ� 211020101011�Դϴ�. ���⼭ ã�� �� �ִ� ���ǿ� �´� �Ҽ��� ���ʺ��� ������� 211, 2, 11�� ������, �� 3���Դϴ�. (211, 2, 11�� k�������� ������ ���� �ƴ�, 10�������� ������ �� �Ҽ����� �Ѵٴ� ���� �����մϴ�.) 211�� P0 ���¿��� ã�� �� ������, 2�� 0P0����, 11�� 0P���� ã�� �� �ֽ��ϴ�.

���� n�� k�� �Ű������� �־����ϴ�. n�� k������ �ٲ��� ��, ��ȯ�� �� �ȿ��� ã�� �� �ִ� �� ���ǿ� �´� �Ҽ��� ������ return �ϵ��� solution �Լ��� �ϼ��� �ּ���.

���ѻ���
1 �� n �� 1,000,000
3 �� k �� 10
����� ��
n	k	result
437674	3	3
110011	10	2
����� �� ����
����� �� #1

���� ���ÿ� �����ϴ�.

����� �� #2

110011�� 10������ �ٲٸ� 110011�Դϴ�. ���⼭ ã�� �� �ִ� ���ǿ� �´� �Ҽ��� 11, 11 2���Դϴ�. �̿� ����, �ߺ��Ǵ� �Ҽ��� �߰��ϴ��� ��� ���� ����� �մϴ�.
 */

public class D220823level1_92335 {
	// �Ҽ� �Ǻ�
	public static boolean isPrimeNumber(long number)
	{
		// 0 �� 1 �� �Ҽ� �ƴϹǷ� ����
		if(number < 2) {
			return false;
		}
		
		// 2 �� �Ҽ�
		if(number == 2) {
			return true;
		}
		
		for(long i = 2; i <= Math.sqrt(number); i++) {
			// �Ҽ��� �ƴҰ�� ����
			if(number % i == 0) {
				return false;
			}
		}
		
		return true;
	}

	// ���� ��ȯ
	public static String reveseKNumber(int n, int k)
	{
		String kNumber = "";
		while(n > 0) {
			kNumber = (n%k) + kNumber;
			n /= k;			
		}
		
		return kNumber;
	}
	
	public static void main(String[] args) {
		int n = 437674;
		int k = 3;
		int answer = 0;

		String kNumber = reveseKNumber(n, k);

		// �Ҽ� ���� ���ϱ�
		int start, end;
		for(start = 0; start < kNumber.length();)
		{
			for(end = start+1; end < kNumber.length(); end++) {
				if(kNumber.charAt(end) == '0') {
					break;
				}
			}
			
			if(isPrimeNumber(Long.parseLong(kNumber.substring(start, end)))) {
				answer++;
			}
			
			start = end;
		}
		
		/*
		while(kNumber != "") {
			int index = 0;

            if(index < kNumber.length()) {
				char numOne = kNumber.charAt(index);
				while(numOne != '0') {
					index++;
					if(index > kNumber.length()-1)
						break;
					numOne = kNumber.charAt(index);
				}

				if(index == 0) {
					kNumber = kNumber.substring(index+1);
				}
				else {
					// �Ҽ� Ȯ��
					long number = Long.parseLong(kNumber.substring(0, index));
					kNumber = kNumber.substring(index);
					if(isPrimeNumber(number)) {
						answer++;
					}
				}
            }
		}
		*/
		
		System.out.println(answer);
	}	
	
}
