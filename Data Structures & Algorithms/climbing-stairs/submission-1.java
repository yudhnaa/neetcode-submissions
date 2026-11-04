class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int result = 0;
        int[] numsStep = new int[n+1];
        numsStep[1] = 1;
        numsStep[2] = 2;

        for (int i = 3; i <= n; i++) {
            numsStep[i] = numsStep[i-1] + numsStep[i-2];
        }

        return numsStep[n];
    }
}
