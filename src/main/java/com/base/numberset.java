package com.base;

/**
 * @author xiaoy
 * @date 2020/05/14
 */
public class numberset {

    /**
     * @param args
     * 
     *            两种格式的含义是一样的。
     * 
     *            直接给每个元素赋值 : int array[4] = {1,2,3,4}; 给一部分赋值，后面的都为 0 ： int array[4] = {1,2}; 由赋值参数个数决定数组的个数 ： int
     *            array[] = {1,2};
     * 
     * 
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] a1;

        // 或者

        int a11[];

    }

    public int add(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

}
