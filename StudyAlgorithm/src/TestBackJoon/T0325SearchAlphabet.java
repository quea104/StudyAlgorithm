package TestBackJoon;
/*
 * 문제명: 알파벳 찾기
 * 일자: 21.03.25.목
 * https://www.acmicpc.net/problem/10809
 * 문제내용: 
 		알파벳 소문자로만 이루어진 단어 S가 주어진다. 
 		각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
 * 출력: 
 		각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
		만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class T0325SearchAlphabet {	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		br.close();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 'a'; i <= 'z'; i++) {
			sb.append(word.indexOf(i)).append(" ");
		}
//		String smallAlphabet = "abcdefghijklmnopqrstuvwxyz";
//		int[] counts = new int[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
//		for(int i = 0; i < word.length(); i++) {
//			int idx = smallAlphabet.indexOf(word.substring(i, i+1));
//			if(counts[idx] == -1) 
//				counts[idx] = i;
//		}
//		for(int i = 0; i < counts.length; i++) {
//			sb.append(counts[i]).append(" ");
//		}
		System.out.print(sb.toString());
	}
}