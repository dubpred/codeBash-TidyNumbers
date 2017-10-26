import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class TidyNumbers {

    private static int n; //number to find tidy number inside of
    private static int testCases;//number of test cases
    private static boolean tidy; //true or false if the number is tidy
    private static Scanner sc;
    private static PrintWriter pw;

    public static void main(String[] args) throws FileNotFoundException {
        pw = new PrintWriter(new File("tidyNumbers.txt"));
        sc = new Scanner(new File("B-small-practice.in"));//scans the test case file

        testCases = sc.nextInt(); //first line is the number of test cases

        int numberList[] = new int[testCases];// creates array with size of test cases

//		System.out.println(testCases);
//		System.out.println(numberList.length);

        //Takes the test cases from the input file and adds them to the array numberList
        while (sc.hasNextInt()) {

            for (int i = 0; i < testCases; i++) {
                numberList[i] = sc.nextInt();
            }
        }


        // prints out the testcases
//		for(int x : numberList){
//			System.out.println(x);
//		}

        //test case counter
        int count = 0;

        //Converts every number in NumberList to string
        for (int x : numberList) {

            //increment the test case counter;
            count++;

            ArrayList <Integer>tidyList = new ArrayList<Integer>();

            //iterates through all of the numbers between 0 and the testcase number (x)
            for(int i = 0; i< x;i++){
                boolean tidy = false;
                String currentTest = new Integer(i).toString();//sets the number to string
                int currentTestLength = currentTest.length();//use string length method to see how many digits the number has

                //adds single digit numbers to mitigate them not being added later
                if(currentTestLength==1)
                    tidyList.add(x);

                //makes array with length of the amount of digits in the number
                int[] digits = new int[currentTestLength];

                //fills array with the individual digits
                for (int j = 0; j < currentTestLength; j++) {
                    digits[j] = Character.getNumericValue(currentTest.charAt(j));
                }

                //tests to see if the digits in the array are all ascending (tidy), if they are set tidy to true
                for(int j = 0; j< digits.length;j++){
                    if(j>0) {
                        if ((digits.length > (j + 1) ) && (digits[j] <= digits[j + 1]) && digits[j-1]<= digits[j])
                            tidy = true;
                        if ((digits.length > (j + 1) ) && (digits[j] > digits[j + 1]) && digits[j-1]> digits[j])
                            tidy = false;

                    }
                }

                //if tidy is set to true the highest tidy value of the test case is added to tidy list
                if(tidy == true){
                    tidyList.add(i);
                }

            }

            //prints out the List
            if(tidyList.size()>0) {
                pw.println("Case #" + count + ": " + tidyList.get(tidyList.size() - 1));
                pw.flush();
                System.out.println("Case #" + count +": "+  tidyList.get(tidyList.size()-1));
            }

            }

        }

    }

