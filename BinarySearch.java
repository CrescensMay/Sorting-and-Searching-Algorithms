package design.classes;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

     private int bSearch(int[] array, int key){

        int low = 0;
        int high = array.length - 1;

        while(high >= low ){

            int middle = (low + high) / 2;
            if (key == array[middle]){
                return middle;
            }
            if(key > array[middle]) {
                low = middle + 1;
            }else {
                high = middle -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum value in of the array: ");
        int maxElement = scanner.nextInt();
        System.out.println();
//        int array[] = {1,2,4,5,3,0,7,6,9,8,14,12,11,10,15};
        int array[] = new int[maxElement];

        System.out.print("Enter the elements: ");
        for (int i = 0; i < array.length; i++){
            int elements = scanner.nextInt();
            array[i] = elements;
        }
        System.out.print("Unsorted given Array: " + Arrays.toString(array));
        System.out.println();
//        Arrays.sort(array);better do it programmatically
//        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++){
            for (int j = i; j < array.length; j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.print("Sorted given Array: " + Arrays.toString(array));
        System.out.println("\n");
        System.out.print("Enter the value to be searched: ");

        int key = scanner.nextInt();
        int result = binarySearch.bSearch(array,key);
        if (result == -1){
            System.out.println();
            System.out.println("Element " + key + " is not found");
        }else {
            System.out.println("Element " + key + " is found at index " + result);
        }
    }

}