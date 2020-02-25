package sortroutines;

import java.util.Arrays;

public class countZerosOnesTwos {
    public static void main(String[] args){
        countZerosOnesTwos main=new countZerosOnesTwos();
        int[] input={0,0,1,2,2,2,1,1,0};
        int [] finalsortedarray=main.countZerosOne(input);
        for (int i=0;i<finalsortedarray.length;i++)
            System.out.println(finalsortedarray[i]);
    }
    public int[] countZerosOne(int [] arr){
        int noofzeroes=0;
        int noofones=0;
        int nooftwos=0;
        int temp;
        if(arr.length==0 || arr==null)
            return null;
        for(int i=0;i<arr.length;i++){
            temp=arr[i];
            if(temp==0)
                noofzeroes++;
            else if (temp==1)
                noofones++;
            else
                nooftwos++; // Assuming that the array contains onlu 0,1 and 2
        }
        for (int j=0;j<arr.length;j++){
            if (noofzeroes>0){
                arr[j]=0;
                noofzeroes--;
            }
            else if(noofones>0){
                arr[j]=1;
                noofones--;
            }
            else if(nooftwos>0){
                arr[j]=2;
                nooftwos--;
            }
            else
                System.out.println("Empty array");
        }
        return arr;
    }
}
