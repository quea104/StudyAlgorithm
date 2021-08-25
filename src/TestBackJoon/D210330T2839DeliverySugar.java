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
import java.io.IOException;
public class D210330T2839DeliverySugar {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int weight = Integer.parseInt(br.readLine());
		int count = 0;
		int[] arr = new int[5001];
		arr[0] = weight;
		while(weight > 0) {
			if(weight%5 == 0) {
				count = count + (weight / 5);
				weight = weight % 5;
			}
			else {
				count++;
				weight -= 3;
			}
			
			if (weight < 0) {
				count = -1;
				break;
			}
		}
		bw.write(Integer.toString(count));
		bw.flush();
	}
}