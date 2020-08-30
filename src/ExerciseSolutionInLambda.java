import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExerciseSolutionInLambda {
    public static void main(String[] args) {
        List <Student> studentList = Arrays.asList(
                new Student("Pronay","Ghosh",22),
                new Student("Pratap","Sen",25),
                new Student("Souvik","Roy",22),
                new Student("Rajesh","Sharma",23),
                new Student("Pratick","Saha",22)
        );

        // step 1 sort list by age

        //Using Lambda Exp
        Collections.sort(studentList,(s1, s2) -> s1.getAge() - s2.getAge());
        //Collections.sort(studentList,Comparator.comparingInt(Student::getAge));

        // step 2 create method that prints all elements in list
        //printFirstNameStartWithP(studentList, s -> true, System.out::println);
        studentList.forEach(System.out::println); //Using forEach loop
        //System.out::println SAME AS s -> System.out.println(s.toString())
        //parameter -> method (parameter) it's a method reference in Lambda
        System.out.println("All firstName in Student :->");
        studentList.stream().forEach(s -> System.out.println(s.getFirstName()));
        System.out.println("All lastName in Student :->");
        studentList.stream().forEach(s -> System.out.println(s.getLastName()));
        System.out.println("All ages in Student :->");
        studentList.stream().forEach(s -> System.out.println(s.getAge()));

        //Using a filter
        System.out.println("Surname of those whose firstName starts with P :->");
        studentList.stream().filter(s -> s.getFirstName().startsWith("P")).forEach(s -> System.out.println(s.getLastName()));

        //Using a filter
        System.out.println("Count the students whose age is same :->");
        long count =studentList.stream().filter(s->s.getAge()==22).count();
        System.out.println(count);
        System.out.println("FistName starts with P :->");
        // step 3 create method that prints First Name beginning with P
        printFirstNameStartWithP(studentList, s -> s.getFirstName().startsWith("P"), s -> System.out.println(s.getFirstName()));

        // step 4 create method that prints Last Name beginning with S and cou
        System.out.println("LastName starts with S :->");
        printFirstNameStartWithP(studentList, s -> s.getLastName().startsWith("S"), s -> System.out.println(s.getLastName()));
    }
    //predicate is an interface in java.util.function, return type is boolean
    //consumer is an interface in java.util.function, return type is an object
    private  static  void  printFirstNameStartWithP(List <Student> studentList, Predicate<Student> predicate, Consumer<Student> consumer){
        for(Student s : studentList){
            if(predicate.test(s))
                consumer.accept(s);
        }
    }
}
