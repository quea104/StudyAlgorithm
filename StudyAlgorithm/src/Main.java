//import Recursion.BasicConcept;
//import Recursion.Maze;
//import Recursion.CountingCellsBlob;
//import Recursion.NQueen;

//import DataStructure.Stack;
//import DataStructure.Queue;

//import SortAlgorithm.BubbleSort;
//import SortAlgorithm.SelectionSort;
//import SortAlgorithm.InsertionSort;
//import SortAlgorithm.MergeSort;
//import SortAlgorithm.QuickSort;

//import TestKakao.NewId;
//import TestKakao.NQueen;

//import TestBackJoon.MinMax;
//import TestBackJoon.MaxIndex;
//import TestBackJoon.CountNumber;
//import TestBackJoon.Remainder;
//import TestBackJoon.Average;
//import TestBackJoon.QuizOX;
//import TestBackJoon.OverAverage;
//import TestBackJoon.SelfNumber;
//import TestBackJoon.ContinueNumber;
//import TestBackJoon.ASCIICode;
//import TestBackJoon.SearchAlphabet;
//import TestBackJoon.RepeatAlphabet;
//import TestBackJoon.StudyWord;
//import TestBackJoon.CountWord;
//import TestBackJoon.ReverseConstant;
//import TestBackJoon.Dial;
//import TestBackJoon.CroatiaAlphabet;
//import TestBackJoon.GroupWord;
//import TestBackJoon.BreakEvenPoint;
//import TestBackJoon.Honeycomb;
//import TestBackJoon.SearchFraction;
//import TestBackJoon.UpPanic;
//import TestBackJoon.Hotel;
//import TestBackJoon.ViceChairman;
//import TestBackJoon.DeliverySugar;
//import TestBackJoon.T0330BigAdd;
//import TestBackJoon.T0331Spacecrapft;
//import TestBackJoon.T0331SearchPrimeNumber;
//import TestBackJoon.T0331PrimeNumber;
//import TestBackJoon.T0401PrimeFactorization;
//import TestBackJoon.T0401SolvePrimeNumber;
//import TestBackJoon.T0401BertrandPostulate;
//import TestBackJoon.T0401GoldbachConjecture;
//import TestBackJoon.T0402EscapeFromSquare;
//import TestBackJoon.T0402FourthDot;
//import TestBackJoon.T0402RightTriangle;
import TestBackJoon.T0402TaxicaGeometry;

import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException {
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
		
//		NQueen cNQueen = new NQueen(10);
//		System.out.println(cNQueen.queens(0));
		
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

//		int[] arr, resultArr;
		
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
		
//		MinMax cMinMax = new MinMax();
//		cMinMax.solution();
		
//		MaxIndex cMaxIndex = new MaxIndex();
//		cMaxIndex.solution();
		
//		CountNumber cCountNumber = new CountNumber();
//		cCountNumber.solution();
		
//		Remainder cRemainder = new Remainder();
//		cRemainder.solution();
		
//		Average cAverage = new Average();
//		cAverage.solution();
		
//		QuizOX cQuizOX = new QuizOX();
//		cQuizOX.solution();
		
//		OverAverage cOverAverage = new OverAverage();
//		cOverAverage.solution();
		
//		SelfNumber cSelfNumber = new SelfNumber();
//		cSelfNumber.solution();
		
//		ContinueNumber cContinueNumber = new ContinueNumber();
//		cContinueNumber.solution();

//		ASCIICode cASCIICode = new ASCIICode();
//		cASCIICode.solution();
		
//		SearchAlphabet cSearchAlphabet = new SearchAlphabet();
//		cSearchAlphabet.solution();
		
//		RepeatAlphabet cRepeateAlphabet = new RepeatAlphabet();
//		cRepeateAlphabet.solution();
		
//		StudyWord cStudyWord = new StudyWord();
//		cStudyWord.solution();
		
//		CountWord cCountWord = new CountWord();
//		cCountWord.solution();
		
//		ReverseConstant cReverseConstant = new ReverseConstant();
//		cReverseConstant.solution();
		
//		Dial cDial = new Dial();
//		cDial.solution();
		
//		CroatiaAlphabet cCroatiaAlphabet = new CroatiaAlphabet();
//		cCroatiaAlphabet.solution();
		
//		GroupWord cGroupWord = new GroupWord();
//		cGroupWord.solution();
		
//		BreakEvenPoint cBreakEvenPoint = new BreakEvenPoint();
//		cBreakEvenPoint.solution();
		
//		Honeycomb cHoneycomb = new Honeycomb();
//		cHoneycomb.solution();
		
//		SearchFraction cSearchFraction = new SearchFraction();
//		cSearchFraction.solution();
		
//		UpPanic cUpPanic = new UpPanic();
//		cUpPanic.solution();
		
//		Hotel cHotel = new Hotel();
//		cHotel.solution();
		
//		ViceChairman cViceChairman = new ViceChairman();
//		cViceChairman.solution();
		
//		DeliverySugar cDeliverySugar = new DeliverySugar();
//		cDeliverySugar.solution();
		
//		T0330BigAdd cBigAdd = new T0330BigAdd();
//		cBigAdd.solution();
		
//		T0331Spacecrapft cSpacecrapft = new T0331Spacecrapft();
//		cSpacecrapft.solution();
		
//		T0331SearchPrimeNumber cSearchPrimeNumber = new T0331SearchPrimeNumber();
//		cSearchPrimeNumber.solution();
		
//		T0331PrimeNumber cPrimeNumber = new T0331PrimeNumber();
//		cPrimeNumber.solution();
		
//		T0401PrimeFactorization cPrimeFactorization = new T0401PrimeFactorization();
//		cPrimeFactorization.solution();
		
//		T0401SolvePrimeNumber cSolvePrimeNumber = new T0401SolvePrimeNumber();
//		cSolvePrimeNumber.solution();
		
//		T0401BertrandPostulate cBertrandPostulate = new T0401BertrandPostulate();
//		cBertrandPostulate.solution();
		
//		T0401GoldbachConjecture cGoldbachConjecture = new T0401GoldbachConjecture();
//		cGoldbachConjecture.solution();
		
//		T0402EscapeFromSquare cSquare = new T0402EscapeFromSquare();
//		cSquare.solution();
		
//		T0402FourthDot cFourthDot = new T0402FourthDot();
//		cFourthDot.solution();
		
//		T0402RightTriangle cRightTriangle = new T0402RightTriangle();
//		cRightTriangle.solution();
		
		T0402TaxicaGeometry cTaxicaGeometry = new T0402TaxicaGeometry();
		cTaxicaGeometry.solution();
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