package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

public class FurtherCodingPracticeProblems {

    public static void main(String[] args) {
        // print hello world
        System.out.println("Input: 2,4,5,6,7,8,10,35");
        int[] arr = {2,4,5,6,7,8,10,35};
        printHelloWorld(arr);

        // find second biggest
        System.out.println("Find second biggest");
        System.out.println("Input 1: 1,2,3,4,5");
        int[] arr2 = {1,2,3,4,5};
        System.out.println(findSecondBiggest(arr2));
        System.out.println("Input 1: 19,9,11,0,12");
        int[] arr3 = {19,9,11,0,12};
        System.out.println(findSecondBiggest(arr3));
    }

    public static void printHelloWorld(int[] array) {
        for(int i = 0; i < array.length; i++){
            if(array[i] % 5 == 0 && array[i] % 7 == 0){
                System.out.println("HelloWorld");
            }
            else{
                if(array[i] % 5 == 0){
                    System.out.println("Hello");
                }
                if(array[i] % 7 == 0){
                    System.out.println("World");
                }
            }
        }
    }

    public static int findSecondBiggest(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }
        int max = array[0];
        int secMax = array[1];
        for(int i = 1; i < array.length; i++){
            if(array[i] > max){
                secMax = max;
                max = array[i];
            }
            if(array[i] < max && array[i] > secMax){
                secMax = array[i];
            }

        }

        return secMax;
    }
}
