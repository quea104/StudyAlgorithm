package TestBackJoon;
/*
 * ������: ���ڿ� �ݺ�
 * ����: 21.03.26.��
 * https://www.acmicpc.net/problem/2675
 * ��������: 
 		���ڿ� S�� �Է¹��� �Ŀ�, �� ���ڸ� R�� �ݺ��� �� ���ڿ� P�� ���� �� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 		��, ù ��° ���ڸ� R�� �ݺ��ϰ�, �� ��° ���ڸ� R�� �ݺ��ϴ� ������ P�� ����� �ȴ�. S���� QR Code "alphanumeric" ���ڸ� ����ִ�.
		QR Code "alphanumeric" ���ڴ� 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: �̴�.
 * �Է�: ù° �ٿ� �׽�Ʈ ���̽��� ���� T(1 �� T �� 1,000)�� �־�����. �� �׽�Ʈ ���̽��� �ݺ� Ƚ�� R(1 �� R �� 8), ���ڿ� S�� �������� ���еǾ� �־�����. S�� ���̴� ��� 1�̸�, 20���ڸ� ���� �ʴ´�. 
 * ���: �� �׽�Ʈ ���̽��� ���� P�� ����Ѵ�.
 */

import java.io.*;
import java.util.StringTokenizer;
public class D210326T2675RepeatAlphabet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int repeat = Integer.parseInt(st.nextToken());
			String word = st.nextToken();
			for(int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				for(int k = 0; k < repeat; k++) {
					bw.write(c);
				}
			}
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}