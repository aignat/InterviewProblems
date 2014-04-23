/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems;

/**
 *
 * @author aignat
 */
public class InterviewProblems {

    public String recursiveReverse(String s) {
        String reverseS = null;

        return reverseS;
    }

    public static void main(String[] args) {

        Java2Novice testClass = new Java2Novice();

        int[] numere = {2, 4, 4, 0, 5, 4, 1};
        testClass.findIndex(numere);

        String s = "abcde";
        System.out.println("The reverse of " + s + "is: " + testClass.reverseStringRecursive(s));

        int nr = 11;
        System.out.println("The binar representation of " + nr + " is: " + testClass.convertDecimalToBinary(nr));

        String uniqueString = "alexandru";
        testClass.checkUnicity(uniqueString);

        // Problems from CrackCode
        ArraysAndStrings ccTest = new ArraysAndStrings();
        System.out.println("Ex. 1.1");
        System.out.println(ccTest.hasDuplicates("acb"));
        System.out.println("Ex. 1.4");
        ccTest.areAnagrams("aaabbbbcc", "caaacbbbb");
        System.out.println("Ex. 1.2");
        System.out.println(ccTest.reverseCString("Alex\n"));
        System.out.println("Ex. 1.5");
        System.out.println(ccTest.replaceSpaces("a b   c d"));
        System.out.println("Ex. 1.6");
        int[][] matrixImage = {{1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20},
        {21, 22, 23, 24, 25}};

        int[][] matrixImage1 = {{1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}};
        ccTest.rotateMatrix(matrixImage);
        System.out.println("Ex. 1.7");
        int[][] matrixZero = {{1, 0, 1, 0},
        {0, 1, 2, 3},
        {1, 2, 3, 4},
        {1, 2, 3, 4},
        {1, 2, 3, 4}};
        ccTest.clearMatrix(matrixZero);
        System.out.println("Ex. 1.8");
        System.out.println(ccTest.isRotated("alex", "exal"));

        LinkedLists ls = new LinkedLists();
        LinkedLists.Node linkedList = ls.new Node(1);
        ls.append(linkedList, 2);
        ls.append(linkedList, 3);
        ls.append(linkedList, 4);
        ls.append(linkedList, 5);
        ls.append(linkedList, 6);
        ls.append(linkedList, 7);
        ls.append(linkedList, 2);
//        ls.append(linkedList, 9);
//        ls.append(linkedList, 10);
//        ls.display(linkedList);
        //linkedList = ls.delete(linkedList, 1);
        //ls.removeDuplicates(linkedList);        
        //ls.display(linkedList);
        //LinkedLists.Node nod = ls.nthElement(linkedList, 9);
        //System.out.println(nod.value);
//        LinkedLists.Node linkedListToTest = linkedList.next.next.next;
//        ls.deleteMiddleNode(linkedListToTest);
//        ls.display(linkedList);
//
//        LinkedLists.Node ls1 = ls.new Node(3);
//        ls.append(ls1, 1);
//        ls.append(ls1, 5);
//
//        LinkedLists.Node ls2 = ls.new Node(5);
//        ls.append(ls2, 9);
//        ls.append(ls2, 2);
//        
//        LinkedLists.Node lsSum = ls.addLists(ls1, ls2);
//        ls.display(lsSum);
        
        System.out.println("The beginning of the list is: " + ls.loopStart(linkedList).value);
    }

}
