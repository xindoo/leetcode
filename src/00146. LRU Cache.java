class LRUCache {
    private class DLinkedList {
        public int key;
        public int value;
        public DLinkedList pre;
        public DLinkedList next;
        public DLinkedList(){};
        public DLinkedList(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
    private int capacity;
    private int size = 0;
    private DLinkedList head;
    private DLinkedList tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DLinkedList();
        this.tail = new DLinkedList();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedList p = findNode(key);
        if (null == p)
            return -1;
        if (p != head.next) {
            deleteNode(p);
            addNode(p);
        }
        return p.value;
    }

    private DLinkedList findNode(int key) {
        DLinkedList p = head.next;
        while (p != tail) {
            if (p.key == key) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public void put(int key, int value) {
        DLinkedList p = findNode(key);
        deleteNode(p);
        DLinkedList newNode = new DLinkedList(key, value);
        addNode(newNode);
        expired();
    }
    
    private void deleteNode(DLinkedList p) {
        if (null == p)
            return;
        p.pre.next = p.next;
        p.next.pre = p.pre;
        size--;
    }
    private void addNode(DLinkedList newNode) {
        newNode.next = head.next;
        head.next.pre = newNode;
        newNode.pre = head;
        head.next = newNode;
        size++;
    }
    private void expired() {
        if (size > capacity) {
            deleteNode(tail.pre);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */