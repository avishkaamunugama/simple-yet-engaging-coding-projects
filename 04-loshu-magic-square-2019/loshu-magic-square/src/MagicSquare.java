import java.util.Scanner;
import java.util.ArrayList;



public class MagicSquare {



    private static int getValues() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many rows?   ");   //asks the user to enter the number of rows in the magic square they are going to make
        return sc.nextInt();
    }





    private static int[][] formSqr(int sqrNum){
        Scanner sc = new Scanner(System.in);
        int[][] numbers = new int[0][0];    // declaration and initiation of a 2d array
        if (sqrNum > 2) {    // makes sure the user makes a magic square with 3 or more rows
            numbers = new int[sqrNum][sqrNum];  //changes the size of 2d array according to user input.

            //prompts the user to enter numbers and adds them to the 2d array
            for (int i = 0; i < sqrNum; i++) {
                for (int j = 0; j < sqrNum; j++) {
                    System.out.print("Enter number " + (i + 1) + "x" + (j + 1) + ":");
                    numbers[i][j] = sc.nextInt();
                }
            }

        } else {
            System.out.println("Magic Square should at least contain 3 rows and 3 columns! \nTry again");
            System.out.println();
        }

        return (numbers);
    }








    private static void displaySqr(int sqrNum, int[][] numbers){
        // prints out the 2d array of numbers
        for (int i = 0; i < sqrNum; i++) {
            for (int j = 0; j < sqrNum; j++) {
                System.out.print(numbers[i][j] + "    ");
            }
            System.out.println();
        }

    }







    private static boolean checkMagicSqr(int sqrNum, int[][] numbers){
        boolean magicSqr = true;

        //checks if the numbers are unique
        ArrayList<Integer> loShuList = new ArrayList<>();
        for (int i = 0; i < sqrNum; i++) {
            for (int j = 0; j < sqrNum; j++) {
                loShuList.add(numbers[i][j]);
            }
        }

        for (int i = 0; i < loShuList.size(); i++) {
            for (int j =0;j<loShuList.size();j++){
                if (loShuList.get(i).equals(loShuList.get(j)) && (i!=j)){
                    magicSqr =false;
                }
            }
        }

        int[] totals = new int[sqrNum+sqrNum+1+1]; //1D array to hold all the totals of rows ,cols,and diagonals

        //calculates the total of all rows in the square and adds each to the totals array
        for (int i =0;i<sqrNum;i++) {
            int total =0;
            for (int j = 0; j < sqrNum; j++) {
                total += numbers[i][j];
            }
            totals[i]=total;
        }

        //calculates the total of all columns in the square and adds each to the totals array
        for (int i =0;i<sqrNum;i++) {
            int total =0;
            for (int j = 0; j < sqrNum; j++) {
                total += numbers[j][i];
            }
            totals[sqrNum+i]=total;
        }

        //calculates the total the diagonals in the square and adds each to the totals array
                                    /*
                    -
                        -
                            -
                                -
                     */
        int total =0;
        for (int i=0;i<sqrNum;i++){
            total += numbers[i][i];
        }
        totals[sqrNum+sqrNum]=total;

                    /*
                                    -
                                -
                            -
                        -
                                        */
        for (int i =(sqrNum-1);i>=0;i--) {
            total =0;
            for (int j = 0; j < sqrNum; j++) {
                total += numbers[j][i];
            }
            totals[sqrNum+sqrNum+1]=total;
        }
        System.out.println();

        // iterates through all numbers in totals array and see whether they are equal
        for (int total1 : totals) {
            for (int total2 : totals) {
                if (total1 != total2) {
                    magicSqr = false;
                }
            }
        }

        System.out.println("Is Magic Square: "+ magicSqr);
        return magicSqr;
    }









    private static void checkLoShu(int sqrNum, int[][] numbers, boolean magicSqr){
        boolean loShu = true;

        //checks whether all numbers in the array are less than 9 , if not makes loShu false
        for (int i = 0; i < sqrNum; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i][j] > 9) {
                    loShu = false;
                }

            }
        }

        // loShu will only be true if square is a magic square
        if(!magicSqr){
            loShu = false;
        }

        System.out.println("Is Lo-Shu magic square: "+loShu);
    }








    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char answer ='y';
        while ((answer =='y') || (answer=='Y')){    //loop iterates as long as answer==y

            try{            //try block executes the code until an error occurs

                int sqrNum = getValues();
                int[][] numbers = formSqr(sqrNum);

                if (sqrNum>2) {
                    displaySqr(sqrNum,numbers);
                    boolean magicSqr = checkMagicSqr(sqrNum,numbers);
                    checkLoShu(sqrNum,numbers,magicSqr);

                    System.out.println();
                    System.out.println();

                    System.out.println("Would you like to give another try? \n(y- to retry   any other key - quit)");
                    answer = sc.next().charAt(0);
                }
            }
            catch(Exception e){
                System.out.println("Invalid Input !\nPlease try again.");
                System.out.println();
            }

        }
    }


}