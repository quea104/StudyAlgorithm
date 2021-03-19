//import packDataStructure.Stack;
//import packDataStructure.Queue;
//import packStudyAlgorithm.NewId;
//import packStudyAlgorithm.NQueen;
//import packSortAlgorithm.BubbleSort;
//import packSortAlgorithm.SelectionSort;
//import packSortAlgorithm.InsertionSort;
//import packSortAlgorithm.MergeSort;
import packSortAlgorithm.QuickSort;

public class Main {
	public static void main(String[] args) {
//		System.out.println("Data Structure: STACK");
//		Stack cStack = new Stack();
//		cStack.push(10);
//		cStack.push(2);
//		cStack.push(8);
//		cStack.push(5);
//		cStack.print();
//		System.out.printf("OUT: %d %d %d %d", cStack.pop(), cStack.pop(), cStack.pop(), cStack.pop());

//		System.out.println("\n\nData Structure: QUEUE");
//		Queue cQueue = new Queue();
//		cQueue.enqueue(10);
//		cQueue.enqueue(2);
//		cQueue.enqueue(8);
//		cQueue.enqueue(5);
//		cQueue.print();
//		System.out.printf("OUT: %d %d %d %d", cQueue.dequeue(), cQueue.dequeue(), cQueue.dequeue(), cQueue.dequeue());

		int[] arr, resultArr;
		
//		System.out.println("Sort Algorithm: Bubble Sort");
//		BubbleSort cBubbleSort = new BubbleSort();
//		arr = new int[] {10, 8, 2, 5, 6, 4};
//		cBubbleSort.print(arr);
//		resultArr = cBubbleSort.sort(arr);
//		cBubbleSort.print(resultArr);
//
//		System.out.println("Sort Algorithm: Selection Sort");
//		arr = new int[] {10, 8, 2, 5, 6, 4};
//		SelectionSort cSelectionSort = new SelectionSort();
//		cSelectionSort.print(arr);
//		resultArr = cSelectionSort.sort(arr);
//		cSelectionSort.print(resultArr);
//		
//		System.out.println("Sort Algorithm: Insertion Sort");
//		arr = new int[] {10, 8, 2, 5, 6, 4};
//		InsertionSort cInsertionSort = new InsertionSort();
//		cInsertionSort.print(arr);
//		resultArr = cInsertionSort.sort(arr);
//		cInsertionSort.print(resultArr);
		
//		System.out.println("Sort Algorithm: Merge Sort");
//		arr = new int[] {10, 8, 2, 5, 6, 4};
//		MergeSort cMergeSort = new MergeSort(arr.length);
//		cMergeSort.print(arr);
//		resultArr = cMergeSort.sort(arr, 0, arr.length-1);
//		cMergeSort.print(resultArr);
		
		System.out.println("Sort Algorithm: Quick Sort");
		arr = new int[] {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		QuickSort cQuickSort = new QuickSort();
		cQuickSort.print(arr);
		resultArr = cQuickSort.sort(arr, 0, arr.length-1);
		cQuickSort.print(resultArr);
		
//		NewId classNewId = new NewId();
//		String answerNewId = classNewId.solution(".1.");
//		System.out.println("Answer:"+answerNewId);
		
//		NQueen classNQueen = new NQueen();
//		int answerNQueen = classNQueen.solution(3);
//		System.out.println("Answer:"+answerNQueen);
	}
}