class Node {
    int data;
    int key;
    Node right;
    Node left;

    Node() {}

    Node(int data, int key) {
        this.data = data;
        this.key = key;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;

        this.head = new Node();
        this.tail = new Node();

        head.right = tail;
        tail.left = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        addToFront(node);

        return node.data;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.data = value;
            remove(node);
            addToFront(node);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.left;
                remove(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(value, key);
            map.put(key, newNode);
            addToFront(newNode);
        }
    }

    public void remove(Node node) {
        Node leftNode = node.left;
        Node rightNode = node.right;

        leftNode.right = rightNode;
        rightNode.left = leftNode;
    }

    public void addToFront(Node node) {
        Node first = head.right;

        node.right = first;
        node.left = head;

        head.right = node;
        first.left = node;
    }
}