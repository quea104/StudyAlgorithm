package SortAlgorithm;

/*
 * 합병정렬
 * 시간복잡도 O(log n)
 * ‘존 폰 노이만(John von Neumann)’ 제안
 * 반으로 쪼개나가며 좌측과 우측 리스트를 계속하여 분할해 나간 후 각 리스트내에서 정렬 후 병합(merge) 정렬 후 병합하는 과정 => 분할 정복(divide and conquer) 알고리즘의 하나
 * 가장 많이 사용
 * 분할(Divide): 입력 배열을 같은 크기의 2개의 부분 배열로 분할 
 * -> 정복(Conquer): 부분 배열을 정렬. 부분 배열의 크기가 충분히 작지 않으면 순환 호출 을 이용하여 다시 분할 정복 방법을 적용 
 * -> 결합(Combine): 정렬된 부분 배열들을 하나의 배열에 합병
 */

public class MergeSort {
	public static int[] tempArr;

	public static void main(String[] args) {
		int[] arr = new int[] {10, 8, 2, 5, 6, 4};
		System.out.println("Sort Algorithm: Merge Sort");
		tempArr = new int[arr.length];
		
		sort(arr, 0, arr.length-1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append('\n');
		}
		System.out.println(sb);
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