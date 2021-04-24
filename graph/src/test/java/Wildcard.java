public class Wildcard {
    public static void main(String args[]) {
        String s="acdcb";
        String p="a*c?b";
        System.out.println(isMatch(s,p));
    }

    private static boolean isMatch(String s, String p) {
        int i=0,j=0;
        while(i<s.length()) {
            if (p.charAt(j) == '?') {
                j++;
                i++;
            }
            if (p.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            }
            if (p.charAt(j) == '*') {
                if (j + 1 > p.length() - 1) {//bound checking
                    return true;
                } else if (p.charAt(j + 1) == s.charAt(i)) {
                    j = j + 2;
                    i++;
                } else {
                    i++;
                }
            }
        }

       if (j== p.length()-1) {
           return true;
       } else{
           while(j<p.length()){
               if(p.charAt(j)=='*') return false;
           }
       }
       return true;
    }

}
