package TestBackJoon;
/*
 * ������: �ܾ� ����
 * ����: 21.03.26.��
 * https://www.acmicpc.net/problem/1157
 * ��������: ���ĺ� ��ҹ��ڷ� �� �ܾ �־�����, �� �ܾ�� ���� ���� ���� ���ĺ��� �������� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�. ��, �빮�ڿ� �ҹ��ڸ� �������� �ʴ´�.
 * �Է�: ù° �ٿ� ���ĺ� ��ҹ��ڷ� �̷���� �ܾ �־�����. �־����� �ܾ��� ���̴� 1,000,000�� ���� �ʴ´�. 
 * ���: ù° �ٿ� �� �ܾ�� ���� ���� ���� ���ĺ��� �빮�ڷ� ����Ѵ�. ��, ���� ���� ���� ���ĺ��� ���� �� �����ϴ� ��쿡�� ?�� ����Ѵ�.
 */

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.io.IOException;
public class D210326T1157StudyWord {
	public static void main(String[] args) throws IOException {
		int b[] = new int[26];
		int c= System.in.read();
		while(c>64) {
			if(c<91) {
				b[c-65]++;
			} else {
				b[c-97]++;
			}
			c = System.in.read();
		}
		
		int max=-1;
		int maxN=0;
		for(int i=0; i<b.length; i++) {
			if(b[i]>max) {
				max=b[i];
				maxN=i;
			} else if(b[i] == max) {
				maxN=-2;
			}
		}
		System.out.println((char)(maxN+65));
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		int[] arr = new int[26];
//		String word = br.readLine().toUpperCase();
//		for (int i = 0; i < word.length(); i++) {
//			arr[alphabet.indexOf(word.substring(i, i+1))] += 1;
//		}
//		
//		int maxCount = arr[0];
//		char maxAlpha = alphabet.charAt(0);
//		for (int i = 1; i < arr.length; i++) {
//			if (maxCount < arr[i]) {
//				maxCount = arr[i];
//				maxAlpha = alphabet.charAt(i);
//			}
//			else if(maxCount == arr[i]) {
//				maxAlpha = '?';
//			}
//		}
//		System.out.println(maxAlpha);
	}
}