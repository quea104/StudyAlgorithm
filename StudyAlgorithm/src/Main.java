//import packRecursion.BasicConcept;
//import packRecursion.Maze;
//import packRecursion.CountingCellsBlob;
import packRecursion.NQueen;

//import packDataStructure.Stack;
//import packDataStructure.Queue;

//import packSortAlgorithm.BubbleSort;
//import packSortAlgorithm.SelectionSort;
//import packSortAlgorithm.InsertionSort;
//import packSortAlgorithm.MergeSort;
//import packSortAlgorithm.QuickSort;

//import packStudyAlgorithm.NewId;
//import packStudyAlgorithm.NQueen;

public class Main {
	public static void main(String[] args) {
//		BasicConcept cBasicConcept = new BasicConcept();
//		int m = 24, n = 36;
//		System.out.println("gcd: " + cBasicConcept.gcd(m, n));
//		System.out.println("gcdSimple: " + cBasicConcept.gcdSimple(m, n));
//		System.out.println("lcm: " + cBasicConcept.lcm(m, n));

//		cBasicConcept.printChars("Cooling Work");
//		cBasicConcept.printCharsReverse("Cooling Work");
		
//		int[] data = cBasicConcept.readFrom(5, new int[] {1,2,3,4,5}, new java.util.Scanner(System.in));
//		print(data);
		
//		System.out.println(cBasicConcept.findMax(new int[] {1,2,10,4,5}, 0, 4));
		
//		Maze cMaze = new Maze();
//		int[][] maze = {
//				{0,0,0,0,0,0,0,1},
//				{0,1,1,0,1,1,0,1},
//				{0,0,0,1,0,0,0,1},
//				{0,1,0,0,1,1,0,0},
//				{0,1,1,1,0,0,1,1},
//				{0,1,0,0,0,1,0,1},
//				{0,0,0,1,0,0,0,1},
//				{0,1,1,1,0,1,0,0}
//		};
//		System.out.println(cMaze.findPath(maze, 0, 0));
//		printMap(maze);
		
//		CountingCellsBlob cCountingCellsBlob = new CountingCellsBlob();
//		int[][] grid = {
//				{1,0,0,0,0,0,0,1},
//				{0,1,1,0,0,1,0,0},
//				{1,1,0,0,1,0,1,0},
//				{0,0,0,0,0,1,0,0},
//				{0,1,0,1,0,1,0,0},
//				{0,1,0,1,0,1,0,0},
//				{1,0,0,0,1,0,0,1},
//				{0,1,1,0,0,1,1,1}
//		};
//		System.out.println(cCountingCellsBlob.countBlob(grid, 3, 5));
//		printMap(grid);
		
		NQueen cNQueen = new NQueen(8);
		System.out.println(cNQueen.queens(0));
		
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
		
//		System.out.println("Sort Algorithm: Quick Sort");
//		arr = new int[] {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
//		QuickSort cQuickSort = new QuickSort();
//		cQuickSort.print(arr);
//		resultArr = cQuickSort.sort(arr, 0, arr.length-1);
//		cQuickSort.print(resultArr);
		
//		NewId classNewId = new NewId();
//		String answerNewId = classNewId.solution(".1.");
//		System.out.println("Answer:"+answerNewId);
		
//		NQueen classNQueen = new NQueen();
//		int answerNQueen = classNQueen.solution(3);
//		System.out.println("Answer:"+answerNQueen);
	}
	
	public static void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void printMap(int maze[][]) {
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze.length; j++) {
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}