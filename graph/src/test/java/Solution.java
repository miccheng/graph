import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Tests.testHasMutualFirstChoice();
        Tests.testHasMutualPairForRank();
    }

    Map<String, String[]> data;

    public Solution(Map<String, String[]> data) {
        this.data = data;
    }

    public boolean hasMutualPairForRank(String username, int rank) {
        if(!validateInput(username)) return false;

        String[] wishes = data.get(username);
        if (wishes == null || wishes.length == 0) return false;

        //out of bound
        if(rank>=wishes.length) return false;
        String target = wishes[rank];
        if(!validateInput(target)) return false;

        String[] reversedWishes = data.get(target);

        if (reversedWishes == null || reversedWishes.length == 0) return false;
        return( rank>=reversedWishes.length)? false: reversedWishes[rank].equals(username);
    }


    public boolean hasMutualFirstChoice(String username) {
        return hasMutualPairForRank(username,0);
    }

    boolean validateInput(String username) {
        //check input data map
        if (data == null || data.isEmpty()) return false;
        if (!data.containsKey(username)) return false;
        return true;
    }


}
