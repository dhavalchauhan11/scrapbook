package misc;

/**
 * Author: dchauhan
 * Date: 5/20/16.
 */
public class MySuper {

    int x = 2;
    static int s = 3;

    MySuper(){
        x += 4;
    }

    MySuper(int x){
        this();
        x += x + 20;
    }

    public MySuper method(){
        x += 35;
        return new MyClass();
    }
}
