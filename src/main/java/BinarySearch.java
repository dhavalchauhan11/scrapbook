/**
 * Author: dchauhan
 * Date: 3/13/16.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] i = {2,4,16,18,70,65};
//        System.out.println(binarySearch(i,180));
        System.out.println(binarySearch(i,0,i.length-1,70));

    }

    public static int binarySearch(int[] arr,int element){
        int low = 0;
        int high = arr.length - 1;

        while(low <=  high){
//            int mid = (low+high)/2;   // may cause overflow because int limitation of 2^31
            int mid = low + (high-low)/2;
            if(arr[mid] == element){
                return arr[mid];
            } else if (element < arr[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr,int low, int high,int element){
        if(low > high)
            return -1;

        int mid = low + (high-low)/2;
        if(arr[mid] == element)
            return arr[mid];
        else if(element < arr[mid]){
            return binarySearch(arr,low,mid-1,element);
        } else {
            return binarySearch(arr,mid+1,high,element);
        }
    }
}
