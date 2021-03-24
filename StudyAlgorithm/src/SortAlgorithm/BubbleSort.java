package SortAlgorithm;

/*
 * 버블정렬
 * 시간복잡도 O(n^2) - for문 두번
 * 공간복잡도 O(n) - 배열 한 개만 사용
 * 서로 인접한 두 원소를 검사하여 정렬하는 알고리즘
 * 간단하지만 시간복잡도가 좋지 않아 거의 사용 안함.
 */
public class BubbleSort {
	public int[] sort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int m = arr[i];
					arr[i] = arr[j];
					arr[j] = m;
				}
			}
		}
		return arr;
	}
}