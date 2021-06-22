package TestKakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		
		while(!s.equals("")) {
			String word = s.substring(0, 1);
			if(word.matches("[0-9]")) {
				sb.append(word);
				s = s.substring(1);
			}
			else {
				if(word.equals("z")) { // zero
					sb.append("0");
					s = s.substring(4);
				}
				else if(word.equals("o")) { // one
					sb.append("1");
					s = s.substring(3);
				}
				else if(word.equals("t")) { // two, three
					if(s.substring(1, 2).equals("w")) {
						sb.append("2");
						s = s.substring(3);
					}
					else {
						sb.append(3);
						s = s.substring(5);						
					}
				}
				else if(word.equals("f")) { // four, five
					if(s.substring(1, 2).equals("o")) {
						sb.append("4");
					}
					else {
						sb.append("5");						
					}
					s = s.substring(4);
				}
				else if(word.equals("s")) { // six, seven
					if(s.substring(1, 2).equals("i")) {
						sb.append("6");
						s = s.substring(3);
					}
					else {
						sb.append("7");
						s = s.substring(5);						
					}
				}
				else if(word.equals("e")) { // eight
					sb.append("8");
					s = s.substring(5);					
				}
				else if(word.equals("n")) { // nine
					sb.append("9");
					s = s.substring(4);					
				}
			}
		}
		System.out.println(Integer.parseInt(String.valueOf(sb)));
		// two3threethreethree33
	}
}
