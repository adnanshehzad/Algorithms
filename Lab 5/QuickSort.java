package sortroutines;
import runtime.*;
import java.util.Arrays;

public class QuickSort extends Sorter {
	
	//public sorting method
	public int[] sort(int[] arr){
		int[] prepared = prepare(arr);
		qsort(prepared,1, prepared.length-2);
		return prepared;
	}
	
	
	public static void main(String[] args){
		QuickSort qs = new QuickSort();
		int[] input = {4, 10, 7, 3, 9, 5, 2, 8, 1, 6};
		
		System.out.println(Arrays.toString(input));
		int[] result = qs.sort(input);
		
		System.out.println(Arrays.toString(result));		
	}
	private void printPrepared(int[] prep){
		System.out.print("[");
		for(int i = 1; i < prep.length-2; ++i) {
			System.out.print(""+prep[i]+", ");
		}
		System.out.println(prep[prep.length-2]+"]");
	}
	/* Insert a lower and upper sentinel */
	private int[] prepare(int[] input){
		int[] prepared = new int[input.length+2];
		prepared[0]=Integer.MIN_VALUE;
		prepared[input.length+1] = Integer.MAX_VALUE;
		for(int i=0; i < input.length;++i){
			prepared[i+1]=input[i];
		}	
		return prepared;
	}
	/* Return the array with sentinels removed */
	private int[] returnPrepared(int[] prep){
		int[] retVal = new int[prep.length-2];
		for(int i = 1; i <=retVal.length; ++i){
			retVal[i-1]= prep[i];
		}
		return retVal;
	}
	

	private void qsort(int[] keyArray, int lower, int upper) {
		int lowPtr, highPtr;		// these are the moving pointers into the array
		int temp;
				
		if (upper <= lower) {
			return;			// base case
		} 
		else {
			//locate position of pivot
			int pivotPos = medianOfThree(keyArray,lower,upper);
			
			//swap pivot to last position
			swap(keyArray,pivotPos,upper);
			
			//pivot is now in rightmost slot
			int pivot = keyArray[upper];
			
			//define the pointers
			lowPtr = lower;
			highPtr = upper-1;
			
			//use the pointers to create the partitions in the array
			
			while (true) {
				while (keyArray[lowPtr] < pivot && lowPtr<=highPtr) lowPtr++;
				while (keyArray[highPtr] > pivot && lowPtr <= highPtr) highPtr--;			
				if(lowPtr <= highPtr) {
					swap(keyArray, lowPtr++,highPtr--);
				}
				else break;
			}
			
			
			//restore pivot to correct spot
			swap(keyArray, upper,lowPtr);
			
			
			qsort(keyArray,lower, lowPtr-1);
			qsort(keyArray,lowPtr+1, upper);
		}
	}
	private void swap(int[] arr, int i, int j){
		if(arr == null || i == j || i >= arr.length || j >=arr.length) return;
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j] = temp;
		
	}
	/** returns the position of the median of first, last, and middle array elements */
	private int medianOfThree(int[] arr, int left, int right){
		if(right-left < 2) return left;
		int center = (left+right)/2;
		//arrange the three
		if(arr[center] < arr[left]) swap(arr,center,left);
		if(arr[right] < arr[left]) swap(arr,right,left);
		if(arr[right] < arr[center]) swap(arr,right,center);
		return center;
		
	}

}
