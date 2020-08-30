import java.util.function.BiConsumer;
import java.util.function.Consumer;

//BiConsumer is a functional interface that has two object and return an object by the help of consumer
public class ExceptionHandlingInLambda {
    public static void main(String[] args) {
        int [] someOfNumbers = {1,2,3,4,5};
        int key =0;
        /*process(someOfNumbers,key, (v,k) -> {try {
            System.out.println(v/k);
        }
        catch (ArithmeticException e){
            System.out.println("Please don't provide k = 0");
        }
        });
         */
        //Instead of exception handled in main lambda, we can go through by a wrapperLambda
        process(someOfNumbers,key,wrapperLambda((v,k) -> System.out.println(v/k)));
    }
    private static void process(int[] someOfNumbers, int key, BiConsumer<Integer, Integer> consumer){
        for(int i : someOfNumbers){
            consumer.accept(i,key);
        }
    }
    private static BiConsumer<Integer,Integer>wrapperLambda (BiConsumer<Integer,Integer> consumer){
        return (v,k)->{
            try{
                consumer.accept(v,k);
            }
            catch (ArithmeticException e){
                System.out.println("Please don't provide k = 0");
            }
        };
    }
}
