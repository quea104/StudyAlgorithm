package TestProgrammers;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
 * ������: �Ű� ��� �ޱ�
 * ����: 22.08.23.ȭ
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 * ���� ����
���Ի�� ������ �Խ��� �ҷ� �̿��ڸ� �Ű��ϰ� ó�� ����� ���Ϸ� �߼��ϴ� �ý����� �����Ϸ� �մϴ�. ������ �����Ϸ��� �ý����� ������ �����ϴ�.

�� ������ �� ���� �� ���� ������ �Ű��� �� �ֽ��ϴ�.
�Ű� Ƚ���� ������ �����ϴ�. ���� �ٸ� ������ ����ؼ� �Ű��� �� �ֽ��ϴ�.
�� ������ ���� �� �Ű��� ���� ������, ������ ������ ���� �Ű� Ƚ���� 1ȸ�� ó���˴ϴ�.
k�� �̻� �Ű�� ������ �Խ��� �̿��� �����Ǹ�, �ش� ������ �Ű��� ��� �������� ���� ����� ���Ϸ� �߼��մϴ�.
������ �Ű��� ��� ������ �����Ͽ� �������� �Ѳ����� �Խ��� �̿� ������ ��Ű�鼭 ���� ������ �߼��մϴ�.
������ ��ü ���� ����� ["muzi", "frodo", "apeach", "neo"]�̰�, k = 2(��, 2�� �̻� �Ű���ϸ� �̿� ����)�� ����� �����Դϴ�.

���� ID	������ �Ű��� ID	����
"muzi"	"frodo"	"muzi"�� "frodo"�� �Ű��߽��ϴ�.
"apeach"	"frodo"	"apeach"�� "frodo"�� �Ű��߽��ϴ�.
"frodo"	"neo"	"frodo"�� "neo"�� �Ű��߽��ϴ�.
"muzi"	"neo"	"muzi"�� "neo"�� �Ű��߽��ϴ�.
"apeach"	"muzi"	"apeach"�� "muzi"�� �Ű��߽��ϴ�.
�� �������� �Ű���� Ƚ���� ������ �����ϴ�.

���� ID	�Ű���� Ƚ��
"muzi"	1
"frodo"	2
"apeach"	0
"neo"	2
�� ���ÿ����� 2�� �̻� �Ű���� "frodo"�� "neo"�� �Խ��� �̿��� �����˴ϴ�. �̶�, �� �������� �Ű��� ���̵�� ������ ���̵� �����ϸ� ������ �����ϴ�.

���� ID	������ �Ű��� ID	������ ID
"muzi"	["frodo", "neo"]	["frodo", "neo"]
"frodo"	["neo"]	["neo"]
"apeach"	["muzi", "frodo"]	["frodo"]
"neo"	����	����
���� "muzi"�� ó�� ��� ������ 2ȸ, "frodo"�� "apeach"�� ���� ó�� ��� ������ 1ȸ �ް� �˴ϴ�.

�̿����� ID�� ��� ���ڿ� �迭 id_list, �� �̿��ڰ� �Ű��� �̿����� ID ������ ��� ���ڿ� �迭 report, ���� ������ �Ǵ� �Ű� Ƚ�� k�� �Ű������� �־��� ��, �� �������� ó�� ��� ������ ���� Ƚ���� �迭�� ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.

���ѻ���
2 �� id_list�� ���� �� 1,000
1 �� id_list�� ���� ���� �� 10
id_list�� ���Ҵ� �̿����� id�� ��Ÿ���� ���ڿ��̸� ���ĺ� �ҹ��ڷθ� �̷���� �ֽ��ϴ�.
id_list���� ���� ���̵� �ߺ��ؼ� ������� �ʽ��ϴ�.
1 �� report�� ���� �� 200,000
3 �� report�� ���� ���� �� 21
report�� ���Ҵ� "�̿���id �Ű���id"������ ���ڿ��Դϴ�.
���� ��� "muzi frodo"�� ��� "muzi"�� "frodo"�� �Ű��ߴٴ� �ǹ��Դϴ�.
id�� ���ĺ� �ҹ��ڷθ� �̷���� �ֽ��ϴ�.
�̿���id�� �Ű���id�� ����(�����̽�)�ϳ��� ���еǾ� �ֽ��ϴ�.
�ڱ� �ڽ��� �Ű��ϴ� ���� �����ϴ�.
1 �� k �� 200, k�� �ڿ����Դϴ�.
return �ϴ� �迭�� id_list�� ��� id ������� �� ������ ���� ��� ���� ���� ������ �˴ϴ�.
����� ��
id_list	report	k	result
["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
["con", "ryan"]	["ryan con", "ryan con", "ryan con", "ryan con"]	3	[0,0]
����� �� ����
����� �� #1

������ ���ÿ� �����ϴ�.

����� �� #2

"ryan"�� "con"�� 4�� �Ű�������, �־��� ���ǿ� ���� �� ������ ���� ������ ���� �� �Ű��� ���� �Ű� Ƚ�� 1ȸ�� ó���մϴ�. ���� "con"�� 1ȸ �Ű���߽��ϴ�. 3�� �̻� �Ű���� �̿��ڴ� ������, "con"�� "ryan"�� ��� ������ ���� �ʽ��ϴ�. ���� [0, 0]�� return �մϴ�.
 */

public class D220823level1_92334_re_re {
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"}; // ����� ID ���
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}; // �Ű� ���� ���
		int k = 2;
		
		// ������ ����ȭ
		int[] answer = new int[id_list.length]; // �� �����ID���� �Ű� ��� ���� ���� Ƚ��
		Hashtable<String, HashSet<String>> reportList = new Hashtable<String, HashSet<String>>(); // �����ID�� �Ű��� ID ���
		Hashtable<String, HashSet<String>> reportedList = new Hashtable<String, HashSet<String>>(); // �����ID�� �Ű��� ID ���
		for(int i = 0; i < id_list.length; i++) {
			reportList.put(id_list[i], new HashSet<String>());
			reportedList.put(id_list[i], new HashSet<String>());
		}

		// ������ ó��
		for(int i = 0; i < report.length; i++) {
			StringTokenizer st = new StringTokenizer(report[i]);
			String id = st.nextToken(); // �����ID
			String target = st.nextToken(); // �����ID�� �Ű��� ID
			
			if(reportList.containsKey(id)) {
				HashSet<String> list = reportList.get(id);
				list.add(target);
				reportList.put(id, list);
			}
			if(reportedList.containsKey(target)) {
				HashSet<String> list = reportedList.get(target);
				list.add(id);
				reportedList.put(target, list);
			}
		}

		Hashtable<String, Boolean> stop_list = new Hashtable<String, Boolean>(); // �����ID�� ���� ���� ���
		for(int i = 0; i < id_list.length; i++) {
			int count = reportedList.get(id_list[i]).size();			
			stop_list.put(id_list[i], (count >= k ? true : false));
		}
		
		for(int i = 0; i < id_list.length; i++) {
			if(reportList.containsKey(id_list[i])) {
				HashSet<String> list = reportList.get(id_list[i]);
				Iterator<String> it = list.iterator();
				while(it.hasNext()) {
					String id = it.next();
					if(stop_list.get(id)) {
						answer[i]++;
					}
				}
			}
		}

		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
