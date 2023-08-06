import java.util.*;
import java.util.stream.Collectors;


public class LambdaExercise {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8,9,10,101,-5};
        List<Integer> list = Arrays.asList(arr);
        List<Integer> list2 = Arrays.asList(arr);
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

        List<int[]> array = new ArrayList<>();
        array.add(new int[]{6,1,2});
        array.add(new int[]{10,2,3});
        array.add(new int[]{2,3,4});
        array.add(new int[]{7,4,5});

        Collections.sort(array,(a,b)-> a[0]-b[0]);

        String a = "AAA";
        String b = "AAA";

        System.out.println(a==b);
        System.out.println(a.equals(b));

        //array.stream().sorted(Comparator.comparing( (a,b)-> a[0]-b[0])).collect(Collectors.toList());



        StringBuilder st = new StringBuilder("  Achint   ");
        st.trimToSize();
        System.out.println("  Achint   ".trim());

        /*int[] a
                = list.stream().toArray();
        System.out.println(avg);*/

        //Session#2 ********************************************
        Double d = list2.stream().mapToInt(x -> x).average().getAsDouble();
        System.out.println(d);
        List<String> str = Arrays.asList("Java","CPP","Ruby","SQL","Node","GraphQL","SQL","Java","Rule");

        //Write a Java program to convert a list of strings to uppercase or lowercase using streams.
        str.stream().map(String::toUpperCase).forEach(System.out::println);

        //Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
        list2.stream().filter(a1->a1%2==0).mapToInt(a1->a1).sum();

        //Write a Java program to remove all duplicate elements from a list using streams.
        str.stream().distinct().collect(Collectors.toList());

        //Write a Java program to count the number of strings in a list that start with a specific letter using streams.
        str.stream().filter(y->y.startsWith("Ru")).forEach(System.out::println);

        //Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
        str.stream().sorted(String::compareTo).forEach(System.out::println);

        //With Employee
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));



        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing((ea,eb)->eb.getAge()-ea.getAge()))
                .forEach(p->System.out.println(p.getSalary()+"-"+p.getAge()));


        //Write a Java program to find the maximum and minimum values in a list of integers using streams.
        System.out.println(list2.stream().mapToInt(num->num).reduce(Math::min).getAsInt());;

        //How many male and female employees are there in the organization?
        Map<String, Long> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(collect);

        // Print the name of all departments in the organization?
        //employeeList.stream().map(em->em.getDepartment()).distinct().forEach(System.out::println);
        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        //What is the average age of male and female employees?
        Map<String, Double> collect1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(collect1);

        //Get the names of all employees who have joined after 2015?
        employeeList.stream().filter(emp->emp.getYearOfJoining()>2015).forEach(System.out::println);

        //Count the number of employees in each department?
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

        //Get the details of youngest male employee in the product development department?
        Employee employee = employeeList.stream()
                .filter(emp1 -> emp1.getGender() == "Male" && emp1.getDepartment() == "Product Development")
                .min(Comparator.comparing(Employee::getAge)).get();
        System.out.println(employee);

        Employee employee1 = employeeList.stream().min(Comparator.comparing(Employee::getYearOfJoining)).get();
        System.out.println(employee1);

        //List down the names of all employees in each department?
        Map<String, List<Employee>> collect2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
        System.out.println(collect2);
    }
}
