package TestBackJoon;
/*
 * ������: ����� �Ѱ���
 * ����: 21.03.25.��
 * https://www.acmicpc.net/problem/4344
 * ��������: 
 		���л� ��������� 90%�� �ڽ��� �ݿ��� ����� �Ѵ´ٰ� �����Ѵ�. ����� �׵鿡�� ���� ������ �˷���� �Ѵ�.
 * �Է�: 
 		ù° �ٿ��� �׽�Ʈ ���̽��� ���� C�� �־�����.
		��° �ٺ��� �� �׽�Ʈ ���̽����� �л��� �� N(1 �� N �� 1000, N�� ����)�� ù ���� �־�����, �̾ N���� ������ �־�����. ������ 0���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�.
 * ���: �� ���̽����� �� �پ� ����� �Ѵ� �л����� ������ �ݿø��Ͽ� �Ҽ��� ��° �ڸ����� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class D210325T4344OverAverage {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int C = Integer.parseInt(br.readLine());
		for(int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[] scores = new int[N];
			double avg = 0;
			for(int j = 0; j < N; j++) {
				scores[j] = Integer.parseInt(st.nextToken());
				avg += scores[j];
			}
			avg /= N;
			double count = 0;
			for(int j = 0; j < N; j++) {
				if(scores[j] > avg)
					count+=1;
			}
			double scoreAvg = count/N*100;
			bw.write(String.format("%.3f", scoreAvg));
			bw.write("%\n");
		}
		bw.flush();
	}
}
