package algorithms.sortsend;

/**
 * @author xiaoy
 * @date 2020/05/12
 */
public class BubbleSort {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int temp[] = {13, 52, 3, 5, 16, 29};
        // 执行temp.length次
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length - i - 1; j++) {
                if (temp[j] > temp[j + 1]) { // 前一个数和后一个数比较
                    int a = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = a;
                }
            }
        }

        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }
}
