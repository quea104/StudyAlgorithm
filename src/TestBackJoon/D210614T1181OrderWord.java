package TestBackJoon;
/*
 * 문제명: 단어 정렬
 * 일자: 21.06.14.월
 * https://www.acmicpc.net/problem/1181
 * 문제내용: 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오. 길이가 짧은 것부터->길이가 같으면 사전 순으로
 * 입력: 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
 * 출력: 조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class D210614T1181OrderWord {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < N; i++) {
			ArrayList<String> innerList = new ArrayList<>();
			String word = br.readLine();
			innerList.add(Integer.toString(word.length()));
			innerList.add(word);
			list.add(innerList);
		}
		
		list.sort((e1, e2) -> {
			int numE1 = Integer.parseInt(e1.get(0));
			int numE2 = Integer.parseInt(e2.get(0));
			if(numE1 > numE2) {
				return 1;
			}
			else if(numE1 == numE2) {
				if(e1.get(1).compareTo(e2.get(1)) > 0) {
					return 1;
				}
				else if(e1.get(1).equals(e2.get(1))) {
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
		
		String repeatWord = "";
		StringBuilder sb = new StringBuilder();
		for(ArrayList<String> innerList : list) {
			String word = innerList.get(1);
			if(!repeatWord.equals(word)) {
				sb.append(word).append("\n");	
			}
			repeatWord = word; 
		}
		System.out.println(sb.toString());
	}
}