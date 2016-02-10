package ch1;

public class StringRemoveDuplicate{
	public static void main(String args[]){
		String s = "abcdabe";
		//System.out.println(removeDup(s));
//		System.out.println(removeDeupAddMem(s));
		removeDeupAddMem(s);
	}

	public static String removeDup(String s){
		
		if(s == null)
			return s;
		
		if(s.length()<2)
			return s;

		boolean[] charSet = new boolean[256];
		
		StringBuffer sb = new StringBuffer();

		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			int intVal = (int)c;
			// int charVal = s.chatAt(i);
			if(!charSet[intVal]){
				sb.append(c);
				charSet[intVal] = true;
			}	
		}
		return sb.toString();
	}

	// Removing dups with additional memory of constant size i.e. without using StringBuffer 
	public static String removeDeupAddMem(String s){
		char[] chars = s.toCharArray(); 
		if(s == null)
			 return s;

		if(s.length()<2)
			 return s;

		boolean[] charHit = new boolean[256];
		// mark the first char as already hit
		charHit[chars[0]] = true;
		int tail = 1;
		for(int i=1;i<chars.length;++i){
			if(!charHit[chars[i]]){
				chars[tail] = chars[i];
				++tail;
				charHit[chars[i]] = true;
			}
		}
//		chars[tail] = 0;
		System.out.println(chars);
		return new String(chars);

	}
}
