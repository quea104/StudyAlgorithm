package TestBackJoon;
/*
 * ������: ��ǥ ����
 * ����: 21.06.14.��~15.ȭ
 * https://www.acmicpc.net/problem/18870
 * ��������: ������ ���� N���� ��ǥ X1, X2, ..., XN�� �ִ�. �� ��ǥ�� ��ǥ ������ �����Ϸ��� �Ѵ�.
			Xi�� ��ǥ ������ ��� X'i�� ���� Xi > Xj�� �����ϴ� ���� �ٸ� ��ǥ�� ������ ���ƾ� �Ѵ�.
			X1, X2, ..., XN�� ��ǥ ������ ������ ��� X'1, X'2, ..., X'N�� ����غ���.
 * �Է�: ù° �ٿ� N�� �־�����. ��° �ٿ��� ���� �� ĭ���� ���е� X1, X2, ..., XN�� �־�����.
 * ���: ù° �ٿ� X'1, X'2, ..., X'N�� ���� �� ĭ���� �����ؼ� ����Ѵ�.
 * ����: 1 �� N �� 1,000,000, -10^9 �� Xi �� 10^9
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;
public class D210614T18870CompressionCoordinates {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());			
		}
		
		int[] sortArr = arr.clone();
		Arrays.sort(sortArr);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int index = 0;
		for(int n : sortArr) {
			if(!map.containsKey(n)) {
				map.put(n, index++);
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int n : arr) {
			sb.append(map.get(n)).append(" ");
		}
		System.out.println(sb.toString());
		
		/*
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<ArrayList<Integer>> cList = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			list.add(num);
			
			ArrayList<Integer> innerList = new ArrayList<Integer>();
			innerList.add(num);
			innerList.add(-1);
			cList.add(innerList);
		}
		
		Collections.sort(list);

		int index = 0;
		int repeatNumber = 1000000001;
		for(int i = 0; i < N; i++) {
			int num = list.get(i);
			if(repeatNumber != num) {
				for(ArrayList<Integer> innerList : cList) {
					if(innerList.get(1) == -1 && innerList.get(0) == num) {
						innerList.set(1, index);
					}
				}
				
				index++;
				repeatNumber = num;
			}	
		}
		
		StringBuilder sb = new StringBuilder();
		for(ArrayList<Integer> innerList : cList) {
			sb.append(innerList.get(1)).append(" ");	
		}
		System.out.println(sb.toString());
		*/
	}
}