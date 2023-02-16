package TestProgrammers;

/*
 * ������: �ּ�, �ִ�
 * ����: 21.03.24.��
 * ��������:
	N���� ����Ʈ�� �Ϸķ� �� �þ �ֽ��ϴ�. �� �߿��� �Ϻ� ����Ʈ ���󿡴� 4g �������� ��ġ�Ǿ� �ֽ��ϴ�. ����� ������ 5g ���䰡 ������ 4g �������� 5g ���������� �ٲٷ� �մϴ�. �׷��� 5g �������� 4g ���������� ���� ������ ����, 4g �������� 5g ���������� �ٲٸ� � ����Ʈ���� ���İ� �������� �ʽ��ϴ�.
	
	���� ��� 11���� ����Ʈ�� �� �þ �ְ�, [4, 11] ��° ����Ʈ ���󿡴� 4g �������� ��ġ�Ǿ� �ֽ��ϴ�. ���� �� 4g �������� ���� ���� �Ÿ��� 1�� 5g ���������� �ٲ� ��� ��� ����Ʈ�� ���ĸ� ������ �� �����ϴ�. (������ ���� �Ÿ��� W�� ��, �������� ��ġ�� ����Ʈ�� �������� ���ĸ� �������� W��ŭ ������ �� �ֽ��ϴ�.)
	
	�ʱ⿡, 1, 2, 6, 7, 8, 9��° ����Ʈ���� ���İ� ���޵��� �ʽ��ϴ�.
	
	1, 7, 9��° ����Ʈ ���� �������� ��ġ�� ���, ��� ����Ʈ�� ���ĸ� ������ �� �ֽ��ϴ�.
	
	�� ���� ����Ʈ ���� �������� ��ġ�ϸ� ��� ����Ʈ�� ���ĸ� ������ �� �ֽ��ϴ�.
	
	�̶�, �츮�� 5g �������� �ּҷ� ��ġ�ϸ鼭 ��� ����Ʈ�� ���ĸ� �����Ϸ��� �մϴ�. ���� ���ÿ��� �ּ� 3���� ����Ʈ ���� �������� ��ġ�ؾ� ��� ����Ʈ�� ���ĸ� ������ �� �ֽ��ϴ�.
	
	����Ʈ�� ���� N, ���� �������� ��ġ�� ����Ʈ�� ��ȣ�� ��� 1���� �迭 stations, ������ ���� �Ÿ� W�� �Ű������� �־��� ��, ��� ����Ʈ�� ���ĸ� �����ϱ� ���� �����ؾ� �� ������ ������ �ּڰ��� �����ϴ� solution �Լ��� �ϼ����ּ���
	
 * ���ѻ���
	N: 200,000,000 ������ �ڿ���
	stations�� ũ��: 10,000 ������ �ڿ���
	stations�� ������������ ���ĵǾ� �ְ�, �迭�� ��� ���� N���� ���ų� ���� �ڿ����Դϴ�.
	W: 10,000 ������ �ڿ���

 * �����:
	N	stations	W	answer
	11	[4, 11]	1	3
	16	[9]	2	3
 */


import java.util.*;

public class D230210Step1_1 {

	public static void main(String[] args) {
		System.out.println(solution1(16, new int[]{9}, 2));
		System.out.println(solution2(16, new int[]{9}, 2));
		System.out.println(solution3(16, new int[]{9}, 2));
	}
	
	// ��� 3 - ������ �˰���
	static int solution3(int n, int[] stations, int w) {
		int answer = 0;
		int position = 1;
		int sIndex = 0;
		
		while(position <= n) {
			if(sIndex < stations.length && stations[sIndex] - w <= position) {
				position = stations[sIndex] + w;
				sIndex++;
			}
			else {
				position = position + w + w;
				answer++;
			}			
			position++;
		}		
		
		return answer;
	}
	
	// ��� 2 - Queue, while - ���������� Queue�� ����ؼ� ����� ���� �ɸ�, Reference Type(Queue) ��� Primitive Type�� ����ϸ� ���� �ӵ��� �������� ��� �ӵ��� ������
	static int solution2(int n, int[] stations, int w) {
		int answer = 0;
		int position = 1;
		
		Queue<Integer> sq = new LinkedList<>();
		for(int s:stations) sq.offer(s);
		
		while(position <= n) {
			// ������ ���� ������ Ȯ�� - ���� ��ġ�� �������� �̹� ��ġ�� ��ġ�� ���� ������ �� ���� �����̸� �̹� ��ġ�� ������ ���� ����
			if(!sq.isEmpty() && sq.peek() - w <= position) {
				// ������ ������ ����� ��ġ�� �̵�
				position = sq.poll() + w;
			}
			else {
				position = position + w + w;
				answer++;
			}
			position++;			
		}
		
		
		return answer;
	}
	
	// ��� 1 - �迭 (��ȿ���� - ���� Ǯ��)
	static int solution1(int n, int[] stations, int w) {
        int answer = 0;
        int[] map = new int[n+1];
        int sIndex = 0;
        
    	for(int i = 0; i < stations.length; i++) {
    		map = build(map, stations[i], w);
        }

        for(int i = 1; i <= n; i++) {        	
        	if(sIndex < stations.length && stations[sIndex] - w <= i) {
        		i = stations[sIndex]+w;
        		sIndex++;
        		continue;
        	}

        	int next = i + w;
    		map = build(map, next, w);
    		answer++;
    		i = next+w;
        }

        return answer;
    }	
	static int[] build(int[] map, int s, int w) {
		for(int i = s-w; i <= s+w; i++) {
			if(i >= 1 && i < map.length)
				map[i]++;
        }		
		return map;
	}
}
