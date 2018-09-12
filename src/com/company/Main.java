package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
     /*
        //reverse a string with String Builder
        reverseString();
        //remove duplicates aaa = a, aabbcc = abc
        removeDuplicates();



        //anagram check baker= break by sorting both words and compare
        System.out.println(anagramMethod1("baker", "break"));
        //System.out.println(anagramMethod2("baker", "break"));
        System.out.println(anagramMethod2("bsker", "break"));
      */

        // first count #of spaces
        // create empty string with new size inclding the replacement for each space
        // add characters into new array with space relacements
        spaceReplacementInString("a b c ");
    }

//reverse a string in place function
    public static void reverseString(){
        String str = "12345";
        System.out.println("original String: " + str);
        Integer start = 0;
        Integer end = str.length()-1;
        StringBuilder builder = new StringBuilder(str);

        while(start < end){
            char leftCurrent = builder.charAt(start);
            char rightCurrent = builder.charAt(end);
            builder.setCharAt(start,rightCurrent);
            builder.setCharAt(end,leftCurrent);
            start++;
            end--;
        }
        System.out.println("reversed String: " + builder.toString());
    }


    public static void removeDuplicates() {
        char[] str = {'2', '2', '4','3', '3','5'};
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;

        int tail = 1;

        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (str[i] == str[j]) break;
            }
            if (j == tail) {
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;

        for (int i = 0; i < len; i++){
            System.out.println(str[i]);
        }
    }

    //check if 2 words is anagram
    // example baker = break
    // method 1 is to sort both words and check if they the same
    // method 2 is to count occurence of  each char. if all have same occurence its anagram
    public  static  boolean anagramMethod1(String s1, String s2){
        char[] string1_array = s1.toCharArray();
        char[] string2_array = s2.toCharArray();
        Arrays.sort(string1_array);
        Arrays.sort(string2_array);

        return Arrays.equals(string1_array, string2_array);

    }
    public static boolean anagramMethod2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] string1_array = s1.toCharArray();
        char[] string2_array = s2.toCharArray();
        int unique_count_t = 0;
        int[] letter = new int[256]; /// when char is compared b = position 98
        int unique_count_s = 0;
        for (char c : string1_array) {
            if (letter[c] == 0)
                unique_count_s++;
            letter[c]++;
        }


        for (int i = 0; i < s2.length(); i++) {
            int c = (int) s2.charAt(i);
            if (letter[c] == 0) {
                System.out.print("Not an anagram has extra letter");
                return false;
            }
            letter[c]--;
            if (letter[c] == 0)
                unique_count_t++;
            if (unique_count_s == unique_count_t) {
                System.out.print("Its an anagram ");
                return true;
            }
        }
    return  false;
    }

    public static void spaceReplacementInString(String str) {
        char[] s = str.toCharArray();
        int lenght = s.length;
        int i =0;
        int j = 0;
        StringBuilder string = new StringBuilder();
        char c1 = '%';
        char c2 = '2';
        char c3 = '0';
        int spaceCount = 0;
        //get # of spaces
        for (char c : s) {
            if (c == ' ')
                spaceCount++;
        }
        int newsize = str.length() + spaceCount * 2;
        char[] newStr = new char[newsize];
       while(i < lenght){
           //if its a space andd in replacemetns for next 3 positions
           //update the position for the new array
            if (s[i] == ' ') {
                newStr[j] = c1;
                newStr[j+ 1] = c2;
                newStr[j + 2] = c3;
                i++;
                j=j+3;
            }else {
                newStr[j] = s[i];
                i++;
                j++;
            }
        }
        for (char c : newStr){
           System.out.println(c);
        }
    }

    //Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
    // first check and keep track of what row and column has 0.
    // use row and column array to keep track of the zeros
    // if we dont use that and replace in place we will end up with all matrix being 0
    public  static void setMatrixZero(int [][] matrix){
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        // Set arr[i][j] to 0 if either row i or column j has a 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ((row[i] == 1 || col[j] == 1)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    static class node
    {
        int val;
        node next;

        public node(int val)
        {
            this.val = val;
        }
    }
    //Write code to remove duplicates from an unsorted linked list.
    //3 approaches
        //use 2 for loops
        // sort and remove dup
        // use hashing
    public static void deleteDups(node head) {
        HashSet<Integer> hash = new HashSet<>();
        node current = head;
        node previous = null;
        while (current != null){
            int curval = current.val;
            if(hash.contains(curval)) // if seen before skip with prev node to remove dup.
                previous.next = current.next;
            else {
                hash.add(curval); //add to hash if never seen before
                previous = current;
            }
            current = current.next;
        }
    }

    //Implement an algorithm to find the nth to last element of a singly linked list.
    // list 1-> 2 -> 3 -> 4 -> 5
    //for n = 1 output = 4
    //for n = 2 output = 3
    //for n = 3 output = 2
    public static node nthToLast( node head, int n){
        if (head == null || n < 1) {
             return null;
        }
        node p1 = head;
        node p2 = head;
        for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
             if (p2 == null) {
                return null; // not found since list size < n
            }
            p2 = p2.next;
         }

         while (p2.next != null) {
             p1 = p1.next;
             p2 = p2.next;
         }
         return p1;

    }
  //page 120
}

