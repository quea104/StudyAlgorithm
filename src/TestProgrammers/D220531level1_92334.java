package TestProgrammers;

/*
 * ������: �Ű� ��� �ޱ�
 * ����: 22.05.31.ȭ
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

public class D220531level1_92334 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report= {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}; 
		int k = 2;
		
		int[] answer = {};

		HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		HashMap<String, Integer> sendMap = new HashMap<String, Integer>();
		for(String id: id_list) {
			map.put(id, new HashSet<String>());
			countMap.put(id, 0);
			sendMap.put(id, 0);
		}
		
		for(String str: report) {
			StringTokenizer st = new StringTokenizer(str, " ");
			String id = st.nextToken();
			HashSet<String> set = map.get(id);
			set.add(st.nextToken());
			map.put(id, set);
		}
		
		for(String key:map.keySet()) {
			HashSet<String> set = map.get(key);
			
			Iterator<String> iter = set.iterator();
			while(iter.hasNext()) {
				String id_report = iter.next();
				int count = countMap.get(id_report)+1;
				countMap.put(id_report, count);
			}
		}

		for(String id:map.keySet()) {
			HashSet<String> set = map.get(id);

			Iterator<String> iter = set.iterator();
			while(iter.hasNext()) {
				String id_report = iter.next();
				if(k >= countMap.get(id_report)) {
					int sendCount = sendMap.get(id) + 1;
					sendMap.put(id, sendCount);
				}
			}
		}

        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]+", ");
        }
	}
}
