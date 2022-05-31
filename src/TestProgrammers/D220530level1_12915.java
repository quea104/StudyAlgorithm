package TestProgrammers;


/*
 * ������: ���ڿ� �� ������� �����ϱ�
 * ����: 22.05.30.��
 * https://programmers.co.kr/learn/courses/30/lessons/12915
 * ���� ����
���ڿ��� ������ ����Ʈ strings��, ���� n�� �־����� ��, �� ���ڿ��� �ε��� n��° ���ڸ� �������� �������� �����Ϸ� �մϴ�. ���� ��� strings�� ["sun", "bed", "car"]�̰� n�� 1�̸� �� �ܾ��� �ε��� 1�� ���� "u", "e", "a"�� strings�� �����մϴ�.

���� ����
strings�� ���� 1 �̻�, 50������ �迭�Դϴ�.
strings�� ���Ҵ� �ҹ��� ���ĺ����� �̷���� �ֽ��ϴ�.
strings�� ���Ҵ� ���� 1 �̻�, 100������ ���ڿ��Դϴ�.
��� strings�� ������ ���̴� n���� Ů�ϴ�.
�ε��� 1�� ���ڰ� ���� ���ڿ��� ���� �� ���, ���������� �ռ� ���ڿ��� ���ʿ� ��ġ�մϴ�.
����� ��
strings	n	return
["sun", "bed", "car"]	1	["car", "bed", "sun"]
["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
����� �� ����
����� �� 1
"sun", "bed", "car"�� 1��° �ε��� ���� ���� "u", "e", "a" �Դϴ�. �̸� �������� strings�� �����ϸ� ["car", "bed", "sun"] �Դϴ�.

����� �� 2
"abce"�� "abcd", "cdx"�� 2��° �ε��� ���� "c", "c", "x"�Դϴ�. ���� ���� �Ŀ��� "cdx"�� ���� �ڿ� ��ġ�մϴ�. "abce"�� "abcd"�� ���������� �����ϸ� "abcd"�� �켱�ϹǷ�, ���� ["abcd", "abce", "cdx"] �Դϴ�.
 */

import java.util.*;

public class D220530level1_12915 {
	public static void main(String[] args) {
        // Input
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 2;
		String[] answer = new String[strings.length];
		
		// 1�� Ǯ��
        Arrays.sort(strings);
        
		for (int i = 0; i < strings.length; i++) {
			answer[i] = strings[i].substring(n, n+1);
		}
		Arrays.sort(answer);
		
		List<String> list = new ArrayList<>(Arrays.asList(strings));
		for(int i = 0; i < answer.length; i++) {
			for(int j = 0; j < list.size(); j++) {
				if(list.get(j).substring(n, n+1).equals(answer[i])) {
					answer[i] = list.get(j);
					list.remove(list.get(j));
					break;
				}
			}
		}
        
        // Output
        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i].toString()+", ");
        }
        System.out.println();
        
		
		// 2�� Ǯ��
		ArrayList<String> list2 = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			list2.add(strings[i].charAt(n) + strings[i]);
        }
        
        Collections.sort(list2);
                
        for (int i = 0; i < list2.size(); i++) {
            answer[i] = list2.get(i).substring(1, list2.get(i).length());
        }
        
        // Output        
        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i].toString()+", ");
        }
	}
}
