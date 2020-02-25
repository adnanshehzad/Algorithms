package sortroutines;

import java.util.Arrays;

class ZeroesAndOnes {

    //input is sorted array of 0s and 1s
    public static int[] findNum0s1s(int[] input) {
        int[] retval = new int[2];
        if(input.length == 0) {
            retval[0] = 0;
            retval[1] = 0;
            return retval;
        }
        else if(input[0] == 1) { //must be all 1s since sorted
            retval[0] = 0;
            retval[1] = input.length;
            return retval;
        }
        else if(input[input.length-1] == 0) { //must all be 0s
            retval[1] = 0;
            retval[0] = input.length;
            return retval;
        }
        return recursezeroesandones(input, 0, input.length-1);
    }
    private static int[] recursezeroesandones(int[] A,int lower, int upper) {

        int[] retarray = new int[2];
        int mid = (upper + lower)/2;
        if(A[mid] == 0 && A[mid+1] == 1) {
            retarray[0] = mid +1;
            retarray[1] = A.length - (mid+1);
            return retarray;
        }
        if(A[mid] == 0 && A[mid+1] == 0) {
            return recursezeroesandones(A, mid+1, upper);
        }
        if (A[mid] == 1) {
            return recursezeroesandones(A, lower, mid -1);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] test1 = {0,0,0,0,0,0,1,1,1,1};
        System.out.println(Arrays.toString(findNum0s1s(test1)));
    }

}