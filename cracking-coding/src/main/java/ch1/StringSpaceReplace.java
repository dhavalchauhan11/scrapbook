package ch1;

/**
 * Created by dhavalchauhan on 8/18/15.
 */
public class StringSpaceReplace {
    public static void main(String[] args) {
        String s = "abc efg edf  ek";
        System.out.println(replaceSpace2(s));
    }

    public static String replaceSpace(String s){
        char[] str = s.toCharArray();

        StringBuffer sb = new StringBuffer();
        for(char c:str){
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }

        return sb.toString();

    }

    public static String replaceSpace2(String s){
        char[] str = s.toCharArray();
        int len = s.length();
        int spaceCount = 0, newLength, i=0;
        for(i=0;i<str.length;++i){
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        newLength = len + spaceCount*2;
        str[newLength] = '\0';
        for (i = len - 1; i >= 0; i--) {
            if(str[i] == ' '){
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }

        }
        return new String(str);
    }
}
