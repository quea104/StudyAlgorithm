package Recursion;

/*
 * https://www.inflearn.com/course/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B0%95%EC%A2%8C/lecture/4076?tab=curriculum
 * '영리한 프로그래밍을 위한 알고리즘 강좌' 강의 섹션2 5. Recursion의 응용: Counting Cells in a Blob
 */

/*
 * 일자: 21.03.23.화
 * Counting Cells in a Blob
 * 	- Binay 이미지
 * 	- 각 픽셀은 Background Pixel 이거나 혹은 Image Pixel
 * 	- 서로 연결된 Image Pixel을 Blob 이라고 지칭 
 * 	- 상하좌우, 대각방향으로 연결된 것으로 간주
 * 
 * 입력: N*N 크기의 2차원 Grid, 좌표 (x,y)
 * 출력: 픽셀(x,y)가 포함된 blob의 크기, 속하지 않는 경우 0  
 */
public class CountingCellsBlob {
	private static final int BACKGROUD_COLOR = 0; // Background Pixel
	private static final int IMAGE_COLOR = 1; // Image Pixel
	private static final int CHECKED_COLOR = 2; // 확인한 Pixel
	
	public int countBlob(int[][] grid, int x, int y) {
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
}
