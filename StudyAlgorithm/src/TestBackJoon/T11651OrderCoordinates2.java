package TestBackJoon;
/*
 * 문제명: 좌표 정렬하기2
 * 일자: 21.06.14.월
 * https://www.acmicpc.net/problem/11651
 * 문제내용: 2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 * 출력: 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class T11651OrderCoordinates2 {	
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
			if(e1.get(1) > e2.get(1)) {
				return 1;
			}
			else if(e1.get(1).equals(e2.get(1))) {
				if(e1.get(0) > e2.get(0)) {
					return 1;
				}
				else if(e1.get(0).equals(e2.get(0))) {
					return 0;
				}
				else {
					return -1;
				}
			}
			else {
				return -1;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (ArrayList<Integer> innerList : list) {
			sb.append(innerList.get(0)+" "+innerList.get(1)).append("\n");
		}
		System.out.println(sb.toString());
	}
}