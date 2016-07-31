package edu.my;

public class Strings {
    public Strings() {
        super();
    }
 
    public static void main(String[] args) {
        String str = "Sudha Chinnappa";
        System.out.println("Reversed String: " + reverseStringinPlace(str));
    }
 
    public static String reverseStringinPlace(String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        int length = strBuilder.length();
        /**
         * Traverse only to the midway of the string.
         *
         * Big O notation: The time complexity of this algorithm is O(n/2) i.e. O(n) where n is the length of String.
         */
        for (int i = 0; i < length / 2; i++) {
            char currrent = strBuilder.charAt(i);
            int otherEndIndex = length - i - 1;
            strBuilder.setCharAt(i, strBuilder.charAt(otherEndIndex));
            strBuilder.setCharAt(otherEndIndex, currrent);
        }
        return strBuilder.toString();
    }
}