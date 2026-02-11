import java.util.Scanner;
//Max Heap and Min Heap implementation used to show heap data structure
class Heap {
    int arr[];
    int size;
    boolean isMinHeap;

    // Constructor
    Heap(int capacity, boolean isMinHeap) {
        arr = new int[capacity];
        size = 0;
        this.isMinHeap = isMinHeap;
    }

    // Insert element
    void insert(int value) {
        arr[size] = value;
        int i = size;
        size++;

        while (i > 0 && compare(arr[i], arr[(i - 1) / 2])) {
            int temp = arr[i];
            arr[i] = arr[(i - 1) / 2];
            arr[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
    }

    // Delete element
    void delete(int value) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Element not found");
            return;
        }

        arr[index] = arr[size - 1];
        size--;
        heapify(index);
    }

    // Heapify function
    void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int selected = i;

        if (left < size && compare(arr[left], arr[selected]))
            selected = left;

        if (right < size && compare(arr[right], arr[selected]))
            selected = right;

        if (selected != i) {
            int temp = arr[i];
            arr[i] = arr[selected];
            arr[selected] = temp;
            heapify(selected);
        }
    }

    // Comparison for Min/Max
    boolean compare(int child, int parent) {
        if (isMinHeap)
            return child < parent;
        else
            return child > parent;
    }

    // Display heap
    void display() {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

public class HeapProgram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        Heap minHeap = new Heap(n, true);
        Heap maxHeap = new Heap(n, false);

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            minHeap.insert(value);
            maxHeap.insert(value);
        }

        System.out.println("\nMin Heap:");
        minHeap.display();

        System.out.println("Max Heap:");
        maxHeap.display();

        System.out.print("\nEnter element to delete: ");
        int key = sc.nextInt();

        minHeap.delete(key);
        maxHeap.delete(key);

        System.out.println("\nMin Heap after deletion:");
        minHeap.display();

        System.out.println("Max Heap after deletion:");
        maxHeap.display();

        sc.close();
    }
}
