package TestBackJoon;
/*
 * 문제명: 유레카 이론
 * 일자: 21.06.28.월~29.화
 * https://www.acmicpc.net/problem/10448
 * 문제내용: 삼각수 Tn(n ≥ 1)는 [그림]에서와 같이 기하학적으로 일정한 모양의 규칙을 갖는 점들의 모음으로 표현될 수 있다.
		자연수 n에 대해 n ≥ 1의 삼각수Tn는 명백한 공식이 있다.			
		Tn = 1 + 2 + 3 + ... + n = n(n+1)/2			
		1796년, 가우스는 모든 자연수가 최대 3개의 삼각수의 합으로 표현될 수 있다고 증명하였다. 예를 들어,			
			4 = T1 + T2
			5 = T1 + T1 + T2
			6 = T2 + T2 or 6 = T3
			10 = T1 + T2 + T3 or 10 = T4
		이 결과는 증명을 기념하기 위해 그의 다이어리에 “Eureka! num = Δ + Δ + Δ” 라고 적은것에서 유레카 이론으로 알려졌다. 꿍은 몇몇 자연수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 궁금해졌다. 
		위의 예시에서, 5와 10은 정확히 3개의 삼각수의 합으로 표현될 수 있지만 4와 6은 그렇지 않다.
		자연수가 주어졌을 때, 그 정수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 없는지를 판단해주는 프로그램을 만들어라. 단, 3개의 삼각수가 모두 달라야 할 필요는 없다.
 * 입력: 프로그램은 표준입력을 사용한다. 테스트케이스의 개수는 입력의 첫 번째 줄에 주어진다. 각 테스트케이스는 한 줄에 자연수 K (3 ≤ K ≤ 1,000)가 하나씩 포함되어있는 T개의 라인으로 구성되어있다.
 * 출력: 프로그램은 표준출력을 사용한다. 각 테스트케이스에대해 정확히 한 라인을 출력한다. 만약 K가 정확히 3개의 삼각수의 합으로 표현될수 있다면 1을, 그렇지 않다면 0을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class D210628T10448TheoryOfEUreka {
	static int N, pass;
	static int[] table = new int[45];
	
	public static void main(String[] args) throws IOException {
		/*
		// 1.완전탐색
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			boolean pass = false;			
			for(int i = 1; i < 45; i++) {
				for(int j = 1; j < 45; j++) {
					for(int k = 1; k < 45; k++) {
						int sum = (i*(i+1)/2) + (j*(j+1)/2) + (k*(k+1)/2);
						if(sum == N) {
							pass = true;
							break;
						}
					}
					if(pass) break;
				}
				if(pass) break;
			}
			if(pass) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		
		System.out.println(sb.toString());
		*/
		
		// 2. DFS
		getTriangleNumber();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			pass = 0;
			dfs(0, 0);
			sb.append(pass).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int depth, int sum) {		
		if(depth == 3) {
			if(sum == N) { // 3개의 삼각수로 값이 이뤄진 경우
				pass = 1;
				return;
			}
			else // 3개의 삼각수로 값이 이뤄지지 않은 경우
				return;
		}

		for(int i = 1; i < table.length; i++) {
			if(table[i] > N) return;
			
			dfs(depth+1, sum+table[i]);
		}
	}
	
	static void getTriangleNumber() {
		int n = 1;
		while(true) {
			int cal = n*(n+1)/2;
			if(cal >= 1000) break;
			table[n++] = cal;
		}
	}
}