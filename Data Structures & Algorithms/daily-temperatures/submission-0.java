class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int tempLength = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int[] result = new int[tempLength];

        for (int currentDay = 0; currentDay < tempLength; currentDay++){
            while(!stack.isEmpty() && temperatures[currentDay] > temperatures[stack.peek()]){

                int previousDay = stack.pop();
                result[previousDay] = currentDay - previousDay;

            }

            stack.push(currentDay);
        }

        return result;
    }
}
