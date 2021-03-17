package packStudyAlgorithm;
import java.util.Scanner;

public class Make1_1463 {
	public static int[] D = new int[10000001]; // x의 연산을 사용하는 횟수의 최소값 저장하는 배열 변수
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt(); // 계산하려는 수
		System.out.println(go(N)); // N의 연산을 사용하는 횟수의 최소값
	}
	
	public static int go(int n){
		if(n == 1) return 0; // 1인 경우 연산 종료
		if(D[n] > 0) return D[n]; // n의 연산 회수값이 존재할 경우 해당 값 반환
		
		// ** 연산 시작 ** //
		D[n] = go(n-1)+1; // 1. 1  빼기
		if(n%3==0) { // 2. 3으로 나누어지는지 확인
			int tmp = go(n/3)+1; // 연산을 이미 한 번 수행하였기에 1을 더해줘야 함
			if(D[n] > tmp) D[n] = tmp;
		}
		if(n%2==0) { // 3. 2로 나누어지는지 확인
			int tmp = go(n/2)+1;
			if(D[n] > tmp) D[n] = tmp;
		}

		return D[n];
	}
}