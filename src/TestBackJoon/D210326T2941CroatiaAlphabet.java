package TestBackJoon;

/*
 * ������: ũ�ξ�Ƽ�� ���ĺ�
 * ����: 21.03.26.��
 * https://www.acmicpc.net/problem/2941
 * ��������: �ܾ �־����� ��, �� ���� ũ�ξ�Ƽ�� ���ĺ����� �̷���� �ִ��� ����Ѵ�.
 * �Է�: ù° �ٿ� �ִ� 100������ �ܾ �־�����. ���ĺ� �ҹ��ڿ� '-', '='�θ� �̷���� �ִ�. �ܾ�� ũ�ξ�Ƽ�� ���ĺ����� �̷���� �ִ�. ���� ������ ǥ�� �����ִ� ���ĺ��� ����� ���·� �Էµȴ�.
 * ���: �Է����� �־��� �ܾ �� ���� ũ�ξ�Ƽ�� ���ĺ����� �̷���� �ִ��� ����Ѵ�.
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

            if (ch == 'c' && i < len - 1) { // ���� ch �� c���?
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    // i+1 ������ �ϳ��� �����̹Ƿ� ���� ���ڸ� �ǳ� �ٱ� ���� 1 ����
                    i++;
                } else if (str.charAt(i + 1) == '-') {
                    i++;
                }
            } else if (ch == 'd' && i < len - 1) { // ���� ch �� d���?
                if (str.charAt(i + 1) == '-') {
                    i++;
                } else if (str.charAt(i + 1) == 'z' && i < len - 2) {
                    if (str.charAt(i + 2) == '=') { // dz= �� ���
                        i += 2;
                    }
                }
            } else if (ch == 'l' && i < len - 1) { // ���� ch �� l���?
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
