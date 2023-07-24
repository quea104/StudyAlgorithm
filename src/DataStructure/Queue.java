package DataStructure;

/*
 * 선형자료구조
 * 랜덤 접근 불가능
 * 선입선출
 */
class LinkedList {
	private int value;
	private LinkedList next;
	public LinkedList(int value, LinkedList next) {
		this.value = value; 
		this.next = next;
	}
	public void setValue(int value) {
		this.value = value;		
	}
	public void setNext(LinkedList next) {
		this.next = next;		
	}
	public int getValue() {
		return this.value;
	}
	public LinkedList getNext() {
		return this.next;
	}
}

public class Queue {
	public static LinkedList front;
	public static LinkedList back;

	public static void main(String[] args) {
		System.out.println("\n\nData Structure: QUEUE");
		enqueue(10);
		enqueue(2);
		enqueue(8);
		enqueue(5);
		print();
		System.out.printf("OUT: %d %d %d %d", dequeue(), dequeue(), dequeue(), dequeue());
	}
	
	public static void enqueue(int n) {
		if(front == null) {
			front = new LinkedList(n, null);
			back = front;
		}
		else {
			back.setNext(new LinkedList(n, null));
			back = back.getNext();
		}
	}
	
	public static int dequeue() {
		int val = front.getValue();
		front = front.getNext();
		return val;
	}
	
	public static void print() {
		LinkedList pQueue = front;
		while(pQueue != null) {
			System.out.print(pQueue.getValue()+" ");
			pQueue = pQueue.getNext();
		}
		System.out.println();
	}
}