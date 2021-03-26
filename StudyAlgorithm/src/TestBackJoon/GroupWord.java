package TestBackJoon;

/*
 * 일자: 21.03.26.금
 * https://www.acmicpc.net/problem/2941
 * 문제명: 크로아티아 알파벳
 * 문제내용: 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 * 입력: 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다. 단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.
 * 출력: 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class GroupWord {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(wordCheck(br.readLine()))
				count++;
		}
		System.out.println(count);
	}
	
	private boolean wordCheck(String word) {
		boolean[] alpha = new boolean[26];
		int prev = 0;
		for(int i = 0; i < word.length(); i++) {
			int now = word.charAt(i); 	// i 번째 문자 저장 (현재 문자)
			if (prev != now) {
				if(alpha[word.charAt(i)-'a'])
					return false;
				else {
					alpha[word.charAt(i)-'a'] = true;
					prev = now;
				}
				
			}
			else {
				continue;
			}
		}
	    return true;
	}
}