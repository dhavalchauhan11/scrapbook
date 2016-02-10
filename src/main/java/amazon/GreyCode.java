package amazon;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;

/**
 * Created by dhavalchauhan on 2/7/15.
 */
public class GreyCode {
    public static void main(String args[]){
        byte b1 = 011;
        byte b2 = 001;
        Byte bObj = new Byte(b1);
        String s1 = Byte.toString(b1);


        try {
            String s = new String(new byte[]{b1},"UTF-8");
            char[] buffer = s.toCharArray();
            byte[] b = new byte[buffer.length];

            for (int i = 0; i < b.length; i++) {

                b[i] = (byte) buffer[i];
            }

            System.out.println(b);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


//        System.out.println(s1);

//        System.out.println(bObj);
//
//        System.out.println(Integer.toBinaryString(9));

    }

    public static BitSet fromByte(byte b)
    {
        BitSet bits = new BitSet(8);
        for (int i = 0; i < 8; i++)
        {
            bits.set(i, (b & 1) == 1);
            b >>= 1;
        }
        return bits;
    }

}
