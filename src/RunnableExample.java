public class RunnableExample {
    public static void main(String[] args) {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed inside Runnable");
            }
        });
        th.run();

        Thread myLambdaThread = new Thread(() -> System.out.println("Printed inside Runnable but using Lambda Expression"));
        myLambdaThread.run();

    }
}
