package com.company;

import java.util.Arrays;

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


}

