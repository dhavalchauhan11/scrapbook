package ch1;

/**
 * Author: dchauhan
 * Date: 4/3/19.
 */
public class MyStringBuilder {
    private static final int BUFFER_MULTIPLIER = 2;
    private static final int BUFFER_INITIAL_SIZE = 16;

    private char[] str;
    private int size;

    private int charCount;

    // Default
    public MyStringBuilder(){
        this.size = BUFFER_INITIAL_SIZE;
        this.str = new char[BUFFER_INITIAL_SIZE];
    }

    /**
     * @param size
     * Initial size of the underlying char array
     */
    public MyStringBuilder(int size){
        this.size = size;
        this.str = new char[this.size];
    }

    /**
     * @param str
     */
    public MyStringBuilder(char[] str){
        this.str = str;
    }

    public MyStringBuilder(String str){
        this.str = str.toCharArray();
    }

    /**
     * Check to see if underlying character array needs resizing
     * @param newInput
     * @return
     */
    private boolean resizeRequired(String newInput) {
        return this.charCount + newInput.length() > this.size;
    }

    /**
     * resize the underlying character array if the existing char array is about to overflow
     * @param newInput
     */
    private void resizeBuffer(String newInput) {
        int oldSize = this.size;
        // update buffer size
        this.size *= BUFFER_MULTIPLIER;

        // initialize new buffer with multiplied size
        char[] newStr = new char[this.size];
        System.out.printf("Resizing the array: Increasing size from %d to %d\n",oldSize,this.size);

        // Copies SOURCE array from specific beginning position to DESTINATION array from mentioned position with defined length
        System.arraycopy(this.str, 0 , newStr, 0, oldSize);

        this.str = newStr;
    }

    private void addString(String str){
        // Copy elements from string to append into the underlying char array.
        System.arraycopy(str.toCharArray(),0, this.str, this.charCount, str.length());
    }

    private void updateCharCount(int charCount){
        this.charCount += charCount;
    }

    public String toString() {
        return String.valueOf(this.str);
    }

    public MyStringBuilder append(Object item){
        String str = item.toString();
        while (resizeRequired(str)) {
            resizeBuffer(str);
        }
        addString(str);
        updateCharCount(str.length());

        return this;
    }
}
