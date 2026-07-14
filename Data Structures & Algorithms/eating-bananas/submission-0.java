class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        
        for (int pile : piles){
            right = Math.max(pile, right);
        }

        int k = 0;
        while (left <= right){
            k = left + (right - left) / 2;

            boolean isAte = isAte(piles, h, k);

            if (isAte){
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return left;
    }

    private boolean isAte(int[] piles, int h, int k){
        int result = 0;

        for (int pile : piles){
            result += Math.ceil((double) pile / k);
        }

        return result <= h;
    }
}