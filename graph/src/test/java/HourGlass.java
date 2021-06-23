public class HourGlass {
    public static void main(String[] args) {
        int n=3;
        printHourGlass(n);
        Integer [] dp=new Integer[3];
        dp[1]=5;
        System.out.println();
    }

    public static void printHourGlass(int n) {
        int i, j, k;
        for (i = 1; i <= n; i++) {
            // printing i spaces at the beginning of each row
            for (k = 1; k < i; k++)
                System.out.print(" ");

            // printing i to rows value at the end of each row
            for (j = i; j <= n; j++)
                System.out.print(j + " ");

            System.out.println();
        }

        // for loop for printing lower half
//        for (i = n - 1; i >= 1; i--) {
//            // printing i spaces at the
//            // beginning of each row
//            for (k = 1; k < i; k++)
//                System.out.print(" ");
//
//            // printing i to rows value
//            // at the end of each row
//            for (j = i; j <= n; j++)
//                System.out.print(j + " ");
//
//            System.out.println();
//        }
    }
}
//***
// *
//***