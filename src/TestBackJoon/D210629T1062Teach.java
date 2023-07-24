package TestBackJoon;
/*
 * 문제명: 가르침
 * 일자: 21.06.29.화
 * https://www.acmicpc.net/problem/1062
 * 문제내용: 남극에 사는 김지민 선생님은 학생들이 되도록이면 많은 단어를 읽을 수 있도록 하려고 한다. 
		그러나 지구온난화로 인해 얼음이 녹아서 곧 학교가 무너지기 때문에, 김지민은 K개의 글자를 가르칠 시간 밖에 없다. 김지민이 가르치고 난 후에는, 학생들은 그 K개의 글자로만 이루어진 단어만을 읽을 수 있다. 
		김지민은 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 되는지 고민에 빠졌다.
		남극언어의 모든 단어는 "anta"로 시작되고, "tica"로 끝난다. 남극언어에 단어는 N개 밖에 없다고 가정한다. 학생들이 읽을 수 있는 단어의 최댓값을 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 단어의 개수 N과 K가 주어진다. N은 50보다 작거나 같은 자연수이고, K는 26보다 작거나 같은 자연수 또는 0이다. 둘째 줄부터 N개의 줄에 남극 언어의 단어가 주어진다. 
		단어는 영어 소문자로만 이루어져 있고, 길이가 8보다 크거나 같고, 15보다 작거나 같다. 모든 단어는 중복되지 않는다.
 * 출력: 첫째 줄에 김지민이 K개의 글자를 가르칠 때, 학생들이 읽을 수 있는 단어 개수의 최댓값을 출력한다.
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
		
		if(K < 5) { // antic 포함해서 알파벳을 배워야하므로 
			result = 0;
		}
		else if(K == 26) {
			result = N;
		}
		else {
			// antic 미리 익히기
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
		if(depth == K) { // K개 알파벳을 다 배웠으니 읽을 수 있는 단어 개수 세기
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
			// 알파벳 배우기
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
