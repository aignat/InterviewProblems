package interviewproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class ArraysAndStrings {

    /**
     * 1.1 Implement an algorithm to determine if a string has all unique
     * characters. What if you can not use additional data structures?
     */
    public boolean hasDuplicates(String inputString) {
        char[] inputChars = inputString.toCharArray();
        char aux;
        for (int i = 0; i < inputChars.length; i++) {
            for (int j = 0; j < inputChars.length; j++) {
                if (inputChars[i] > inputChars[j]) {
                    aux = inputChars[i];
                    inputChars[i] = inputChars[j];
                    inputChars[j] = aux;
                }
            }
        }
        for (int i = 0; i < inputChars.length - 1; i++) {
            if (inputChars[i] == inputChars[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 1.2 Write code to reverse a C-Style String. (C-String means that “abcd”
     * is represented as five characters, including the null character.)
     */
    public String reverseCString(String inputString) {
        char aux;
        char[] chars = inputString.toCharArray();
        int middleIndex = (chars.length - 1) / 2;   //middle index of input string without last char -> '/n'        

        for (int i = 0; i < middleIndex; i++) {
            int index = chars.length - i - 2;       //simetric of i to the middle of the string
            aux = chars[i];
            chars[i] = chars[index];
            chars[index] = aux;
        }

        return String.valueOf(chars);

    }

    /**
     * 1.3 Design an algorithm and write code to remove the duplicate characters
     * in a string without using any additional buffer. NOTE: One or two
     * additional variables are fine. An extra copy of the array is not.
     */
    public String removeDuplicates(String input) {
        return null;
    }

    /**
     * 1.4 Write a method to decide if two strings are anagrams or not.
     */
    public void areAnagrams(String s1, String s2) {
        HashMap<Character, Integer> map1, map2;
        map1 = new HashMap();
        map2 = new HashMap();

        for (int i = 0; i < s1.length(); i++) {
            char currentChar = s1.charAt(i);
            if (!map1.containsKey(currentChar)) {
                map1.put(currentChar, 1);
            } else {
                map1.put(currentChar, map1.get(currentChar).intValue() + 1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char currentChar = s2.charAt(i);
            if (!map2.containsKey(currentChar)) {
                map2.put(currentChar, 1);
            } else {
                map2.put(currentChar, map2.get(currentChar).intValue() + 1);
            }
        }

        Iterator<Entry<Character, Integer>> it = map1.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Character, Integer> e = it.next();
            if (map2.containsKey(e.getKey())) {
                if (map2.get(e.getKey()).intValue() == e.getValue()) {
                    it.remove();
                    map2.remove(e.getKey());
                }
            }
        }

        if (map1.size() > 0 || map2.size() > 0) {
            System.out.println("Not anagrams.");
        } else {
            System.out.println("Are anagrams.");
        }
    }

    /**
     * 1.5 Write a method to replace all spaces in a string with ‘%20’.
     */
    public String replaceSpaces(String inputString) {
        char[] inputChars = inputString.toCharArray();
        int newLength = (inputChars.length - 1) * 4 + 1;        //the length of the new array
        int numberOfSpaces = 0;
        char[] outputChars = new char[newLength];
        for (int i = 0; i < inputChars.length; i++) {
            int newPosition = i + 2 * numberOfSpaces;           //the index of % in the new array
            if (inputChars[i] != ' ') {
                outputChars[newPosition] = inputChars[i];
            } else {
                numberOfSpaces++;
                outputChars[newPosition] = '%';
                outputChars[newPosition + 1] = '2';
                outputChars[newPosition + 2] = '0';
            }
        }

        return String.valueOf(outputChars);
    }

    /**
     * 1.6 Given an image represented by an NxN matrix, where each pixel in the
     * image is 4 bytes, write a method to rotate the image by 90 degrees. Can
     * you do this in place?
     */
    public void rotateMatrix(int[][] inputMatrix) {
        int aux;
        int length = inputMatrix.length;
        for (int i = 0; i < (length - 1) / 2; i++) {
            for (int j = i; j < length - 1 - i; j++) {
                aux = inputMatrix[i][j];
                inputMatrix[i][j] = inputMatrix[length - 1 - j][i];
                inputMatrix[length - 1 - j][i] = inputMatrix[length - 1 - i][length - 1 - j];
                inputMatrix[length - 1 - i][length - 1 - j] = inputMatrix[j][length - 1 - i];
                inputMatrix[j][length - 1 - i] = aux;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(inputMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 1.7 Write an algorithm such that if an element in an MxN matrix is 0, its
     * entire row and column is set to 0.
     */
    public void clearMatrix(int[][] inputMatrix) {
        HashSet<Integer> zeroLines = new HashSet<Integer>();
        HashSet<Integer> zeroColumns = new HashSet<Integer>();
        for (int line = 0; line < inputMatrix.length; line++) {
            for (int column = 0; column < inputMatrix[0].length; column++) {
                if (inputMatrix[line][column] == 0) {
                    zeroLines.add(line);
                    zeroColumns.add(column);
                }
            }
        }

        for (int line : zeroLines) {
            for (int i = 0; i < inputMatrix[0].length; i++) {
                inputMatrix[line][i] = 0;
            }
        }

        for (int column : zeroColumns) {
            for (int i = 0; i < inputMatrix.length; i++) {
                inputMatrix[i][column] = 0;
            }
        }

        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[0].length; j++) {
                System.out.print(inputMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 1.8 Assume you have a method isSubstring which checks if one word is a
     * substring of another. Given two strings, s1 and s2, write code to check
     * if s2 is a rotation of s1 using only one call to isSubstring (i.e.,
     * “waterbottle” is a rotation of “erbottlewat”).
     */
    public boolean isRotated(String firstString, String secondString) {
        char[] firstChars = firstString.toCharArray();
        char[] secondChars = secondString.toCharArray();
        int startIndexSecond = 0;
        int endIndexFirst = 0;
        //chack the 2 strings have the same length, if not return false
        if (firstChars.length != secondChars.length) {
            return false;
        }
        //find startIndexSecond - index of the first character from first string in the second string
        while (startIndexSecond < secondChars.length) {
            if (secondChars[startIndexSecond] == firstChars[0]) {
                break;
            }
            startIndexSecond++;
        }
        //if first character from firstString doesn't exist in secondString return false
        if (startIndexSecond == secondChars.length) {
            return false;
        }

        //find endIndexFirst - index in firstString of last common character 
        while (startIndexSecond < secondChars.length) {
            if (firstChars[endIndexFirst] != secondChars[startIndexSecond]) {
                break;
            }
            startIndexSecond++;
            endIndexFirst++;
        }

        String substring = firstString.substring(0, endIndexFirst);
        if (secondString.contains(substring)) {
            return true;
        }

        return false;
    }

}
