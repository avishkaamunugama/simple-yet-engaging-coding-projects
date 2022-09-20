public class Squarelotron {

    int[][] square;
    private int size;

    public Squarelotron(int size) {
        this.size = size;
    }

    int[][] buildSquare() {


        int counter = 0;

        this.square = new int[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                counter++;
                this.square[Math.abs(0 - i)][Math.abs(0 - j)] = counter;

            }
        }


        //square printer
        counter = 0;


        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                counter++;
                System.out.print(square[i][j] + ((counter % square.length == 0) ? "\n" : "\t"));

            }
        }

        return square;
    }


    void upSideDownFlip() {


        int counter = 0;

        int[][] newSquare = new int[this.size][this.size];


        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                counter++;
                newSquare[Math.abs((this.size-1) - i)][j] = counter;

            }
        }


        for (int i = 1; i < newSquare.length - 1; i++) {
            for (int j = 1; j < newSquare.length - 1; j++) {
                newSquare[i][j] = square[i][j];

            }
        }


        counter = 0;

        for (int i = 0; i < newSquare.length; i++) {
            for (int j = 0; j < newSquare.length; j++) {
                counter++;
                System.out.print(newSquare[i][j] + ((counter % newSquare.length == 0) ? "\n" : "\t"));

            }
        }

    }


    void mainDiagonalFlip() {

        int counter = 0;

        int[][] newSquare = new int[this.size][this.size];


        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                counter++;
                newSquare[Math.abs(j)][Math.abs(i)] = counter;

            }
        }


        for (int i = 1; i < newSquare.length - 1; i++) {
            for (int j = 1; j < newSquare.length - 1; j++) {
                newSquare[i][j] = square[i][j];

            }
        }


        counter = 0;

        for (int i = 0; i < newSquare.length; i++) {
            for (int j = 0; j < newSquare.length; j++) {
                counter++;
                System.out.print(newSquare[i][j] + ((counter % newSquare.length == 0) ? "\n" : "\t"));

            }
        }

    }


    void rotateRight(int numberOfTurns) {


        int[][] newSquare = new int[this.size][this.size];


        int counter = 0;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                counter++;
                newSquare[i][j] = counter;

            }
        }

        int number = Integer.parseInt(numberOfTurns < 0 ? "4" : "0");

        for (int n = 0; n < Math.abs(number-(Math.abs(numberOfTurns%4))); n++) {

            counter = 0;
            int[] counterList = new int[this.size * this.size];

            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    counterList[counter] = newSquare[i][j];
                    counter++;

                }
            }


            counter = 0;
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {

                    newSquare[Math.abs(0 - j)][Math.abs((this.size-1) - i)] = counterList[counter];
                    counter++;
                }
            }
        }


        for (int i = 1; i < newSquare.length - 1; i++) {
            for (int j = 1; j < newSquare.length - 1; j++) {
                newSquare[i][j] = square[i][j];

            }
        }


        counter = 0;

        for (int i = 0; i < newSquare.length; i++) {
            for (int j = 0; j < newSquare.length; j++) {
                counter++;
                System.out.print(newSquare[i][j] + ((counter % newSquare.length == 0) ? "\n" : "\t"));

            }
        }

    }


}

