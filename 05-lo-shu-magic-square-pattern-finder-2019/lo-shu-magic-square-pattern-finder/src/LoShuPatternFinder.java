
public class LoShuPatternFinder {
    private static int sqrCounter = 0;

    public static void main(String[] args) {


        int[] a = new int[9];

        for (int i = 0; i < 9; i++) {
            a[i] = (i + 1);
        }


        permute(a, 0);  //heap's algorithm


        System.out.println("\n\nSo there are " + sqrCounter + " Lo-Shu Magic Square patterns.");
    }


    private static void permute(int[] a, int k) {
        if (k == a.length) {

            loshuPrinter(a);

        } else {
            for (int i = k; i < a.length; i++) {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;

                permute(a, k + 1);

                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }

    private static boolean loshuChecker(int[][] list2D) {
        boolean loshu = true;

        //horizontal
        int hSum1 = 0;
        int hSum2 = 0;
        int hSum3 = 0;
        for (int i = 0; i < 3; i++) {
            hSum1 += list2D[0][i];
            hSum2 += list2D[1][i];
            hSum3 += list2D[2][i];

        }


        if ((hSum1 != hSum2) || (hSum1 != hSum3)) {
            loshu = false;
        }


        //vertical
        int vSum1 = 0;
        int vSum2 = 0;
        int vSum3 = 0;
        for (int i = 0; i < 3; i++) {
            vSum1 += list2D[i][0];
            vSum2 += list2D[i][1];
            vSum3 += list2D[i][2];

        }

        if ((vSum1 != vSum2) || (vSum1 != vSum3) || (hSum1 != vSum1)) {
            loshu = false;
        }


        //diagonal1
        int d1Sum = 0;

        for (int i = 0; i < 3; i++) {
            d1Sum += list2D[i][i];

        }

        if (d1Sum != vSum1) {
            loshu = false;
        }


        //diagonal2
        int d2Sum = 0;

        for (int i = 0; i < 3; i++) {
            d2Sum += list2D[i][2 - i];

        }

        if (d2Sum != vSum1) {
            loshu = false;
        }

        return loshu;
    }


    private static void loshuPrinter(int[] numList) {

        int[][] list2D = new int[3][3];
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {


                list2D[i][j] = numList[counter];
                counter++;

            }
        }


        boolean loshu = loshuChecker(list2D);

        if (loshu) {
            sqrCounter++;
            System.out.println();
            System.out.println();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(list2D[i][j] + ((j == 2) ? "\n" : "\t"));
                }
            }
        }


    }

}
