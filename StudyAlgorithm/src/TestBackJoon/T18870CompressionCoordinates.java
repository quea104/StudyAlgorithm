package TestBackJoon;
/*
 * 문제명: 좌표 압축
 * 일자: 21.06.14.월
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
import java.util.ArrayList;
import java.util.StringTokenizer;
public class T18870CompressionCoordinates {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int index = 0;
		ArrayList<Integer> indexList = new ArrayList<>();
		list.sort((e1, e2) -> {
			if(e1 > e2) {
				indexList.add(index++);
			}
		});

		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(list.get(i)).append(" ");	
		}
		System.out.println(sb.toString());
	}
}