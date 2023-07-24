package TestBackJoon;

/*
 * 문제명: 크로아티아 알파벳
 * 일자: 21.03.26.금
 * https://www.acmicpc.net/problem/2941
 * 문제내용: 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 * 입력: 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다. 단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.
 * 출력: 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class D210326T2941CroatiaAlphabet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int len = str.length();
        int count = 0;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);

            if (ch == 'c' && i < len - 1) { // 만약 ch 가 c라면?
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    // i+1 까지가 하나의 문자이므로 다음 문자를 건너 뛰기 위해 1 증가
                    i++;
                } else if (str.charAt(i + 1) == '-') {
                    i++;
                }
            } else if (ch == 'd' && i < len - 1) { // 만약 ch 가 d라면?
                if (str.charAt(i + 1) == '-') {
                    i++;
                } else if (str.charAt(i + 1) == 'z' && i < len - 2) {
                    if (str.charAt(i + 2) == '=') { // dz= 일 경우
                        i += 2;
                    }
                }
            } else if (ch == 'l' && i < len - 1) { // 만약 ch 가 l라면?
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            } else if (ch == 'n' && i < len - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            } else if (ch == 's' && i < len - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            } else if (ch == 'z' && i < len - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }
            count++;
        }
        System.out.println(count);
	}
	
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int count = 0;
		while(word != "") {
			int index = 1;
			if(word.length() > 1 && check(word.substring(0, 2))) {
				index = 2;
			}
			else {
				if(word.length() > 2 && check(word.substring(0, 3))) {
					index = 3;
				}
			}
			word = word.substring(index);
			count++;
		}
		System.out.println(count);
	}
	private boolean check(String ch) {
		boolean c = false;
		if(ch.length() == 2)
			c = (ch.equals("c=") || ch.equals("c-") || ch.equals("d-") || ch.equals("lj") || ch.equals("nj") || ch.equals("s=") || ch.equals("z="));
		else
			c = ch.equals("dz=");
		return c;
	}
	*/
}
