import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        WhackAMole game1 = new WhackAMole(50, 10);

        game1.place(1, 2);
        game1.place(1, 9);
        game1.place(3, 5);
        game1.place(9, 7);
        game1.place(2, 8);
        game1.place(0, 5);
        game1.place(4, 3);
        game1.place(7, 0);
        game1.place(4, 9);
        game1.place(6, 0);


        while (game1.attemptsLeft > 0) {

            System.out.println("\nYou have " + game1.attemptsLeft + " attempts left.");
            System.out.println("You have " + game1.molesLeft + " moles left.\n");
            System.out.print("Enter X to whack :");

            int x = sc.nextInt();
            System.out.print("Enter Y to whack :");
            int y = sc.nextInt();


            if ((x == -1) || (y == -1)) {
                break;
            }
            try {
                game1.whack(x - 1, y - 1);
                System.out.println();

                game1.printGridToUser();
                System.out.println();
            } catch (Exception e) {

                System.out.println("\nPlease enter a number in between 1 and 10 inclusive.");
                continue;
            }

        }


        System.out.println();
        game1.printGrid();


    }
}
