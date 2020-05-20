package problems;

/**
 * @author xiaoy
 * @date 2020/05/17
 */
public class SynDemo {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (SynDemo.class) {
                    System.out.println("真的有所谓的类锁？");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(500);
        answer();
    }

    synchronized static void answer() {
        System.out.println("答案清楚了吗");
    }
}

// 输出结果
// 真的有所谓的类锁？
// 间隔几秒左右
// 答案清楚了吗
