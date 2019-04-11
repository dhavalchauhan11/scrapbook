/**
 * Author: dchauhan
 * Date: 5/3/16.
 */
public class Class1 {

    String str = null;
    SubClass1 subClass1;

    public Class1(){
        subClass1 = new SubClass1(str);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void doSomething(){
        subClass1.doSomething();
    }


}
