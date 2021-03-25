package TestBackJoon;

/*
 * 일자: 21.03.25.목
 * https://www.acmicpc.net/problem/4344
 * 문제명: 평균은 넘겠지
 * 문제내용: 
 		대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
 * 입력: 
 		첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
		둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
 * 출력: 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
 */

//import java.io.BufferedWriter;
//import java.io.OutputStreamWriter;
//import java.io.IOException;
public class SelfNumber {
	public void solution() // throws IOException 
	{
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = 10001;
		boolean[] numbers = new boolean[N];
		for(int i = 1; i < N; i++) {
			int num = d(i);
			if(num < N)
				numbers[num] = true;
		}
		
		for(int i = 1; i < N; i++) {
			if(!numbers[i])
				//bw.write(i + "\n");
				sb.append(i).append('\n');
		}
		System.out.print(sb);
		//bw.flush();
	}
	
	private int d(int num) {
		int sum = num;
		
		// 수로 계산
		while (num != 0) {
			sum += (num % 10);
			num = num / 10;
		}
		
		// 문자열로 계산
//		String strNum = Integer.toString(num);
//		for(int i = 0; i < strNum.length(); i++) {
//			sum += Integer.parseInt(strNum.substring(i, i+1));
//		}
		return sum;
	}
}
