package com.neokpara;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // Question 3
        printFibonacciSeries();

        String line =  new Scanner(System.in).nextLine();
        int[] arrayToCheck = Arrays.stream(line.split(","))
                           .filter(str -> isInteger(str))
                           .mapToInt(Integer::parseInt).toArray();
        System.out.println(arrayToCheck);

        // Question 1
        int val1 = smallestPositiveInteger(arrayToCheck);
        System.out.println(val1);
        
        int val2 = smallestPositiveInteger(new int[] {-3, -6, 1, 2});
        System.out.println(val2);

        // Question 4
        printPrimeNumbersBackwards(1, 100);
    }

    private static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private static int smallestPositiveInteger(int[] A){
        int N = A.length, res = 1;
        boolean isFound = false;

        // Remove Duplicates and Values less than one from the Integer Array
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }
        // Return 1 if the set is empty
        if(set.isEmpty()){
            return res;
        }
        // Loop through for range of N + 1
        for (int i = 1; i <= N + 1 && !isFound; i++) {
            if (!set.contains(i)) {
                res = i;
                isFound = true;
            }
        }
        return res;
    }

    int encodeInteger(int x, int n){
        n = n<<(1<<(1<<(1<<1)));
        x = x | n;
        return x;
    }

    int[] encodeArray(int[] A, int[] B, int n){
        for(int i=0;i<n;i++) {
            A[i] = encodeInteger(A[i], B[i]);
        }
        return A;
    }

    static void printFibonacciSeries(){
        int noOfSeries = 10, prevNumber = 0, nextNumber = 1;
        System.out.print("First " + noOfSeries + " Series: ");
        for (int i = 1; i <= noOfSeries; ++i) {
            System.out.print(prevNumber);
            if(i != noOfSeries)
                System.out.print(", ");
            int sum = prevNumber + nextNumber;
            prevNumber = nextNumber;
            nextNumber = sum;
        }
        System.out.println();
    }

    static void printPrimeNumbersBackwards(int min, int max) {
        String primeNumbers = "";
        for(int i = max; i >= min; i--){
            if(isPrime(i)){
                primeNumbers += i + " ";
            }
        }
        System.out.println("Prime Numbers between " + min + " and " + max + " in reverse order are:");
        System.out.println(primeNumbers);
    }

    private static boolean isPrime(int number){
        if(number <= 1) return false;
        for(int i = 2; i <= number/2; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
