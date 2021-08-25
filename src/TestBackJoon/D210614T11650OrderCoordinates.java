package TestBackJoon;
/*
 * ������: ��ǥ �����ϱ�
 * ����: 21.06.14.��
 * https://www.acmicpc.net/problem/11650
 * ��������: 2���� ��� ���� �� N���� �־�����. ��ǥ�� x��ǥ�� �����ϴ� ������, x��ǥ�� ������ y��ǥ�� �����ϴ� ������ ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� ���� ���� N (1 �� N �� 100,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� i������ ��ġ xi�� yi�� �־�����. (-100,000 �� xi, yi �� 100,000) ��ǥ�� �׻� �����̰�, ��ġ�� ���� �� ���� ����.
 * ���: ù° �ٺ��� N���� �ٿ� ���� ������ ����� ����Ѵ�.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class D210614T11650OrderCoordinates {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			ArrayList<Integer> innerList = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			innerList.add(Integer.parseInt(st.nextToken()));
			innerList.add(Integer.parseInt(st.nextToken()));
			list.add(innerList);
		}
	
		list.sort((e1, e2) -> {
			if(e1.get(0) > e2.get(0))
				return 1;
			else if(e1.get(0).equals(e2.get(0))) {
				if(e1.get(1) > e2.get(1)) 
					return 1;
				else if(e1.get(1).equals(e2.get(1))) {
					return 0;
				}
				else 
					return -1;
			}
			else
				return -1;
		});
		
		StringBuilder sb = new StringBuilder();
		for (ArrayList<Integer> innerList : list) {
			sb.append(innerList.get(0)+" "+innerList.get(1)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	/*
	// �������ķ� 2�����迭 ����
	public static void sort(int[][] arr) {
		for(int i = 1; i < arr.length; i++) {
			for(int j = i-1; j >= 0; j--) {
				if(arr[j][0] > arr[j+1][0]) {
					int[][] temp = new int[1][2];
					temp[0] = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp[0];
				}
			}
		}
		for(int i = 1; i < arr.length; i++) {
			for(int j = i-1; j >= 0; j--) {
				if(arr[j][0] == arr[j+1][0] && arr[j][1] > arr[j+1][1]) {
					int temp = arr[j+1][1];
					arr[j+1][1] = arr[j][1];
					arr[j][1] = temp;
				}
			}
		}
	}
	*/
}