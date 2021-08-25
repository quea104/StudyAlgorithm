package SortAlgorithm;

/*
 * ��������
 * �ð����⵵ O(n^2) - for�� �ι�
 * �������⵵ O(n) - �迭 �� ���� ���
 * ���� ������ �� ���Ҹ� �˻��Ͽ� �����ϴ� �˰���
 * ���������� �ð����⵵�� ���� �ʾ� ���� ��� ����.
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr, resultArr;
		System.out.println("Sort Algorithm: Bubble Sort");
		arr = new int[] {10, 8, 2, 5, 6, 4};
		print(arr);
		resultArr = sort(arr);
		print(resultArr);
	}
	
	public static int[] sort(int arr[]) {
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
	
	public static void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}