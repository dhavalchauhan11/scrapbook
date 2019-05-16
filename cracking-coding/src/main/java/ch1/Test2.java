package ch1;

import java.util.Arrays;
import java.util.List;

/**
 * Author: dchauhan
 * Date: 4/21/19.
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 t2 = new Test2();
        int[] nums = new int[]{0,1,3,0,12,0};
        t2.moveZeroes(nums);
        System.out.println(nums);
//        System.out.println(t2.getRow(3));

    }

    public void moveZeroes(int[] nums) {
        int pointer = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                pointer = i;
            }
        }
    }

//    public List<Integer> getRow(int rowIndex) {
//        Integer[] res = new Integer[rowIndex + 1];
//        int temp1 = 1, temp2 = 1;
//        for (int i = 0; i <= rowIndex; i++) {
//            res[0] = 1;
//            for (int j = 1; j < i; j++) {
//                temp2 = temp1;
//                temp1 = res[j - 1] + res[j];
//                if (j > 1){
//                    res[j - 1] = temp2;
//                }
//            }
//            if (i > 0) res[i - 1] = temp1;
//            res[i] = 1;
//        }
//        return Arrays.asList(res);
//    }

//    Class Solution {
//        public :
//        string multiply( string num1, string num2) {
//            string res = "" ;
//            int m = num1.size(), n = num2.size();
//            Vector < int > vals(m + n);
//            for ( int i = m - 1 ; i >= 0 ; -- i) {
//                for ( int j = n - 1 ; j >= 0 ; -- j) {
//                    int Mul = (num1[i] - ' 0 ' ) * (num2[j] - ' 0 ' );
//                    int p1 = i + j, p2 = i + j + 1 , sum = mul + vals[p2];
//                    Vals[p1] += sum / 10 ;
//                    Vals[p2] = sum % 10 ;
//                }
//            }
//            For ( int val : vals) {
//                if (!res.empty() || val != 0 ) res.push_back(val + ' 0 ' );
//            }
//            Return res.empty() ? " 0 " : res;
//        }
//    };
}
