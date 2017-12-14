package design.classes;

import java.util.*;

public class MergeSort {
    private void merge(int[] array, int low, int middle, int high){
        //finding size of the subArrays to be merged
        int subLeft = middle - low + 1;
        int subRight = high - middle;

        //create temporary arrays
        int[] subLeftArray = new int[subLeft];
        int[] subRightArray = new int[subRight];

        //copy data into temporary arrays
        for (int i = 0; i < subLeft; i++){
            subLeftArray[i] = array[low + i];
        }
        for (int j = 0; j < subRight; j++){
            subRightArray[j] = array[middle + 1 + j];
        }
        //merge temporary arrays
        //initial indexes of merged subArray
        int i = 0;
        int j = 0;

        //initial index of merged subArray
        int k = low;
        while (i < subLeft && j < subRight){
            if(subLeftArray[i] <= subRightArray[j]){
                array[k] = subLeftArray[i];
                i++;
            }else {
                array[k] = subRightArray[j];
                j++;
            }
            k++;
        }
        //copy remaining elements of subLeftArray[]
        while (i < subLeft){
            array[k] = subLeftArray[i];
            i++;
            k++;
        }

        //copy remaining elements of subRightArray[]
        while (j < subRight){
            array[k] = subRightArray[j];
            j++;
            k++;
        }
    }

    private void mSort(int[] array, int low, int high){
        if (low < high){
            int middle = (low + high) / 2;
            mSort(array, low, middle);
            mSort(array, middle + 1, high);
            merge(array, low, middle, high);
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
        MergeSort mergeSort = new MergeSort();
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
        System.out.println();
        System.out.println();
        long startTime = System.currentTimeMillis();
        mergeSort.mSort(array, 0, array.length-1);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        double totalInSecond = totalTime / 1000.0;
        System.out.println();
        System.out.print("Here is the sorted array: ");
        mergeSort.display(array);
        System.out.println();
        System.out.println("Total time to go through the loop: " + totalInSecond + "s");
//        System.out.println();
//        System.out.print("After Sorting Without Duplicates: " + set);
        System.out.println();

    }
}
