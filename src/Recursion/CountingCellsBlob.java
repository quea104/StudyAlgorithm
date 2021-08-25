package Recursion;

/*
 * https://www.inflearn.com/course/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B0%95%EC%A2%8C/lecture/4076?tab=curriculum
 * '������ ���α׷����� ���� �˰��� ����' ���� ����2 5. Recursion�� ����: Counting Cells in a Blob
 */

/*
 * ����: 21.03.23.ȭ
 * Counting Cells in a Blob
 * 	- Binay �̹���
 * 	- �� �ȼ��� Background Pixel �̰ų� Ȥ�� Image Pixel
 * 	- ���� ����� Image Pixel�� Blob �̶�� ��Ī 
 * 	- �����¿�, �밢�������� ����� ������ ����
 * 
 * �Է�: N*N ũ���� 2���� Grid, ��ǥ (x,y)
 * ���: �ȼ�(x,y)�� ���Ե� blob�� ũ��, ������ �ʴ� ��� 0  
 */
public class CountingCellsBlob {
	private static final int BACKGROUD_COLOR = 0; // Background Pixel
	private static final int IMAGE_COLOR = 1; // Image Pixel
	private static final int CHECKED_COLOR = 2; // Ȯ���� Pixel

	public static void main(String[] args) {
		int[][] grid = {
				{1,0,0,0,0,0,0,1},
				{0,1,1,0,0,1,0,0},
				{1,1,0,0,1,0,1,0},
				{0,0,0,0,0,1,0,0},
				{0,1,0,1,0,1,0,0},
				{0,1,0,1,0,1,0,0},
				{1,0,0,0,1,0,0,1},
				{0,1,1,0,0,1,1,1}
		};
		System.out.println(countBlob(grid, 3, 5));
		printMap(grid);
	}
	
	public static int countBlob(int[][] grid, int x, int y) {
		int N = grid.length;
		if(x < 0 || y < 0 || x >= N || y >= N) {
			return 0;
		}
		else if(grid[x][y] != IMAGE_COLOR) {
			return 0;
		}
		else {
			grid[x][y] = CHECKED_COLOR;
			// (1,1) => (0,0),(0,1),(0,2),(1,0),(1,2),(2,0),(2,1),(2,2)
			// (3,5) => (2,4),(2,5),(2,6),(3,4),(3,6),(4,4),(4,5),(4,6)
			return 1 + countBlob(grid, x-1, y-1) + countBlob(grid, x-1, y) + countBlob(grid, x-1, y+1)
				+ countBlob(grid, x, y-1) + countBlob(grid, x, y+1)
				+ countBlob(grid, x+1, y-1) + countBlob(grid, x+1, y) + countBlob(grid, x+1, y+1);
		}
	}

	public static void printMap(int maze[][]) {
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze.length; j++) {
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
