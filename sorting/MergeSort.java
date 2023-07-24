package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int[] aux, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, aux, left, mid);
        mergeSort(arr, aux, mid + 1, right);
        merge(arr, aux, left, mid, right);
    }

    public static void merge(int[] arr, int[] aux, int left, int mid, int right) {
        // copy to aux
        for (int i = 0; i < arr.length; i++) {
            aux[i] = arr[i];
        }

        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (aux[i] <= aux[j]) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
            }
        }

        while (i <= mid) arr[k++] = aux[i++];
        while (j <= right) arr[k++] = aux[j++];
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1, 3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 5, 6]
    }
}
