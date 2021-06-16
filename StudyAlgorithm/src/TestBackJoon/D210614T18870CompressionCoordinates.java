package TestBackJoon;
/*
 * 문제명: 좌표 압축
 * 일자: 21.06.14.월~15.화
 * https://www.acmicpc.net/problem/18870
 * 문제내용: 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
			Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
			X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
 * 입력: 첫째 줄에 N이 주어진다. 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
 * 출력: 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
 * 제한: 1 ≤ N ≤ 1,000,000, -10^9 ≤ Xi ≤ 10^9
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