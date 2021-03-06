package algorithms.sort.base;


import java.util.Arrays;

/* TODO:
- ci: TIME on target enviornment and send back report
- make methods generic?
*/

// in big o notation ignore minor details in order of simplicity of most dominant factor:
// e.g: o(n2) will over-shadow o(n2 + n*2 + 10)
public class Sort{
  public static void main(String[] args){ }

  // big o-notation: n squared(can reduce to n * log(n)?)

  //   - TIME COMPLEXITY - BUBBLE SORT -
  //  | worst case: o(n2)               |
  //  | average case: o(n2)             |
  //  | best case: o(n)                 |
  //   ---------------------------------
  public static int[] bubble(int[] input){
    // remember java methods are parsed by value of reference?
    int[] output = copyArr(input);

    // int[] temp = int[arr.length];
    for(int i = 0; i < output.length - 1; i++)
      for(int j = i + 1; j < output.length; j++)
        if(output[i] > output[j]){
          //swap
          int temp = output[i];
          output[i] = output[j];
          output[j] = temp;
        }
    return output;
  }

  //   - TIME COMPLEXITY - SELECTION SORT -
  //  | worst case: o(n2)                  |
  //  | average case: o(n2)                |
  //  | best case: o(n2)                   |
  //   ------------------------------------
  public static int[] selection(int[] input){
    int[] output = copyArr(input);
    int min = 0; //min index
    int temp;
    for(int i = 0; i < output.length - 1; i++){
      min = i;
      for(int j = i + 1; j < output.length; j++){
        if(output[min] > output[j]){
          min = j;
        }
      }
      // swap
      temp = output[i];
      output[i] = output[min];
      output[min] = temp;
    }
    return output;
  }

  // worst, average and  best case scenario: O(n x log(n))

  //   - TIME COMPLEXITY - MERGE SORT -
  //  | worst case: o(n*log(n))        |
  //  | average case: o(n*log(n))      |
  //  | best case: o(n*log(n))         |
  //   --------------------------------
  public static int[] merge(int[] input){
    // anonymous inner class
    return new MergeSort(){

      public int[] divide(int[] input){
        if(input.length < 2) // can't be divided anymore
          return input;
        int[] arrLeft = new int[input.length / 2];
        int[] arrRight = new int[input.length / 2];

        for(int j = 0; j < arrLeft.length; j++){
          arrLeft[j] = input[j];
        }

        for(int i = 0; i < arrRight.length; i++){
          arrRight[i] = input[input.length / 2 + i];
        }

        int[] left = this.divide(arrLeft);
        int[] right = this.divide(arrRight);
        return doMerge(left, right);
      }

      public int[] doMerge(int[] left, int[] right){
        int[] temp = new int[left.length + right.length];

        int l = 0;
        int r = 0;
        for(int i = 0; i < temp.length; i++){
          if((r >= right.length) || (l < left.length && left[l] <= right[r])){
            temp[i] = left[l];
            l++;
          }else{
            temp[i] = right[r];
            r++;
          }
        }

        return temp;
      }
    }.divide(input);
  }

  // quick-sort sorts the array in place though mutations and no copies

  //   - TIME COMPLEXITY - QUICK SORT -
  //  | worst case: o(n2)              |
  //  | average case: o(n*log(n))      |
  //  | best case: o(n*log(n))         |
  //   --------------------------------
  public static int[] quick(int[] arr){
    int[] copyOfArr = copyArr(arr); // this will make the quickSort pure without mutating original array

    new QuickSort(){

      // Lomuto partition scheme  :  https://en.wikipedia.org/wiki/Quicksort
      @Override
      public int partition(int[] arr, int startIndex, int endIndex) {
        int valOfPivot = arr[endIndex];
        int i = startIndex;
        for(int j = startIndex; j < endIndex; j++){
          if(arr[j] < valOfPivot){
            swap(arr, j, i);
            i++;
          }
        }

        // swap val of pivot with i, return index of i
        swap(arr, i, endIndex);
        return i;
      }

      @Override
      public void sort(int[] arr, int startIndex, int endIndex, String description) {
        if(startIndex < endIndex){
          System.out.println(description); 
          int pivotIndex = this.partition(arr, startIndex, endIndex);
          sort(arr, startIndex, pivotIndex - 1, "left");
          sort(arr, pivotIndex + 1, endIndex, "right");
        }
      }
    }.sort(copyOfArr, 0, copyOfArr.length - 1, "initial");

    return copyOfArr;
  }

  private interface QuickSort{
    int partition(int[] arr, int startIndex, int endIndex);
    void sort(int[] arr, int startIndex, int endIndex, String description);
  }

  private interface MergeSort{
    int[] divide(int[] arr);
    int[] doMerge(int[] left, int[] right);
  }

  public static int[] copyArr(int[] input){
    int[] output = new int[input.length];
    System.arraycopy(input, 0, output, 0, output.length);
    return output;
  }

  public static void swap(int[] arr, int indexA, int indexB){
     int temp = arr[indexA];
     arr[indexA] = arr[indexB];
     arr[indexB] = temp;
  }
}
