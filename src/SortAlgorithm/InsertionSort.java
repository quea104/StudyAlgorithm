package SortAlgorithm;

/*
 * 삽입정렬
 * 시간복잡도 O(n^2)
 * 하나씩 삽입해 나가는 형태의 정렬방식, 특정 값에 대해서 그 값이 맞는 위치를 찾고, 나머지는 한칸씩 밀어내기.
 * O(n^2) 정렬 알고리즘 중에서는 가장 빠름
 */
public class InsertionSort {
	public static void main(String[] args) {
		int[] arr, resultArr;
		System.out.println("Sort Algorithm: Insertion Sort");
		arr = new int[] {10, 8, 2, 5, 6, 4};
		print(arr);
		resultArr = sort(arr);
		print(resultArr);
	}
	
	public static int[] sort(int arr[]) {
		for(int i = 1; i < arr.length; i++) {
			for(int j = i-1; j >= 0; j--) { // j를 i의 왼쪽으로 이동
				if(arr[j] > arr[j+1]) { // i번째 값이 커질 때까지 이동
					int t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;
				}
				else break;
			}
		}
		return arr;
	}
	
	public static void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
