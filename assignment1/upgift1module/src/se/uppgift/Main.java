package se.uppgift;

import java.util.Random;


public class Main
{
    public static void main(String[] args)
    {

        //G-Upgift
        String[] words = {"Hello", "World", "!"};
        printHelloWord(words);

//--------------------------------------------------------------

        //VG-uppgift -- generate Int
        Random rand = new Random();
        int[] intNumbers = new int[10];


        for (int i = 0; i < intNumbers.length; i++)
        {

            intNumbers[i] = rand.nextInt(101);

        }

        //VG-uppgift -- generate double
        double[] doubleNumbers = new double[2];

        for (int i = 0; i < doubleNumbers.length; i++)
        {

            doubleNumbers[i] = rand.nextDouble() * 100;

        }





        //VG-MaxNum
        int maxNum = findMaxNum(intNumbers);
        System.out.println("The numbers are ");
        for (int i : intNumbers)
        {

            System.out.print(i + " ");

        }
        System.out.println();
        System.out.println("The max number is " + maxNum);

        //VG-compareDouble
        System.out.println("The doubles are " + doubleNumbers[0] + " and " + doubleNumbers[1]);
        double maxDouble = compareDouble(doubleNumbers);
        System.out.println("The max double is " + maxDouble);


        //VG-print name
        String fName = "John";
        String lName = "Doe";
        printFullName(fName, lName);


    }

//--------------------------------------------------------------

    //G-Upgift
    public static void  printHelloWord(String[] words)
    {

        for (String word : words)
        {

            System.out.println(word);

        }
    }

//--------------------------------------------------------------

    //VG-MaxNum
    public static int findMaxNum (int[] arr)
    {

        int max = arr[0];
        for (int num : arr)
        {

            if(num > max) max = num;

        }
        return max;
    }

    //VG-compareDouble
    public static double compareDouble (double[] arr)
    {

        double dMax = arr[0];
        for (double num : arr){
            if(num > dMax) dMax = num;
        }
        return dMax;
    }

    //VG-print full name
    public static void printFullName (String fName, String lName)
    {

        System.out.println(fName + " " + lName);

    }

}