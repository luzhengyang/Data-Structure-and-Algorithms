// Given two strings S and T, determine if they are both one edit distance apart.
// 一个字符串仅需要1次编辑（插入，替换，删除）就和另一个字符串完全一样

public class OneEditDistance{
	// 1. substitution
    // abcde <-> abcXe
    // 2. insertion/deletion
    // abcde <-> abcXde
    // 3. append/deletion
    // abcde <-> abcdeX

    public boolean isOneEditDistance(String s, String t){
    	if(s == null || t == null){
    		return false;
    	}

    	int sLen = s.length();
    	int tLen = t.length();
    	if((sLen == 0 && tLen == 0) || Math.abs(sLen - tLen) > 1){
    		return false;
    	}

    	// we assume sLen < tLen
    	if(sLen > tLen){
    		return isOneEditDistance(t, s);
    	}

    	int index = 0;

    	while(index < sLen && s.charAt(index) == t.charAt(index)){
    		index++;
    	}	// after this while loop index stops

    	int diff = tLen - sLen;	// if diff > 1, return false
    	if(index == sLen){	// 3. abcde <-> abcdeX
    		return diff == 1;
    	}

    	// now we know that index < sLen, consider case 1 and case 2
    	// 1. abcde <-> abcXe => sLen == tLen
    	if(sLen == tLen){
    		index++;
    		while(index < sLen && s.charAt(index) == t.charAt(index)){
    			index++;
    		}
    		return index == sLen;
    	}
    	else{	// sLen != tLen, 2. abcde <-> abcXde
    		int j = index + 1;
    		while(index < sLen && s.charAt(index) == t.charAt(j)){
    			index++;
    			j++;
    		}
    		return (index == sLen && j == tLen);
    	}
    }
}
