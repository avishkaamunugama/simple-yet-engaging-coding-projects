public class WhackAMole {

    int score;
    int molesLeft;
    int attemptsLeft;
    char moleGrid[][];


    WhackAMole(int numAttempts, int gridDimension) {
        this.attemptsLeft = numAttempts;
        this.moleGrid = new char[gridDimension][gridDimension];

        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                this.moleGrid[i][j] = '*';
            }
        }


    }

    boolean place(int x, int y) {
//        Character c1 = this.moleGrid[x][y];
//        Character c2 = '*';
//        if (!(c1.equals(c2))) {
        this.moleGrid[x][y] = 'M';
        this.molesLeft++;

//            return true;
//        }


        return false;
    }


    void whack(int x, int y) {
        Character c1 = this.moleGrid[x][y];
        Character c2 = 'M';
        if ((c1.equals(c2))) {
            this.moleGrid[x][y] = 'W';
            this.molesLeft--;
            this.score++;
            this.attemptsLeft--;
            System.out.println("\nNice You whacked a mole!");


        } else {
            this.attemptsLeft--;
            System.out.println("\nOops you just missed a mole.");
        }

    }

    void printGridToUser() {
        int counter = 0;

        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                counter++;

                if (moleGrid[i][j] != 'M') {
                    System.out.print(moleGrid[i][j] + (counter%moleGrid.length == 0 ? "\n" : "\t"));
                } else {
                    System.out.print("*" + (counter%moleGrid.length == 0 ? "\n" : "\t"));
                }
            }
        }

    }

    void printGrid() {
        int counter = 0;

        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                counter++;

                System.out.print(moleGrid[i][j] + ((counter%moleGrid.length == 0) ? "\n" : "\t"));

            }
        }
    }

}
