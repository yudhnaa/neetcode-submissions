class Solution {
    int SUB_BOX_SIZE = 3;

    private int getSubBoxSetIndex(int rowIndex, int colIndex){
        int subBoxRowIndex = rowIndex / SUB_BOX_SIZE;
        int subBoxColIndex = colIndex / SUB_BOX_SIZE;

        int flatArrayIndex = subBoxRowIndex * SUB_BOX_SIZE + subBoxColIndex;

        return flatArrayIndex;
    }
    public boolean isValidSudoku(char[][] board) {
        int boardLength = board.length;
        int subBoxLength = boardLength*boardLength / (SUB_BOX_SIZE*SUB_BOX_SIZE);

        Set<Character>[] rowSets = new HashSet[boardLength];
        Set<Character>[] colSets = new HashSet[boardLength];
        Set<Character>[] subBoxSets = new HashSet[subBoxLength];

        for (int i = 0; i < boardLength; i++){
            rowSets[i] = new HashSet<Character>();
            colSets[i] = new HashSet<Character>();
        }

        for (int i = 0; i < subBoxLength; i++){
            subBoxSets[i] = new HashSet<Character>();
        }

        for (int i = 0; i < boardLength; i++){
            for (int j = 0; j < boardLength; j++){
                
                char value = board[i][j];

                if (value == '.'){
                    continue;
                }
                
                int subBoxSetIndex = getSubBoxSetIndex(i, j);
                boolean isNotValid = rowSets[i].contains(value) || colSets[j].contains(value) || subBoxSets[subBoxSetIndex].contains(value);

                if (isNotValid){
                    return false;
                }

                colSets[j].add(value);
                rowSets[i].add(value);
                subBoxSets[subBoxSetIndex].add(value);
            }
        }

        return true;
    }
}