import java.util.*;

public class QuickSortAlgorithm {

    int[] a;   // instance variable

    void quickSort(int low, int high) {
        if (low < high) {
            int j = partition(low, high);
            quickSort(low, j - 1);
            quickSort(j + 1, high);
        }
    }

    int partition(int low, int high) {

        int pivot = a[low];
        int i = low + 1;
        int j = high;

        while (i <= j) {

            while (i <= high && a[i] <= pivot) {
                i++;
            }

            while (a[j] > pivot) {
                j--;
            }

            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        a[low] = a[j];
        a[j] = pivot;

        return j;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        QuickSortAlgorithm obj = new QuickSortAlgorithm();
        obj.a = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            obj.a[i] = sc.nextInt();
        }

        obj.quickSort(0, n - 1);

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(obj.a[i] + " ");
        }
    }
}