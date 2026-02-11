import java.util.*;

public class MergeSortAlgorithm {

    int[] a;   // instance array

    // Merge Sort function
    void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    // Merge function
    void merge(int low, int mid, int high) {

        int[] b = new int[a.length];   // temporary array

        int i = low;
        int j = mid + 1;
        int h = low;

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

        // Copy remaining elements
        if (i > mid) {
            for (int k = j; k <= high; k++) {
                b[h] = a[k];
                h++;
            }
        } else {
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

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        MergeSortAlgorithm obj = new MergeSortAlgorithm();
        obj.a = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            obj.a[i] = sc.nextInt();
        }

        obj.mergeSort(0, n - 1);

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(obj.a[i] + " ");
        }
    }
}