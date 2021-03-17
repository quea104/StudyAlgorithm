package packSortAlgorithm;

/*
 * 선택정렬
 * 시간복잡도 O(n^2)
 * 버블정렬과 유사. 한번 순회를 하면서 가장 큰 수를 찾아서 배열의 마지막 위치와 교환.
 */
public class SelectionSort {
	public void sort(int arr[]) {
		int minIndex;
		for (int i = 0; i < arr.length; i++) {
			minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[minIndex] < arr[j]) {
					minIndex = j;
				}
			}
			int t = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = t;
		}
	}
	
	public void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
