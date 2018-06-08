package com.michael;

public class Main {

    public static void main(String[] args) {
        int k = 999;
        int[] a = {5, 32, 527, 338, 3};
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        int[] b = basicCountingSort(a, k);
        System.out.println("results of counting sort: ");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
        radixSort(a, 3);
        System.out.println("results of radix sort: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

    public static int[] basicCountingSort(int[] a, int k){
        int[] b = new int[a.length];
        int[] c = new int[k+1];
        for(int i = 0; i <= k ; i++){
            c[i] = 0;
        }
        for(int i = 0; i < a.length; i++){
            c[a[i]]++;
        }
        for(int i = 1; i <= k; i++){
            c[i] += c[i-1];
        }
        for(int i = a.length - 1; i >= 0; i--){
            b[c[a[i]]-1] = a[i];
            c[a[i]]--;
        }
        return b;
    }

    private static void digitCountingSort(int[] a, int digit){
        int[] b = new int[a.length];
        int[] c = new int[10];
        for(int i = 0; i < 10 ; i++){
            c[i] = 0;
        }
        for(int i = 0; i < a.length; i++){
            c[ getValueOfDigitAtPosition(a[i], digit) ]++;
        }
        for(int i = 1; i < 10; i++){
            c[i] += c[i-1];
        }
        for(int i = a.length - 1; i >= 0; i--){
            b[ c[ getValueOfDigitAtPosition(a[i], digit) ] -1] = a[i];
            c[ getValueOfDigitAtPosition(a[i], digit) ]--;
        }
        System.arraycopy( b, 0, a, 0, a.length );
    }
    private static int getValueOfDigitAtPosition(int target, int x){
        return (target % (int) Math.pow(10, x)) / ((int) Math.pow(10, x - 1));
    }

    public static void radixSort(int[] a, int d){

        for(int i = 1; i <= d; i++){
            digitCountingSort(a, i);
        }
    }

    public static void bucketSort(){
        //WILL GET TO THIS LATER
    }
}
