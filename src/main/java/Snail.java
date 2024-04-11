public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */


    public static int[] flattenSnail(int[][] array2d) {
        if (array2d == null) {
            return new int[0];
        }
        if (!isPerfectSquare(array2d)){
            return new int[0];
        }
        int n = array2d.length;
        int[] flattenArray = new int[n * n];
        int flattenIndex = 0;
        int colIndex = 0;
        int loopNum = 0;
        while (n > 0) {
            int rowIndex = loopNum;
            for (int i = 0; i < n; i++) {
                flattenArray[flattenIndex++] = array2d[rowIndex][colIndex++];
            }
            colIndex--;
            rowIndex++;
            for (int i = 0; i < n - 1; i++) {
                flattenArray[flattenIndex++] = array2d[rowIndex++][colIndex];
            }
            rowIndex--;
            colIndex--;
            for (int i = 0; i < n - 1; i++) {
                flattenArray[flattenIndex++] = array2d[rowIndex][colIndex--];
            }
            colIndex++;
            rowIndex--;
            for (int i = 0; i < n - 2; i++) {
                flattenArray[flattenIndex++] = array2d[rowIndex--][colIndex];
            }
            colIndex++;

            n -= 2;
            loopNum+=1;
        }
        return flattenArray;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if (array1d == null) {
            return new int[0][0];
        }
        if (!isPerfectSquare(array1d)) {
            return new int[0][0];
        }

        int n = (int) Math.sqrt(array1d.length);
        int[][] snailArray = new int[n][n];
        int index = 0;
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // top row
            for (int col = colStart; col <= colEnd; col++) {
                snailArray[rowStart][col] = array1d[index++];
            }
            rowStart++;

            // right column
            for (int row = rowStart; row <= rowEnd; row++) {
                snailArray[row][colEnd] = array1d[index++];
            }
            colEnd--;

            // bottom row
            if (rowStart <= rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    snailArray[rowEnd][col] = array1d[index++];
                }
                rowEnd--;
            }

            // left column
            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    snailArray[row][colStart] = array1d[index++];
                }
                colStart++;
            }
        }

        return snailArray;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int i: array1d){
            System.out.println(i);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for(int[] col: array2d){
            for(int row: col){
                System.out.println(row);
            }
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        int num = array1d.length;
        int squareRoot = (int) Math.sqrt(num);
        if (num<=0){
            return false;
        }else if(squareRoot*squareRoot == num){
            return true;
        }
        return false;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        int collength = array2d.length;
        int rowlength = array2d[0].length;
        for (int[] i:array2d){
            if (rowlength != i.length){
                return false;
            }
        }
        if (collength == rowlength){
            return true;
        }
        return false;
    }


}
