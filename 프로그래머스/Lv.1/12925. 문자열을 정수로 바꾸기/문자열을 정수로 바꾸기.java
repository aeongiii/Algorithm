class Solution {
    public int solution(String S) {
        int i = 0;
    	boolean b = true;
        String[] strArr = S.split("");
        
        if (strArr[0].equals("+") ) {
    		i++;
    	}
    	if (strArr[0].equals("-") ) {
    		i++;
    		b = false;
    	}
        String newS = "";
    	for (; i < strArr.length; i++) {
    		newS = newS + strArr[i];
    	}

    	int answer = Integer.parseInt(newS);
    	if (b==false) {
    		answer = answer * -1;
    	}
        return answer;
    }
}