# �˰����� �̷�

## �׷����� Ž���ϴ� ���
- �׷��� Graph
	- ����(node)�� �� ������ �����ϴ� ����(edge)���� �̷���� �ڷᱸ��.
	- �׷��� Ž�� = �ϳ��� �������κ��� �����Ͽ� ���ʴ�� ��� �������� �� ���� �湮�ϴ� ��.
	
- DFS
	- Depth-First Search; ���� �켱 Ž��.
	- ��Ʈ ���(Ȥ�� �ٸ� ������ ���)���� �����ؼ� �ִ��� ���� ������(=�ش� �б�(branch)�� �Ϻ��ϰ� Ž��) �� ���̻� ���� �� ���� ���� ��� ��(���� �б�)���� �̵�.
	- ���� �������� �� �� �ִ� ������� ���鼭 Ž��.
	- ���� �Ǵ� ����Լ��� ����.
	- ���� ����� BFS ���� ����.
	- �˻� �ӵ��� BFS ���� ����.
	- ���� ����
		- �׷����� ��� ������ �湮�ϱ�.
		- ����� Ư¡�� �����ϱ�.
		- �˻� ��� �׷����� �Ը� ū ���.
	- �ǻ��ڵ�	
		```
		dfs(V, E, R) {  # V : ���� ����, E : ���� ����, R : ���� ����
		    visited[R] <- YES;  # ���� ���� R�� �湮 �ߴٰ� ǥ���Ѵ�.
		    for each x �� E(R)  # E(R) : ���� R�� ���� ���� ����.(���� ��ȣ�� ������������ �湮�Ѵ�)
		        if (visited[x] = NO) then dfs(V, E, x);
		}
		```

		
- BFS
	- Breadth-First Search; �ʺ� �켱 Ž��.
	- ��Ʈ ���(Ȥ�� �ٸ� ������ ���)���� �����ؼ� �ִ��� �а� �̵�(=������ ��带 ���� Ž��)�� ����, �� �̻� �� �� ���� �� �Ʒ��� �̵�.
	- ���� �������� ����� ����� ������� Ž��.
	- ť�� ����.
	- ���� ����
		- �׷����� ��� ������ �湮�ϱ�.
		- �� ��� ������ �ִ� ��θ� ã��.
		- �˻� ��� �׷����� �Ը� ũ�� �ʰ� �˻� ���� �������κ��� ���ϴ� ����� ���� ���� ���.
	
- �ð����⵵
	- N: ���, E: ����
	- ���� ����Ʈ�� ���� ��: O(N+E) <- ȿ����
	- ���� ��ķ� ���� ��: O(N^2)
	
- ����
	- TestBackJoon.D220825T1260DFSAndBFS class	


## ��ó 
https://devuna.tistory.com/32