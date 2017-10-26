import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class TidyNumbers {

    private static int n; //number to find tidy number inside of
    private static int testCases;//number of test cases
    private static boolean tidy; //true or false if the number is tidy
    private static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
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

        //Converts every number in NumberList to string
        for (int x : numberList) {
            ArrayList <Integer>tidyList = new ArrayList<Integer>();

            for(int i = 0; i< x;i++){
                boolean tidy = false;
                String currentTest = new Integer(i).toString();
                int currentTestLength = currentTest.length();
//            System.out.println(currentTestLength);

                //makes array with length of the amount of digits in the number
                int[] digits = new int[currentTestLength];




                for (int j = 0; j < currentTestLength; j++) {
                    digits[j] = Character.getNumericValue(currentTest.charAt(j));

                }
                for(int j = 0; j< digits.length;j++){
                    if(j>=1) {
                        if ((digits.length > j + 1) && (digits[j] <= digits[j + 1]) && digits[j-1]<= digits[j])
                            tidy = true;
                        if ((digits.length > j + 1) && (digits[j] >= digits[j + 1]) && digits[j-1]>= digits[j])
                            tidy = false;
                    }
                    else {
                        if ((digits.length > j + 1) && (digits[j] <= digits[j + 1]))
                            tidy = true;
                        if((digits.length>j+1) && (digits[j] <= digits[j+1]))
                            tidy = false;
                    }



                }
                if(tidy == true){
                    tidyList.add(i);
                }

            }

            if(tidyList.size()>0)
                System.out.println(tidyList.get(tidyList.size()-1));

            }

        }

    }

