import java.util.*;

public class MergeSortAlgorithm {

    // Global array to be sorted
    static int[] a;

    // Main MergeSort function
    static void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(low, mid);        // Sort left half
            mergeSort(mid + 1, high);   // Sort right half
            merge(low, mid, high);      // Merge both halves
        }
    }

    // Merge procedure
    static void merge(int low, int mid, int high) {

        int[] b = new int[a.length];   // Temporary array

        int i = low;       // pointer for left subarray
        int j = mid + 1;   // pointer for right subarray
        int h = low;       // pointer for temp array

        // Compare and copy
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                b[h] = a[i];
                i++;
            } else {
                b[h] = a[j];
                j++;
            }
            h++;
        }

        // Copy remaining left elements
        if (i > mid) {
            for (int k = j; k <= high; k++) {
                b[h] = a[k];
                h++;
            }
        }
        // Copy remaining right elements
        else {
            for (int k = i; k <= mid; k++) {
                b[h] = a[k];
                h++;
            }
        }

        // Copy back to original array
        for (int k = low; k <= high; k++) {
            a[k] = b[k];
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        a = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        mergeSort(0, n - 1);

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}