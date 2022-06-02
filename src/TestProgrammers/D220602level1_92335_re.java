package TestProgrammers;

/*
 * ������: �Ű� ��� �ޱ� - ����
 * ����: 22.06.02.ȭ
 * https://programmers.co.kr/learn/courses/30/lessons/92334
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

���ѽð� �ȳ�
��Ȯ�� �׽�Ʈ : 10��
 */

import java.util.*;

public class D220602level1_92335_re {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"}; // ����� ���
		String[] report= {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}; // �Ű��� 
		int k = 2;
		
		int[] answer = new int[id_list.length];

		HashMap<String, Reports> users = new HashMap<String, Reports>(); // ����� �Ű� ���� ���
		
		for(String id: id_list) {
			users.put(id, new Reports());
		}
		
		for(String str: report) {
			StringTokenizer st = new StringTokenizer(str, " ");
			String id_report = st.nextToken(); // �Ű��� �����
			String id_reported = st.nextToken(); // �Ű���� �����
			
			users.get(id_report).reportList.add(id_reported);
			users.get(id_reported).reportedList.add(id_report);
		}
		
		for(String name:users.keySet()) {
			Reports reportInfo = users.get(name);
			Iterator<String> iter = reportInfo.reportList.iterator(); // ���� �Ű��� ����� ���
			while(iter.hasNext()) {
				String id_reported = iter.next();
				if(k <= users.get(id_reported).reportedList.size()) {
					reportInfo.increaseSendCount();
				}
			}
		}
		
		for(int i = 0; i < id_list.length; i++) {
			answer[i] = users.get(id_list[i]).sendCount;
		}

        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]+", ");
        }
	}
}

class Reports{
	int sendCount; // �Ű� ó�� ��� ���� ���� ���� ȸ��
	HashSet<String> reportList; // ����ڰ� �Ű��� �Ű��� ���
	HashSet<String> reportedList; // ����ڸ� �Ű��� �Ű��� ���
	
	protected Reports() {
		sendCount = 0;
		reportList = new HashSet<>();
		reportedList = new HashSet<>();
	}
	
	protected void increaseSendCount() {
		this.sendCount++;
	}
}