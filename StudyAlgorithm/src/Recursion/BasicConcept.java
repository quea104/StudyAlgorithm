package Recursion;

/*
 * https://www.inflearn.com/course/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B0%95%EC%A2%8C/lecture/4073?tab=curriculum
 * '영리한 프로그래밍을 위한 알고리즘 강좌' 강의 섹션2 1~3
 * 일자: 21.03.22.월~21.03.23.화
 */

public class BasicConcept {
	public static void main(String[] args) {
		int m = 24, n = 36;
		System.out.println("gcd: " + gcd(m, n));
		System.out.println("gcdSimple: " + gcdSimple(m, n));
		System.out.println("lcm: " + lcm(m, n));

		printChars("Cooling Work");
		printCharsReverse("Cooling Work");
		
		int[] data = readFrom(5, new int[] {1,2,3,4,5}, new java.util.Scanner(System.in));
		print(data);
		
		System.out.println(findMax(new int[] {1,2,10,4,5}, 0, 4));
	}
	
	/*
	 * 0! = 1
	 * n! = n*(n-1)!
	 */
	public static int factorial(int n) {
		if(n == 0) return 1;
		else {
			return n * factorial(n-1);
		}
	}
	
	/*
	 * x^0 = 1
	 * x^n = x*x^n-1 (if n>0)
	 */
	public static double power(double x, int n) {
		if(n < 0) return -1;
		else if (n == 0)
			return 1;
		else 
			return x*power(x, n-1);
	}
	
	/*
	 * f0 = 0
	 * f1 = 1
	 * fn = fn-1 + fn-2 (if n>1)
	 */
	public static int fibonacci(int n) {
		if(n < 0) return -1;
		else if(n == 0) return 0;
		else if(n == 1) return 1;
		else {
			return fibonacci(n-1)*fibonacci(n-2);
		}
	}
	
	/*
	 * Euclid Method - 최대공약수
	 * m>=n인 두 양의 정수 m & n에 대해서 
	 * 	m이 n의 배수이면 gcd(m,n) = n,
	 * 	그렇지 않으면 gcd(m,n) = gcd(n, m%n)
	 */
	public static int gcd(int m, int n) {
		/*
		 * if(m < n) { int tmp = m; m = n; n = tmp; }
		 */
		if(m >= 0 && n >= 0) {
			if(m % n == 0) return n;
			else {
				return gcd(n, m%n);
			}
		}
		else return -1; 
	}
	
	/*
	 * gcd(m, n) = 
	 * 	m (if n=0)
	 * 	gcd(n, m%n) otherwise
	 */
	public static int gcdSimple(int m, int n) {
		if(n == 0) 
			return m;
		else
			return gcd(n, m%n);
	}
	
	/*
	 * 최소공배수
	 */
	public static int lcm(int m, int n) {
		return m*n/gcd(m,n);
	}
	
	/*
	 * 문자열 길이 계산
	 */
	public static int lengthOfString(String str) {
		if (str.equals(""))
			return 0;
		else
			return 1 + lengthOfString(str.substring(1));
	}
	
	/*
	 * 문자열 출력
	 */
	public static void printChars(String str) {
		if (str.length()==0)
			return;
		else {
			System.out.print(str.charAt(0));
			printChars(str.substring(1));
		}			
	}
	
	/*
	 * 문자열 뒤집어 출력
	 */
	public static void printCharsReverse(String str) {
		if (str.length()==0) {
			return;
		}
		else {
			printCharsReverse(str.substring(1));
			System.out.print(str.charAt(0));
		}
	}
	
	/*
	 * 2진법
	 */
	public static String numberInBinary(int n, String nStr) {
		if (n<2) {
			return Integer.toString(n).concat(nStr);
		}
		else {
			return numberInBinary((int)n/2, Integer.toString(n%2).concat(nStr));
		}
	}
	
	/*
	 * 배열의 합 구하기
	 */
	public static int sum(int n, int[] data) {
		if (n<=0)
			return 0;
		else
			return sum(n-1, data) + data[n-1];
	}
	
	/*
	 * 데이터파일로부터 n개의 정수 읽어오기
	 */
	public static int[] readFrom(int n, int[] data, java.util.Scanner in) {
		if (n == 0) 
			return data;
		else {
			data[n-1] = in.nextInt();
			return readFrom(n-1, data, in);
		}
	}
	
	/*
	 * 순차탐색
	 */
	// 암시적(Implicit) 매개변수
	public static int search(int[] data, int n, int target) {
		for (int i = 0; i < n; i++) {
			if (data[i] == target) {
				return i;
			}		
		}
		return -1;
	}
	
	// 명시적(Explicit) 매개변수 - 검색구간의 종료점을 명시적으로 지정
	public static int search(int[] data, int begin, int end, int target) {
		if (begin > end) 
			return -1;
		else if (target == data[begin]) 
			return begin;
		else 
			return search(data, begin+1, end, target);
	}
	// 명시적(Explicit) 매개변수 - 검색구간의 시작점을 명시적으로 지정
	public static int search2(int[] data, int begin, int end, int target) {
		if(begin > end) 
			return -1;
		else if (target == data[begin]) 
			return begin;
		else 
			return search(data, begin, end-1, target);
	}
	
	// 이분 탐색 활용
	public static int searchByDivide(int[] data, int begin, int end, int target) {
		if (begin > end)
			return -1;
		else {
			int middle = (begin+end)/2;
			if (data[middle] == target) // 대상 찾음
				return middle;
			
			int index = searchByDivide(data, begin, middle-1, target);
			if (index != -1) // 대상 찾음 
				return index;
			else {
				return searchByDivide(data, middle+1, end, target);
			}
		}
	}
	
	/*
	 * 최대값 찾기
	 * MAX(data[n]) = MAX( data[1], MAX(data[n-1]~data[2]) )
	 */
	// 명시적 매개변수	
	public static int findMax(int[] data, int begin, int end) {
		if (begin == end)
			return data[begin];
		else {
			//return Math.max(data[begin], findMax(data, begin+1, end));
			int max = findMax(data, begin+1, end);
			if(data[begin] > max)
				max = data[begin];
			return max;			
		}
	}
	
	// 이분 탐색 활용
	public static int findMaxByDivde(int[] data, int begin, int end) {
		if(begin == end)
			return data[begin];
		else {
			int middle = (begin+end)/2;
			int max1 = findMaxByDivde(data, begin, middle);
			int max2 = findMaxByDivde(data, middle+1, end);
			return Math.max(max1, max2);
		}
	}
	
	/*
	 * 이진검색 - 단, 데이터가 오름차순 정렬 되어 있어야 함.
	 */
	public static int binarySearch(int[] data, int begin, int end, int target) {
		if (begin > end)
			return -1;
		else {
			int middle = (begin+end)/2;
			if(data[middle] == target)
				return middle;
			else if(data[middle] < target)
				return binarySearch(data, begin, middle-1, target);
			else 
				return binarySearch(data, middle+1, end, target);
		}
	}
	
	public static void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
