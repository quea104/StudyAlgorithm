package DataStructure;

/*
 * 선형자료구조
 * 랜덤 접근 불가능
 * 후입선출
 */
public class Stack {
	static final int TOP_SIZE = 500;
	static int top = 0;
	static int[] arr = new int[TOP_SIZE];

	public static void main(String[] args) {
		System.out.println("Data Structure: STACK");
		push(10);
		push(2);
		push(8);
		push(5);
		print();
		System.out.printf("OUT: %d %d %d %d", pop(), pop(), pop(), pop());
	}

	public static int push(int n) {
		if(top >= TOP_SIZE) return -1;
		arr[top++] = n;
		return 0;
	}
	
	public static int pop() {
		if(top <= 0) return -1;
		return arr[--top];
	}
	
	public static void print() {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
