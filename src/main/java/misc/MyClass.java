package misc;

/**
 * Author: dchauhan
 * Date: 5/20/16.
 */
public class MyClass extends MySuper {
    public MyClass(){
        super(3);
        x -= 7;
        s += x;
    }

    public MySuper method(){
        x += 7;
        return super.method();
    }

    public static void main(String[] args) {
        MyClass mc = new MyClass();
        mc.method();
        System.out.println(s);
    }
}
