package mergearrays;

public class Solution {
    public static int[] mergeArrays(int[] arr1, int[] arr2) 
    {  
      int arr1Pointer = 0;
      int arr2Pointer = 0;
      int[] mergedArr = new int[arr1.length + arr2.length];
      int i = 0;
      while (arr1Pointer < arr1.length && arr2Pointer < arr2.length) {
        if (arr1[arr1Pointer] < arr2[arr2Pointer]) {
            mergedArr[i++] = arr1[arr1Pointer++];
        } else {
            mergedArr[i++] = arr2[arr2Pointer++];
        }
      }

      while (arr1Pointer < arr1.length) {
        mergedArr[i++] = arr1[arr1Pointer++];
      }

      while (arr2Pointer < arr2.length) {
        mergedArr[i++] = arr2[arr2Pointer++];
      }
      return mergedArr;
    } 

    public static void main(String[] args) {
        int[] arr1 = new int[]{4,5,6};
        int[] arr2 = new int[]{-2,-1,0,7};
        int[] result = mergeArrays(arr1, arr2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
