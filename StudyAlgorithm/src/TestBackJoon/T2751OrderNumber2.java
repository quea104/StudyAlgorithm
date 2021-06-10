package TestBackJoon;
/*
 * 문제명: 수 정렬하기
 * 일자: 21.06.10.목
 * https://www.acmicpc.net/problem/2751
 * 문제내용: N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 출력: 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 풀이: 시간 복잡도가 O(nlogn)인 정렬 알고리즘으로 풀 수 있습니다. 예를 들면 병합 정렬, 힙 정렬 등이 있지만, 어려운 알고리즘이므로 지금은 언어에 내장된 정렬 함수를 쓰는 것을 추천드립니다.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class T2751OrderNumber2 {
	public static int[] tempArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[Integer.parseInt(br.readLine())];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		tempArr = new int[arr.length];
		
		sort(arr, 0, arr.length-1);

		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void sort(int[] arr, int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			sort(arr, start, mid);
			sort(arr, mid+1, end);
			merge(arr, start, end);
		}
	}
	
	public static void merge(int[] arr, int start, int end) {
		int mid = (start + end) / 2;
		int moveFirst = start;
		int moveMiddle = mid+1;
		int index = start;
		
		while(moveFirst <= mid && moveMiddle <= end) {
			if(arr[moveFirst] > arr[moveMiddle]) {
				tempArr[index++] = arr[moveMiddle++];
			}
			else {
				tempArr[index++] = arr[moveFirst++];
			}
		}
		
		int remainIndex = (moveFirst > mid ? moveMiddle : moveFirst);
		while(index <= end) {
			tempArr[index++] = arr[remainIndex++];
		}
		
		for(int i = start; i <= end; i++) {
			arr[i] = tempArr[i];
		}
	}
}
