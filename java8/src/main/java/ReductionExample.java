import java.util.Arrays;
import java.util.List;

public class ReductionExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,10,10);

        //reduce method
        Integer red =
        list.stream()
                .reduce(0, Integer::sum);

        System.out.println(red);
    }
}
