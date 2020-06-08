package algorithms.sort.common;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class TaskScheduler {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Runnable runnable = ()-> {
                // task to run goes here
                System.out.println("Hello !!");
        };
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);

    }

}
