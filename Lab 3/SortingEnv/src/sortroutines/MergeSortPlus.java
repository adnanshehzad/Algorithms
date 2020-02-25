package sortroutines;


import runtime.*;
import java.util.*;

public class MergeSortPlus extends Sorter {
    private final int constat_VAL = 20;
    int[] theArray;
    //public sorter
    public int[] sort(int[] input){
        int n = input.length;
        int[] temp = new int[n];
        theArray = input;
        mergeSort(temp,0,n-1);
        return theArray;
    }



    /** Merges the ranges [lowerPointer,upperPointer-1] and [upperPointer,upperBound] in place */
    private void merge(int[] tempStorage, int lowerPointer, int upperPointer, int upperBound) {
        int j = 0; //tempStorage index
        int lowerBound = lowerPointer;
        int n = upperBound - lowerBound + 1; //total number of elements to rearrange

        int mid = upperPointer -1;
        //First while loop to merge the arrays upto the minimim number of array size
        while(lowerPointer <= mid && upperPointer <= upperBound){
            if(theArray[lowerPointer] < theArray[upperPointer]){
                tempStorage[j++] = theArray[lowerPointer++];
            }
            else {
                tempStorage[j++] = theArray[upperPointer++];
            }
        }
        //left array may still have elements -- insert them into tempStorage
        while(lowerPointer <= mid) {
            tempStorage[j++] = theArray[lowerPointer++];
        }
        //right array may still have elements -- insert these into tempStorage
        while(upperPointer <= upperBound){
            tempStorage[j++] = theArray[upperPointer++];
        }
        //replace the range [lowerBound,upperBound] in theArray with
        //the range [0,n-1] just created in tempStorage
        for(j=0; j<n; ++j) {
            theArray[lowerBound+j] = tempStorage[j];
        }

    }


    void mergeSort(int[] tempStorage, int lower, int upper) {
        if(lower==upper){
            return;
        }
        if(upper-lower <= this.constat_VAL){
            insertionSort(lower,upper);
        }
        else {
            int mid = (lower+upper)/2;
            mergeSort(tempStorage,lower,mid);  //sort left half
            mergeSort(tempStorage,mid+1, upper); //sort right half
            merge(tempStorage,lower,mid+1,upper); //merge them
        }
    }

    private void insertionSort(int lower, int upper) {
        if(theArray == null || theArray.length <= 1)
            return;

        int temp = 0;
        int j = 0;
        for(int i = lower; i <= upper; ++i) {
            temp = theArray[i];
            j=i;
            while(j>lower && temp < theArray[j-1]){
                theArray[j] = theArray[j-1];
                j--;
            }
            theArray[j]=temp;
        }
    }
    public static void main(String[] args) {
        int[] input = {1,32,2,1,423,423,12,533,2,14,24,12,1,4,6,23,1,3,2,2,4,5,7,2};
        MergeSortPlus mergeplus = new MergeSortPlus();
        System.out.println(Arrays.toString(input));
        mergeplus.sort(input);
        System.out.println(Arrays.toString(input));
    }


}
