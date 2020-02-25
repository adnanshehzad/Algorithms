package sortroutines;

import runtime.Sorter;

import java.util.Arrays;

public class BubbleSort1 extends Sorter {
    int[] arr;
    public int[] sort(int[] array){
        this.arr = array;
        bubbleSort1();
        return arr;

    }
    private void bubbleSort1(){
        int len = arr.length;
        boolean flag;
        for(int i = 0; i < len; ++i) {
            flag=false;
            for(int j = 0; j < len-1; ++j) {
                if(arr[j]> arr[j+1]){
                    swap(j,j+1);
                    if (flag!=true)flag=true;
                }
            }
            if (flag==false)
                break;
        }
    }

    int[] swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;

    }
    public static void main(String[] args){
        int[] test = {21,13,1,-22, 51, 5, 18};
        int[] test1 = {1,2,3,4,5,6,7,8,9,10}; //Sorted Array
        BubbleSort1 bs1 = new BubbleSort1();
        System.out.println(Arrays.toString(bs1.sort(test1)));
    }
}
