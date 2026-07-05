class LRUCache {

    class Node {
        Node previousNode;
        Node nextNode;

        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer, Node> hashTable;
    private int capacity;

    public LRUCache(int capacity) {
        this.hashTable = new HashMap<>();
        this.capacity = capacity;
        
        Node dummy = new Node (-1,-1);
        this.head = dummy;
        this.tail = dummy;
    }

    public int get(int key) {
        boolean isKeyExist = hashTable.containsKey(key);
        if (!isKeyExist) {
            return -1;
        }

        Node currentNode = hashTable.get(key);

        remove(currentNode);
        addToTail(currentNode);

        return currentNode.value;
    }

    public void put(int key, int value) {
        boolean isKeyExist = hashTable.containsKey(key);
        if (isKeyExist) {
            Node currentNode = hashTable.get(key);

            currentNode.value = value;

            remove(currentNode);
            addToTail(currentNode);

            return;
        }

        boolean isOverCapacity = hashTable.size() == capacity;
        if (isOverCapacity) {
            Node lru = head.nextNode;

            hashTable.remove(lru.key);
            remove(lru);
        }

        Node newNode = new Node(key,value);
        
        addToTail(newNode);

        hashTable.put(key, newNode);
    }

    private void remove(Node node){
        Node prev = node.previousNode;
        Node next = node.nextNode;

        prev.nextNode = next;

        if (next != null){
            next.previousNode = prev;
        } else {
            tail = prev;
        }

        node.previousNode = null;
        node.nextNode = null;
    }

    private void addToTail(Node newNode){
        newNode.previousNode = tail;
        newNode.nextNode = null;
        
        tail.nextNode = newNode;
        tail = newNode;
    }
}
