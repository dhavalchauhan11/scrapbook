package ch11_sorting;

/**
 * you are give two sorted arrays A and B where A has a large enough buffer at the end to hold B.
 * Write method to merge B into A in sorted order
 */
public class Ch11_1 {

    public static void main(String[] args) {
        int[] a = new int[7];
        for(int i = 0;i<4;i++){
            a[i] = i+1;
        }

        int[] b = new int[]{5,6,7};

        merge(a,b,4,3);

    }

    /**
     * Start from the right ends of A and B
     * @param a
     * @param b
     * @param lastA
     * @param lastB
     */
    public static void merge(int[] a, int[] b, int lastA, int lastB){
        int indA = lastA - 1;
        int indB = lastB - 1;
        int indMerged = lastA + lastB - 1;

        // merge elements starting from right
        while(indA >= 0 && indB >= 0){

            // if last element of A is greater than B's last THEN - move it to the end
            if(a[indA] > b[indB]){
                a[indMerged] = a[indA]; // move it to the end
                indMerged--;            // Move merged index to left
                indA--;                 // one down in A
            } else {
                // B's last is greater
                a[indMerged] = b[indB];
                indMerged--;
                indB--;
            }
        }

        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]);
            System.out.print(",");
        }

    }
}
