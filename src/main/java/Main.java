import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {


        // ---FUNCTIONAL INTERFACES---

        //CONSUMER

        Consumer<String> myConsumer = s -> System.out.println(s.length());
        myConsumer.accept("BOBI");


        //SUPPLIER

        Supplier<Integer> mySupplier = () -> {
                                                Random random = new Random();
                                                return random.nextInt(100);
                                              };

        System.out.println(mySupplier.get());

        //FUNCTION

        Function<Integer, Integer> myFunction = x-> x+10;
        System.out.println(myFunction.apply(5));
        Function<Integer, Integer> myFunction2 = x-> x*x;
        Function<Integer, Integer> myFunction3 = myFunction.compose(myFunction2);
        System.out.println(myFunction3.apply(10));
        Function<Integer, Integer> myFunction4 = myFunction.andThen(myFunction2);
        System.out.println(myFunction4.apply(2));

        //PREDICATE

        Predicate<String> myPredicate = s -> s.contains("art");

       // System.out.println(myPredicate.test("Mart"));
        System.out.println(myPredicate.test("arc"));

        myMethod("Mart", myPredicate);



    }

    public static void myMethod(String s, Predicate<String> myPredicate){

        System.out.println("From my method " + myPredicate.test(s));
    }
}
