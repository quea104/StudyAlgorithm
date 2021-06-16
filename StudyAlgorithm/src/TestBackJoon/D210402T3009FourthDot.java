package TestBackJoon;
/*
 * 문제명: 네 번째 점
 * 일자: 21.04.02.금
 * https://www.acmicpc.net/problem/3009
 * 문제내용: 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
 * 입력: 세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.
 * 출력: 직사각형의 네 번째 점의 좌표를 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
public class D210402T3009FourthDot {
	public static void main(String[] args) throws IOException {
		int x4 = 0, y4 = 0;
		int[] xArr = new int[3];
		int[] yArr = new int[3];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			xArr[i] = Integer.parseInt(st.nextToken());
			yArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(xArr);
		Arrays.sort(yArr);
		if(xArr[0] == xArr[1]) {
			x4 = xArr[2]; 
		}
		else {
			x4 = xArr[0];			
		}
		if(yArr[0] == yArr[1]) {
			y4 = yArr[2]; 
		}
		else {
			y4 = yArr[0];			
		}
		System.out.println(x4 + " " + y4);
	}
	
	public void solution2() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int[][] num = new int[3][2];
		
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(num[0][0] == num[1][0]) {
			sb.append(num[2][0]);
		}
		else if(num[0][0] == num[2][0]) {
			sb.append(num[1][0]);
		}
		else {
			sb.append(num[0][0]);
		}
		sb.append(" ");
		
		if(num[0][1] == num[1][1]) {
			sb.append(num[2][1]);
		}
		else if(num[0][1] == num[2][1]) {
			sb.append(num[1][1]);
		}
		else {
			sb.append(num[0][1]);
		}
		System.out.println(sb);
	}
}