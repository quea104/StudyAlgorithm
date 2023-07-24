package TestBackJoon;
/*
 * 문제명: 요세푸스 문제
 * 일자: 21.06.30.수
 * https://www.acmicpc.net/problem/1158
 * 문제내용: 요세푸스 문제는 다음과 같다.
		1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 
		한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 
		원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.		
		N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)
 * 출력: 예제와 같이 요세푸스 순열을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D210630T1158JosephuProblem {	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 1. 배열 사용
		int[] queue = new int[N];
		for(int i = 0; i < N; i++) {
			queue[i] = i+1;
		}

		int size = N;
		int front = 0, move = 0;
		
		
		while(size-- > 0) {
			move = 0;
			while(move < K) {
				if(front == N) {
					front = 0;
				}
				
				if(queue[front] == 0) {
					front++;
				}
				else {
					front++;
					move++;
				}
			}
			
			sb.append(queue[front-1]).append(", ");			
			queue[front-1] = 0;
		}
		System.out.println("<" + sb.toString().substring(0, sb.length()-2) + ">");
		
		// 2. List 사용
		sb = new StringBuilder();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			arr.add(i);
		}
		int idx = K-1;
		
		sb.append("<");
		while(arr.size() != 1) {
			int out = arr.remove(idx);
			sb.append(out);
			sb.append(", ");
			idx = (idx + K-1) % arr.size();
		}
		sb.append(arr.get(0));
		sb.append(">");
		System.out.println(sb);
	}
}