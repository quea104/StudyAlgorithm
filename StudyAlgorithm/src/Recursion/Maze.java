package Recursion;

/*
 * https://www.inflearn.com/course/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B0%95%EC%A2%8C/lecture/4075?tab=curriculum
 * '영리한 프로그래밍을 위한 알고리즘 강좌' 강의 섹션2 4. Recursion의 응용 - 미로찾기 1
 */

/*
 * 미로찾기
 * N X N
 * pathway : 통로
 * wall : 막힌 벽
 */
public class Maze {
	// Decision Problem : 답이 Yes 또는 No인 문제
	
	private static final int PATHWAY_COLOR = 0; // white - 이동 가능한 통로
	private static final int WALL_COLOR = 1; 	// blue - 미로의 벽
	private static final int BLOCKED_COLOR = 2;	// red - 지나가면 안되는 경로
	private static final int PATH_COLOR = 3;	// green - 이동 경로
		
	public boolean findPath(int[][] maze, int x, int y) {
		int N = maze.length;
		if(x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}
		else if(maze[x][y] != PATHWAY_COLOR) {
			//System.out.println("!PATHWAY_COLOR : ("+x+", "+y+")");
			return false;
		}
		else if (x == N-1 && y == N-1) {
			//System.out.println("LAST: ("+x+", "+y+")");
			maze[x][y] = PATH_COLOR;
			return true;
		}
		else {
			//System.out.println("("+x+", "+y+")");
			//print(maze);
			maze[x][y] = PATH_COLOR;
		
//			int[] neigbor = new int[] {-1, 1}; 
//			for(int i = 0; i < neigbor.length;i++) { 
//				if(findPath(maze, x+neigbor[i], y) || findPath(maze, x, y+neigbor[i]))
//					return true; 
//			}			
			if(findPath(maze, x-1, y) || findPath(maze, x, y+1) || findPath(maze, x+1, y) || findPath(maze, x, y)) {
				return true;
			}
			
			maze[x][y] = BLOCKED_COLOR;
			//print(maze);
			return false;
		}
	}
}
