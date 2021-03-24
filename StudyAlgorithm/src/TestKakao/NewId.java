package TestKakao;

/*
 * 문제: https://programmers.co.kr/learn/courses/30/lessons/72410?language=java
 * 참고: https://codechacha.com/ko/java-regex/
 */

public class NewId {	
	public String solution(String new_id) {
        String answer = new_id;
        
        System.out.println("0: " + answer);
        answer = checkId(answer);
                
        return answer;
    }
	
	private String checkId(String str) {
		str = changeLower(str);
		
		str = removeCharacter(str);
		
		str = changeDot(str);
		
		str = removeDotStartEnd(str);
		
		str = limitString(str);
		str = removeDotStartEnd(str);
		
		str = paddingString(str);
		return str;
	}
	
	// 소문자로 치환
	private String changeLower(String str) {
		return str.toLowerCase();
	}
	
	// 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외
	private String removeCharacter(String str) {
		// [^abc] : a, b, c를 제외한 문자 1개
		str = str.replaceAll("[^0-9a-z-_.]", "");
		return str;
	}
	
	// '...'와 '..' 가 '.'로 교체
	private String changeDot(String str) {
	    // + : 1회 이상 반복
		str = str.replaceAll("\\.+", ".");
		return str;
	}

    // 마침표(.)는 처음과 끝에 사용 불가
	private String removeDotStartEnd(String str) {
        // ^ : 문자열의 시작지점
		// $ : 문자열의 종료지점
		// X|Z : X 또는 Z
		str = str.replaceAll("^[.]|[.]$", "");
		return str;
	}

	private String limitString(String str) {
		if(str.length() > 15) {
			str = str.substring(0, 15);  
        }
		return str;
	}

	private String paddingString(String str) {
		// 내 풀이
		/*
		if(str.length() < 3) {
        	String lastWord = "";
        	if (str.equals("")) {
        		lastWord = "a";
        	}
        	else {
        		lastWord = str.substring(str.length()-1);
            	if (lastWord.equals("")) {
            		lastWord = "a";
            	}
        	}
        	
        	if (!lastWord.equals("")) {
        		for(int a = str.length(); a < 3; a++) {
            		str = str.concat(lastWord);
                }
        	}
        }
        */
		
		// 다른 사람 풀이
		StringBuilder sBuilder = new StringBuilder(str);
        while (sBuilder.length() <= 2) {
            sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
        }
        str = sBuilder.toString();
        
		return str;
	}
}
