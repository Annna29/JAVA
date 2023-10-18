import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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


        //STREAMS

        IntStream intStream = IntStream.range(0,15);
        intStream.forEach(x-> System.out.println(x));

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(3,7,9,11,4,16,29,100,12));
        Stream<Integer> myStream = arrayList.stream();
        IntStream intStream1 = IntStream.of(10,100,26,57,45,40);
        Stream<Integer> stm = Stream.of(3,5,10,2,22);
        ArrayList<Integer> arr = (ArrayList<Integer>) arrayList.stream().collect(Collectors.toList());
        System.out.println(arr);

        ArrayList<Integer> a = (ArrayList<Integer>) arr.stream().filter(x ->x%2==0).collect(Collectors.toList());
        System.out.println(a);

       List<Helper> h = a.stream().map(Helper::new).collect(Collectors.toList());
        System.out.println(h);
        List<Helper> hh = a.stream().map(x->new Helper()).collect(Collectors.toList());
        System.out.println(hh);
        List<Helper> hhh = a.stream().map(x -> new Helper(x)).collect(Collectors.toList());
        System.out.println(hhh);

        a.stream().forEach( System.out::println);
        Helper hp = new Helper();
        a.stream().forEach(x-> hp.printnumber(x));

        a.stream().forEach(Helper::printMessage);

        List<Integer> numbers = Arrays.asList(2,9,111,12,14,45,47,48,40);
        List<Integer> evenNumbers = numbers.stream()
                .filter(x->x%2==0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        List<String> stringList = Arrays.asList("Mart", "Smart", "Fast", "Apple");
        List<String> stringList1 = stringList.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        System.out.println(stringList1);

        List<Integer> nr = Arrays.asList(2,7,4,2,7,6,8,7,7,35,4,2,35,29,27,35);
        List<Integer> distinctNr = nr.stream()
                .distinct().collect(Collectors.toList());
        System.out.println(distinctNr);

        List<Integer> num = Arrays.asList(1,5,9,7,11,12,10,150,13);
        List<Integer> numPr = num.stream()
                .map(x ->x*x)
                .collect(Collectors.toList());
        System.out.println(numPr);


        List<List<Integer>> myListOfList = Arrays.asList(Arrays.asList(2,6,4),Arrays.asList(10,2,11),Arrays.asList(6,4,32));
        List<Integer> justAList = myListOfList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(justAList);


        List<Integer> listtt = Arrays.asList(4,7,12,13,15,2);
            boolean isPresent = listtt.stream().anyMatch(x ->x.equals(7));
        System.out.println(isPresent);

        List<String > myList = Arrays.asList("Mart", "Smart");
        boolean allContains = myList.stream().allMatch(x -> x.contains("art"));
        System.out.println(allContains);

        List<String> list = Arrays.asList("apple", "cake", "fruit");
        list.stream().forEach(System.out::println);
        int nrOfElem = (int) list.stream().count();
        System.out.println(nrOfElem);

        List<Integer> listt = Arrays.asList(2,8,11,9,4,6,5,7,6);
        int sum =  listt.stream().reduce(0,Integer::sum);
        System.out.println(sum);
        int max = listt.stream().reduce(0,Integer::max);
        System.out.println(max);
        List<Integer> otherList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(otherList.stream().reduce(0,(c,d)->c));
        System.out.println(otherList.stream().reduce(0,(c,d)->d));

        List<Integer> oList = Arrays.asList(2,6,5,11,13,7);
        Optional<Integer> exemplu = oList.stream().filter(x -> x>7).findAny();
        System.out.println(exemplu.get());


        Optional <String> something = returnSomething();
        something.orElse(something());


        // Lazy
        something.orElseGet( () -> {
            System.out.println("or else get");
            return "test";
        });


       

    }
    public static Optional<String> returnSomething(){

        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if(randomNumber==0) {
            return Optional.of("something");
        }
        return  Optional.empty();
    }

    public static String something(){
        System.out.println("or else");
        return "test";

    }





    public static void myMethod(String s, Predicate<String> myPredicate){

        System.out.println("From my method " + myPredicate.test(s));
    }
}
