class Solution {
    public int minCostClimbingStairs(int[] cost) {

        if (cost.length == 2) {
            return Math.min(
                cost[0],
                cost[1]
            );
        }

        int[] minCost = new int[cost.length+1];
        minCost[0] = 0;
        minCost[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            minCost[i] = Math.min(
                minCost[i-1] + cost[i-1],
                minCost[i-2] + cost[i-2]
            );
        }

        return minCost[cost.length];
    }
}
