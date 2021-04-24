public class MinCostPath {

    //    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
//    Note: You can only move either down or right at any point in time.
    private static int arr[][] = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
    };

    public static void main(String args[]) {
//        int i = minPathRecursive(arr.length -1, arr[0].length-1);
//        System.out.println(i);

        int i3 = minPathRecursive2(0, 0);
        System.out.println(i3);
    }

    //pass in index
    private static int minPathRecursive(int m, int n) {
        if (m == 0 && n == 0) {
            return arr[0][0];
        }
        //when hit boundary row and boundary column
        if (m == 0 ) {
            return arr[m][n]+ minPathRecursive(m,n-1);
        }
        if (n == 0) {
            return arr[m][n] + minPathRecursive(m - 1, n);
        }
        int steps = arr[m][n] + Math.min(minPathRecursive(m - 1, n) , minPathRecursive(m, n - 1));
        return steps;
    }

    //why doesn't work???
    private static int minPathRecursive2(int x, int y) {
        int m= arr.length;
        int n=arr[0].length;
        //when hit boundary row and boundary column. discourage it
        if (x >m-1|| y > n-1) {
            return Integer.MAX_VALUE;
        }

        //hit bottom
        if(x==n-1&&y==n-1){
            return arr[x][y];
        }
        int down = minPathRecursive2(x + 1, y);
        int up = minPathRecursive2(x, y + 1);
        int min=Math.min(down,up);
        int steps = arr[x][y] +min;
        return steps;
    }


}
