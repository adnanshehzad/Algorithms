package util;

public class RandomPermutations {
	//slow way
	static int[] nextArray1(int n){
		int[] retVal = new int[n];
		int next = 0;
		for(int i = 0; i < n; ++i){
			do {
				next = RandomNumbers.getRandomInt(0,n-1);
			}
			while(contains(retVal,next));
			retVal[i] = next;
		}
		return retVal;
		
	}
	static boolean contains(int[] arr, int x){
		for(int i = 0; i < arr.length; ++i){
			if(arr[i]==0) return false;
			if(arr[i] == x) return true;
		}
		return false;
	}
	
	//fast way
	//it's in-place, so no need to create new array
	//returns a random permutation of 0..n-1
	public static int[] nextArray2(int n){
		int[] retVal = new int[n];
		for(int i = 0; i < n; ++ i){
			retVal[i] = i;
		}
		for(int i = 0; i < n; ++i){
			swap(retVal,i, RandomNumbers.getRandomInt(i,n-1));
			
		}
		return retVal;
		
	}
	//this is faster than permute
	public static int[] permute2(int[] arr){
		if(arr == null || arr.length==0) return arr;
		int[] retVal = new int[arr.length];
		for(int i = 0; i < arr.length; ++i){
			swap(retVal,i, RandomNumbers.getRandomInt(i,arr.length-1));
			
		}
		return retVal;		
	}
	static void swap(int[] arr, int index1, int index2){
		int temp = arr[index1];
		arr[index1]=arr[index2];
		arr[index2] = temp;
	}
	//uses the random perm alg to permute elements of array
	public static int[] permute(int[] arr){
		int[] indices = nextArray2(arr.length);
		return applyPermutation(indices,arr);
	}
	
	public static int[] applyPermutation(int[] indices, int[] arr) {
		if(indices == null || arr == null || arr.length != indices.length){
			System.out.println("Input to applyPermutation is invalid -- returning initial array.");
			return arr;
		}
		int[] retVal = new int[arr.length];
		for(int i = 0; i < arr.length; ++i) {
			retVal[i] = arr[indices[i]];
		}
		return retVal;
	}
	
	public static void main(String[] args){
		long start1 = time();
		nextArray1(100000);
		long end1 = time();
		long start2 = time();
		nextArray2(100000);
		long end2 = time();
		System.out.println("First Way: "+(end1-start1));
		System.out.println("Second Way: "+(end2-start2));
		
		
		
	}
	public static long time() {
		return System.currentTimeMillis();
	}
}
