package sortroutines;

import runtime.Sorter;

import java.util.ArrayList;

public class BstSort extends Sorter {
    int[] Array;
    @Override
    public int[] sort(int[] arr) {
        MyBST bst=new MyBST();
        //int [] inputarray=new int[]{6,5,10,2,1,4,7,15,12,18};
        Array=arr;
        int [] sortedarray=new int[Array.length];
        int [] finalarr;
        for(int i = 0; i< Array.length; i++){
            bst.insert(Array[i]);
        }
        finalarr= bst.printTree(sortedarray);
        return finalarr;

    }
}
