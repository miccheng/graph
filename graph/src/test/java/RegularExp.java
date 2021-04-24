import org.yaml.snakeyaml.tokens.BlockEndToken;

public class RegularExp {
//    private static String s="aab";
//    private static String p="c*a*b";

//    private static String s="aaa";
//    private static String p="a*";

    private static String s="ab";
    private static String p=".*";

    public static void main(String args[]) {
//        String a = "abc";
//        System.out.println(a.substring(0));
        System.out.println(doesMatch(0,0));
    }

    private static boolean doesMatch(int i, int j) {
        if (i >= s.length() && j >= p.length())
            return true;
        if (i + 1 < s.length()) {
            if ((p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) && (j + 1 >= p.length() || p.charAt(j + 1) != '*')) {
                doesMatch(i + 1, j + 1);
            }
            if (j + 1 < p.length()) {
                if (s.charAt(i) == p.charAt(j) && p.charAt(j + 1) == '*') {
                    doesMatch(i + 1, j);
                } else if (s.charAt(i) != p.charAt(j) && p.charAt(j + 1) == '*') {
                    doesMatch(i, j + 2);
                }
            }
        }
        return true;
    }


    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
