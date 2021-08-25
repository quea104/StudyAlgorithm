package TestBackJoon;
/*
 * ������: ���̾�
 * ����: 21.03.26.��
 * https://www.acmicpc.net/problem/5622
 * ��������:
 		��ȭ�� �ɰ� ���� ��ȣ�� �ִٸ�, ���ڸ� �ϳ��� ���� ������ �ݼ� ���� �ִ� �� ���� �ð�������� ������ �Ѵ�. ���ڸ� �ϳ� ������ ���̾��� ó�� ��ġ�� ���ư���, ���� ���ڸ� �������� ���̾��� ó�� ��ġ���� �ٽ� ������ �Ѵ�.
		���� 1�� �ɷ��� �� 2�ʰ� �ʿ��ϴ�. 1���� ū ���� �Ŵµ� �ɸ��� �ð��� �̺��� �� �ɸ���, �� ĭ ���� �ִ� ���ڸ� �ɱ� ���ؼ� 1�ʾ� �� �ɸ���.
		������� �ҸӴϴ� ��ȭ ��ȣ�� �� ���ڿ� �ش��ϴ� ���ڷ� �ܿ��. ��, � �ܾ �� ��, �� ���ĺ��� �ش��ϴ� ���ڸ� �ɸ� �ȴ�. ���� ���, UNUCIC�� 868242�� ����.
		�ҸӴϰ� �ܿ� �ܾ �־����� ��, �� ��ȭ�� �ɱ� ���ؼ� �ʿ��� �ּ� �ð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� ���ĺ� �빮�ڷ� �̷���� �ܾ �־�����. �ܾ��� ���̴� 2���� ũ�ų� ����, 15���� �۰ų� ����.
 * ���: ù° �ٿ� ���̾��� �ɱ� ���ؼ� �ʿ��� �ּ� �ð��� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class D210326T5622Dial {
	public static void main(String[] args) throws IOException {
		int sum = 0;
		int input = System.in.read(); 
		while(input > 64 && input < 91) {
			if(input < 68) sum += 3;
			else if(input < 71) sum += 4;
			else if(input < 74) sum += 5;
			else if(input < 77) sum += 6;
			else if(input < 80) sum += 7;
			else if(input < 84) sum += 8;
			else if(input < 87) sum += 9;
			else sum += 10;
			
			input = System.in.read();
		}
		System.out.println(sum);
	}
	
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(calulate(br.readLine()));
	}
	
	private int calulate(String str) {
		if(str == "")
			return 0;
		else {
			return 2 + getDialNumber(str.charAt(0)) + calulate(str.substring(1));
		}
	}
	
	private int getDialNumber(char c) {
		if("ABC".indexOf(c) > -1)
			return 1;
		else if("DEF".indexOf(c) > -1)
			return 2;
		else if("GHI".indexOf(c) > -1)
			return 3;
		else if("JKL".indexOf(c) > -1)
			return 4;
		else if("MNO".indexOf(c) > -1)
			return 5;
		else if("PQRS".indexOf(c) > -1)
			return 6;
		else if("TUV".indexOf(c) > -1)
			return 7;
		else if("WXYZ".indexOf(c) > -1)
			return 8;
		else 
			return -2;
	}
	*/
}