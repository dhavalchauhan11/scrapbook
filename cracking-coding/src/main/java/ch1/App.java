package ch1;

/**
 * Author: dchauhan
 * Date: 4/3/19.
 */
public class App {
    public static void main(String[] args) {
        MyStringBuilder sb = new MyStringBuilder();
        sb.append("this");
        sb.append(" ");
        sb.append("is");
        sb.append(" ");
        sb.append("cool");

        sb.append("Lets get ready to ROCK AND ROLLL RAWRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");

        sb.append("Another super long ass string here we go !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        System.out.println(sb.toString());
    }
}
