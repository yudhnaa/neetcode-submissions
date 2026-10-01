class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';

            if (curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode curr){
        
        if (index == word.length()){
            return curr.isEnd;
        }

        boolean isAny = word.charAt(index) == '.';

        if (isAny){
            
            for (TrieNode node : curr.children){
                if (node != null){
                    if (search(word, index+1, node)){
                        return true;
                    }
                }
            }

            return false;

        } else {
            
            int nodeIndex = word.charAt(index)-'a';

            if (curr.children[nodeIndex] == null){
                return false;
            }

            return search(word, index+1, curr.children[nodeIndex]);

        }
    }
}
