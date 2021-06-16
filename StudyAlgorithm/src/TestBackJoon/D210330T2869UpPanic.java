package TestBackJoon;
/*
 * 문제명: 달팽이는 올라가고 싶다
 * 일자: 21.03.30.화
 * https://www.acmicpc.net/problem/2869
 * 문제내용:
 		땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
		달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
		달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)
 * 출력: 첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
 * 풀이:
 		(a-b)*day = v-b
 		day = (v-b) / (a-b)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
public class D210330T2869UpPanic {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int day = 0;
//		while(v > 0) {
//			day++;
//			v -= a;
//			if(v <= 0)
//				break;
//			v += b;
//		}
		day = (v-b)/(a-b);
		if((v-b)%(a-b) > 0)
			day++;
		bw.write(Integer.toString(day));
		bw.flush();
		bw.close();
	}
}