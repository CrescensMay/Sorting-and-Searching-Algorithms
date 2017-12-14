package design.classes;

import java.util.Scanner;

public class BubbleSort {
    private void bSort(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = i; j < array.length; j++){
                if(array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private void displayArray(int[] array){
        System.out.print("[");
        for (int anArray : array) {
            System.out.print( anArray + " ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum number of element: ");
        int maxElements = scanner.nextInt();
        System.out.println();
        int[] array = new int[maxElements];
        System.out.print("Enter the elements: ");
        System.out.println();
        for (int i = 0; i < maxElements; i++){
            int elements = scanner.nextInt();
            array[i] = elements;
        }
//        int[] array = {106,119,5,31,70,42,140,13,21,108,186,30,141,69,91,78,1, 100, 50, 75, 12, 89, 51, 11, 28, 99, 4,2,110, 6, 8, 10,1, 3, 5, 7, 9};
        System.out.println();
        bubbleSort.bSort(array);
        System.out.print("Sorted Array: ");
        bubbleSort.displayArray(array);
    }

}
