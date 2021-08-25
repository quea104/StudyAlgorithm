package TestKakao;

/*
 * ����: https://programmers.co.kr/learn/courses/30/lessons/72410?language=java
 * ����: https://codechacha.com/ko/java-regex/
 */

public class NewId {	
	public static void main(String[] args) {
        String answer = ".1.";
        
        System.out.println("0: " + answer);
        answer = checkId(answer);

        System.out.println(answer);
    }
	
	public static String checkId(String str) {
		str = changeLower(str);
		
		str = removeCharacter(str);
		
		str = changeDot(str);
		
		str = removeDotStartEnd(str);
		
		str = limitString(str);
		str = removeDotStartEnd(str);
		
		str = paddingString(str);
		return str;
	}
	
	// �ҹ��ڷ� ġȯ
	public static String changeLower(String str) {
		return str.toLowerCase();
	}
	
	// ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ����
	public static String removeCharacter(String str) {
		// [^abc] : a, b, c�� ������ ���� 1��
		str = str.replaceAll("[^0-9a-z-_.]", "");
		return str;
	}
	
	// '...'�� '..' �� '.'�� ��ü
	public static String changeDot(String str) {
	    // + : 1ȸ �̻� �ݺ�
		str = str.replaceAll("\\.+", ".");
		return str;
	}

    // ��ħǥ(.)�� ó���� ���� ��� �Ұ�
	public static String removeDotStartEnd(String str) {
        // ^ : ���ڿ��� ��������
		// $ : ���ڿ��� ��������
		// X|Z : X �Ǵ� Z
		str = str.replaceAll("^[.]|[.]$", "");
		return str;
	}

	public static String limitString(String str) {
		if(str.length() > 15) {
			str = str.substring(0, 15);  
        }
		return str;
	}

	public static String paddingString(String str) {
		// �� Ǯ��
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
		
		// �ٸ� ��� Ǯ��
		StringBuilder sBuilder = new StringBuilder(str);
        while (sBuilder.length() <= 2) {
            sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
        }
        str = sBuilder.toString();
        
		return str;
	}
}
