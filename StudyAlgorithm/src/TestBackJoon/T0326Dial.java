package TestBackJoon;
/*
 * 문제명: 다이얼
 * 일자: 21.03.26.금
 * https://www.acmicpc.net/problem/5622
 * 문제내용:
 		전화를 걸고 싶은 번호가 있다면, 숫자를 하나를 누른 다음에 금속 핀이 있는 곳 까지 시계방향으로 돌려야 한다. 숫자를 하나 누르면 다이얼이 처음 위치로 돌아가고, 다음 숫자를 누르려면 다이얼을 처음 위치에서 다시 돌려야 한다.
		숫자 1을 걸려면 총 2초가 필요하다. 1보다 큰 수를 거는데 걸리는 시간은 이보다 더 걸리며, 한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다.
		상근이의 할머니는 전화 번호를 각 숫자에 해당하는 문자로 외운다. 즉, 어떤 단어를 걸 때, 각 알파벳에 해당하는 숫자를 걸면 된다. 예를 들어, UNUCIC는 868242와 같다.
		할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 최소 시간을 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어의 길이는 2보다 크거나 같고, 15보다 작거나 같다.
 * 출력: 첫째 줄에 다이얼을 걸기 위해서 필요한 최소 시간을 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class T0326Dial {
	public void solution2() throws IOException {
		int sum = 0;
		int input = System.in.read(); 
		while(input > 64 && input < 91) {
			if(input < 68) sum += 3;
			else if(input < 71) sum += 4;
			else if(input < 74) sum += 5;
			else if(input < 77) sum += 6;
			else if(input < 80) sum += 7;
			else if(input < 84) sum += 8;
			else if(input < 87) sum += 9;
			else sum += 10;
			
			input = System.in.read();
		}
		System.out.println(sum);
	}
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(calulate(br.readLine()));
	}
	
	private int calulate(String str) {
		if(str == "")
			return 0;
		else {
			return 2 + getDialNumber(str.charAt(0)) + calulate(str.substring(1));
		}
	}
	
	private int getDialNumber(char c) {
		if("ABC".indexOf(c) > -1)
			return 1;
		else if("DEF".indexOf(c) > -1)
			return 2;
		else if("GHI".indexOf(c) > -1)
			return 3;
		else if("JKL".indexOf(c) > -1)
			return 4;
		else if("MNO".indexOf(c) > -1)
			return 5;
		else if("PQRS".indexOf(c) > -1)
			return 6;
		else if("TUV".indexOf(c) > -1)
			return 7;
		else if("WXYZ".indexOf(c) > -1)
			return 8;
		else 
			return -2;
	}
}