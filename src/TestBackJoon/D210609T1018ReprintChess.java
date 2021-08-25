package TestBackJoon;

/*
 * ������: ü���� �ٽ� ĥ�ϱ�
 * ����: 21.06.09.��~10.��
 * https://www.acmicpc.net/problem/1018
 * ��������:
 		�����̴� �ڽ��� ���ÿ��� MN���� ���� ���簢������ �������� �ִ� (y+8)*N ũ���� ���带 ã�Ҵ�. � ���簢���� ���������� ĥ���� �ְ�, �������� ������� ĥ���� �ִ�. �����̴� �� ���带 �߶� 8*8 ũ���� ü�������� ������� �Ѵ�.
		ü������ �������� ����� �����Ƽ� ĥ���� �־�� �Ѵ�. ��ü������, �� ĭ�� �������� ��� �� �ϳ��� ��ĥ�Ǿ� �ְ�, ���� �����ϴ� �� ���� �簢���� �ٸ� ������ ĥ���� �־�� �Ѵ�. ���� �� ���Ǹ� ������ ü������ ��ĥ�ϴ� ���� �� �������̴�. 
		�ϳ��� �� ���� �� ĭ�� ����� ���, �ϳ��� �������� ����̴�.		
		���尡 ü����ó�� ĥ���� �ִٴ� ������ ���, �����̴� 8*8 ũ���� ü�������� �߶� �Ŀ� �� ���� ���簢���� �ٽ� ĥ�ؾ߰ڴٰ� �����ߴ�. �翬�� 8*8 ũ��� �ƹ������� ��� �ȴ�. �����̰� �ٽ� ĥ�ؾ� �ϴ� ���簢���� �ּ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�: ù° �ٿ� N�� M�� �־�����. N�� M�� 8���� ũ�ų� ����, 50���� �۰ų� ���� �ڿ����̴�. ��° �ٺ��� N���� �ٿ��� ������ �� ���� ���°� �־�����. B�� �������̸�, W�� ����̴�.
 * ���: ù° �ٿ� �����̰� �ٽ� ĥ�ؾ� �ϴ� ���簢�� ������ �ּڰ��� ����Ѵ�.
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
//                    // ������ ���ƾ� �ϴ� ���
//                    if(chess[i + x][j + y] != prevColor) {
//                		System.out.println((i + j) + "=>" + (i + x) + "/" +(j + y) + ": " + chess[i + x][j + y]);
//                    	count++;
//                    }
//                }
//                else {
//                    // ������ �޶�� �ϴ� ���
//                    if(chess[i + x][j + y] == prevColor) {
//                		System.out.println((i + j) + "=>" + (i + x) + "/" +(j + y) + ": " + chess[i + x][j + y]);
//                    	count++;
//                    }
//                }
//            }
//        }
		
		int n = x+8; // ü���� ���� ������ �� ��
		int m = y+8; // ü���� ���� ������ �� ��
		for(int i = x; i < n; i++) {
			for(int j = y; j < m; j++) {
				if(i == x && j == y) { // i��, j���� ��� ù��° ��ġ�� ��� �ǳʶ��
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
				
				if(j == m-1) { // i���� �ι�° ������ ��ġ�� �ְ� j���� ù��° ��ġ�� ���
					// i-1���� �������� ������ ��, �� ������ ������ ��������
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
		
		�� ���ø� ���� ù��° ���ڸ� 'W'�� ��ĥ�ϸ� ����ȸ���� '1'ȸ������ ���ϴ� ü������ ���� �� ������ 
		�ݺ��������� ó�� ���ڸ� �������� ü���� ��ü�� ���ϱ� ������ '63'ȸ�� ������ �� �ۿ� ����.
		�׷��� ���������� ��ü ü������ �ִ��� ����ȸ���� 8*8=64�� ����ȸ���� ����
		���� ������ Ȯ�� ����ó�� 64-63=1�̶�� ���� ������ �� �ִ�.
		�׸��� �ּ��� ���� ���ϴ� ���̹Ƿ� ����ȸ���� �ּҺ񱳸� ����߸� �Ѵ�.
		 */
		return Math.min(count, 64-count);
	}
}
