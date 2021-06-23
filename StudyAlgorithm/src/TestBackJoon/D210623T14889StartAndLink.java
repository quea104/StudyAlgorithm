package TestBackJoon;
/*
 * 문제명: 스타트와 링크
 * 일자: 21.06.18.금, 22.화~23.수
 * https://www.acmicpc.net/problem/14889
 * 문제내용: 오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다. 축구는 평일 오후에 하고 의무 참석도 아니다. 축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다. 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.
			BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다. 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다. 
			팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다. Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.
			예를 들어, 1, 2번이 스타트 팀, 3, 4번이 링크 팀에 속한 경우에 두 팀의 능력치는 아래와 같다.
				스타트 팀: S12 + S21 = 1 + 4 = 5
				링크 팀: S34 + S43 = 2 + 5 = 7
			1, 3번이 스타트 팀, 2, 4번이 링크 팀에 속하면, 두 팀의 능력치는 아래와 같다.
				스타트 팀: S13 + S31 = 2 + 7 = 9
				링크 팀: S24 + S42 = 6 + 4 = 10
			축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다. 위의 예제와 같은 경우에는 1, 4번이 스타트 팀, 2, 3번 팀이 링크 팀에 속하면 스타트 팀의 능력치는 6, 링크 팀의 능력치는 6이 되어서 차이가 0이 되고 이 값이 최소이다.
 * 입력: 첫째 줄에 N(4 ≤ N ≤ 20, N은 짝수)이 주어진다. 둘째 줄부터 N개의 줄에 S가 주어진다. 각 줄은 N개의 수로 이루어져 있고, i번 줄의 j번째 수는 Sij 이다. Sii는 항상 0이고, 나머지 Sij는 1보다 크거나 같고, 100보다 작거나 같은 정수이다.
 * 출력: 첫째 줄에 스타트 팀과 링크 팀의 능력치의 차이의 최솟값을 출력한다.
 * 풀이: https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%8014889-%EC%8A%A4%ED%83%80%ED%8A%B8%EC%99%80-%EB%A7%81%ED%81%AC-java
 		조합문제처럼 풀면 됨
 		사람이 6명(0번~5번)일 경우 012, 013, 014, 015, 023, 024, 025, 034, 035, 045, 123, 124, 125, 134, 135, 145, 234, 235, 345 조합 순으로 start 팀으로 나누게 됨.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class D210623T14889StartAndLink {
	static int[][] table;
	static boolean[] visited;
	static int N;
	static int diffMin = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		table = new int[N][N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(diffMin);
	}

	static void dfs(int round, int start) {
		// 전체 인원의 반절씩 팀으로 나누기 때문에 인원수의 반절일 경우 분기 이동 중단
		if(round == N/2) {
			int[] startTeam = new int[N/2], linkTeam = new int[N/2];
			int startIndex = 0, linkIndex = 0;
			int sumStart = 0, sumLink = 0;
			
			for(int i = 0; i < N; i++) {
				if(visited[i]) { // true일 경우 스타트 팀 귀속
					startTeam[startIndex++] = i;
				}
				else { // false일 경우 링크 팀 귀속
					linkTeam[linkIndex++] = i;
				}
			}

//			System.out.print("\n\nS: ");
//			for(int i = 0; i < startIndex; i++) {
//				System.out.print(startTeam[i]);
//			}
//			System.out.print("\nL: ");
//			for(int i = 0; i < linkIndex; i++) {
//				System.out.print(linkTeam[i]);
//			}

			// i=j 일 경우는 값이 0이므로 j는 i+1로 시작해줌
			for(int i = 0; i < N/2; i++) {
				for(int j = i+1; j < N/2; j++) {
					//System.out.print("\nI: " + i + "," + j);
					//System.out.print("\nS: " + startTeam[i] + "," + startTeam[j]);
					//System.out.print("\nL: " + linkTeam[i] + "," + linkTeam[j]);
					sumStart += table[startTeam[i]][startTeam[j]] + table[startTeam[j]][startTeam[i]];
					sumLink += table[linkTeam[i]][linkTeam[j]] + table[linkTeam[j]][linkTeam[i]];
				}
			}
			//System.out.println();
			
			diffMin = Math.min(diffMin, Math.abs(sumStart-sumLink));
		}
		else {
			for(int i = start; i < N; i++) {
				visited[i] = true; // true일 경우 스타트 팀 귀속
				dfs(round+1, i+1);
				visited[i] = false; // false일 경우 링크 팀 귀속
			}
		}
	}
}