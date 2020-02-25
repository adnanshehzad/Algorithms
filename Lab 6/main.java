package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class Fibonacci {
public static void main(String args[]){
    Fibonacci main=new Fibonacci();
    int result=main.recFibonacci(7);
    System.out.println("The result for Fibonacci series using recursion is : "+ result);
    int res=main.iterativeFibonacci(7);
    System.out.println("The result for Fibonacci series using Iteration is  : "+ res);
    ArrayList<String> show=main.ReverseString("we test coders");
    for(int i=show.size()-1;i>=0;i--)
        System.out.print(show.get(i)+ " ");
}

public int recFibonacci(int n){
    if(n<=1)
        return n;
    else
        return recFibonacci(n-1)+recFibonacci(n-2);
    }
    public int iterativeFibonacci(int n){
    int first=0;
    int previous=1;
    int sum=0;
    if(n==0 || n==1)
        return 1;
    for(int i=0;i<n-1;i++){
        sum=first+previous;
        first=previous;
        previous=sum;
    }
    return sum;
    }
    public ArrayList<String> ReverseString(String str){
        StringBuilder output=new StringBuilder();
        ArrayList<String> arr=new ArrayList<>();
        char[] s=str.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            stack.push(s[i]);
        }
        while (!stack.isEmpty()){
            char c=stack.pop();
            String st;
            if(c==' ') {
                arr.add(output.toString());
                output.setLength(0);
            }
            else
                output.append(c);
        }
        if (output.length()>0) {
            arr.add(output.toString());
            output.setLength(0);
        }
        return arr;
    }
}
