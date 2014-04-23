package interviewproblems;

public class Java2Novice {

    /**
     * write a recursive function that compute the reverse of a string
     */
    public String reverseStringRecursive(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        return (reverseStringRecursive(s.substring(1, s.length())) + s.toCharArray()[0]);
    }

    /**
     * write a function that converts a decimal number to its binary
     * representation
     */
    public String convertDecimalToBinary(int nr) {
        StringBuilder sb = new StringBuilder();
        while (nr > 0) {
            sb.insert(0, String.valueOf(nr % 2));
            nr = nr / 2;
        }
        return sb.toString();
    }

    /**
     * given a vector V, find the index i of a element in the vector so that the
     * sum of the predecesors of Vi equals the sum of the succesors
     */
    public void findIndex(int[] numere) {
        int startSum = 0, endSum = 0, startIndex = 0, endIndex = numere.length - 1;
        while (endIndex - startIndex >= 2) {
            startSum += numere[startIndex++];
            endSum += numere[endIndex--];
        }
        if (startSum == endSum) {
            System.out.println("Indexul pentru care suma predecesorilor = suma succesorilor este: " + (startIndex + 1));
        } else {
            System.out.println("Vectorul nu indeplineste cerinta, nu exista index potrivit.");
        }
    }
    
    /**
     * check if the characters in a string are all unique
     */
    public void checkUnicity(String input) {
        int[] asciiChars = new int[256];
        for (int i=0; i<input.length(); i++) {
            asciiChars[(int)input.charAt(i)] += 1;
        }
        for (int i=0; i<asciiChars.length; i++) {
            if (asciiChars[i] > 1) {
                System.out.println("Stringul " + input + " contine caractere duplicate.");
                return;
            }
        }
        System.out.println("Stringul " + input + " contine caractere unice.");
    }
    
}
