package design.classes;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {

    private int lSearch(int array[], int key){

        for (int i = 0; i < array.length; i++){
            if(array[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum value in of the array: ");
        int maxElement = scanner.nextInt();
        System.out.println();
        int array[] = new int[maxElement];

        System.out.print("Enter the elements: ");
        for (int i = 0; i < array.length; i++){
            int elements = scanner.nextInt();
            array[i] = elements;
        }
        System.out.println("Given Array: " + Arrays.toString(array));
        System.out.println();
        System.out.print("Enter the value to be searched: ");

        int key = scanner.nextInt();
        int result = linearSearch.lSearch(array,key);
        if (result == -1){
            System.out.println();
            System.out.println("Element " + key + " is not found");
        }else {
            System.out.println("Element " + key + " is found at index " + result);
        }
    }

}
