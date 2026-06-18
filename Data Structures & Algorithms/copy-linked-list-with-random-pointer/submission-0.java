/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Map<Node,Node> hashTable = new HashMap<>();

        for (Node iterator = head; iterator != null; iterator = iterator.next){
            hashTable.put(
                iterator,
                new Node(iterator.val)
            );
        }

        for (Node iterator = head; iterator != null; iterator = iterator.next){
            Node copy = hashTable.get(iterator);

            copy.next = hashTable.get(iterator.next);
            copy.random = hashTable.get(iterator.random);
        }

        return hashTable.get(head);
    }
}
