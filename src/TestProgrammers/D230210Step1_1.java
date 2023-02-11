package TestProgrammers;

public class D230210Step1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(11, new int[]{4, 11}, 1));
	}
	
	static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int[] map = new int[n+1];
        
    	for(int i = 0; i < stations.length; i++) {
    		map = build(map, stations[i], w);
        }

        for(int i = 1; i <= n; i++) {
        	int next = i+w;
        	if(next >= 1 && next < map.length) {
        		map = build(map, next, w);
        		answer++;
        		i = next+w;
        	}
        }

        return answer;
    }
	
	static int[] build(int[] map, int s, int w) {
		for(int i = s-w; i <= s+w; i++) {
			if(i >= 1 && i < map.length)
				map[i]++;
        }
		
		return map;
	}
}
