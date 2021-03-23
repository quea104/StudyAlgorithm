package packRecursion;

/*
 * https://www.inflearn.com/course/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B0%95%EC%A2%8C/lecture/4077?tab=curriculum
 * '영리한 프로그래밍을 위한 알고리즘 강좌' 강의 섹션2 6. Recursion의 응용: n queens problem
 */

/*
 * n queens problem
 * 	- N*N 크기의 체스판
 * 	- N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제
 * 	- 퀸이 놓였을 때 퀸 자신을 기준으로 일직선상(가로 및 세로)과 대각선 방향에는 아무것도 놓여있으면 안 됨
 * 
 * Backtracking(되추적 기법)
 *  - 최근에 지나온 괘적을 되돌아가서 번복하여 문제를 해결하는 방법
 *  - 상태공간 트리를 깊이 우선 방식으로 탐색하여 해를 찾는 알고리즘
 * 	- 상태공간트리: 
 * 			찾는 해를 포함하는 트리. 
 * 			해가 존재한다면 그것은 반드시 이 트리의 어떤 한 노드에 해당함. 
 * 			따라서 이 트리를 체계적으로 탐색하면 해를 구할 수 있음. 
 * 			(트리를 만드는 것이 아니라 논리적인 개념을 활용하여 문제를 해결하는 방법임.)
 * 			탐색 불가한 트리를 Infeasible 또는 non-promising 상태에 놓여있다고 함.
 * 
 * 입력: N이 주어진다. (1 ≤ N < 15)
 * 출력: 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수
 */
public class NQueen {
	private int[] cols;
	
	public NQueen(int N) {
		cols = new int[N+1];
	}

	public boolean queens(int level) {
		if(level < 0 || level >= cols.length) 
			return false;
		else if(level == cols.length)
			return true;
		else if(!promising(level))
			return false;
		else {
			for(int i = 1; i <= cols.length; i++) {
				cols[level+1] = i;
				if(queens(level+1))
					return true;
			}
			return false;
		}
	}
	
	private boolean promising(int level) {
		return true;
	}
}