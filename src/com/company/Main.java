package com.company;

public class Main {

    public static void main(String[] args) {
        //reverse a string with String Builder
        reverseString();
        removeDuplicates();

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
}
