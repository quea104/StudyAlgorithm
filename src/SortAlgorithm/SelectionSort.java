package SortAlgorithm;

/*
 * ��������
 * �ð����⵵ O(n^2)
 * �������İ� ����. �ѹ� ��ȸ�� �ϸ鼭 ���� ���� ���� ã�Ƽ� �� ��ġ�� ��ȯ.
 */
public class SelectionSort {
	public static void main(String[] args) {
		int[] arr, resultArr;
		System.out.println("Sort Algorithm: Selection Sort");
		arr = new int[] {10, 8, 2, 5, 6, 4};
		print(arr);
		resultArr = sort(arr);
		print(resultArr);
	}
	
	public static int[] sort(int arr[]) {
		int minIndex;
		for (int i = 0; i < arr.length; i++) {
			minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			int t = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = t;
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
