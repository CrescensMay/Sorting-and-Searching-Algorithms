package design.classes;

import java.util.*;

public class QuickSort {

    private int partition(int[] array, int first, int last) throws InterruptedException {
        int pivot = array[last];
        int i = first - 1;
        for (int j = first; j < last; j++){
           if(array[j] <= pivot){
               i++;
               System.out.println(array[j] + " is smaller(equal) than " + pivot);
               int temp = array[i];
               array[i] = array[j];
               array[j] = temp;
               System.out.println("Swapping " + array[i] + " index(" + j + ") and " + array[j] + " index(" + i + ")");
               System.out.println("=> " + Arrays.toString(array));
               System.out.println();
           }else {
               System.out.println(array[j] + " is greater than " + pivot);
               System.out.println("Nothing happens.");
               System.out.println("Same as previous => " + Arrays.toString(array));
               System.out.println();
           }
        }
        System.out.println("After the loop's done => " + Arrays.toString(array));
        int temp = array[i+1];
        array[i+1] = array [last];
        array[last] = temp;
        System.out.println("Finally putting " + array[i+1] +" at the right position by Swapping " + array[i+1] + " and " + array[last]);
        System.out.println("=> " + Arrays.toString(array));
        System.out.println();
        Thread.sleep(200);

        return i + 1;
    }

    private void qSort(int[] array, int first, int last) throws InterruptedException {
        if(first < last){
            int part = partition(array, first, last);
            qSort(array, first,part-1);
            qSort(array, part+1, last);
        }
    }

    private void display(int[] array){
        System.out.print("[");
        for (int anArray : array) {
            System.out.print(anArray + ", ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) throws InterruptedException {
        QuickSort quickSort = new QuickSort();
//        Set<Integer> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++){
            int element = random.nextInt(array.length) + 1;
            array[i] = element;
        }
//        for (int element: array){
//            set.add(element);
//        }
        System.out.println();
        System.out.println("Generating a random array of range (1-" + size + ")...");
        Thread.sleep(2000);
        System.out.println("=> " + Arrays.toString(array));
        System.out.println("Value " + array[array.length - 1] + " is chosen as pivot");
        System.out.println("First = " + 0 + " ,Last = " + (array.length-1) + " ,Pivot = " + array[array.length - 1] + " sent to be partitioned.");
        System.out.println();
        System.out.println();
        long startTime = System.currentTimeMillis();
        quickSort.qSort(array, 0, array.length-1);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        double totalInSecond = totalTime / 1000.0;
        System.out.println("Total time to go through the loop: " + totalInSecond + "s");
        System.out.println();
        System.out.print("Here is the sorted array: ");
        quickSort.display(array);
        System.out.println();
//        System.out.println();
//        System.out.print("After Sorting Without Duplicates: " + set);
        System.out.println();

    }
}
