import java.util.*;

public class Exercise {
    public static void main(String[] args) {
        List <Student> studentList = Arrays.asList(
                new Student("Pronay","Ghosh",22),
                new Student("Pratap","Sen",25),
                new Student("Souvik","Roy",27),
                new Student("Rajesh","Sharma",23),
                new Student("Pratick","Saha",29)
        );
        // step 1 sort list by age

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getAge() - s2.getAge();
            }
        });
        // step 2 create method that prints all elements in list
        printAll(studentList);

        System.out.println("\n");

        // step 3 create method that prints First Name beginning with P
        printFirstNameStartWithP(studentList, new Condition(){
            @Override
            public boolean test(Student s) {
                return s.getFirstName().startsWith("P");
            }
        });
    }
    private  static void printAll(List <Student> studentList){
        for(Student s : studentList){
            System.out.println(s);
        }
    }
    private  static  void  printFirstNameStartWithP(List <Student> studentList, Condition condition ){
        for(Student s : studentList){
            if(condition.test(s))
                System.out.println(s);
        }
    }

    interface Condition{
        boolean test(Student s);
    }
}
