package SortAlgorithm;

/*
 * �պ�����
 * �ð����⵵ O(log n)
 * ���� �� ���̸�(John von Neumann)�� ����
 * ������ �ɰ������� ������ ���� ����Ʈ�� ����Ͽ� ������ ���� �� �� ����Ʈ������ ���� �� ����(merge) ���� �� �����ϴ� ���� => ���� ����(divide and conquer) �˰����� �ϳ�
 * ���� ���� ���
 * ����(Divide): �Է� �迭�� ���� ũ���� 2���� �κ� �迭�� ���� 
 * -> ����(Conquer): �κ� �迭�� ����. �κ� �迭�� ũ�Ⱑ ����� ���� ������ ��ȯ ȣ�� �� �̿��Ͽ� �ٽ� ���� ���� ����� ���� 
 * -> ����(Combine): ���ĵ� �κ� �迭���� �ϳ��� �迭�� �պ�
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