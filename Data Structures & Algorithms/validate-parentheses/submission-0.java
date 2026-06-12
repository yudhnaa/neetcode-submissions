class Solution {
    private boolean isOpenBracket(char bracket){
        switch (bracket){
            case '(':
            case '{':
            case '[':
                return true;
            default:
                return false;
        }
    }

    private boolean isBracketPair(char openBracket, char closeBacket){
        switch (openBracket){
            case '(':
                return closeBacket == ')';
            case '{':
                return closeBacket == '}';
            case '[':
                return closeBacket == ']';
            default:
                return false;
        }
    }

    public boolean isValid(String s) {
        if (s.length() == 1){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char character : s.toCharArray()){
            if (isOpenBracket(character)){
                stack.push(character);
            } else {
                if (stack.isEmpty()){
                    return false;
                }

                char openCharacter = stack.pop();
                boolean isAPair = isBracketPair(openCharacter, character);

                if (!isAPair){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
