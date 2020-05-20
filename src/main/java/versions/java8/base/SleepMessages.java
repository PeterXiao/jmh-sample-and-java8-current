package versions.java8.base;

/**
 * @author xiaoy
 * @date 2020/05/18
 */
public class SleepMessages {
    public static void main(String args[]) throws InterruptedException {
        String importantInfo[] = {"Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too"};

        for (int i = 0; i < importantInfo.length; i++) {
            // Pause for 4 seconds
            Thread.sleep(4000);
            // Print a message
            System.out.println(importantInfo[i]);
        }
    }
}
