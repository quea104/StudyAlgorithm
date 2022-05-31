package TestProgrammers;

/*
 * ������: �� �ʰ�
 * ����: 22.05.30.��
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 * ����: ArrayList�� ����ϸ� �ð��ʰ� �߻��ϹǷ� Heap�� ����ؾ� ��.
 * ���� ����
�ſ� ���� �����ϴ� Leo�� ��� ������ ���ں� ������ K �̻����� ����� �ͽ��ϴ�. ��� ������ ���ں� ������ K �̻����� ����� ���� Leo�� ���ں� ������ ���� ���� �� ���� ������ �Ʒ��� ���� Ư���� ������� ���� ���ο� ������ ����ϴ�.

���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
Leo�� ��� ������ ���ں� ������ K �̻��� �� ������ �ݺ��Ͽ� �����ϴ�.
Leo�� ���� ������ ���ں� ������ ���� �迭 scoville�� ���ϴ� ���ں� ���� K�� �־��� ��, ��� ������ ���ں� ������ K �̻����� ����� ���� ����� �ϴ� �ּ� Ƚ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
scoville�� ���̴� 2 �̻� 1,000,000 �����Դϴ�.
K�� 0 �̻� 1,000,000,000 �����Դϴ�.
scoville�� ���Ҵ� ���� 0 �̻� 1,000,000 �����Դϴ�.
��� ������ ���ں� ������ K �̻����� ���� �� ���� ��쿡�� -1�� return �մϴ�.
����� ��
scoville	K	return
[1, 2, 3, 9, 10, 12]	7	2
����� �� ����
���ں� ������ 1�� ���İ� 2�� ������ ������ ������ ���ں� ������ �Ʒ��� ���� �˴ϴ�.
���ο� ������ ���ں� ���� = 1 + (2 * 2) = 5
���� ������ ���ں� ���� = [5, 3, 9, 10, 12]

���ں� ������ 3�� ���İ� 5�� ������ ������ ������ ���ں� ������ �Ʒ��� ���� �˴ϴ�.
���ο� ������ ���ں� ���� = 3 + (5 * 2) = 13
���� ������ ���ں� ���� = [13, 9, 10, 12]

��� ������ ���ں� ������ 7 �̻��� �Ǿ��� �̶� ���� Ƚ���� 2ȸ�Դϴ�.
 */

import java.util.*;

public class D220530level2_42626 {
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		int answer = 0;

		// �ڹٿ����� PriorityQueue (�켱���� ť)�� �־����� �ڵ����� �ּ� ������ ���������.
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		for(int num: scoville) {
			heap.offer(num);
		}
		
		
		while(heap.peek() < K) {
			try {
				// ���� �ִ� ������ ������� poll()�� �ϸ� �ּڰ��� ������� ���´�.
				int mixFood = heap.poll() + heap.poll()*2;
				heap.offer(mixFood);
				answer++;
				
				if(heap.peek() >= K) break;
				
				// �� ����� 1�� ��µ� ���ں��� K���� ������ �� �̻� ���� �� �����Ƿ� answer = -1�� �Ѵ�.
				if(heap.size() == 1 && heap.peek() < K) {
					answer = -1;
					break;
				}
			}
			catch(Exception e) {
				answer = -1;
			}
		}
		

        System.out.print(answer);
	}

	/*
	ArrayList ���
	static int limit;
	static int answer = 0;
	static ArrayList<Integer> scovilleList = new ArrayList<Integer>();
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		limit = 7;
		for(int num: scoville) {
			scovilleList.add(num);
		}
		
		make();

        System.out.print(answer);
	}
	
	static void make() {
		if(check()) {
			return;
		}

		Collections.sort(scovilleList);
		
		mix(scovilleList.get(0), scovilleList.get(1));
		
		scovilleList.remove(0);
		scovilleList.remove(1);
		
		answer++;
		
		make();
	}
	
	static boolean check() {
		for(int i = 0; i < scovilleList.size(); i++) {
			if(scovilleList.get(i) <= limit) {
				return false;
			}
		}
		return true;
	}
	
	static int mix(int min, int secondMin) {
		return min + (secondMin*2);
	}
	*/

}
