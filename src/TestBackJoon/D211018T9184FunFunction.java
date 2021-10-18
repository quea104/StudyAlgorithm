package TestBackJoon;

/*
 * ������: �Ǻ���ġ �Լ�
 * ����: 21.10.18.��
 * https://www.acmicpc.net/problem/9184
 * ��������: ��� ȣ�⸸ �����ϸ� ���� ����! �ƴѰ���? ������ ���� ����Լ� w(a, b, c)�� �ִ�.

if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
    1
    
if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
    w(20, 20, 20)
    
if a < b and b < c, then w(a, b, c) returns:
    w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)

otherwise it returns:
    w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    
���� �Լ��� �����ϴ� ���� �ſ� ����. ������, �״�� �����ϸ� ���� ���ϴµ� �ſ� ���� �ð��� �ɸ���. (���� ���, a=15, b=15, c=15)
a, b, c�� �־����� ��, w(a, b, c)�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

 * �Է�: �Է��� �� ���� a, b, c�� �̷���� ������, �� �ٿ� �ϳ��� �־�����. �Է��� �������� -1 -1 -1�� ��Ÿ����, �� ������ ��� -1�� ���� �Է��� �������� �����ϸ� ����.
 * ���: �Է����� �־��� ������ a, b, c�� ���ؼ�, w(a, b, c)�� ����Ѵ�.
 * ����: -50 �� a, b, c �� 50
 * Ǯ��: ������ȹ��(Dynamic programming), ���
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D211018T9184FunFunction {
	static int[][][] result = new int[21][21][21];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String strNumbers = "";
		
		while(true) {
			strNumbers = br.readLine();
			if(strNumbers.equals("-1 -1 -1")) {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(strNumbers, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a ,b ,c)).append('\n');
		}
		System.out.print(sb.toString());
	}
	
	static int w(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		if(result[a][b][c] > 0) {
			return result[a][b][c];
		}
		else {
			if(a > 20 || b > 20 || c > 20) {
				result[a][b][c] = w(20, 20, 20);
			}
			else if(a < b && b < c) {
				result[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
			}
			else {
				result[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
			}
			
			return result[a][b][c];	
		}
	}
}
