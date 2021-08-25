package SortAlgorithm;

/*
 * 퀵 정렬
 * 찰스 앤터니 리처드 호어
 * 시간복잡도 O(log n)
 * 임의의 pivot 값을 기준으로 pivot 의 좌측에는 pivot 보다 작은값을 두고 우측에는 pivot 보다 큰 값을 두고자 한다.
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr, resultArr;
		System.out.println("Sort Algorithm: Quick Sort");
		arr = new int[] {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		print(arr);
		resultArr = sort(arr, 0, arr.length-1);
		print(resultArr);
	}
	
	public static int[] sort(int[] arr, int s, int e) {
		if(s < e) {
			int q = partition(arr, s, e);
			sort(arr, s, q-1);
			sort(arr, q+1, e);
		}
		return arr;
	}
	
	public static int partition(int[] arr, int s, int e) {
		int pivot = arr[s];
		int i = s+1;
		int j = e;
		
		// i와 j가 교차할 때까지 반복(i<j)
		while (i <= j) {
			// arr[i]가 피벗보다 작으면 계속 i를 증가
			while (i <= e && arr[i] < pivot) {
				i++;
			}

			// arr[j]가 피벗보다 크면 계속 j를 감소
			while (j >= s && arr[j] > pivot) {
				j--;
			}
			
			if (i < j) { // 엇갈리지 않았다면 i와 j 번째 요소 교체
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				System.out.print("(" + i + "," + j + ")");
				print(arr);
			}
		}
		
		// 현재 엇갈린 상태이면 피벗과 교체
		int t = arr[j];
		arr[j] = arr[s];
		arr[s] = t;
		print(arr);
		
		return j;
	}
	
	public static void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
