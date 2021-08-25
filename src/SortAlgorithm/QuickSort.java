package SortAlgorithm;

/*
 * �� ����
 * ���� ���ʹ� ��ó�� ȣ��
 * �ð����⵵ O(log n)
 * ������ pivot ���� �������� pivot �� �������� pivot ���� �������� �ΰ� �������� pivot ���� ū ���� �ΰ��� �Ѵ�.
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
		
		// i�� j�� ������ ������ �ݺ�(i<j)
		while (i <= j) {
			// arr[i]�� �ǹ����� ������ ��� i�� ����
			while (i <= e && arr[i] < pivot) {
				i++;
			}

			// arr[j]�� �ǹ����� ũ�� ��� j�� ����
			while (j >= s && arr[j] > pivot) {
				j--;
			}
			
			if (i < j) { // �������� �ʾҴٸ� i�� j ��° ��� ��ü
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				System.out.print("(" + i + "," + j + ")");
				print(arr);
			}
		}
		
		// ���� ������ �����̸� �ǹ��� ��ü
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
