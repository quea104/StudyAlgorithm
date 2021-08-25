package TestBackJoon;
/*
 * ������: �����
 * ����: 21.06.14.��
 * https://www.acmicpc.net/problem/2108
 * ��������: ���� ó���ϴ� ���� ����п��� ����� �߿��� ���̴�. ����п��� N���� ���� ��ǥ�ϴ� �⺻ ��谪���� ������ ���� �͵��� �ִ�. ��, N�� Ȧ����� ��������.
			������ : N���� ������ ���� N���� ���� ��
			�߾Ӱ� : N���� ������ �����ϴ� ������ �������� ��� �� �߾ӿ� ��ġ�ϴ� ��
			�ֺ� : N���� ���� �� ���� ���� ��Ÿ���� ��
			���� : N���� ���� �� �ִ񰪰� �ּڰ��� ����
			N���� ���� �־����� ��, �� ���� �⺻ ��谪�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� ���� ���� N(1 �� N �� 500,000)�� �־�����. ��, N�� Ȧ���̴�. �� ���� N���� �ٿ��� �������� �־�����. �ԷµǴ� ������ ������ 4,000�� ���� �ʴ´�.
 * ���: ù° �ٿ��� �������� ����Ѵ�. �Ҽ��� ���� ù° �ڸ����� �ݿø��� ���� ����Ѵ�.
		��° �ٿ��� �߾Ӱ��� ����Ѵ�.		
		��° �ٿ��� �ֺ��� ����Ѵ�. ���� �� ���� ������ �ֺ� �� �� ��°�� ���� ���� ����Ѵ�.		
		��° �ٿ��� ������ ����Ѵ�.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class D210614T2108Statistics {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();

		int sum = 0;
        int[] countArr = new int[8001];
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			list.add(num);
			sum += num;
			countArr[num+4000]++;
		}
        br.close();
        
        Collections.sort(list);
        
		int repeatMaxCount = 0;
		for(int i = 0; i < countArr.length; i++) {
			if(countArr[i] >= repeatMaxCount) {
				repeatMaxCount = countArr[i];
			}
		}
		ArrayList<Integer> repeatList = new ArrayList<>();
		for(int i = 0; i < countArr.length; i++) {
			if(countArr[i] == repeatMaxCount) {
				repeatList.add(i-4000);
			}
		}
        
        sb.append((int)Math.round((double)sum / N)).append('\n'); // ������ - �Ҽ��� ���� ù° �ڸ����� �ݿø��� ���� ����Ѵ�.
        sb.append(list.get(((N + 1) / 2) - 1)).append('\n'); // �߾Ӱ�
        // �ֺ�
        if(repeatList.size() == 1) {
        	sb.append(repeatList.get(0)).append('\n');
        }
        else {
        	Collections.sort(repeatList);
    		sb.append(repeatList.get(1)).append('\n'); 
        }
        sb.append(list.get(N-1) - list.get(0)); // ����
        
		System.out.println(sb);
	}
}