package TestBackJoon;
/*
 * ������: �����̴� �ö󰡰� �ʹ�
 * ����: 21.03.30.ȭ
 * https://www.acmicpc.net/problem/2869
 * ��������:
 		�� ���� �����̰� �ִ�. �� �����̴� ���̰� V������ ���� ���븦 �ö� ���̴�.
		�����̴� ���� A���� �ö� �� �ִ�. ������, �㿡 ���� �ڴ� ���� B���� �̲�������. ��, ���� �ö� �Ŀ��� �̲������� �ʴ´�.
		�����̰� ���� ���븦 ��� �ö󰡷���, ��ĥ�� �ɸ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� �� ���� A, B, V�� �������� ���еǾ �־�����. (1 �� B < A �� V �� 1,000,000,000)
 * ���: ù° �ٿ� �����̰� ���� ���븦 ��� �ö󰡴µ� ��ĥ�� �ɸ����� ����Ѵ�.
 * Ǯ��:
 		(a-b)*day = v-b
 		day = (v-b) / (a-b)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
public class D210330T2869UpPanic {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int day = 0;
//		while(v > 0) {
//			day++;
//			v -= a;
//			if(v <= 0)
//				break;
//			v += b;
//		}
		day = (v-b)/(a-b);
		if((v-b)%(a-b) > 0)
			day++;
		bw.write(Integer.toString(day));
		bw.flush();
		bw.close();
	}
}