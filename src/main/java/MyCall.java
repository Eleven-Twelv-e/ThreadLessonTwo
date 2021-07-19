import java.util.concurrent.Callable;

public class MyCall implements Callable<Integer> {
    private final int msgCount ;
    private final String name;

    public MyCall(int msgCount, String name) {
        this.msgCount = msgCount;
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        Thread.currentThread().setName("Thread of  "+name);
        int count = 0;
        try {
            while (count < msgCount) {

                Thread.sleep(2500);
                System.out.println("Hello I am " + Thread.currentThread().getName());
                count++;
            }
        } catch (InterruptedException err) {

        }
        return msgCount;
    }
}
