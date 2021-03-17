package packStudyAlgorithm;

public class Main {
	public static void main(String[] args) {
//		NewId classNewId = new NewId();
//		String answerNewId = classNewId.solution(".1.");
//		System.out.println("Answer:"+answerNewId);
		
		NQueen classNQueen = new NQueen();
		int answerNQueen = classNQueen.solution(3);
		System.out.println("Answer:"+answerNQueen);
	}
}