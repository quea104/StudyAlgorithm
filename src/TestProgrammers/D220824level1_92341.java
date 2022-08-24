

package TestProgrammers;

/*
 * ������: ���� ��� ���
 * ����: 22.08.23.ȭ-24.��
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */

import java.util.*;
import java.time.*;

class Record {
	LocalTime inTime; // IN �ð�
	LocalTime outTime; // OUT �ð�
	int minute = 0; // ���� ���� �ð�

	protected void setInTime(LocalTime inTime) {
		this.inTime = inTime;
		this.outTime = null;
	}
	
	protected LocalTime getInTime() {
		return inTime;
	}

	protected void setOutTime(LocalTime outTime) {
		this.outTime = outTime;
		
		setMinute();
	}

	protected LocalTime getOutTime() {
		return outTime;
	}

	protected void setMinute() {
		// ���� �ð� ���
		long second = Duration.between(this.inTime, this.outTime).getSeconds();
		int minute = (int)second/60;
		
		this.minute += minute;
	}

	protected int getMinute() {
		return minute;
	}
}

public class D220824level1_92341 {	
	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600}; // ���ǥ: �⺻ �ð�(��), �⺻ ���(��), ���� �ð�(��), ���� ���(��)
		// ��/���� ���: �ð�(��:��)	���� ��ȣ	����
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int[] answer = {};
		
		Hashtable<String, Record> recordTable = new Hashtable<String, Record> ();
		
		StringTokenizer st;
		for(String strRecord: records) {
			st = new StringTokenizer(strRecord);
			String time = st.nextToken();
			String number = st.nextToken();
			String action = st.nextToken();
			
			if(!recordTable.containsKey(number)) {
				recordTable.put(number, new Record());
			}

			Record record = recordTable.get(number);
			if(action.equals("IN")) {
				record.setInTime(LocalTime.parse(time));
			}
			else { // OUT
				record.setOutTime(LocalTime.parse(time));
			}

			recordTable.put(number, record);
		}
		
		List<String> numberList = new ArrayList<String>(recordTable.keySet());
		numberList.sort(String::compareTo);		

		int index = 0;
		answer = new int[recordTable.size()];
		for(String number: numberList) {
			Record record = recordTable.get(number);
			
			// �������� ������ ���� �ð�(23:59)���� ����
			if(record.getOutTime() == null) {
				record.setOutTime(LocalTime.of(23, 59));
			}

			// ���� ��� ���
			int price = fees[1];
			if(record.getMinute() > fees[0]) {
				price += (int)Math.ceil((record.getMinute() - (double)fees[0])/fees[2]) * fees[3];
			}
			
			answer[index++] = price;
		}

		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}	
}