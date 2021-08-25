package TestBackJoon;
/*
 * 문제명: 단어 공부
 * 일자: 21.03.26.금
 * https://www.acmicpc.net/problem/1157
 * 문제내용: 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 * 입력: 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다. 
 * 출력: 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 */

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.io.IOException;
public class D210326T1157StudyWord {
	public static void main(String[] args) throws IOException {
		int b[] = new int[26];
		int c= System.in.read();
		while(c>64) {
			if(c<91) {
				b[c-65]++;
			} else {
				b[c-97]++;
			}
			c = System.in.read();
		}
		
		int max=-1;
		int maxN=0;
		for(int i=0; i<b.length; i++) {
			if(b[i]>max) {
				max=b[i];
				maxN=i;
			} else if(b[i] == max) {
				maxN=-2;
			}
		}
		System.out.println((char)(maxN+65));
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		int[] arr = new int[26];
//		String word = br.readLine().toUpperCase();
//		for (int i = 0; i < word.length(); i++) {
//			arr[alphabet.indexOf(word.substring(i, i+1))] += 1;
//		}
//		
//		int maxCount = arr[0];
//		char maxAlpha = alphabet.charAt(0);
//		for (int i = 1; i < arr.length; i++) {
//			if (maxCount < arr[i]) {
//				maxCount = arr[i];
//				maxAlpha = alphabet.charAt(i);
//			}
//			else if(maxCount == arr[i]) {
//				maxAlpha = '?';
//			}
//		}
//		System.out.println(maxAlpha);
	}
}