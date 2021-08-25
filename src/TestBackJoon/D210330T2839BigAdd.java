package TestBackJoon;
/*
 * ������: ���� ���
 * ����: 21.03.30.ȭ
 * https://www.acmicpc.net/problem/2839
 * ��������:
 		����̴� ���� �������忡�� ������ ����ϰ� �ִ�. ����̴� ���� �������Կ� ������ ��Ȯ�ϰ� Nų�α׷��� ����ؾ� �Ѵ�. �������忡�� ����� ������ ������ ����� �ִ�.
 		������ 3ų�α׷� ������ 5ų�α׷� ������ �ִ�.
		����̴� ������ ������, �ִ��� ���� ������ ��� ������ �Ѵ�. ���� ���, 18ų�α׷� ������ ����ؾ� �� ��, 3ų�α׷� ���� 6���� �������� ������, 5ų�α׷� 3���� 3ų�α׷� 1���� ����ϸ�, �� ���� ������ ������ ����� �� �ִ�.
		����̰� ������ ��Ȯ�ϰ� Nų�α׷� ����ؾ� �� ��, ���� �� ���� �������� �Ǵ��� �� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� N�� �־�����. (3 �� N �� 5000)
 * ���: ����̰� ����ϴ� ������ �ּ� ������ ����Ѵ�. ����, ��Ȯ�ϰ� Nų�α׷��� ���� �� ���ٸ� -1�� ����Ѵ�.
 * Ǯ��
		1) 5kg �� ������ �������� ���� �� �ִٸ� (�Է� ���� 5�� �����������ٸ�) �Է°��� 5�� ���� ���� ����ϰ� ���α׷� ����
		2) 5kg �� ������ �������� ���� �� ���ٸ� 3kg ������ �� �� ��� (���� ī��Ʈ�� 1 ����, �Է°��� 3 ����)		
		3) ���� �Է°��� 0���� �۾����� -1�� ����ϰ� ���α׷� ����
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;
public class D210330T2839BigAdd {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		if(A.length() > B.length())
			B = String.format("%0"+Integer.toString(A.length()-B.length())+"d", 0).concat(B);
		else if(A.length() < B.length())
			A = String.format("%0"+Integer.toString(B.length()-A.length())+"d", 0).concat(A);
		int a = 0, b = 0, add = 0, remain = 0;
		String result = "";
		for(int i = A.length(); i > 0; i--) {
			a = Integer.parseInt(A.substring(i-1, i));
			b = Integer.parseInt(B.substring(i-1, i));
			add = a + b + remain;
			remain = add/10;
			result = Integer.toString((add >= 10 && i > 1) ? add-10 : add).concat(result);
		}
		bw.write(result);
		bw.flush();
		
//		BigInteger A = new BigInteger(input());
//		BigInteger B = new BigInteger(input());
//		 
//		/*
//		 * add() �޼ҵ�� �ش� BigInteger ��ü�� �Ķ����(����)�� ���� 
//		 * BigInteger��ü�� ���� ���� BigInteger Ÿ������ ��ȯ�Ѵ�.
//		 */
//		A = A.add(B);
//		print(A.toString());
	}
}
