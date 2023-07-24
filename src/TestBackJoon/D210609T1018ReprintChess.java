package TestBackJoon;

/*
 * 문제명: 체스판 다시 칠하기
 * 일자: 21.06.09.수~10.목
 * https://www.acmicpc.net/problem/1018
 * 문제내용:
 		지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 (y+8)*N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8*8 크기의 체스판으로 만들려고 한다.
		체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 
		하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.		
		보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8*8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.
 * 출력: 첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class D210609T1018ReprintChess {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] chess = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine(); 
			for(int j = 0; j < M; j++) {
				chess[i][j] = str.charAt(j);
			}
		}

		int count = 64;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i + 8 > N || j + 8 > M) {
					continue;
				}
				
				int temp = rePrint(chess, i, j);
				if(count > temp)
					count = temp;
			}
		}

		System.out.println(count);
	}
	
	public static int rePrint(char[][] chess, int x, int y) {
		int count = 0;
		char prevColor = chess[x][y];
		
//		System.out.println(x + "/" + y + ": " + prevColor);
//		for(int i = x; i < (x+8); i++) {
//			for(int j = y; j < (y+8); j++) {
//				System.out.print(chess[i][j]);
//			}
//			System.out.println();
//		}

//		for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if((i + j) % 2 == 0) {
//                    // 색깔이 같아야 하는 경우
//                    if(chess[i + x][j + y] != prevColor) {
//                		System.out.println((i + j) + "=>" + (i + x) + "/" +(j + y) + ": " + chess[i + x][j + y]);
//                    	count++;
//                    }
//                }
//                else {
//                    // 색깔이 달라야 하는 경우
//                    if(chess[i + x][j + y] == prevColor) {
//                		System.out.println((i + j) + "=>" + (i + x) + "/" +(j + y) + ": " + chess[i + x][j + y]);
//                    	count++;
//                    }
//                }
//            }
//        }
		
		int n = x+8; // 체스판 열의 마지막 열 값
		int m = y+8; // 체스판 행의 마지막 행 값
		for(int i = x; i < n; i++) {
			for(int j = y; j < m; j++) {
				if(i == x && j == y) { // i행, j열이 모두 첫번째 위치일 경우 건너띄기
					continue;
				}

				if(prevColor == chess[i][j]) {
            		//System.out.println((i + j) + "=>" + i + "/" + j + ": " + chess[i][j] + " | " + prevColor);
					count++;
					prevColor = (chess[i][j] == 'B' ? 'W' : 'B');
					//chess[i][j] = (chess[i][j] == 'B' ? 'W' : 'B');
				}
				else {
					prevColor = chess[i][j];					
				}
				
				if(j == m-1) { // i행이 두번째 이후의 위치에 있고 j열이 첫번째 위치일 경우
					// i-1열의 마지막행 값으로 비교, 단 색깔을 역으로 가져오기
					prevColor = (prevColor == 'B' ? 'W' : 'B');
				}
			}
		}
//		for(int i = x; i < (x+8); i++) {
//			for(int j = y; j < (y+8); j++) {
//				System.out.print(chess[i][j]);
//			}
//			System.out.println();
//		}
		
		/*
		8 8
		BBWBWBWB
		BWBWBWBW
		WBWBWBWB
		BWBWBWBW
		WBWBWBWB
		BWBWBWBW
		WBWBWBWB
		BWBWBWBW
		
		위 예시를 보면 첫번째 문자를 'W'로 색칠하면 변경회수가 '1'회만으로 원하는 체스판을 만들 수 있으나 
		반복문에서는 처음 문자를 기준으로 체스판 전체를 비교하기 때문에 '63'회를 변경할 수 밖에 없다.
		그래서 마지막으로 전체 체스판의 최대의 변경회수인 8*8=64에 변경회수를 빼면
		동전 뒤집기 확률 문제처럼 64-63=1이라는 수를 도출할 수 있다.
		그리고 최소의 수를 구하는 것이므로 변경회수와 최소비교를 해줘야만 한다.
		 */
		return Math.min(count, 64-count);
	}
}
