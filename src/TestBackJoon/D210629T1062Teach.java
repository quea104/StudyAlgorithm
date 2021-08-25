package TestBackJoon;
/*
 * ������: ����ħ
 * ����: 21.06.29.ȭ
 * https://www.acmicpc.net/problem/1062
 * ��������: ���ؿ� ��� ������ �������� �л����� �ǵ����̸� ���� �ܾ ���� �� �ֵ��� �Ϸ��� �Ѵ�. 
		�׷��� �����³�ȭ�� ���� ������ ��Ƽ� �� �б��� �������� ������, �������� K���� ���ڸ� ����ĥ �ð� �ۿ� ����. �������� ����ġ�� �� �Ŀ���, �л����� �� K���� ���ڷθ� �̷���� �ܾ�� ���� �� �ִ�. 
		�������� � K���� ���ڸ� �����ľ� �л����� ���� �� �ִ� �ܾ��� ������ �ִ밡 �Ǵ��� ��ο� ������.
		���ؾ���� ��� �ܾ�� "anta"�� ���۵ǰ�, "tica"�� ������. ���ؾ� �ܾ�� N�� �ۿ� ���ٰ� �����Ѵ�. �л����� ���� �� �ִ� �ܾ��� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� �ܾ��� ���� N�� K�� �־�����. N�� 50���� �۰ų� ���� �ڿ����̰�, K�� 26���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�. ��° �ٺ��� N���� �ٿ� ���� ����� �ܾ �־�����. 
		�ܾ�� ���� �ҹ��ڷθ� �̷���� �ְ�, ���̰� 8���� ũ�ų� ����, 15���� �۰ų� ����. ��� �ܾ�� �ߺ����� �ʴ´�.
 * ���: ù° �ٿ� �������� K���� ���ڸ� ����ĥ ��, �л����� ���� �� �ִ� �ܾ� ������ �ִ��� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D210629T1062Teach {
	static int N, K, result;
	static String[] words;
	static boolean[] alphabet = new boolean[26];
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(K < 5) { // antic �����ؼ� ���ĺ��� ������ϹǷ� 
			result = 0;
		}
		else if(K == 26) {
			result = N;
		}
		else {
			// antic �̸� ������
			alphabet['a'-97] = true;
			alphabet['c'-97] = true;
			alphabet['n'-97] = true;
			alphabet['i'-97] = true;
			alphabet['t'-97] = true;
			words = new String[N];
			K-= 5;
			for(int i = 0; i < N; i++) {
				String word = br.readLine();
				words[i] = word.substring(4, word.length()-4);
			}
			
			dfs(0, 0);	
		}

		System.out.println(result);
	}
	
	static void dfs(int depth, int start) {
		if(depth == K) { // K�� ���ĺ��� �� ������� ���� �� �ִ� �ܾ� ���� ����
			int count = 0;
			
			for(int i = 0; i < N; i++) {
				boolean check = true;
				
				for(int j = 0; j < words[i].length(); j++) {
					char c = words[i].charAt(j);
					if(!alphabet[c-97]) {
						check = false;
						break;
					}
				}

				if(check) {
					count++;
				}
			}
			
			if(result < count)
				result = count;
			
			return;
		}
		else {
			// ���ĺ� ����
			for(int i = start; i < 26; i++) {
				if(!alphabet[i]) {
					alphabet[i] = true;
					dfs(depth+1, i);
					alphabet[i] = false;					
				}
			}
		}
	}
}
