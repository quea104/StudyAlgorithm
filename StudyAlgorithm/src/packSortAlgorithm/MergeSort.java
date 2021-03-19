package packSortAlgorithm;

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
	int[] sorted;
	
	public MergeSort (int maxSize) {
		sorted = new int[maxSize];
	}
	
	public int[] sort(int arr[], int s, int e)
	{
		int mid;
		if (s < e)
		{
			mid = (s + e) / 2; 
			
			sort(arr, s, mid);
			sort(arr, mid + 1, e);
			merge(arr, s, e);
		}
		print(sorted);
		return arr;
	}
	
	private void merge(int arr[], int s, int e)
	{
		int mid = (s + e) / 2;

		int i = s;
		int j = mid + 1;
		int k = s;
		while (i <= mid && j <= e)
		{
			if (arr[i] <= arr[j]) 
				sorted[k++] = arr[i++]; 
			else
				sorted[k++] = arr[j++];
		}

		int tmp = i>mid ? j : i;
		
		while(k<=e) 
			sorted[k++] = arr[tmp++];

		for (i=s;i<=e;i++) 
			arr[i] = sorted[i];
	}
	
	public void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}