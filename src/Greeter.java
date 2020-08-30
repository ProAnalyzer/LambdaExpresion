public class Greeter {
    private void greet(Greeting greeting){
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();

        Greeting helloWorldGreeting = new HelloWorldGreeting();
        greeter.greet(helloWorldGreeting);

        Greeting innerClassGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Inner Class Hello World ! ");
            }
        };
        innerClassGreeting.perform();

        greeter.greet(innerClassGreeting);

        Greeting myLambda = () -> System.out.println("Hello World ! ");
        myLambda.perform();

        printLength(s -> s.length());
    }

    private static void printLength(StringLength l) {
        System.out.println(l.getLength("Hello World ! "));
    }
    interface StringLength{
        int getLength(String s);
    }
}
