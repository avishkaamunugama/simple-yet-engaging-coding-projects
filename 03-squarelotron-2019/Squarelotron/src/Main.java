import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Squarelotron squarelotron = new Squarelotron(5);



        squarelotron.buildSquare();

        System.out.println("\nThis is your number square, which you are about to flip it all about.\n\n");

        boolean isOver = false;

        Scanner sc = new Scanner(System.in);

        while (!isOver){

            System.out.println("\nEnter :\n\tu - to flip the number square up-side-down\n\tm - to flip in main-diagonal\n\tr - to flip right\n\tanything else - to quit");
            String choise = sc.next();

            System.out.println();
            System.out.println();

            if(choise.equals("u")){
                squarelotron.upSideDownFlip();

                System.out.println();
                System.out.println();

            }else if (choise.equals("m")){
                squarelotron.mainDiagonalFlip();

                System.out.println();
                System.out.println();

            }else if (choise.equals("r")){

                System.out.print("Enter the number of turns to flip: ");
                int turns = sc.nextInt();

                System.out.println();

                squarelotron.rotateRight(turns);

                System.out.println();
                System.out.println();

            }else {
                isOver=true;
            }
        }


    }
}
