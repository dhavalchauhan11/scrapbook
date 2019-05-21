import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumers {
    public static void main(String[] args) {
//        List<String> strings = Arrays.asList("one","two","three","four","five");
//
//        Consumer<String> c1 = System.out::println;
////        strings.forEach(c1);
//
//        List<String> results = new ArrayList<>();
//        Consumer<String> c2 = results::add;
//        strings.forEach(c1.andThen(c2));
//        System.out.println("size of results: " +results.size());

        consumerChainAndThen();


    }

    public static void basicConsumer() {
        // Consumer to display a number
        Consumer<Integer> display = System.out::println;
        // Implement display using accept()
        display.accept(10);

        Consumer<List<Integer>> modify = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, 2 * list.get(i));
            }
        };

        // consumer to display list of numbers
        Consumer<List<Integer>> dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);


        // implement modify using accept
        modify.accept(list);

        // Implement dispList using accept
        dispList.accept(list);

    }

    public static void consumerChainAndThen() {
        // define modify consumer
        Consumer<List<Integer>> modify =
                list -> {
                    for (int i = 0; i < list.size(); i++) {
                        list.set(i, 2 * list.get(i));
                    }
                };

        // consumer to display contents of the list
        Consumer<List<Integer>> displayList = list -> list.stream().forEach(a -> System.out.print(a+ " "));

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        // call modify and then display
        modify.andThen(displayList).accept(list);
    }

    public static void consumerEg3(){
        List<String> list = new ArrayList<>();

        Consumer<String> c1 = list::add;
        Consumer<String> c2 = System.out::println;


    }
}
