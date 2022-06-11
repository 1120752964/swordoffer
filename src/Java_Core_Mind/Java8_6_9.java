package Java_Core_Mind;

import java.util.ArrayList;

public class Java8_6_9 {
    public static void main(String[] args) {
//      var x = new ArrayList:ArrayList<String>;
        var thread = new Thread(Task.asRunnable(()->{
            Thread.sleep(1000);
            System.out.println("hello world");
            throw new Exception("Check this out!");
        }));
        thread.start();
    }
}
interface Task{
    void run() throws Exception;

    @SuppressWarnings("unchecked")
    static <T extends Throwable> void throwAs(Throwable t) throws T{
        throw (T) t;
    }

    static Runnable asRunnable(Task task){
        return ()->{
            try {
                task.run();
            }catch (Exception e){
                Task.<RuntimeException>throwAs(e);
            }
        };
    }
}