package sortroutines;

import java.util.Arrays;

import runtime.Sorter;

public class SelectionSort extends Sorter {
	int[] arr;
	
	public int[] sort(int[] arr){
		this.arr = arr;
		selectionSort();
		return arr;
	}
	
	private void selectionSort(){
		if(arr == null || arr.length <=1) return;
		int len = arr.length;
		
		for(int i = 0; i < len; ++i){
			int nextMinPos = minpos(i,len-1);
			swap(i,nextMinPos); 
		}
		
	}
	void swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	//find minimum of arr between the indices bottom and top
	private int minpos(int bottom, int top){		
		int m = arr[bottom];
		int index = bottom;
		for(int i = bottom+1; i <= top; ++i){
			if(arr[i]<m){ 
				m = arr[i];
				index = i;
			}
		}
		//return location of min, not the min itself
		return index;
	}
	public static void main(String[] args){
		int[] test = {21,13,1,-22, 51, 5, 18};
		SelectionSort ss = new SelectionSort();
		
		System.out.println(Arrays.toString(ss.sort(test)));
		
	}
}