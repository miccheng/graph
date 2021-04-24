public class MaxSubArray {
    private static int max;
    private static int startIndex;

    public static void main(String args[]){
        int nums []={-2,1,-3,4,-1,2,1,-5,4};

        maxSubArr(nums);
        System.out.println(max+":"+startIndex);
    }

    private static void maxSubArr(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        max = dp[0];
        startIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            if (dp[i - 1] < 0) {
                startIndex = i;
            }
//            max=Math.max(max,dp[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }

    }
}
