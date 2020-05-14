package algorithms.sort.common;



import algorithms.sort.SortAlgorithm;
import static algorithms.sort.common.SortUtils.*;

import org.openjdk.jmh.annotations.Benchmark;

public class BubbleSort_plus implements SortAlgorithm {
    /**
     * This method implements the Generic Bubble Sort
     *
     * @param array The array to be sorted
     * Sorts the array in increasing order
     **/

    @Override
    public  <T extends Comparable<T>> T[] sort(T array[]) {
    	
    	
        int last = array.length;
        //Sorting
        boolean swap;
       T temp;//临时变量
 	   boolean flag;//是否交换的标志
 	   for(int i=0; i<array.length-1; i++){   //表示趟数，一共 arr.length-1 次

 	       // 每次遍历标志位都要先置为false，才能判断后面的元素是否发生了交换
 	       flag = false;
 	       
 	       for(int j=array.length-1; j>i; j--){ //选出该趟排序的最大值往后移动

 	           if(less(array[j] , array[j-1])){
 	        	  swap = swap(array, j, j-1);
 	               flag = true;    //只要有发生了交换，flag就置为true
 	           }
 	       }
 	       // 判断标志位是否为false，如果为false，说明后面的元素已经有序，就直接return
 	       if(!flag) break;
 	   }

        return array;
    }
    


    // Driver Program
    public static void main(String[] args) {

        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        BubbleSort_plus bubbleSort = new BubbleSort_plus();
        bubbleSort.sort(integers);

        // Output => 231, 78, 54, 23, 12, 9, 6, 4, 1
        print(integers);

        // String Input
        String[] strings = {"c", "a", "e", "b","d"};
        //Output => e, d, c, b, a
        print(bubbleSort.sort(strings));

    }
    
    
    // Driver Program
    @Benchmark
    public static void test() {

        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        BubbleSort_plus bubbleSort = new BubbleSort_plus();
        bubbleSort.sort(integers);

        // Output => 231, 78, 54, 23, 12, 9, 6, 4, 1
       // print(integers);

        // String Input
        String[] strings = {"c", "a", "e", "b","d"};
        //Output => e, d, c, b, a
      //  print(bubbleSort.sort(strings));
    	
    }
    
}