public class ClosuresInLambda {
    int a=10;
    public static void main(String[] args) {
        int a=10;
        int b=20;
        /*doProcess(a, new process() {
            @Override
            public void process(int i) {
                System.out.println(i+b);
            }
        });
         */
        //doProcess(a,i -> System.out.println(i+b));

        ClosuresInLambda CIL =new ClosuresInLambda();
        /*CIL.doProcess(a, new process() {
            @Override
            public void process(int i) {
                System.out.println("value of a is : "+i);
                System.out.println(this); //this reference is the instance of anonymous innerclass that we created
            }

            @Override
            public String toString() {
                return "This is an anonymous inner class.";
            }
        });
         */
        CIL.execute();
    }
    private void execute(){
        doProcess(a,i -> {
            System.out.println("value of a is : "+i);
            System.out.println(this);
        });
    }

    @Override
    public String toString() {
        return "This is the main ClosureInLambda class instance.";
    }

    private void doProcess(int i, process p){
        p.process(i);
    }

    interface process{
        void process(int i);
    }
}
