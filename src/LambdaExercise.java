import java.util.*;


public class LambdaExercise {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8,9,10,101,-5};

        List<Integer> list = Arrays.asList(arr);
        Random random = new Random();
        //limit(x) ->method specifies the limit of the elements. The size that you specify in the limit(X), it will return the Stream of the size of ‘X’.
        list.stream().limit(4).forEach(System.out::println);

        /* sorted() method is used to sort the output after
         terminal operation forEach
         */
        random.ints().limit(5).sorted().forEach(System.out::println);

        //list.stream() just gives you Stream of Integer objects, so you need maptoInt to get int stream primitives
        //sum() is terminal operation so it need int primitives to perform active, that is why we use mapToInt
        System.out.println(list.stream().mapToInt(a->a).sum());

        OptionalDouble avg = list.stream().mapToInt(a->a*a)
                .filter(a->a<100).average();

        Integer integer = list.stream().sorted(Integer::compareTo).reduce(Math::max).get();

        System.out.println(integer);



        /*int[] a
                = list.stream().toArray();
        System.out.println(avg);*/
    }
}
