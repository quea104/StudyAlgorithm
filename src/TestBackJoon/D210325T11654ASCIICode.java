package TestBackJoon;
/*
 * 문제명: 아스키 코드
 * 일자: 21.03.25.목
 * https://www.acmicpc.net/problem/11654
 * 문제내용: 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
 * 입력: 알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.
 * 출력: 입력으로 주어진 글자의 아스키 코드 값을 출력한다.
 */

import java.io.*;
public class D210325T11654ASCIICode {
	public static void main(String[] args) throws IOException {
		int a = System.in.read();
        System.out.println(a);
        
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String s = br.readLine();
//		int number = 0;
//		try {
//			number = Integer.parseInt(s) + 48;
//		}
//		catch (java.lang.NumberFormatException e) {
//			String bigAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//			String smallAlphabet = "abcdefghijklmnopqrstuvwxyz";
//			number = (bigAlphabet.indexOf(s) > -1 ? bigAlphabet.indexOf(s) + 65 : smallAlphabet.indexOf(s) + 97);
//		}
//		System.out.println(number);
	}
}
