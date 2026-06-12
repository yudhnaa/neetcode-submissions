class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int carLength = position.length;
        double[][] cars = new double[carLength][2];
        Stack<Double> fleetStack = new Stack<>();

        for (int i = 0; i < carLength; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(
            cars,
            (a, b) -> Double.compare(b[0], a[0])
        );

        for (int i = 0; i < carLength; i++){
            double currentCarSpendTime = cars[i][1];

            if (fleetStack.isEmpty() || currentCarSpendTime > fleetStack.peek()){
                fleetStack.push(currentCarSpendTime);               
            }
        }

        return fleetStack.size();
        
    }
}