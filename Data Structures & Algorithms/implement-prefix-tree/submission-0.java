class TrieNode {
    TrieNode[] nextNode;
    boolean isEndOfWord;

    TrieNode(){
        nextNode = new TrieNode[26];
        isEndOfWord = false;
    }
}

class PrefixTree {

    private final TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';

            if (cur.nextNode[index] == null){
                cur.nextNode[index] = new TrieNode();
            }

            cur = cur.nextNode[index];
        }
        cur.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';

            if (cur.nextNode[index] == null){
                return false;
            }

            cur = cur.nextNode[index];
        }

        return cur.isEndOfWord == true;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        char[] chars = prefix.toCharArray();

        for (int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';

            if (cur.nextNode[index] == null){
                return false;
            }

            cur = cur.nextNode[index];
        }

        return true;
    }
}
