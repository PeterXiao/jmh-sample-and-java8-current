package versions.java8.base;

/**
 * @author xiaoy
 * @date 2020/05/18
 */
public class HelloThread extends Thread {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new HelloThread()).start();

    }

}
/*
支持中断
线程如何支持自己的中断？这取决于它目前正在做什么。如果线程经常调用抛出 InterruptedException 的方法，它只需在捕获该异常后从 run 方法返回。例如，假设 SleepMessages 示例中的中央消息循环位于线程的 Runnable 对象的 run 方法中。然后可以按如下方式修改它以支持中断：

for (int i = 0; i < importantInfo.length; i++) {
    // Pause for 4 seconds
    try {
        Thread.sleep(4000);
    } catch (InterruptedException e) {
        // We've been interrupted: no more messages.
        return;
    }
    // Print a message
    System.out.println(importantInfo[i]);
}
抛出 InterruptedException 的许多方法，例如 sleep，旨在取消当前操作并在收到中断时立即返回。

如果一个线程长时间没有调用抛出 InterruptedException 的方法怎么办？那么它必须定期调用 Thread.interrupted，如果收到中断，则该方法返回 true。例如：

for (int i = 0; i < inputs.length; i++) {
    heavyCrunch(inputs[i]);
    if (Thread.interrupted()) {
        // We've been interrupted: no more crunching.
        return;
    }
}
在这个简单的例子中，代码只是测试中断，如果收到则退出线程。在更复杂的应用程序中，抛出 InterruptedException 可能更有意义：

if (Thread.interrupted()) {
    throw new InterruptedException();
}
这允许中断处理代码集中在 catch 子句中。
*/