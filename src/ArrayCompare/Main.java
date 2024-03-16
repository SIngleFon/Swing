package ArrayCompare;
import ArrayCompare.ArrayCompare;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        Integer[] arr1 = {1, 2, 4, 3};
        String[] arr2 = {"Text", "Field", "Thunder"};
        String[] arr3 = {"Text", "Field"};
        Object[] arr4 = {"Text", "Field", "Thunder"};
        Object[] arr5 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(arr) + " + " + Arrays.toString(arr5) + " = " + ArrayCompare.compareArrays(arr, arr5));
        System.out.println(Arrays.toString(arr1) + " + " + Arrays.toString(arr5) + " = " + ArrayCompare.compareArrays(arr1, arr5));
        System.out.println(Arrays.toString(arr2) + " + " + Arrays.toString(arr3) + " = " + ArrayCompare.compareArrays(arr2, arr3));
        System.out.println(Arrays.toString(arr4) + " + " + Arrays.toString(arr2) + " = " + ArrayCompare.compareArrays(arr4, arr2));
        System.out.println(Arrays.toString(arr5) + " + " + Arrays.toString(arr2) + " = " + ArrayCompare.compareArrays(arr5, arr2));


    }
}
