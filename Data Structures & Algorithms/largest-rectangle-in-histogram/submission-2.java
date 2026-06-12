// General ideas:
// - Create a stack to store index of non-decreased element.
// - Stack này phải đảm bảo: Mỗi phần tử trong stack phải lớn hơn các phần từ ở dưới nó. Điều này kết hợp với thuật toán đảm bảo khi tính rectangle ta có thể tìm được:
// + Biên bên trái: Phần tử gần nhất nhỏ nhất bên trái (tức là phần tử liền kề dưới nó ở trong stack)
// + Biên bên phải: Index hiện tại của loop.
// + Bởi vì khi đặt element vào stack ta đã đảm bảo các tính chất:
// Phần tử trên luôn lớn hơn các phần tử dưới
// Phần từ dưới luôn là thằng nhỏ gần nhất
// Thắc mắc: tại sao không chọn phần tử nhỏ xa hơn thì việc đó được giao cho phần tử  khác dưới stack rồi
// + Dùng 2 biên này có thể tính được rectangle của phần tử đó
// - While stack is not stack empty or value[i] < stack.peek() -> Calculate max rectangle


class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxRectangle = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int topHeightIndex = stack.pop();
                int height = heights[topHeightIndex];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int rectangle = height * width;

                maxRectangle = Math.max(maxRectangle, rectangle);
            }

            stack.push(i);
        }

        return maxRectangle;
    }
}